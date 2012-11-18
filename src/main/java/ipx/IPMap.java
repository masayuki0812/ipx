package ipx;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class IPMap {

    private TreeMap<Long, IPRange> mapping;

    public IPMap(String path) throws Exception {
        this.mapping = generateFromFile(path);
    }

    public IPRange find(IP ip) {
        Entry<Long, IPRange> entry = mapping.floorEntry(ip.toLong());
        if (entry == null) {
            return null;
        }

        IPRange range = entry.getValue();
        if ( ! (ip.toLong() < range.getEnd().toLong())) {
            return null;
        }

        return range;
    }

    public int size() {
        return this.mapping.size();
    }

    /*-- private --*/

    private TreeMap<Long, IPRange> generateFromFile(String path) throws Exception {
        TreeMap<Long, IPRange> mapping = new TreeMap<Long, IPRange>();

        BufferedReader br = new BufferedReader(new FileReader(path));

        try {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                IPRange range = new IPRange(strs[0], strs[1], strs[2]);

                mapping.put(new Long(range.getStart().toLong()), range);
            }
        }
        finally {
            br.close();
        }

        return mapping;
    }
}
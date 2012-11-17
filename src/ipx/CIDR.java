package ipx;

public class CIDR {

    public static String[] convertToRange(String cidr) throws Exception {

        String[] str = cidr.split("/");
        if( str.length != 2 ){
            throw new Exception("Invalid CIDR format.");
        }

        long addr = IP.toLong(str[0]);
        long netmask = Netmask.toLong(str[1]);

        long startAddr = addr & netmask;
        long endAddr = addr | ~netmask;

        return new String[]{IP.toString(startAddr), IP.toString(endAddr)};
    }


}
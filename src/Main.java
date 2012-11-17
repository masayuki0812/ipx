import ipx.*;

public class Main {

    public static void main( String[] args ){

        try {
            // CIDR
            String cidr = "192.168.0.0/16";
            String[] ips = CIDR.convertToRange(cidr);
            System.out.println("## Converted " + cidr + " to '" + ips[0] + " ~ " + ips[1] + "'");

            // IP
            String ip = "192.168.1.1";
            long nIp = IP.toLong(ip);
            System.out.println("## Converted " + ip + " to '" + nIp + "'");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }
}
import ipx.*;

public class Main {

    public static void main( String[] args ){

        try {
            // CIDR
            String cidr = "192.168.0.0/16";
            System.out.println("## Convert " + cidr);
            String[] ips = CIDR.convertToRange(cidr);
            System.out.println("## -> " + ips[0] + " ~ " + ips[1]);

            
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }
}
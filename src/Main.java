import ipx.*;

public class Main {

    public static void main( String[] args ){

        try {
            // IP
            IP ip = new IP("192.168.1.1");
            System.out.println("## " + ip + " converted to '" + ip.toLong() + "'");

            // CIDR
            CIDR cidr = new CIDR("192.168.0.0/16");
            System.out.println("## " + cidr + " converted  to '" + cidr.getStart() + " ~ " + cidr.getEnd() + "'");

            // CIDR includes IP or not
            if (cidr.includes(ip)) {
                System.out.println("## " + cidr + " includes " + ip);
            }
            else {
                System.out.println("## " + cidr + " NOT includes " + ip);
            }

            ip = new IP("10.0.1.1");
            if (cidr.includes(ip)) {
                System.out.println("## " + cidr + " includes " + ip);
            }
            else {
                System.out.println("## " + cidr + " NOT includes " + ip);
            }

            // IP is included in CIDR or not
            if (ip.isIncludedIn(cidr)) {
                System.out.println("## " + ip + " is includes in " + cidr);
            }
            else {
                System.out.println("## " + ip + " is NOT includes in " + cidr);
            }

            cidr = new CIDR("10.0.0.0/16");
            if (ip.isIncludedIn(cidr)) {
                System.out.println("## " + ip + " is includes in " + cidr);
            }
            else {
                System.out.println("## " + ip + " is NOT includes in " + cidr);
            }

            IPRange range = new IPRange("192.168.0.0", "192.168.255.255");

            ip = new IP("192.168.1.1");
            if (range.includes(ip)) {
                System.out.println("## " + range + " includes " + ip);
            }
            else {
                System.out.println("## " + range + " NOT includes " + ip);
            }
            ip = new IP("10.0.1.1");
            if (range.includes(ip)) {
                System.out.println("## " + range + " includes " + ip);
            }
            else {
                System.out.println("## " + range + " NOT includes " + ip);
            }

            if (ip.isIncludedBetween("10.0.0.0", "10.0.255.255")) {
                System.out.println("## " + ip + " is includes in " + cidr);
            }
            else {
                System.out.println("## " + ip + " is NOT includes in " + cidr);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }
}
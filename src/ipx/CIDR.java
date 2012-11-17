package ipx;

public class CIDR {

    private String cidr;

    private IP start;
    private IP end;

    public CIDR(String cidr) throws Exception {
        this.cidr = cidr;

        IP[] range = convertToRange(cidr);
        this.start = range[0];
        this.end = range[1];
    }

    public IP getStart() {
        return this.start;
    }

    public IP getEnd() {
        return this.end;
    }

    public boolean includes(IP ip) {
        long addr = ip.toLong();
        return (this.start.toLong() <= addr && addr <= this.end.toLong());
    }

    public boolean includes(String ip) throws Exception {
        return this.includes(new IP(ip));
    }

    @Override
    public String toString() {
        return this.cidr;
    }

    /*-- static --*/

    public static IP[] convertToRange(String cidr) throws Exception {

        String[] str = cidr.split("/");
        if( str.length != 2 ){
            throw new Exception("Invalid CIDR format.");
        }

        long addr = new IP(str[0]).toLong();
        long netmask = Netmask.toLong(str[1]);

        long startAddr = addr & netmask;
        long endAddr = addr | ~netmask;

        return new IP[]{new IP(startAddr), new IP(endAddr)};
    }
}
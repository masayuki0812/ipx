package ipx;

public class IP {

    private String addr;
    private long nAddr;

    public IP(String addr) throws Exception {
        this.addr = addr;
        this.nAddr = convertToLong(addr);
    }
    public IP(long nAddr) {
        this.addr = convertToString(nAddr);
        this.nAddr = nAddr;
    }

    public long toLong() {
        return this.nAddr;
    }

    @Override
    public String toString() {
        return this.addr;
    }

    public boolean isIncludedIn(CIDR cidr) {
        return cidr.includes(this);
    }
    public boolean isIncludedIn(String cidr) throws Exception {
        return isIncludedIn(new CIDR(cidr));
    }
    public boolean isIncludedIn(IPRange range) {
        return range.includes(this);
    }
    public boolean isIncludedBetween(String start, String end) throws Exception {
        return isIncludedIn(new IPRange(start, end));
    }

    /*-- static --*/

    public static long convertToLong(String addr) throws Exception {
        String[] octs = addr.split("\\.");

        if( octs.length != 4 ){
            throw new Exception("Invalid address format.");
        }

        long octA = Long.parseLong(octs[0]);
        long octB = Long.parseLong(octs[1]);
        long octC = Long.parseLong(octs[2]);
        long octD = Long.parseLong(octs[3]);

        if( octA < 0 || 255 < octA ){
            throw new Exception("Invalid octet on 1st section.");
        }
        if( octB < 0 || 255 < octB ){
            throw new Exception("Invalid octet on 2nd section.");
        }
        if( octC < 0 || 255 < octC ){
            throw new Exception("Invalid octet on 3rd section.");
        }
        if( octD < 0 || 255 < octD ){
            throw new Exception("Invalid octet on 4th section.");
        }

        return (octA<<24) | (octB<<16) | (octC<<8) | octD;
    }

    public static String convertToString(long addr) {
        long octA = ((addr & 0xFF000000) >> 24) & 0xFF;
        long octB = ((addr & 0x00FF0000) >> 16) & 0xFF;
        long octC = ((addr & 0x0000FF00) >>  8) & 0xFF;
        long octD = ((addr & 0x000000FF)      ) & 0xFF;

        return octA + "." + octB + "." + octC + "." + octD;
    }

}
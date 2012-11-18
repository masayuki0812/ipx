package ipx;

public class IPRange {

    private IP start;
    private IP end;

    private String id;

    public IPRange(String start, String end) throws Exception {
        this.start = new IP(start);
        this.end = new IP(end);
        this.id = null;
    }
    public IPRange(String start, String end, String id) throws Exception {
        this.start = new IP(start);
        this.end = new IP(end);
        this.id = id;
    }

    public IP getStart() {
        return this.start;
    }

    public IP getEnd() {
        return this.end;
    }

    @Override
    public String toString() {
        return this.start + "-" + this.end + ":" + this.id;
    }

    public boolean includes(IP ip) {
        long addr = ip.toLong();
        return (this.start.toLong() <= addr && addr <= this.end.toLong());
    }

    public boolean includes(String ip) throws Exception {
        return this.includes(new IP(ip));
    }
}
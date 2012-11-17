package ipx;

public class IPRange {

    private IP start;
    private IP end;

    public IPRange(String start, String end) throws Exception {
        this.start = new IP(start);
        this.end = new IP(end);
    }

    @Override
    public String toString() {
        return this.start + "-" + this.end;
    }

    public boolean includes(IP ip) {
        long addr = ip.toLong();
        return (this.start.toLong() <= addr && addr <= this.end.toLong());
    }

    public boolean includes(String ip) throws Exception {
        return this.includes(new IP(ip));
    }
}
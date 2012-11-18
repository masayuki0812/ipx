package ipx;

public class Netmask {

    public static long toLong(String range) throws Exception {
        if( range.length() > 2 ){
            throw new Exception("Invalid range.");
        }
        return ~((long)Math.pow(2, 32-Double.parseDouble(range))-1);
    }

}
package ipx;

public class IP {

    public static long toLong(String addr) throws Exception {
        String[] octs = addr.split("\\.");

        if( octs.length != 4 ){
            throw new Exception("Invalid address format.");
        }

        int octA = Integer.parseInt(octs[0]);
        int octB = Integer.parseInt(octs[1]);
        int octC = Integer.parseInt(octs[2]);
        int octD = Integer.parseInt(octs[3]);

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

        return (long)((octA<<24) | (octB<<16) | (octC<<8) | octD);
    }

    public static String toString(long addr) {
        long octA = ((addr & 0xFF000000) >> 24) & 0xFF;
        long octB = ((addr & 0x00FF0000) >> 16) & 0xFF;
        long octC = ((addr & 0x0000FF00) >>  8) & 0xFF;
        long octD = ((addr & 0x000000FF)      ) & 0xFF;

        return octA + "." + octB + "." + octC + "." + octD;
    }    

}
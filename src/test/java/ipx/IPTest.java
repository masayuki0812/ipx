package ipx;

import junit.framework.Assert;
import org.junit.Test;

public class IPTest {

    private IP ip;

    public IPTest() throws Exception {
        this.ip = new IP("192.168.1.1");
    }

    @Test
    public void testToLong() {
        Assert.assertEquals(this.ip.toLong()+"", "3232235777");
    }

}
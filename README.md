Extended IP library for Java
====

## Build

Just run `mvn`:

    $ mvn package

Then, `.jar` will be generated in `./target`, and you can run this `.jar` with no args:

    $ java -jar target/ipx-0.0.1-SNAPSHOT-jar-with-dependencies.jar

## Usage

You can convert CIDR to start/end IPs:

    import ipx.CIDR;
    
    String[] ips = CIDR.convertToRange("192.168.0.0/24");
    // ips[0] will be "192.168.0.0"
    // ips[1] will be "192.168.255.255"

And also get number representation of IP:

    import ipx.IP;

    long addr = IP.toLong("192.168.1.1");
    // addr will be -1062731519


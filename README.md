Extended IP implementation for Java
====

## Build

Just run `mvn`:

    $ mvn package

Then, `.jar` will be generated in `./target`, and you can run this `.jar` with no args:

    $ java -jar target/ipx-0.0.1-SNAPSHOT-jar-with-dependencies.jar

## Usage

### IP class:

```java
import ipx.IP;

IP ip = new IP("192.168.1.1");

ip.toString();
// "192.168.1.1"

ip.toLong();
// 3232235777

ip.isIncludedIn("192.168.0.0/16");
// true

ip.isIncludedBetween("192.168.0.0", "192.168.255.255");
// true
```
long-representation can be treated as unsigned int.

### CIDR class:

```java
import ipx.IP;
import ipx.CIDR;

CIDR cidr = new CIDR("192.168.0.0/16");

IP start = cidr.getStart();
// "192.168.0.0

IP end = cidr.getEnd();
// "192.168.255.255"

cidr.includes("192.168.1.1");
// true
```
And of course:

```java
import ipx.IP;
import ipx.CIDR;

IP ip = new IP("192.168.1.1");
CIDR cidr = new CIDR("192.168.0.0/16");

cidr.includes(ip);
// true

ip.isIncludedIn(cidr);
// true
```
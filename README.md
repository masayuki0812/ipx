Extended IP implementation in Java
====

## Release

Currently, 0.1.0 is the latest.

## Requirement

* Java 1.6, or higher

## Download

You can download `.jar` from [here](https://github.com/masayuki0812/ipx/downloads 'https://github.com/masayuki0812/ipx/downloads').

## Build

Clone this project, and just run `mvn`:

    $ mvn package

Then, `.jar` will be generated as `./target/ipx-0.1.0.jar`. 

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

cidr.includes(new IP("192.168.1.1"));
// true
```

### IPRange class:

```java
import ipx.IP;
import ipx.IPRange;

IPRange range = new IPRange("192.168.0.0", "192.168.255.255");

range.includes(new IP("192.168.1.1"));
// true

IPRange range1 = new IPRange("192.168.1.0","192.168.1.255", "seg1");
IPRange range2 = new IPRange("192.168.2.0","192.168.2.255", "seg2");
```

### IPMap class:

```java
import ipx.IP;
import ipx.IPMap;

IPMap map = new IPMap("./ip_country_mapping.csv");

IPRange range = map.find("3.0.0.1");
// "3.0.0.0", "4.255.255.255", "US"

map.find("0.0.0.0");
// null, if not found
```
In this case, `ip_country_mapping.csv` is:
```csv
3.0.0.0,4.255.255.255,US,UNITED STATES
6.0.0.0,9.255.255.255,US,UNITED STATES
11.0.0.0,13.255.255.255,US,UNITED STATES
15.0.0.0,23.15.255.255,US,UNITED STATES
23.16.0.0,23.17.255.255,CA,CANADA
23.18.0.0,23.29.191.255,US,UNITED STATES
...
```
You can generate this csv by using [ip-country-mapping](https://github.com/masayuki0812/ip-country-mapping 'https://github.com/masayuki0812/ip-country-mapping').

Enjoy!
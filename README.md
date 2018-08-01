# com.dabogee.config-tools.poc

Date: Jul 26, 2018

Compare of:\
https://github.com/lightbend/config \
Latest release: 1.3.3 / 21-Feb-2018

1. ConfigException for non-existing fields using ConfigFactory.load(..).getString("bar") (It's a library feature).
2. There is no annotation like owner's @Key. Need to create a Foo class with "bar" field for property like "foo.bar".
3. No default values.

https://github.com/lviggiano/owner \
Latest release: 1.0.10 / 28-Feb-2018

https://github.com/cfg4j/cfg4j \
Latest release: 4.4.1 / 12-Jul-2017

Requirements:
* There are no violations with default rules of checkstyle and pmd.
* Inheritable configuration

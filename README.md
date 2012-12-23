podcastr
========

# podcast client in Java
It reads the podcasts to be downloaded from feeds.txt

Build Instructions
------------------
```
mvn package
```
```
mvn -q exec:java -Dexec.mainClass="com.polyglot.App"
```
It will download the podcast episodes in the same directory as the application directory.


TODO
----
* Make an executable jar
* Download the podcasts in a subdirectoryt under the user's home directory

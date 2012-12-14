podcastr
========

podcast client in Java
----------------------

Just add the podcast feeds to feeds.txt and it will download the recent episodes. Then use your favorite media player to play the episodes.

Build
-----

Install maven using your package manager.

On Arch Liunx, it is
```
pacman -Syu maven
```

Then,
```
mvn package
java -cp target/<jar file> com.polyglot.App
```

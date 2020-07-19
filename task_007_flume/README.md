
# Working with Flume

## Install

- [Java] Oracle JDK 1.8
- [Maven] Apache Maven 3


Expand the memory used to compile.
```
export MAVEN_OPTS="-Xms512m -Xmx1024m -XX:PermSize=256m -XX:MaxPermSize=512m"
```

### start an agent

```
bin/flume-ng agent -n $agent_name -c conf -f conf/flume-conf.properties
```

Create the listening agent.
```
bin/flume-ng agent --conf conf --conf-file conf/flume-conf.properties --name a1 -Dflume.root.logger=INFO,console
```

Access configured port, pipe data through telnet.

```
ssh namesync -t 'cat opt/books/* | nc 192.168.56.105 44444 >/dev/null'
```



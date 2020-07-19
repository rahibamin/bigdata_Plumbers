
# Working with Flume

## Install

- [Java] Oracle JDK 1.8
- [Maven] Apache Maven 3


## pre-configure hadoop

Prepare and copy the configuration files.
```
agents-42@atlanta-hq:~/bigdata_Plumbers/task_007_flume$ ssh namesync find /home/hadoop/hadoop/etc/hadoop -type f -and -name '*\[a-z\]' -exec ls -1t {} + | head -n 10 | ssh hadoop@namesync "xargs -I {} scp {} datanode2:{}"
```


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


# Working with Twitter using 1%

> agents-42@atlanta-hq:~/bigdata_Plumbers/task_007_flume$ ssh hadoop@namesync -t 'source .profile; source .bash_profile; start-dfs.sh'
> Starting namenodes on [namenode1]
> Starting datanodes
> Starting secondary namenodes [namenode1]
> Connection to 192.168.56.105 closed.
> agents-42@atlanta-hq:~/bigdata_Plumbers/task_007_flume$ ssh hadoop@namesync -t 'source .profile; source .bash_profile; start-yarn.sh'
> Starting resourcemanager
> Starting nodemanagers
> Connection to 192.168.56.105 closed.

Set the CLASSPATH in `flume-env.sh`
```

export CLASSPATH="$CLASSPATH:/home/hadoop/flume/lib"
```

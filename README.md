# config-agent

An JVM agent which allows you to specify a path to a Java properties file and have the agent read the properties from that file into the JVM as if those properties 

Assuming a properties file containing the following:

```
property.one=1
property.two=2
property.three=3
```

Starting your JVM using the following command:

`java -javaagent:/path/to/config-agent.jar=/path/to/some.properties -jar some.jar`

.... is equivalent to:

`java -Dproperty.one=1 -Dproperty.two=2 -Dproperty.three=3 -jar some.jar`

Not a massive difference if you've only got a few properties, but much easier when you've got loads!
#!/bin/bash

####################################################
# DO NOT CHANGE THE GRADLE OPTIONS IN THE BLOCK    #
# BELOW, IT WILL HAVE IMPACT ON THE PERFORMANCE    #
# OF YOUR APPLICATION                              #
####################################################
GRADLE_OPTS="-Dgradle.user.home=~/gradle_cache"    #
####################################################



./gradlew clean bootrun &

while ! netstat -tna | grep 'LISTEN\>' | grep -q ':8081\>'; do
  echo "waiting for spring application to start"
  sleep 2 # time in seconds, tune it as needed
done

# If you have any script to load the data make sure that its part of this bash script.

 mongoimport --host buildout-qa-shard-00-02.ctmqn.mongodb.net:27017 --ssl -u admin -p 'admin' --authenticationDatabase admin  --db quiz1 --collection myData  --file initial_data_load.json --jsonArray
 
 echo "data loaded into mongo atlas"

# Cron Expression Parser

Main purpose of this project is to validate and decompose cron expression (standard POSIX) into easier to validate format (with precise information about minutes, hours etc when it will run). It should be runned from command line with cron expression passed as argument.

How to run:
Project needs to be compiled. To do that you must have JDK installed on your machine (at least v17) and Maven (newest version possible). Both can be aquired from their respective webpages. For more instructions on how to install them on you local machine please look there.

After that please go to main directory of the project (CronExpressionParser by default) and compile it using maven:

`mvn clean compile`

After that you should notice a new directory called target. Please go to it.

To execute this application you need to run in using java and pass cron expression as argument:

`java -jar CronExpressionParser-1.0-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"`

where CronExpressionParser-1.0-SNAPSHOT.jar is the name of the jar generated from previous step and "*/15 0 1,15 * 1-5 /usr/bin/find" is the cron expression which we want to process.
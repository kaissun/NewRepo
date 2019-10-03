## Problem
Please write a program to represent the following scenario:

We are a national supermarket chain that is interested in starting to use special offers in our stores. We stock the following products:

| Item | Price|
| ------------- | ------------- |
| Apple  | 0.20  |
| Orange | 0.50  | 
| Watermelon| 0.80  | 

We would like to allow the following special offers:
- Buy One Get One Free on Apples
- Three For The Price Of Two on Watermelons


We would like to see the output for an example basket containing the following items:

| Item | Quantity|
| ------------- | ------------- |
| Apple  | 4|
| Orange | 3| 
| Watermelon| 5| 


## Demonstration 

The program is introduced using java. And the project has been built initially with Maven. 

So first, you need to be sure that maven is already installed and fully configured (with java 8 as java home).
Second, using command line, execute the following :

`mvn package`

A new folder of maven called target will be generated after this command. To check the tests please follow this folder : surefire-reports, it contains all the results of testing for each junit class created. This result is also shown when executing in the command line previously. You could also execute the following command after executing the previous one: 

`mvn test`

in the same newely created folder, you will find the assembly for our program: SuperMarket1.0-0.0.1-SNAPSHOT.jar
To run the program, please execute the following the line in the command line:

`java -jar SuperMarket1.0-0.0.1-SNAPSHOT.jar`




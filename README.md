# Welcome to my programming practice!

## Purpose
This is a java project intended as a simple exercise to showcase my usage of build tools and the java programming language.

## The problem
We are going to be working on the task of formatting signed integers as strings in english
Basically you can pass an integer to the IntFormatter
and it will return the String representation for your number!
As simple as that.
### Specific rules of the formatted String
UK and US english differ in how to use the "and" in numbers. (see https://english.stackexchange.com/questions/71770/usage-of-and-and-comma-when-writing-numbers-uk-style) 
We are going to always add the "and" between hundreds and tens. eg. 
* 1111: One thousand one hundred and eleven
* 234,501,723: Two hundred thirty four million five hundred one thousand seven hundred and twenty three. 

## In order to build this project:
1. Install java (we work with java 8) https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
2. Install maven https://maven.apache.org/install.html
With maven installed just do
`mvn clean install`

## To run the tests
You can just run `mvn test` on the project

## If you want to create an executable jar
you can use maven and run `mvn package` on the main folder

## If you want to build and run the cli
Just run (having installed maven and java 8) `./run.sh`

# Issues?
run.sh needs execution permissions. You can add that with `chmod +x run.sh`
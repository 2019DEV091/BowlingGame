# Kata Bowling

This project is a solution to the kata found here: http://codingdojo.org/kata/Bowling/


## Prerequisites

Java 8 installed and on your PATH

Maven installed


## Installing

Compile the project using Maven: mvn clean install

This will run the unit tests and install the application in your maven repository

## Running the tests

Run mvn clean test

This will run the JUnit5 tests and create a JUnit XML in target/surefire-reports called "TEST-kata.bowling.BowlingTest.xml"

## Running the application

After installation open a terminal (navigate to the folder where the jar is located) and type (replacing what is between quotes with your score): java -jar bowling-1.0.0.jar "your score to check here"

E.g. java -jar bowling-1.0.0.jar "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"

It is important that your frames are separated by a space

If correct you will get a display of your score.


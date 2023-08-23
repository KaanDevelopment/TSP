This repository contains Java classes for calculating the shortest path for a given travel plan using a brute-force approach. It also includes a class for representing individual cities and calculating the distance between them.
This collection of Java classes is designed to address the problem of finding the shortest path for a given travel plan, where a list of cities and their coordinates are provided. The code utilizes a brute-force approach, 
exploring all possible routes to determine the one with the minimum total distance.

Brute Force Shortest Path Finder
bruteForceFindBestRoute.java
This class calculates the shortest path for a given travel plan using Depth First Search (DFS) algorithm. It takes the first city as the initial starting point for calculating the shortest distance path. Key features include:
Constructor: Initializes the brute force path finder with the input file name.
Search Method: Implements the DFS algorithm to find the shortest path.
isBestRoute Method: Determines if the current route is the best one found so far.
Performance: This algorithm is suitable for small to moderately-sized travel plans but may be computationally expensive for larger datasets.


City Class
City.java
The City class is responsible for storing individual city data and calculating the Euclidean distance between two cities. Key features include:
Constructor: Initializes a city with its ID and coordinates (x, y).
Parsing Constructor: Parses a string containing city data to create a city object.
Distance Calculation: Calculates the Euclidean distance between two cities.
Getters and Setters: Provides access to city attributes.

Main Class
Main.java
The Main class serves as the entry point for executing the brute force path finder on various test cases. It calls the computePath method for different input files. Key features include:

computePath Method: Initializes and executes the brute force path finder.
Main Method: Calls computePath for different test cases.

Travel Class
Travel.java
The Travel class is responsible for storing all cities in a specific travel file and calculating the possible distance for a single visit. Key features include:
Constructors: Initializes the Travel class with empty city data or loads data from a file.
Population of Cities: Reads data from a file and populates the list of cities.
Distance Calculation: Calculates the total distance for the current travel configuration.
Accessors: Provides methods to access city data.
ToString Method: Returns a string representation of the current travel plan.

Usage
Compile the Java code using the Java Development Kit (JDK).
Run the Main class with appropriate input files to calculate the shortest paths for different travel plans.

License
This code is provided under the MIT License. You are free to use, modify, and distribute it according to the terms of the license. See the LICENSE file for more details.

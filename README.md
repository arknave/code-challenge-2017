# code-challenge-2017
"Many teams enter only one team leaves."

## What is the code challenge?
It is an algorithmic challenge between UMD and UT to find out each school's abilities at processing and handling large amounts of data based off of real-world scenarios.

## Rules
* Teams must be composed of 3 members
* One member from each team must have a GitHub account for submitting the solution as a branch on this repo.
* Each team's solution must be implemented in Java 8.x only (no outside libraries in your submission)
* You will are provided with a simple project starter kit to execute and evaluate the output of your solution
* You cannot alter the methods signatures or object models that already exist in the starter kit
* You cannot store results between runs of your solution (results must be calculated from the data on each run)
* A team must solve as many goals/results as possible in the allotted time for implementing their solution.
* If multiple teams get all of the goals/results successfully in the allotted time, the winning team will be chosen based on the performance of their solution (average runtime for getting the proper results).
* Finally, do not share results w/other teams. This is every team's challenge.

## The Starter Kit
The simple starter kit for the challenge provide a predefined means for executing your solution and evaluating the results. This kit  provides the following, which cannot be changed by a teams:
* The data sample that will be ingested 
* An entry point into executing the implementation (main)
* Ingests the data sample into a predefined model/structure
* Outputs all results in a predefined model/structure
* Performs a simple evaluation of the time taken to calculate the results

##Required Results/Goals
* Find the neighborhood that has the most interests from unique individuals
* Find the neighborhood that has the least interests from unique individuals
* Find the top 4 individuals that have the most interests in locations
* Find all users that were interested in all neighborhoods (Hint: Where's Waldo and Waldina?)

###What identifies interest?
An individual remaining at a single location for 30 minutes or more is then defined as interested in that location, otherwise they are not interested 

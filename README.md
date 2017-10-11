# code-challenge-2017
"Many teams enter only one team leaves."

## What is the code challenge?
It is an algorithmic challenge between UMD and UT to find out each school's abilities at processing and handling large amounts of data based off of real-world scenarios.

## Rules
* Teams must be composed of 3 members
* One member from each team must have a GitHub account for submitting the solution as a branch on this repo.
* Do not push your branch until you are given the go ahead by a member of Dante.
* Each team's solution must be implemented in Java 8.x only (no outside libraries in your submission)
* You cannot alter the source data, methods signatures, or object models that already exist in the starter kit
* You cannot store results between runs of your solution (results must be calculated from the data on each run)
* A team must solve as many goals/results as possible in the allotted time for implementing the solution
* If multiple teams successfully get all of the goals/results in the allotted time, the winning team is chosen based on the performance of their solution (average runtime for getting those results)
* Finally, do not share results or algorithms w/other teams. This is every team's challenge

## The Starter Kit
The simple starter kit for the challenge provides a predefined means for executing your solution and evaluating the results. This kit  provides the following, which cannot be changed by a team:
* The data sample that will be ingested 
* An entry point into executing the implementation (main)
* Ingests the data sample into a predefined model/structure
* Outputs all results in a predefined model/structure
* Performs a simple evaluation of the time taken to calculate the results

## Required Results/Goals
* Find the neighborhood that has the most _interests_ from unique individuals
* Find the neighborhood that has the least _interests_ from unique individuals
* Find the top 4 individuals that have the most _interests_ in locations
* Find all users that have _interest_ in all neighborhoods (Hint: Where's Waldo and Waldina?)

### What Identifies Interest?
An individual remaining at a single location for 30 minutes or more is then defined as having _interest_ in that location, otherwise they do not have _interest_ in that location.

## What Does The Data Look Like?
The data represents a collection of simple user events that may be generated over a period of time from user interaction with a mobile application. You can imagine that over time this data would rapidly grow in size, but would be immensly valuable for calculating the trends and behaviors of users.

```javascript
{
    uuid: string
    userId: string
    eventType: string
    timeStamp: number
    neighborhood?: string
}
```
Above you can see the model of an individual user event.

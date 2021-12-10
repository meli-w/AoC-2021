# Advent of Code 2021

This repo is
based [henningBunk](https://github.com/henningBunk/advent-of-code-kotlin-template) [Kotlin template](https://github.com/henningBunk/advent-of-code-kotlin-template)
for AoC

---

### Solutions

[Day 1](https://github.com/meli-w/AoC-2021/blob/main/app/src/main/kotlin/day01/Day01.kt)  
[Day 2](https://github.com/meli-w/AoC-2021/blob/main/app/src/main/kotlin/day02/Day02.kt)  
[Day 3](https://github.com/meli-w/AoC-2021/blob/main/app/src/main/kotlin/day03/Day03.kt)  
[Day 4](https://github.com/meli-w/AoC-2021/blob/main/app/src/main/kotlin/day04/Day04.kt)  
[Day 5](https://github.com/meli-w/AoC-2021/blob/main/app/src/main/kotlin/day05/Day05.kt)  
[Day 6](https://github.com/meli-w/AoC-2021/blob/main/app/src/main/kotlin/day06/Day06.kt)
[Day 7](https://github.com/meli-w/AoC-2021/blob/main/app/src/main/kotlin/day07/Day07.kt)  
[Day 10](https://github.com/meli-w/AoC-2021/blob/main/app/src/main/kotlin/day10/Day10.kt)  

### Setup / Run

Set up the automatic input download  
The setup process differs depending on how you are planning to execute your solutions.

1. Via gradle from the command line
2. Via the run button in IntelliJ

Either way, you will have to determine your session cookie beforehand.

The downloader tries to download the input for the current year. If you want to use this template for older puzzles you
have to adjust it accordingly.

0. Determine your session cookie  
   Open adventofcode.com in your browser  
   Login  
   Open the developer tools  
   Open the storage tab  
   Select "Cookies" → "https://adventofcode.com"  
   A table will open, the row with the name "session" is the correct one, the session cookie is the string in the "
   Value" field
1. Via gradle from the command line  
   Setup (only needed once)  
   Create the file `./gradle.properties`  
   Insert the line `sessionCookie=yourSessionCookieWithoutQuotes`  
   Execution for a day  
   Execute` ./gradlew run -Dday={day number}`  
   Alternatively you could skip the setup and pass the cookie as a
   parameter: `./gradlew run -Dday={day number} -DsessionCookie={session cookie}`
2. Via the run button in IntelliJ  
   Open one of the `Day{XY}.kt` files  
   Click the play button next to the main function, select Modify run configuration  
   Insert your session cookie into the field Program arguments  
   Execute the day by clicking the run button again and select Run  
   You have to repeat this for each day. Or you edit your run configuration each day to execute a different main
   function.  
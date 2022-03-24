# 🤖Kiva Bot🤖
![badmath](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![badmath](http://ForTheBadge.com/images/badges/built-with-love.svg)

## Description
Replication of Kiva robots used in Amazon fullfilment centers that move pods around map given commands from user. Objective is for user to navigate Kiva towards a pod, pick it up, and transport it into a designated zone where it will drop the pod. User has to avoid obstacles while moving throughout map and make sure Kiva go out of bounds on the map.

## Table of Contents

- [Features](#features)
- [Instructions](#Instructions)
- [Visuals](#Visuals)
- [Contributing](#Contributing)
- [Usage](#Usage)
- [License](#License)

## Features
- 6 possible commands from user: forward, back, left, right, pickup, drop
- Returns successful or failure result depending on if pod dropped off at   designated drop zone.
- Maps include obstacles and out of bounds areas for Kiva to avoid. Unit tests are included to catch edge cases where Kiva runs into obstacle or runs out of bounds.

## Instructions
- Create new instance of remote control class.
- You will then be prompted to choose one of several maps available. These vary in # of obstacles and different drop and pickup zones.
- User is prompted to input movement commands (L, R, F, B, T, D). These are left, right, forward, backward, take, and drop functions respectively.
- Result will return either a success or failure case depending on if pod is dropped at correct zone. All other cases will result in failure.

## Visuals
Overview of elements on map (every map has dashes that create border that is not to be crossed): 
- K: Kiva bot
- P: Pod
- D: Designated drop zone
- *: Obstacle to avoid

![alt text](https://i.imgur.com/SrdLQ6T.png)

![alt text](https://i.imgur.com/Bt10jeV.png)
    
![alt text](https://i.imgur.com/AoDN0v7.png)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

MIT

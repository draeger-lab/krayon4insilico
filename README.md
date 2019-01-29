# krayon4insilco
## Goals of the project
The goal of this project is to develope a plugin for the the plugin-framework [insilico](https://github.com/draeger-lab/insilico).
Said plugin should offer the user the full functionality of the drawing tool [krayon4sbgn](https://github.com/wiese42/krayon4sbgn) embedded in insilico, for example displaying editing files of the .sbgn format. At a later point the plugin should also be enabled to interact with other plugins which can be used to display and execute sbml files. At the final state this plugin can be used as an important component of a configuration of insilico optimized for work in systems biology.

## Current state / working time

The total amount of time spent working on this project so far is 90h (28.01.2019)

In the last two months several problems with setting up insilico and and krayon4sbgn had to be fixed. Some of them like compiling krayon4sgbn using the eclipse IDE and building insilico using Maven under windows still haven't been fixed. A meeting with [Roland Wiese](https://github.com/wiese42) brought up the current approach that is editing krayon4sbgn using IntelliJ and developing the plugin importing classes from the krayon4sbgn.jar file in the build path.
Even though the beginning of coding was delayed by unforeseen problems there have already been learn-effects regarding setting up the java and kotlin compiler and build path and working with eclipse and IntelliJ as well as working with software with commercial licence and obfuscation.

## Authors
[Anton Rabe](https://github.com/AntonJuliusRabe)

Supervisor:
[Dr. Andreas Draeger](https://github.com/draeger)

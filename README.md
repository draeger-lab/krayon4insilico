# krayon4insilco
## Goals of the project
The goal of this project is to develope a plugin for the the plugin-framework [insilico](https://github.com/draeger-lab/insilico).
Said plugin should offer the user the full functionality of the drawing tool [krayon4sbgn](https://github.com/wiese42/krayon4sbgn) embedded in insilico, for example displaying editing files of the .sbgn format. At a later point the plugin should also be enabled to interact with other plugins which can be used to display and execute sbml files. At the final state this plugin can be used as an important component of a configuration of insilico optimized for work in systems biology.

## project history

In the first two months of working time several problems with setting up insilico and and krayon4sbgn had to be fixed. Some of them like compiling krayon4sgbn using the eclipse IDE and building insilico using Maven under windows still haven't been fixed. A meeting with [Roland Wiese](https://github.com/wiese42) brought up the current approach that is editing krayon4sbgn using IntelliJ and developing the plugin importing classes from the krayon4sbgn.jar file in the build path.  
A modified version of the krayon4sbgn project that can be used as a resource for this project can be found [here](https://github.com/draeger-lab/krayon4sbgn).  
Even though the beginning of coding was delayed by unforeseen problems there had already been learn-effects regarding setting up the java and kotlin compiler and build path and working with eclipse and IntelliJ as well as working with software with commercial licence and obfuscation. Shortly after that a working JavaFX Appliction making most features of krayon4insilico  available was finished. This state of work is located on the master branch.  
Up to this point Drag and Drop which is central for krayon4sbgn functionality does not work inside a javaFX swingNode. It was decided to keep this issue open and continue working on plugin development.
In the following weeks problems with insilicos maven build occured leading to a bug fix for insilicos maven build under Windows.
In the last weeks of working time the current state of the project with the final plugin structures consisting of a bundle the corresponding feature and osgi-services were finished.  
The plugin still contains several bugs. For this see [Issues](https://github.com/draeger-lab/krayon4insilico/issues) and next steps.

## Next steps
This project will be turned over to another developer so hera are a couple of instructions:
At first this project should be installed and built and then debugged to work inside insilico displaying sbgn files. Right now there are still problems with obtaining a document url from the context for sbgn files.   Once this is fixed the plugin should be further optimized. The first and most important step will be to replace the swing GUI of [krayon4sbgn](https://github.com/draeger-lab/krayon4sbgn) with a GUI definition based on JavaFX to enable drag and drop and get rid of the unwanted GUI behavior caused by using swingNodes to display Krayon4sbgn in JavaFX.  
After that the new developer is free to optimize the krayon4sbgn menu and functionality to match insilico and to work on interaction with other plugins.

## Building the project
Start by installing [insilico](https://github.com/draeger-lab/insilico) so it can be started in eclipse (follow instructions in README.md).  Clone this project and checkout plugin-dev then replace git files and README.md of insilico with the corresponding files from this project and add the krayon4insilico bundle und feature to insilicos bundles and features. The easiest way to do this is to copy the content of your insilico project to this project.   
In org.insilico.product add krayon4insilico.feature to contents.
For debugging also add "-console" to Launching Programm Arguments.
For this plugin to work properly krayon4sbgn.jar has to be located in /bundles/org.insilico.krayon4insilico/res.

## Authors
[Anton Rabe](https://github.com/AntonJuliusRabe)

Supervisor:
[Dr. Andreas Draeger](https://github.com/draeger)

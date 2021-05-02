# Simple JavaFX project example

Here is an example of an application with a local (heavyweight) graphical user interface based on Java and javaFX.

## Dependencies

It needs a *Java Runtime Environment* version 11+ in order to run the application.

Basically, it can run on many platforms as long as a JRE is available, but start scripts are only provided for Windows and Linux. In both cases, the `JAVA_HOME` environment variable must be defined on the system.

In order to build the project, you will need:
* A [JDK](https://jdk.java.net/) version 11 or more
* [Apache Maven](https://maven.apache.org/) version 3.6.0 or more

## Usage

* (Compile the project with the command `mvn package` which should not be done by real end-users in a real project of course)
* Go to the `target` folder
* Call either `start.sh` from Linux or MacOS, or `start.bat` from Windows.

## Contributing

You may also run the application with the following command:

    cd gui && mvn javafx:run

## License

This project is licensed according to **CC BY-NC-SA** ( [description](https://creativecommons.org/licenses/by-nc-sa/4.0/) | [legal](https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode) )

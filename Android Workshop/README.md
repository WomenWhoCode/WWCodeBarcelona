# Android Workshop
Workshop details and final project

Please follow the installation instructions below before the day of the workshop. Downloading the required tools takes time 
so it is important to come prepared, that way you will be ready to start coding and will benefit from it most.
Bear in mind that the wifi in the workshops may be a bit slow so we strongly recommend installing before hand.
Do not hesitate to write a comment in the meetup if you have an issue. In order for us to help you as soon 
as possible indicate what is your computer model, operating system and the errors you are seeing.

## Installation instructions
 
 1. Install Java

    * Open a Command line
        - Windows: go to the search ()at the bottom left in Windows 10) and type cmd. You will see a program in the list, select it.
        - Linux: ctr + alt + T or look for the app Terminal
        - Mac: look for the app Terminal (often inside tools??) 
    * Check if you have java installed, type in the command line:
 
      `java -version` or `which java`
      
      If you get a message displaying a path or a version of java, you can skip to step 2.
    * Installation: 
        - Linux:
         ```
         sudo add-apt-repository ppa:webupd8team/java
         sudo apt-get update
         sudo apt-get install oracle-java8-installer
         sudo apt-get install oracle-java8-set-default
         ```
        - Mac and Windows:     
            * Go to the [Oracle website](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
            * On the first box tick the __Accept License Agreement__ checkbox and select the right build for 
                your operating system. 
                - Mac: lucky you, there is only one in the list for Macs to chose from.
                - Windows: 
                    If you have windows 10 or 8 type 
                    ```
                    control /name Microsoft.System
                    ``` 
                    in the command line or open the Control panel manually. 
                    For older versions open the control panel manually.
                    There should be a system section and it will say __64 bits system__ or __32 bits system__
            * Click in the downloaded file to open it and follow the instructions of the installer.
      
      
    2. Setup JAVA_HOME
    
 * Check if you have it already setup, in the command line type:
 
    * Linux and Mac:
    ```
        echo $JAVA_HOME
    ```
    * Windows
    ```
       echo %JAVA_HOME%
     ```    
    If you get a file path, then you can go to step 3.
 
 * Setup
   - Windows:
   
        - Start > Control Panel > System > Advanced System Settings > Environment Variables System Variables > New
        - Variable name: JAVA_HOME
        - Variable value: C:\Program Files\Java\jdk1.8.0_171 (or whatever version your installation is!)
        - Don't forget to accept.
        - Open a new command line and type: `echo %JAVA_HOME%` again to make sure the path is set.
      
   - Mac:
   
        - Open Terminal.
        - Navigate to your home directory using `cd`
        - Open the file `~/.bash_profile` which is a configuration file for your terminal
        - Add the following command to the file: 
        `export JAVA_HOME=$(/usr/libexec/java_home)`
        - Reload the configuration file using:
        `source ~/.bash_profile`
        - Enter `echo $JAVA_HOME` to confirm the path.
   - Linux:
        - Open `.bashrc` file. Add `export JAVA_HOME=/usr/lib/jvm/java-8-oracle` at the end of the file.
        - Open a terminal and check with `echo $JAVA_HOME`
   
        
    3. Install Android Studio
    
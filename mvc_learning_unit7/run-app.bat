@echo off

:: Build the project
echo Building the project...
call mvn clean package

:: Copy WAR file to Tomcat webapps directory
echo Copying WAR file to Tomcat...
xcopy target\mvc_learning_unit7-1.0-SNAPSHOT.war "C:\Program Files\Apache Software Foundation\Tomcat 10.0\webapps\mvc_learning_unit7.war" /Y

:: Start Tomcat
echo Starting Tomcat...
start "" "C:\Program Files\Apache Software Foundation\Tomcat 10.0\bin\startup.bat"

:: Wait for Tomcat to start
timeout /t 10

:: Open browser
echo Opening browser...
start http://localhost:8080/mvc_learning_unit7/employee

echo Application is now running in external browser.
pause

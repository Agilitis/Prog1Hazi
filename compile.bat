@echo off
echo 	======== Projlab 2019 BME ========
echo 	========    WeCsharp      ========

rem Delete old build if exists
IF EXIST "bin\" (
    echo Cleaning possible old build...
    rmdir /s /q bin
)

rem Defines preferred java path 
if defined JAVA_HOME (
if exist "%JAVA_HOME%\bin\javac.exe" goto okJavac
)

rem No java version found, exit.


rem Java version found, continue as normal
:okJavac
echo Java path "%JAVA_HOME%"
"%JAVA_HOME%\bin\javac.exe" -version

rem Compile .\src\\*.java into .\bin\\*.class using libraries in .\lib\\*.jar
subst m: %0\..
rem "%0\.." is the real path of the batch file
pushd m:
cd \
echo Search java sources in .\src\...
dir src\*.java /B/S > javasrc.tmp~
if ERRORLEVEL 1 (
echo Cannot find Java source files in .\src\
goto abort
)
echo Search jar libraries in .\lib\...
if exist lib for /F "usebackq delims==" %%l in (`dir lib\*.jar /B/S`) do echo -classpath %%l >> javasrc.tmp~
echo Compile in .\bin\...
if exist bin rmdir /S /Q bin
mkdir bin
echo on
@"%JAVA_HOME%\bin\javac.exe" -encoding utf8 -d bin @javasrc.tmp~
@echo  off
echo Done compile.
robocopy input/ bin/input /E > nul
robocopy lib/ bin/lib /E > nul
echo Input and libs copied to bin dir for use when running the program!

:abort
del javasrc.tmp~
popd

:end
set JAVA_ROOT=
echo Please run run.bat to run the program! Setup and Compile done.
echo on
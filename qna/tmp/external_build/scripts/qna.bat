@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  qna startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and QNA_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\qeatsbackend-v1.jar;%APP_HOME%\lib\spring-boot-starter-log4j2-2.1.4.RELEASE.jar;%APP_HOME%\lib\log4j-slf4j-impl-2.12.1.jar;%APP_HOME%\lib\log4j-core-2.12.1.jar;%APP_HOME%\lib\log4j-jul-2.12.1.jar;%APP_HOME%\lib\log4j-api-2.12.1.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.28.jar;%APP_HOME%\lib\spring-boot-starter-web-2.1.4.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-json-2.1.4.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-actuator-2.1.4.RELEASE.jar;%APP_HOME%\lib\spring-boot-actuator-autoconfigure-2.1.4.RELEASE.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.9.8.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.9.8.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.9.8.jar;%APP_HOME%\lib\jackson-databind-2.9.8.jar;%APP_HOME%\lib\jackson-core-2.9.8.jar;%APP_HOME%\lib\springfox-swagger2-2.9.2.jar;%APP_HOME%\lib\springfox-swagger-common-2.9.2.jar;%APP_HOME%\lib\swagger-models-1.5.20.jar;%APP_HOME%\lib\jackson-annotations-2.9.8.jar;%APP_HOME%\lib\geohash-1.3.0.jar;%APP_HOME%\lib\spring-boot-starter-data-mongodb-2.1.4.RELEASE.jar;%APP_HOME%\lib\modelmapper-2.3.2.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\springfox-swagger-ui-2.9.2.jar;%APP_HOME%\lib\springfox-spring-web-2.9.2.jar;%APP_HOME%\lib\springfox-schema-2.9.2.jar;%APP_HOME%\lib\springfox-spi-2.9.2.jar;%APP_HOME%\lib\springfox-core-2.9.2.jar;%APP_HOME%\lib\guava-20.0.jar;%APP_HOME%\lib\spring-boot-devtools-2.1.4.RELEASE.jar;%APP_HOME%\lib\spring-data-mongodb-2.1.6.RELEASE.jar;%APP_HOME%\lib\spring-plugin-metadata-1.2.0.RELEASE.jar;%APP_HOME%\lib\spring-plugin-core-1.2.0.RELEASE.jar;%APP_HOME%\lib\spring-data-commons-2.1.6.RELEASE.jar;%APP_HOME%\lib\slf4j-api-1.7.26.jar;%APP_HOME%\lib\spring-boot-starter-2.1.4.RELEASE.jar;%APP_HOME%\lib\mongodb-driver-3.8.2.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.1.4.RELEASE.jar;%APP_HOME%\lib\hibernate-validator-6.0.16.Final.jar;%APP_HOME%\lib\spring-webmvc-5.1.6.RELEASE.jar;%APP_HOME%\lib\spring-web-5.1.6.RELEASE.jar;%APP_HOME%\lib\micrometer-core-1.1.4.jar;%APP_HOME%\lib\swagger-annotations-1.5.20.jar;%APP_HOME%\lib\classmate-1.4.0.jar;%APP_HOME%\lib\mapstruct-1.2.0.Final.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.1.4.RELEASE.jar;%APP_HOME%\lib\spring-boot-actuator-2.1.4.RELEASE.jar;%APP_HOME%\lib\spring-boot-2.1.4.RELEASE.jar;%APP_HOME%\lib\javax.annotation-api-1.3.2.jar;%APP_HOME%\lib\spring-tx-5.1.6.RELEASE.jar;%APP_HOME%\lib\spring-context-5.1.6.RELEASE.jar;%APP_HOME%\lib\spring-aop-5.1.6.RELEASE.jar;%APP_HOME%\lib\spring-beans-5.1.6.RELEASE.jar;%APP_HOME%\lib\spring-expression-5.1.6.RELEASE.jar;%APP_HOME%\lib\spring-core-5.1.6.RELEASE.jar;%APP_HOME%\lib\snakeyaml-1.23.jar;%APP_HOME%\lib\mongodb-driver-core-3.8.2.jar;%APP_HOME%\lib\bson-3.8.2.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.17.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.17.jar;%APP_HOME%\lib\tomcat-embed-el-9.0.17.jar;%APP_HOME%\lib\validation-api-2.0.1.Final.jar;%APP_HOME%\lib\jboss-logging-3.3.2.Final.jar;%APP_HOME%\lib\HdrHistogram-2.1.9.jar;%APP_HOME%\lib\LatencyUtils-2.0.3.jar;%APP_HOME%\lib\spring-jcl-5.1.6.RELEASE.jar;%APP_HOME%\lib\byte-buddy-1.9.12.jar


@rem Execute qna
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %QNA_OPTS%  -classpath "%CLASSPATH%"  %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable QNA_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%QNA_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega

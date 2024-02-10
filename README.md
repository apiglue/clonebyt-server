# Clonebyt Server

## Build

Gradle:
`./gradlew build --no-daemon`

Build image:
` docker build -t marcelo10/io.apilgue.clonebyt-server .`

Run container:
`docker run -it -p 8888:8080 marcelo10/io.apiglue.clonebyt-server /bin/bash`
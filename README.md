# File manager
Pirlouit PROVIS

You can retreive this image from DockerHub.  
pull: `docker pull pirlouitprovis/filemanager:release`
run: `docker run -p 8080:8080 -t pirlouitprovis/filemanager:release`
#### Build and run with docker
To build the image: `sudo ./mvnw install dockerfile:build`  
To run it: `sudo docker run -p 8080:8080 -t pirlouitprovis/filemanager:latest`  
To stop the image:  
`sudo docker ps` to see all the images running.  
`sudo docker stop <CONTAINER ID>` to stop the image.

#### How to use it
File manager is a micro-service allowing you to upload files on your server.  
By default the files will be stored in a directory `/uploads` where the micro-servcice runs.  
If you want to change the location, you have to modify it in the resource [file](/src/main/resources/application.properties): `/src/main/resources/application.properties`.  
Modify the parameter `file.upload-dir` with a new path.  
Exemple:
```json
## File Storage Properties
# All files uploaded through the REST API will be stored in this directory
file.upload-dir=/home/user/Documents/fileStorage
```

Once it runs, you can test it by using the `index.html` file in the `front-file-upload` folder.  
On the web page, there is a button to add a file and another to upload the file.
Once you have uploaded a file you can check the files contained by going to http://localhost:8080/listFiles  


# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:8
ADD docker-S3-jar.jar docker-S3-jar.jar
EXPOSE 9087
ENTRYPOINT ["java", "-jar", "docker-S3-jar.jar"]
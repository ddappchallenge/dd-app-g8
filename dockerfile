FROM openjdk:8-jdk-alpine
ADD <source_app_path> <dest_app_path>
EXPOSE <tomcat_port>
ENTRYPOINT ["java","-jar","dest_app_path"]

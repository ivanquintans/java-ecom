FROM tomcat:9.0-jdk8-corretto

WORKDIR /usr/local/tomcat
COPY ./context.xml ./conf/context.xml
COPY ./tienda ./webapps/tienda
COPY ./javafiles ./webapps/tienda/javafiles


WORKDIR /usr/local/tomcat/webapps/tienda
RUN mkdir -p ./WEB-INF/classes
RUN javac -cp ./WEB-INF/lib/servlet-api.jar:./WEB-INF/lib/postgresql-42.7.3.jar -d ./WEB-INF/classes ./javafiles/**/*.java 

WORKDIR /usr/local/tomcat
EXPOSE 8080
CMD [ "/bin/sh", "-c", "catalina.sh run" ]
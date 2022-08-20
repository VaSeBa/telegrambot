FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=JavaRush_VaSeBa_bot
ENV BOT_TOKEN=5439984676:5439984676:AAHNo0SCVbQtiYBL3CPP43zNcHl7NApZI_c
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]
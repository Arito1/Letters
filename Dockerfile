# ---------- BUILD STAGE ----------
FROM gradle:8.8-jdk21 AS builder

WORKDIR /app

# Копируем только то, что нужно для кеша зависимостей
COPY build.gradle settings.gradle gradle ./
COPY gradlew gradlew.bat ./
COPY gradle/wrapper gradle/wrapper

RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

# Копируем остальной код
COPY src src

# Собираем JAR
RUN ./gradlew bootJar --no-daemon

# ---------- RUNTIME STAGE ----------
FROM bellsoft/liberica-openjdk-debian:21

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

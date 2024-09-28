FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder
WORKDIR /opt/app
COPY . .
RUN  --mount=type=cache,target=/root/.m2 mvn --activate-profiles docker --batch-mode --update-snapshots clean install package

FROM eclipse-temurin:21-jre-alpine
WORKDIR /opt/monitoring

# Create a group and user
RUN addgroup -S monitoring && \
    adduser -S -G monitoring monitoring && \
    chown -R monitoring:monitoring /opt/monitoring

COPY --from=builder /opt/app/target/monitoring.jar .

# Change to 'monitoring' user
USER monitoring

ENTRYPOINT ["java", "-jar", "/opt/monitoring/monitoring.jar"]
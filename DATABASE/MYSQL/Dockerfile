# Use the official MySQL base image from Docker Hub
FROM arm64v8/mysql:latest

# Copy the schema.sql file to the container
COPY ../../Docker/DATABASE/MYSQL/schema.sql /docker-entrypoint-initdb.d/

# Set environment variables
ENV MYSQL_ROOT_PASSWORD=password
ENV MYSQL_DATABASE=fortunes
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=password

# Expose the MySQL port (default: 3306)
EXPOSE 3306

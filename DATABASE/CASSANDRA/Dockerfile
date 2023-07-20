# Use the official Cassandra base image from Docker Hub
FROM arm64v8/cassandra:latest

# Copy the schema.cql file to the container
COPY schema.cql /etc/cassandra/schema.cql


# Run the schema initialization script when the container starts
COPY init.sh /docker-entrypoint-initdb.d/init.sh
RUN chmod +x /docker-entrypoint-initdb.d/init.sh

# Expose the Cassandra port (default: 9042)
EXPOSE 9042

-- Create keyspace
CREATE KEYSPACE IF NOT EXISTS history
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

-- Use keyspace
USE history;

-- Create table
CREATE TABLE IF NOT EXISTS fortunes (
      userId UUID,
      fortune TEXT,
      date TIMESTAMP,
      PRIMARY KEY (userId, date)
);

CREATE KEYSPACE IF NOT EXISTS history
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE history;

CREATE TABLE IF NOT EXISTS fortunes (
      userId INT,
      wish TEXT,
      theme TEXT,
      date TIMESTAMP,
      PRIMARY KEY (userId, date)
);

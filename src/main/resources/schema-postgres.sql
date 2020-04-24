DROP TABLE IF EXISTS triggers;
-- CREATE SEQUENCE hibernate_sequence START 1;
CREATE TABLE triggers(id serial PRIMARY KEY, nname VARCHAR(255),  researcher VARCHAR(255), bucket VARCHAR(255), college VARCHAR(255), threshold INT);

INSERT INTO triggers(nname, researcher, bucket, college, threshold) VALUES('Notifier1', 'Andrew Aldrich', 'Bucket1', 'Engineering', 52);
INSERT INTO triggers(nname, researcher, bucket, college, threshold) VALUES('Notifier1', 'Ryan Karrasch', 'Bucket3', 'Engineering', 75);
INSERT INTO triggers(nname, researcher, bucket, college, threshold) VALUES('Notifier2', 'Jon Snoe', 'Bucket2', 'Medical', 104);
INSERT INTO triggers(nname, researcher, bucket, college, threshold) VALUES('Notifier3', 'Ryan Karrasch', 'Bucket2', 'Engineering', 17);
INSERT INTO triggers(nname, researcher, bucket, college, threshold) VALUES('Notifier4', 'Jon Snoe', 'Bucket3', 'Engineering', 157);

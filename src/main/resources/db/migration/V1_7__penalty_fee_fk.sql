-- Create foreign key PenaltyFee_FK

CREATE TEMPORARY TABLE temp AS
SELECT *
FROM PenaltyFee;

DROP TABLE PenaltyFee;

CREATE TABLE PenaltyFee (
	id STRING,
	reason STRING,
	value REAL,
	state STRING,
	CONSTRAINT PenaltyFee_FK FOREIGN KEY (id) REFERENCES License(id)
);

INSERT INTO PenaltyFee
SELECT *
FROM temp;

DROP TABLE temp;


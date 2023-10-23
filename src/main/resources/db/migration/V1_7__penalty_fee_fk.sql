-- Create foreign key PenaltyFee_FK

DROP TABLE PenaltyFee;

CREATE TABLE PenaltyFee (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	reason STRING,
	value REAL,
	id_license INTEGER,
	CONSTRAINT PenaltyFee_FK FOREIGN KEY (id_license) REFERENCES License(id)
);




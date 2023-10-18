CREATE TEMPORARY TABLE license_temp AS
SELECT *
FROM License;

DROP TABLE License;

create table License (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_client integer,
    id_auditor string,
    start string,
    end string,
    state string,
    estimated_impact string,
    necessary_recovery string,
    CONSTRAINT License_FK_Client FOREIGN KEY (id_client) REFERENCES Client(id)
);

INSERT INTO License
SELECT *
FROM license_temp;

DROP TABLE license_temp;

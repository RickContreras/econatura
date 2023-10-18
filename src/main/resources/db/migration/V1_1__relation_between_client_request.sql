CREATE TEMPORARY TABLE client_temp AS
SELECT *
FROM Client;

CREATE TEMPORARY TABLE request_temp AS
SELECT *
FROM Request;

DROP TABLE Client;
DROP TABLE Request;

create table Client (
    id integer primary key AUTOINCREMENT,
    fullname string,
    document string,
    type string
);

CREATE TABLE Request (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	id_cliente STRING,
	resource_id STRING,
	date STRING,
	state STRING,
	estimated_impact STRING,
	necessary_recovery STRING,
	CONSTRAINT Request_FK_Client FOREIGN KEY (id) REFERENCES Client(id)
);

INSERT INTO Client
SELECT null, fullname, document, type
FROM client_temp;

INSERT INTO Request
SELECT *
FROM request_temp;

DROP TABLE client_temp;
DROP TABLE request_temp;

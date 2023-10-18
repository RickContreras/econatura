-- Drop column resource_id

CREATE TEMPORARY TABLE temp AS
SELECT
  id,
  id_cliente,
  date,
  state,
  estimated_impact,
  necessary_recovery
FROM Request;

DROP TABLE Request;

CREATE TABLE Request (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	id_cliente STRING,
	date STRING,
	state STRING,
	estimated_impact STRING,
	necessary_recovery STRING,
	nombre_recurso TEXT,
	municipio TEXT,
	departamento TEXT,
	CONSTRAINT Request_FK_Client FOREIGN KEY (id) REFERENCES Client(id)
);

INSERT INTO Request
 (id,
  id_cliente,
  date,
  state,
  estimated_impact,
  necessary_recovery)
SELECT
  id,
  id_cliente,
  date,
  state,
  estimated_impact,
  necessary_recovery
FROM temp;

DROP TABLE temp;

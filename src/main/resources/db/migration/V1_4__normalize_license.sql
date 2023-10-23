-- Drop column necessary_recovery
-- Drop column estimated_impact

CREATE TEMPORARY TABLE temp AS
SELECT
  id,
  id_request,
  id_auditor,
  "start",
  "end",
  state
FROM License;

DROP TABLE License;

CREATE TABLE License (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	id_request INTEGER,
	id_auditor INTEGER,
	"start" STRING,
	"end" STRING,
	state STRING,
	CONSTRAINT License_FK_Request FOREIGN KEY (id_request) REFERENCES Request(id)
);

INSERT INTO License
 (id,
  id_request,
  id_auditor,
  "start",
  "end",
  state)
SELECT
  id,
  id_request,
  id_auditor,
  "start",
  "end",
  state
FROM temp;

DROP TABLE temp;

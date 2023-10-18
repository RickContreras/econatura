DROP TABLE License;

create table License (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_request integer,
    id_auditor integer,
    start string,
    end string,
    state string,
    estimated_impact string,
    necessary_recovery string,
    CONSTRAINT License_FK_Request FOREIGN KEY (id_request) REFERENCES Request(id)
);

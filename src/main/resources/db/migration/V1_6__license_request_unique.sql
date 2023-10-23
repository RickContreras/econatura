DELETE FROM License;
CREATE UNIQUE INDEX License_id_request_IDX ON License (id_request);
UPDATE Request set state="IN_REVIEW" where state="APROVED";

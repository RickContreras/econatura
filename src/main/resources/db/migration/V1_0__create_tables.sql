create table IF NOT EXISTS Client (fullname string, document string, type string );
create table IF NOT EXISTS License (id string, id_client string, id_auditor string , start string,end string, state string, estimated_impact string , necessary_recovery string);
create table IF NOT EXISTS PenaltyFee (id string, reason string, value real , state string);
create table IF NOT EXISTS Request (id string, id_cliente string, resource_id string , date string, state string,estimated_impact string,necessary_recovery string);
create table IF NOT EXISTS Resource (name string, lo string, la string , type string, capacity string);
CREATE UNIQUE INDEX IF NOT EXISTS Client_document_IDX ON Client (document);

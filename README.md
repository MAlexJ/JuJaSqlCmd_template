# JuJaSqlCmd_template
Console Application
Database - PostgreSQL


**********************  sqlcmd  ***************************   
CREATE DATABASE sqlcmd
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'C'
       LC_CTYPE = 'C'
       CONNECTION LIMIT = -1;
       
CREATE TABLE "user"
(
  id serial NOT NULL,
  name character varying(20) NOT NULL,
  password character varying(20) NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "user"
  OWNER TO postgres;
  
  
CREATE TABLE test
(
  id integer NOT NULL,
  name character varying(20),
  password character varying(20),
  CONSTRAINT test_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE test
  OWNER TO postgres;

**********************  test  ***************************       
CREATE DATABASE test
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'C'
       LC_CTYPE = 'C'
       CONNECTION LIMIT = -1;
       
CREATE TABLE qwe ()
WITH (  OIDS=FALSE);
ALTER TABLE qwe OWNER TO postgres;


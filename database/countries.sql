SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP TABLE IF EXISTS countries CASCADE;

CREATE TABLE countries (
  id       integer PRIMARY KEY,
  name     varchar(60),
  name_pt_br  varchar(60),
  code     varchar(2),
  bacen    integer
);

COMMENT ON TABLE countries
  IS 'Countries and Nations';

COMMENT ON COLUMN countries.code
  IS 'ISO 3166-1 Alpha2';

INSERT INTO countries (id, name, name_pt_br, code, bacen) VALUES
(1, 'Brazil', 'Brasil', 'BR', 1058);

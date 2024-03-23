--liquibase formatted sql

--changeset didenko:1
ALTER TABLE cruise
ADD COLUMN duration INT NOT NULL DEFAULT 1,
ADD COLUMN first_port_id BIGINT REFERENCES port(id),
ADD COLUMN last_port_id BIGINT REFERENCES port(id);
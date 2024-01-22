--liquibase formatted sql

--changeset didenko:1
CREATE TABLE document(
    id BIGSERIAL PRIMARY KEY ,
    client_id BIGINT NOT NULL REFERENCES client(id),
    name VARCHAR(64) NOT NULL UNIQUE ,
    state VARCHAR(18) NOT NULL
)
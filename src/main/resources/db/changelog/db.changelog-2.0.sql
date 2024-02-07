--liquibase formatted sql

--changeset didenko:1
ALTER TABLE document
ADD COLUMN number VARCHAR(12) UNIQUE ;
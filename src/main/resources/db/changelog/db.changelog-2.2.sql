--liquibase formatted sql

--changeset didenko:1
ALTER TABLE document
DROP COLUMN number;
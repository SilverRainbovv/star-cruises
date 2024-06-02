--liquibase formatted sql

--changeset didenko:1
ALTER TABLE cruise
ADD COLUMN state VARCHAR NOT NULL DEFAULT 'UPCOMING';
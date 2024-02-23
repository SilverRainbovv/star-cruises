--liquibase formatted sql

--changeset didenko:1
ALTER TABLE ship
ADD COLUMN image VARCHAR;
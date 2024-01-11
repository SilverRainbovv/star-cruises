--liquibase formatted sql

--changeset didenko:1
ALTER TABLE cruise
ADD COLUMN image VARCHAR(64);
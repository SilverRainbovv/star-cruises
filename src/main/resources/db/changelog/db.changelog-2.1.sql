--liquibase formatted sql

--changeset didenko:1
ALTER TABLE seat
ADD COLUMN number_of_persons INT NOT NULL DEFAULT 1;
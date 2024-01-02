--liquibase formatted sql

--changeset didenko:1
ALTER TABLE cruise
ADD COLUMN description VARCHAR(256) DEFAULT '';
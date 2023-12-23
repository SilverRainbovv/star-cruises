--liquibase formatted sql

--changeset didenko:1
ALTER TABLE seat
ADD COLUMN seat_class VARCHAR(32);
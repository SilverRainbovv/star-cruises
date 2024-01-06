--liquibase formatted sql

--changeset didenko:1
ALTER TABLE seat
ADD COLUMN seat_group INT;

ALTER TABLE seat
ADD UNIQUE (seat_group, number);
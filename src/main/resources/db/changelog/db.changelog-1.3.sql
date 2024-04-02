--liquibase formatted sql

--changeset didenko:1
ALTER TABLE seat
ADD COLUMN seat_group INT;

ALTER TABLE seat
ADD UNIQUE (ship_id ,seat_group, number);
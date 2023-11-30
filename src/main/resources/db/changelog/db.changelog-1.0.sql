--liquibase formatted sql

--changeset didenko:1
CREATE TABLE ship (
                      id BIGSERIAL PRIMARY KEY ,
                      name VARCHAR(64) UNIQUE NOT NULL
);

--changeset didenko:2
CREATE TABLE seat (
                      id BIGSERIAL PRIMARY KEY ,
                      ship_id BIGINT REFERENCES ship(id) ON DELETE CASCADE NOT NULL,
                      number VARCHAR(8) NOT NULL ,
                      price NUMERIC(9, 2) NOT NULL ,
                      vacancy VARCHAR (16) NOT NULL
);

--changeset didenko:3
CREATE TABLE cruise (
                        id BIGSERIAL PRIMARY KEY ,
                        ship_id BIGINT REFERENCES ship(id) ON DELETE CASCADE NOT NULL
);

--changeset didenko:4
CREATE TABLE port (
                      id BIGSERIAL PRIMARY KEY ,
                      name VARCHAR(128) NOT NULL ,
                      cruise_id BIGINT REFERENCES cruise(id) ON DELETE CASCADE NOT NULL,
                      visit_date DATE NOT NULL
);

--changeset didenko:5
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY ,
                       role VARCHAR(32) NOT NULL ,
                       email VARCHAR(64) UNIQUE NOT NULL ,
                       password VARCHAR(128) NOT NULL
);

--changeset didenko:6
CREATE TABLE client (
                        id BIGSERIAL PRIMARY KEY ,
                        user_id BIGINT REFERENCES users(id) UNIQUE NOT NULL ,
                        firstname VARCHAR(64) NOT NULL ,
                        lastname VARCHAR(64) NOT NULL ,
                        birth_date DATE NOT NULL
) INHERITS (users);

--changeset didenko:7
CREATE TABLE ticket (
                        id BIGSERIAL PRIMARY KEY ,
                        cruise_id BIGINT REFERENCES cruise(id) NOT NULL ,
                        seat_id BIGINT REFERENCES seat(id) NOT NULL ,
                        client_id BIGINT REFERENCES client(id) NOT NULL ,
                        state VARCHAR(32) NOT NULL
);
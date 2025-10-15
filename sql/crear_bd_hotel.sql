-- Script SQL para crear la BD y tablas (Hotel)
-- Ejecutar como superusuario postgres (psql -U postgres)
CREATE DATABASE hotel;
\c hotel
-- Tablas
CREATE TABLE hotel (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    ciudad VARCHAR(50),
    direccion VARCHAR(150)
);

CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(20)
);

CREATE TABLE habitacion (
    id SERIAL PRIMARY KEY,
    numero INT NOT NULL,
    tipo VARCHAR(50),
    precio NUMERIC(12,2),
    hotel_id INT NOT NULL REFERENCES hotel(id) ON DELETE CASCADE
);

CREATE TABLE empleado (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cargo VARCHAR(50),
    salario NUMERIC(12,2),
    hotel_id INT REFERENCES hotel(id) ON DELETE SET NULL
);

CREATE TABLE reserva (
    id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL REFERENCES cliente(id) ON DELETE RESTRICT,
    hotel_id INT NOT NULL REFERENCES hotel(id) ON DELETE CASCADE,
    habitacion_id INT NOT NULL REFERENCES habitacion(id) ON DELETE RESTRICT,
    fecha_inicio DATE,
    fecha_fin DATE
);

CREATE TABLE actividad (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    costo NUMERIC(12,2),
    hotel_id INT REFERENCES hotel(id) ON DELETE CASCADE
);

CREATE TABLE factura (
    id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL REFERENCES cliente(id) ON DELETE RESTRICT,
    reserva_id INT REFERENCES reserva(id) ON DELETE SET NULL,
    fecha DATE,
    total NUMERIC(12,2)
);

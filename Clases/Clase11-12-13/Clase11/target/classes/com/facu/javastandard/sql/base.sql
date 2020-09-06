drop database if exists colegio;

create database colegio;

use colegio;

create table cursos(
    id int identity(1,1) primary key,
    titulo varchar(20) not null,
    profesor varchar(20) not null,
    dia varchar(20) not null,
    turno varchar(20) not null
);

create table alumnos(
    id int identity(1,1) primary key,
    nombre varchar(20) not null,
    apellido varchar(20) not null,
    edad int,
    curso int
);
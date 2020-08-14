drop database if exists concesionaria;
create database concesionaria;
use concesionaria;

create table autos (
    au_id int auto_increment primary key,
    au_marca varchar(255) not null,
    au_modelo varchar(255) not null,
    au_precio float not null,
    au_color varchar(255) not null,
    au_largo int not null,
    au_ancho int not null,
    au_altura int not null,
    au_equipamiento varchar(255) not null
);

create table compradores (
    c_id int auto_increment primary key,
    c_nombre varchar(255) not null,
    c_apellido varchar(255) not null,
    c_dni varchar(255) not null,
    c_presupuesto float not null
);

create table vendedores (
    v_id int auto_increment primary key,
    v_nombre varchar(255) not null,
    v_apellido varchar(255) not null,
    v_dni varchar(255) not null,
    v_autosVendidos int not null
);
    

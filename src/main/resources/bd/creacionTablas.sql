drop database if exists gestionalumnos;
create database gestionalumnos;
use gestionalumnos;

create table cursos(
    id int not null primary key auto_increment,
    nombre_curso varchar(1) not null
);

create table divisiones(
    id int not null primary key auto_increment,
    nombre_division varchar(1) not null
);

/*
 create table examenes(
   id int not null primary key auto_increment,
    fecha_Examen date not null,
    nota float
 ); */
/*
create table practicos(
    id int not null primary key auto_increment,
    fecha_Practico date not null,
    nota float
);
*/
create table alumnos(
    id int not null primary key auto_increment,
    nombre varchar(20) not null,
    apellido varchar(15) not null,
    dni varchar(8) not null unique,
    genero varchar(1) not null, 
    fecha_nacimiento date
);

create table profesores(
    id int not null primary key auto_increment,
    nombre varchar(20) not null,
    apellido varchar(15) not null,
    dni varchar(8) not null,
    genero varchar(1) not null, 
    fecha_nacimiento date
);

create table usuarios(
    id int not null primary key auto_increment,
    username varchar(15) not null,
    pass varchar(255) not null,
    email varchar(30) not null,
    enabled boolean
);

create table roles(
	id int not null primary key auto_increment,
	authority varchar(255) unique
);

create table materias(
    id int not null primary key auto_increment,
    nombre_materia varchar(20) not null,
    hr_inicio time not null,
    hr_fin time not null
);

create table notas(
	id int not null primary key auto_increment,
	nota int,
    descripcion varchar(25),
    fecha date
);

create table agendas(
	id int not null primary key auto_increment,
    titulo varchar(20) not null,
    descripcion varchar(100) not null,
    fecha date
);


CREATE DATABASE prueba-tecnica
    WITH OWNER = postgres
        ENCODING = 'UTF8'
        TABLESPACE = pg_default
        LC_COLLATE = 'undefined'
        LC_CTYPE = 'undefined'
        CONNECTION LIMIT = -1;

create table examen (
    id uuid primary key,
    nombre varchar(300) not null
);

create table estudiante (
    id uuid  primary key,
    nombre varchar(300) not null,
    edad int not null,
    ciudad varchar(300) not null,
    zona_horaria varchar(120) not null
);

create table pregunta (
    id uuid primary key,
    id_examen uuid not null, foreign key(id_examen) references examen(id),
    interrogante varchar(300) not null,
    primera_opcion varchar(300) not null,
    segunda_opcion varchar(300) not null,
    tercera_opcion varchar(300) not null,
    cuarta_opcion varchar(300) not null,
    opcion_correcta varchar(1) not null
);

create table estudiante_asignacion_examen (
    id_examen uuid not null, foreign key(id_examen) references examen(id),
    id_estudiante uuid not null, foreign key(id_estudiante) references estudiante(id),
    fecha_presentacion timestamp not null,
    zona_horaria varchar(120) not null,
    primary key (id_examen, id_estudiante)
);

create table estudiante_respuestas_examen (
    id_estudiante uuid not null,foreign key(id_estudiante) references estudiante(id),
    id_examen uuid not null, foreign key(id_examen) references examen(id),
    id_pregunta uuid not null, foreign key(id_pregunta) references pregunta(id),
    respuesta varchar(1) not null,
    primary key (id_estudiante, id_examen, id_pregunta)
);
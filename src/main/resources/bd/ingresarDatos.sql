insert into divisiones(nombre_division) values
('A'),
('B');

insert into cursos(nombre_curso, fk_cur_div) values
('3',1),
('3',2);

insert into profesores(nombre, apellido, dni, genero, fecha_nacimiento) values
('Luisina', 'Espindola', '28374944', 'F', '1985-04-25');


insert into materias(nombre_materia, hr_inicio, hr_fin, fk_mat_pro, fk_mat_cur) values
('Informática I', '14:30', '15:30', 1, 1),
('Informática I', '16:30', '17:30', 1, 2);


insert into Usuarios(username, pass, email, enabled)
values
('MESistemas','$2a$10$wr5sgAORjIxbNaVwFUnwO.72rLDTyc2oIetfr/H0wjLnddRPWaisG','matiasespindolads@gmail.com',1);

insert into Roles(user_id, authority)
values
(1, 'ADMIN');


select * from alumnos;

delete from alumnos where id = 3;

select * from notas where descripcion = 'Primer Examen';

select * from agendas;

select * from usuarios;

select * from profesores;

select * from roles;

select * from materias;
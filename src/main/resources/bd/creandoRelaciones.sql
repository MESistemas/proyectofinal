alter table alumnos add column fk_alu_cur int null;
alter table alumnos add constraint fk_alu_cur foreign key (fk_alu_cur)
references cursos(id) on delete cascade;

alter table usuarios add column fk_usu_pro int null;
alter table usuarios add constraint fk_usu_pro foreign key (fk_usu_pro)
references profesores(id) on delete cascade;

alter table notas add column fk_not_alu int null;
alter table notas add constraint fk_not_alu foreign key (fk_not_alu)
references alumnos(id) on delete cascade;

alter table roles add column user_id int null;
alter table roles add constraint user_id foreign key (user_id)
references usuarios(id) on delete cascade;

alter table notas add column fk_not_mat int null;
alter table notas add constraint fk_not_mat foreign key (fk_not_mat)
references materias(id) on delete cascade;

/*
alter table materias_alumnos add column fk_Mat_Exa int null;
alter table materias_alumnos add constraint fk_Mat_Exa foreign key (fk_Mat_Exa)
references examenes(id) on delete cascade;

alter table materias_alumnos add column fk_Mat_Pra int null;
alter table materias_alumnos add constraint fk_Mat_Pra foreign key (fk_Mat_Pra)
references practicos(id) on delete cascade; */

alter table materias add column fk_mat_pro int null;
alter table materias add constraint fk_mat_pro foreign key (fk_mat_pro)
references profesores(id) on delete cascade;

alter table materias add column fk_mat_cur int null;
alter table materias add constraint fk_mat_cur foreign key (fk_mat_cur)
references cursos(id) on delete cascade;

alter table agendas add column fk_age_mat int null;
alter table agendas add constraint fk_age_mat foreign key (fk_age_mat)
references materias(id) on delete cascade;


alter table cursos add column fk_cur_div int null;
alter table cursos add constraint fk_cur_div foreign key (fk_cur_div)
references divisiones(id) on delete cascade;
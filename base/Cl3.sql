create database modelo_CL3_LPI_2022_22;
use modelo_CL3_LPI_2022_22;
create table tb_distrito
(
cod_distrito int primary key auto_increment,
nom_distrito varchar(30)
);
create table tb_edificio
(
cod_edificio int primary key auto_increment,
des_edificio varchar(30),
pisos_edificio int,
pre_edificio double,
cod_distrito int
);
drop tb_edificio go


select*from modelo_cl3_lpi_2022_22.tb_empleado;
select*from modelo_cl3_lpi_2022_22.tb_distrito;
create table tb_empleado
(
cod_empleado int primary key auto_increment,
nom_empleado varchar(25),
ape_empleado varchar(25),
dni_empleado varchar(25),
num_hijos int,
sueldo double,
cod_distrito int
);
alter table tb_edificio add constraint FK01 foreign key(cod_distrito) references tb_distrito(cod_distrito);
insert into tb_distrito values(null,'Los Olivos');
insert into tb_distrito values(null,'Breña');
insert into tb_distrito values(null,'Callao');
insert into tb_distrito values(null,'Rímac');

select e.cod_empleado,e.nom_empleado,e.ape_empleado,e.dni_empleado,e.num_hijos,e.sueldo,d.nom_distrito
from tb_empleado e join tb_distrito d on e.cod_distrito=d.cod_distrito


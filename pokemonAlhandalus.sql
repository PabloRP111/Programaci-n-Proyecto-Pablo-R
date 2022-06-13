use proyectoprogramacion;

create table Pokemon( id int Primary key auto_increment, nombre Varchar(40), puntosExp int(3), nivel int(3), raza Varchar(40), tipoPokemon Varchar(40), vida int);

create table habilidad (id int Primary key auto_increment, nombre Varchar(40), ptsAtaque int, tipoHabilidad Varchar(40), usos int(2));

create table habilidadPokemon( idHabilidad int, idPokemon int);

create table objetoCuracion( id int Primary key, nombre varchar(40), tipoObjeto varchar(40),vidaCurada int (3));

create table entrenador( id int Primary Key auto_increment, nombre Varchar(30),dineroTotal int(4),aspecto varchar(40));

create table LiderGymnasio(id_entrenador int primary key, nombre Varchar(30), monedero int(4), aspecto varchar(40),medalla Varchar(20));

Create table EntrenadorPokemon( id_Entrenador int, id_Pokemon int);

create table objeto( id int Primary key auto_increment, nombre varchar(20),tipoObjeto varchar(40) );

CREATE TABLE EntrenadorObjeto(idEntrenador int,idObjeto int);

create table Jugador( id_entrenador int primary key, nombre Varchar(30), dineroTotal int(4), aspecto varchar(40), genero Varchar(50));

alter table habilidadPokemon add constraint fk_habilidad_id foreign key (idHabilidad) references habilidad(id) on delete cascade;

alter table habilidadPokemon add constraint fk_pokemon_id  foreign key (idPokemon) references Pokemon(id) on delete cascade;

alter table LiderGymnasio add constraint fk_entrenador_lider foreign key (id_entrenador) references entrenador(id) on delete cascade;

alter table Jugador add constraint fk_entrenador_jug foreign key (id_entrenador) references entrenador(id) on delete cascade;

alter table EntrenadorObjeto add constraint fk_ent_obj foreign key (idEntrenador)references entrenador(id) on delete cascade;

alter table EntrenadorObjeto add constraint fk_obj_entrenador foreign key (idObjeto) references objeto(id) on delete cascade;

alter table Entrenadorpokemon add constraint fk_pok_entrenador foreign key (id_Pokemon) references Pokemon(id) on delete cascade;

alter table Entrenadorpokemon add constraint fk_entrenador_pok foreign key (id_Entrenador) references Entrenador(id) on delete cascade;

alter table objetoCuracion add constraint fk_obj_objC foreign key (id) references Objeto(id) on delete cascade;

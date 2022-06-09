use proyectoprogramacion;

create table Pokemon(
id int Primary key,
nombre Varchar(40),
puntosExp int(3),
nivel int(3),
raza Varchar(40),
tipoPokemon Varchar(40),
habilidad1 int,
habilidad2 int,
habilidad3 int,
habilidad4 int);


create table habilidad(
id int Primary key,
nombre Varchar(40),
ptsAtaque int,
tipoHabilidad Varchar(40));

create table habilidadPokemon(
idHabilidad int,
idPokemon int
);

alter table habilidadPokemon
add constraint fk_habilidad_id 
foreign key (idHabilidad)
references habilidad(id)
on delete cascade;

alter table habilidadPokemon
add constraint fk_pokemon_id 
foreign key (idPokemon)
references Pokemon(id)
on delete cascade;

create table 
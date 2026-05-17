create database bolsasenati;
use bolsasenati;

create table instructor (
    id bigint primary key auto_increment not null, 
    nombre char(150) not null,                
    apellido char(150) not null,                  
    genero char(20) not null,                      
    dni char(8) not null unique,
    telefono char(9) null,                          
    imageurl longtext not null,                    
    correo_institucional char(100) not null unique,
    clave char(60) not null,                        
    correo_personal char(100) not null unique,
    especialidad char(100) not null
);

insert into instructor (nombre, apellido, genero, dni, telefono, imageurl, correo_institucional, clave, correo_personal, especialidad)
values (
    'instructor', 
    'gomez', 
    'masculino', 
    '74561230', 
    '912345678', 
    'https://ejemplo.com/foto.png', 
    'instructor@senati.pe', 
    '123456', 
    'gomez26@gmail.com', 
    'desarrollo de software'
);

-- login --
delimiter //
create procedure sp_login_instructor(
    in p_correo char(100),
    in p_clave char(60)
)
begin
    select * from instructor 
    where correo_institucional = trim(p_correo) 
      and clave = trim(p_clave);
end //
delimiter ;

-- editar --
delimiter //
create procedure sp_actualizar_instructor(
    in p_id bigint, 
    in p_nombre char(150), 
    in p_apellido char(150), 
    in p_telefono char(9), 
    in p_correo_p char(100), 
    in p_especialidad char(100), 
    in p_img longtext
)
begin
    update instructor set 
        nombre = trim(p_nombre), 
        apellido = trim(p_apellido), 
        telefono = trim(p_telefono), 
        correo_personal = trim(p_correo_p), 
        especialidad = trim(p_especialidad), 
        imageurl = trim(p_img)
    where id = p_id;
end //
delimiter ;

-- cambiar clave --
delimiter //
create procedure sp_cambiar_password(
    in p_id bigint, 
    in p_clave char(60)
)
begin
    update instructor 
    set clave = trim(p_clave) 
    where id = p_id;
end //
delimiter ;
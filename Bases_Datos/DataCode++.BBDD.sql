-- DROP DE TABLAS
DROP TABLE IF EXISTS Juega;
DROP TABLE IF EXISTS Partida;
DROP TABLE IF EXISTS Personaje;
DROP TABLE IF EXISTS GameMaster;
DROP TABLE IF EXISTS Miembro;

-- CREACION DE TABLAS
-- MIEMBRO
CREATE TABLE Miembro (
	id_miembro INT auto_increment,
    nombre_apellidos TEXT,
    numero_expediente INT,
    nombre_estudio TEXT,
    nombre_usuario TEXT, 
    clave_usuario INT (4), 
    PRIMARY KEY (id_miembro)
	);

-- GAMEMASTER
CREATE TABLE GameMaster (
	id_gameMaster INT auto_increment, 
    alias TEXT,
    id_miembro INT, 
    PRIMARY KEY (id_gameMaster),
    FOREIGN KEY (id_miembro) REFERENCES Miembro (id_miembro)
    );

-- PERSONAJE
CREATE TABLE Personaje (
	id_personaje INT auto_increment, 
    nombre TEXT, 
    raza TEXT, 
    nivel_experiencia INT, 
    clase TEXT,
    id_miembro INT,
	PRIMARY KEY (id_personaje),
    FOREIGN KEY (id_miembro) REFERENCES Miembro (id_miembro)
    );
    
-- PARTIDA
CREATE TABLE Partida (
	id_partida INT auto_increment, 
    nombre TEXT,
    dia_hora DATETIME, 
    numero_sesion INT,
    ambientacion TEXT, 
    finalizada TEXT (2),
    duracion_sesion INT,
    id_gameMaster INT,
    PRIMARY KEY (id_partida),
    FOREIGN KEY (id_gameMaster) REFERENCES GameMaster (id_gameMaster)
    );
    
-- JUEGA
CREATE TABLE Juega (
	id_personaje INT auto_increment,
    id_partida INT,
    descripcion TEXT,
    fuerza INT,
    destreza INT,
    constitucion INT,
    inteligencia INT,
    sabiduria INT,
    carisma INT,
	PRIMARY KEY (id_personaje, id_partida),
    FOREIGN KEY (id_personaje) REFERENCES Personaje (id_personaje),
    FOREIGN KEY (id_partida) REFERENCES Partida (id_partida)
    );
    
-- INSERCIÓN DE DATOS
-- Miembros
INSERT INTO Miembro (nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES ('Nacho Moreno', 456789, 'DAW', 'achonacho', 1234);
INSERT INTO Miembro (nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES ('Daniel Farias', 876543, 'DAW', 'dani', 0000);
INSERT INTO Miembro (nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES ('Daniel Gonzalez', 674510, 'DAW', 'garrote', 2323);
INSERT INTO Miembro (nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES ('Sara Villanueva', 346701, 'Educacion', 'sara', 3470);
INSERT INTO Miembro (nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES ('Irene Rincon', 561201, 'Educacion', 'irene', 6565);
INSERT INTO Miembro (nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES ('Raul Rodriguez', 122101, 'Ingeniera', 'raul', 0219);
INSERT INTO Miembro (nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES ('Prueba', 0000, 'Pruebas', 'a', 0);

-- Personajes
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (01, 'Aragorn', 'Humano', 3, 'Guerrero', 01) ;
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (02, 'Drako el Sabio', 'Draconido', 4, 'Mago', 01);
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (03, 'Thranduil', 'Elfo', 2, 'Guerrero', 02);
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (04, 'Han Solo', 'Humano', 4, 'Contrabandista', 02);
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (05, 'Frodo Bolson', 'Hobbit', 2, 'Heroe', 03);
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (06, 'Bofur Barbillas', 'Enano', 3, 'Picaro', 03);
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (07, 'Sam', 'Mediano', 01, 'Guardian', 03 );
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (08, 'Grimnir', 'Semiorco', 02, 'Paladin', 05);

-- Game Master
INSERT INTO GameMaster (id_gameMaster, alias, id_miembro)
VALUES (99, 'Sara Durmiente', 06);

-- INSERCION VALORES 
-- Partida 

-- Partidas
INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (01, 'La búsqueda del anillo', '2024-05-23 18:00:00', 1, 'Tierra Media', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (02, 'Galaxia en guerra', '2024-05-22 15:00:00', 1, 'Galaxia', 'No', 3, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (03, 'Las sombras de la montaña', '2024-05-22 21:00', 1, 'Montañas', 'No', 5, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (04, 'La magia perdida', '2024-05-24 09:00:00', 1, 'Bosque encantado', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (05, 'El rescate de la princesa', '2024-05-24 12:00:00', 1, 'Castillo', 'No', 3, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (06, 'Intriga en la corte', '2024-06-06 20:00:00', 1, 'Palacio real', 'No', 5, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (07, 'La ciudad maldita', '2024-05-22 10:45:00', 1, 'Ciudad abandonada', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (08, 'El laberinto de la muerte', '2024-05-23 19:25:00', 1, 'Laberinto', 'No', 6, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (09, 'La expedición al misterio', '2024-05-22 18:00:00', 1, 'Selva Amazónica', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (10, 'La búsqueda del tesoro perdido', '2024-05-23 18:00:00', 1, 'Islas del Caribe', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (11, 'La maldición del faraón', '2024-05-24 18:00:00', 1, 'Antiguo Egipto', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (12, 'La leyenda del unicornio', '2024-05-25 18:00:00', 1, 'Bosque Encantado', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (13, 'La búsqueda del Grial', '2024-05-26 18:00:00', 1, 'Camelot', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (14, 'El misterio de la Atlántida', '2024-05-27 18:00:00', 1, 'Atlántida', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (15, 'La rebelión de las máquinas', '2024-05-28 18:00:00', 1, 'Futuro distópico', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (16, 'La conquista del espacio', '2024-05-29 18:00:00', 1, 'Galaxias lejanas', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (17, 'La invasión zombie', '2024-05-30 18:00:00', 1, 'Ciudad abandonada', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (18, 'El viaje al centro de la Tierra', '2024-05-31 18:00:00', 1, 'Subterráneo', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (19, 'La venganza del pirata', '2024-06-01 18:00:00', 1, 'Mar Caribe', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (20, 'La guerra de los magos', '2024-06-02 18:00:00', 1, 'Reino de Fantasía', 'No', 4, 100);

-- INSERCION DE VALORES 
-- Juega
INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (01, 01, 'Líder, habilidoso en combate', 80, 59, 72, 18, 20, 40);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (01, 02, 'Experto en hechizos y magia', 40, 84, 45, 69, 80, 55);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (02, 03, 'Experto arquero, valiente', 60, 87, 36, 70, 53, 33);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (02, 04, 'Hábil piloto y contrabandista', 59, 86, 44, 52, 40, 72);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (03, 05, 'Portador del anillo, valiente', 68, 50, 20, 66, 59, 38);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (06, 06, 'Hábil ladrón, conoce secretos', 42, 90, 43, 79, 60, 12);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (03, 07, 'Amigo leal, valiente', 44, 50, 62, 49, 66, 89);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (08, 08, 'Poderoso guerrero, resistente', 88, 71, 68, 11, 38, 50);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (02, 09, 'Astuto ladrón, ágil y rápido', 70, 90, 60, 55, 30, 75);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (03, 10, 'Sabio mago, experto en hechizos', 30, 40, 40, 90, 85, 65);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (04, 11, 'Hábil arquero, preciso y certero', 65, 85, 55, 40, 35, 60);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (05, 12, 'Valiente paladín, protector divino', 90, 60, 75, 50, 55, 80);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (06, 13, 'Misterioso hechicero, controla las sombras', 50, 65, 45, 85, 80, 40);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (07, 14, 'Ágil asesino, maestro del sigilo', 75, 90, 50, 45, 30, 55); 

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (08, 15, 'Ingeniero habilidoso, domina la tecnología', 55, 60, 70, 75, 40, 65);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (01, 16, 'Noble caballero, con honor y lealtad', 85, 70, 80, 45, 50, 70);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (02, 17, 'Pícaro encantador, persuasivo y astuto', 60, 80, 50, 60, 45, 85);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES  (03, 18, 'Sabio druida, conectado con la naturaleza', 75, 65, 85, 60, 70, 55);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (04, 19, 'Temible bárbaro, salvaje y poderoso', 95, 50, 90, 35, 30, 40);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (05, 20, 'Cazador experto, rastrea y caza sin igual', 80, 85, 65, 45, 40, 60);
       
-- PRUEBAS: 
delete from gamemaster where id_gameMaster=100;
commit;
select * from GameMaster;

select * from Juega WHERE id_partida = 20;

SELECT j.id_partida, per.nombre, per.raza, per.clase, per.nivel_experiencia FROM Juega j JOIN Personaje per ON j.id_personaje = per.id_personaje WHERE j.id_partida = 19;

SELECT p.nombre, p.finalizada, per.nombre AS nombrePer, j.fuerza, j.destreza, j.constitucion, j.inteligencia, j.sabiduria, j.carisma  FROM Juega j JOIN Personaje per ON j.id_personaje = per.id_personaje JOIN Partida p ON p.id_partida = j.id_partida WHERE per.id_miembro = 02;

SELECT p.nombre, j.fuerza, j.destreza, j.constitucion, j.inteligencia, j.sabiduria, j.carisma  FROM Juega j JOIN Personaje per ON j.id_personaje = per.id_personaje JOIN Partida p ON p.id_partida = j.id_partida WHERE per.id_personaje = 03;

UPDATE Juega SET fuerza = 40, destreza = 58, constitucion = 71, inteligencia = 31, sabiduria = 26, carisma = 27 WHERE id_personaje = 4 AND id_partida = 20;

UPDATE Partida SET id_gameMaster = 100 WHERE id_partida = 20;

SELECT * FROM Partida WHERE nombre = 'La guerra de los magos';

UPDATE Personaje SET experiencia = 3 WHERE id_personaje = 5;

INSERT INTO Personaje(nombre ,raza, nivel_experiencia, clase, id_miembro) VALUES ('El papi', 'Humano', 5, 'Guerrero', 2);

SELECT * FROM miembro;
-- DROP DE TABLAS
DROP TABLE IF EXISTS Juega;
DROP TABLE IF EXISTS Partida;
DROP TABLE IF EXISTS Personaje;
DROP TABLE IF EXISTS GameMaster;
DROP TABLE IF EXISTS Miembro;

-- CREACION DE TABLAS
-- MIEMBRO
CREATE TABLE Miembro (
	id_miembro INT,
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
	id_personaje INT, 
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
	id_partida INT, 
    nombre TEXT,
    dia_hora DATE, 
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
	id_personaje INT,
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
INSERT INTO Miembro (id_miembro, nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES (01, 'Nacho Moreno', 456789, 'DAW', 'achonacho', 1234);
INSERT INTO Miembro (id_miembro, nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES (02, 'Daniel Farias', 876543, 'DAW', 'danielfarias', 0000);
INSERT INTO Miembro (id_miembro, nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES (03, 'Daniel Gonzalez', 674510, 'DAW', 'garrote', 2323);
INSERT INTO Miembro (id_miembro, nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES (04, 'Sara Villanueva', 346701, 'Educacion', 'sara', 3470);
INSERT INTO Miembro (id_miembro, nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES (05, 'Irene Rincon', 561201, 'Educacion', 'irene', 6565);
INSERT INTO Miembro (id_miembro, nombre_apellidos, numero_expediente, nombre_estudio, nombre_usuario, clave_usuario)
VALUES (06, 'Raul Rodriguez', 122101, 'Ingeniera', 'raul', 0219);

-- Personajes
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (21, 'Aragorn', 'Humano', 3, 'Guerrero', 01) ;
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (11, 'Drako el Sabio', 'Draconido', 4, 'Mago', 01);
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (20, 'Thranduil', 'Elfo', 2, 'Guerrero', 02);
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (12, 'Han Solo', 'Humano', 4, 'Contrabandista', 02);
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (10, 'Frodo Bolson', 'Hobbit', 2, 'Heroe', 03);
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (16, 'Bofur Barbillas', 'Enano', 3, 'Picaro', 03);
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (13, 'Sam', 'Mediano', 01, 'Guardian', 03 );
INSERT INTO Personaje (id_personaje, nombre, raza, nivel_experiencia, clase, id_miembro)
VALUES (18, 'Grimnir', 'Semiorco', 02, 'Paladin', 05);

-- Game Master
INSERT INTO GameMaster (id_gameMaster, alias, id_miembro)
VALUES (99, 'Sara Durmiente', 06);

-- INSERCION VALORES 
-- Partida 

-- Partidas
INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (01, 'La búsqueda del anillo', '2024-04-01', 1, 'Tierra Media', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (02, 'Galaxia en guerra', '2024-04-02', 1, 'Galaxia', 'No', 3, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (03, 'Las sombras de la montaña', '2024-04-03', 1, 'Montañas', 'No', 5, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (04, 'La magia perdida', '2024-04-04', 1, 'Bosque encantado', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (05, 'El rescate de la princesa', '2024-04-05', 1, 'Castillo', 'No', 3, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (06, 'Intriga en la corte', '2024-04-06', 1, 'Palacio real', 'No', 5, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (07, 'La ciudad maldita', '2024-04-07', 1, 'Ciudad abandonada', 'No', 4, 99);

INSERT INTO Partida (id_partida, nombre, dia_hora, numero_sesion, ambientacion, finalizada, duracion_sesion, id_gameMaster)
VALUES (08, 'El laberinto de la muerte', '2024-04-08', 1, 'Laberinto', 'No', 6, 99);

-- INSERCION DE VALORES 
-- Juega
INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (21, 01, 'Líder, habilidoso en combate', 80, 59, 72, 18, 20, 40);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (11, 02, 'Experto en hechizos y magia', 40, 84, 45, 69, 80, 55);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (20, 03, 'Experto arquero, valiente', 60, 87, 36, 70, 53, 33);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (12, 04, 'Hábil piloto y contrabandista', 59, 86, 44, 52, 40, 72);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (10, 05, 'Portador del anillo, valiente', 68, 50, 20, 66, 59, 38);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (16, 06, 'Hábil ladrón, conoce secretos', 42, 90, 43, 79, 60, 12);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (13, 07, 'Amigo leal, valiente', 44, 50, 62, 49, 66, 89);

INSERT INTO Juega (id_personaje, id_partida, descripcion, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma)
VALUES (18, 08, 'Poderoso guerrero, resistente', 88, 71, 68, 11, 38, 50);
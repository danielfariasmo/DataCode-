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
	id_gameMaster INT, 
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
    caracteristicas_personaje TEXT,
	PRIMARY KEY (id_personaje, id_partida),
    FOREIGN KEY (id_personaje) REFERENCES Personaje (id_personaje),
    FOREIGN KEY (id_partida) REFERENCES Partida (id_partida)
    );
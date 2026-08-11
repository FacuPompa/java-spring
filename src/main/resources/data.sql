INSERT INTO cine_java_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado) VALUES ('El señor de los anillos', 201, 'EPICA', 9.0, '2003-12-17', 'D') ON CONFLICT (titulo) DO NOTHING;

INSERT INTO cine_java_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado) VALUES ('El Padrino', 175, 'DRAMA', 9.2, '1972-03-15', 'D') ON CONFLICT (titulo) DO NOTHING;

INSERT INTO cine_java_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado) VALUES ('Titanic', 194, 'DRAMA', 8.0, '1997-12-19', 'D') ON CONFLICT (titulo) DO NOTHING;

INSERT INTO cine_java_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado) VALUES ('Interestellar', 169, 'CIENCIA_FICCION', 8.7, '2014-10-26', 'D') ON CONFLICT (titulo) DO NOTHING;

INSERT INTO cine_java_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado) VALUES ('Joker', 122, 'DRAMA', 8.3, '2019-10-04', 'D') ON CONFLICT (titulo) DO NOTHING;

INSERT INTO cine_java_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado) VALUES ('Kill Bill', 111, 'ACCION', 8.2, '2003-10-10', 'D') ON CONFLICT (titulo) DO NOTHING;

INSERT INTO cine_java_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado) VALUES ('El club de la pelea', 139, 'DRAMA', 8.8, '1999-09-10', 'D') ON CONFLICT (titulo) DO NOTHING;

INSERT INTO cine_java_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado) VALUES ('Los siete samurais', 207, 'EPICA', NULL, '1954-04-26', 'D') ON CONFLICT (titulo) DO NOTHING;

INSERT INTO cine_java_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado) VALUES ('Gladiador', 155, 'AVENTURA', NULL, '2000-05-05', 'D') ON CONFLICT (titulo) DO NOTHING;

INSERT INTO cine_java_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado) VALUES ('Bastardos sin gloria', 153, 'DRAMA', NULL, '2009-05-20', 'D') ON CONFLICT (titulo) DO NOTHING;
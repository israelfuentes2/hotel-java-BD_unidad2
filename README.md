Proyecto Java - Hotel (PostgreSQL)
==================================
Autor: Israel Fuentes

Contenido del proyecto:
- src/conexion/ConexionPostgres.java         -> Clase para conectar con PostgreSQL
- src/conexion/TestApp.java                 -> Programa de prueba que inserta y lista datos
- src/conexion/TestCRUD.java                -> Programa de prueba CRUD para nuevas entidades
- src/conexion/models/*.java                -> Clases de modelo
- src/conexion/dao/*.java                   -> DAOs para CRUD
- sql/crear_bd_hotel.sql                    -> Script SQL para crear la BD y tablas
- lib/postgresql-42.x.x.jar                 -> Driver JDBC (NO incluido, descargar desde https://jdbc.postgresql.org/download/ )

Instrucciones rápidas (Windows):
1. Descarga el driver JDBC (postgresql-42.x.x.jar) y colócalo en la carpeta 'lib' del proyecto.
2. Ejecuta el script sql/crear_bd_hotel.sql con psql -U postgres (contraseña 2424).
3. Compilar:
   javac -cp ".;lib/postgresql-42.x.x.jar" -d bin src/conexion/*.java src/conexion/models/*.java src/conexion/dao/*.java
4. Ejecutar prueba CRUD:
   java -cp "bin;lib/postgresql-42.x.x.jar" conexion.TestCRUD

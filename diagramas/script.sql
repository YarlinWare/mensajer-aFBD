DROP TABLE cliente, estado, horario, mensajero, servicio, telefono, tipo_paquete, trayecto;

CREATE TABLE cliente
(
	k_num_documento numeric(10) NOT NULL,
	k_tipo_documento char(2) NOT NULL,
	n_primer_nombre varchar(20) NOT NULL,
	n_segundo_nombre varchar(20) NULL,
	n_primer_apellido varchar(20) NOT NULL,
	n_segundo_apellido varchar(20) NULL,
	o_genero char(1) NULL,
	f_nacimiento date NULL,
	n_correo varchar(50) NULL
)
;

CREATE TABLE estado
(
	k_id_servicio integer NOT NULL,
	k_id_estado integer NOT NULL,
	o_estado_actual varchar(50) NOT NULL
)
;

CREATE TABLE horario
(
	k_id_horario SERIAL NOT NULL,
	n_dia varchar(9) NOT NULL,
	o_hora_inicio time without time zone NOT NULL,
	o_hora_final time without time zone NOT NULL,
	k_num_documento numeric(10) NOT NULL,
	k_tipo_documento char(2) NOT NULL
)
;

CREATE TABLE mensajero
(
	k_num_documento numeric(10) NOT NULL,
	k_tipo_documento char(2) NOT NULL,
	n_primer_nombre varchar(20) NOT NULL,
	n_segundo_nombre varchar(20) NULL,
	n_primer_apellido varchar(20) NOT NULL,
	n_segundo_apellido varchar(20) NULL,
	q_tefefono numeric(10) NOT NULL,
	o_genero char(1) NOT NULL,
	f_nacimiento date NOT NULL,
	d_dir varchar(30) NULL,
	q_num_seguridad_social integer NOT NULL,
	o_medio_transporte varchar(11) NULL
)
;

CREATE TABLE servicio
(
	k_id_servicio serial NOT NULL,
	k_id_tipo_paquete integer NOT NULL,
	k_num_documento_usuario numeric(10) NOT NULL,
	k_tipo_documento_usuario char(2) NOT NULL,
	k_num_documento_mensajero numeric(10) NULL,
	k_tipo_documento_mensajero char(2) NULL,
	f_fecha date NOT NULL,
	f_hora time without time zone NOT NULL,
	v_valor_servicio numeric NULL
)
;

CREATE TABLE telefono
(
	k_telefono numeric(10) NOT NULL,
	k_num_documento numeric(10) NOT NULL,
	k_tipo_documento char(2) NOT NULL
)
;

CREATE TABLE tipo_paquete
(
	k_id_tipo_paquete serial NOT NULL,
	n_tipo char(4) NOT NULL,
	o_descripcion text NULL,
	--k_id_servicio integer NULL
)
;

CREATE TABLE trayecto
(
	k_id_trayecto serial NOT NULL,
	d_dir_origen varchar(50) NOT NULL,
	d_dir_destino varchar(50) NOT NULL,
	k_id_servicio integer NULL,
	--k_id_tipo_servicio integer NULL
)
;


ALTER TABLE cliente ADD CONSTRAINT "PK_num_documentok_tipo_documento"
	PRIMARY KEY (k_num_documento,k_tipo_documento)
;

ALTER TABLE cliente ADD CONSTRAINT "CK_tipo_identificacion" CHECK (k_tipo_documento IN ('TI', 'CC', 'CE', 'MS', 'PA', 'RC'))
;

ALTER TABLE estado ADD CONSTRAINT "PK_id_serviciok_id_estado"
	PRIMARY KEY (k_id_servicio,k_id_estado)
;

ALTER TABLE estado ADD CONSTRAINT "CK_estado_actual" CHECK (o_estado_actual IN ('Esperando Pago', 'Aceptado', 'Cancelado', 'Entregado', 'Erróneo'))
;

CREATE INDEX "IXFK_estado_servicio" ON estado (k_id_servicio ASC)
;

ALTER TABLE horario ADD CONSTRAINT "PK_k_id_horario"
	PRIMARY KEY (k_id_horario)
;

CREATE INDEX "IXFK_horario_mensajero" ON horario (k_num_documento ASC,k_tipo_documento ASC)
;

ALTER TABLE mensajero ADD CONSTRAINT "PK_cliente"
	PRIMARY KEY (k_num_documento,k_tipo_documento)
;

ALTER TABLE mensajero ADD CONSTRAINT "CK_medio_transporte" CHECK (o_medio_transporte IN('Bicicleta', 'Motocicleta', 'Vehiculo'))
;

ALTER TABLE mensajero ADD CONSTRAINT "CK_tipo_identificacion" CHECK (k_tipo_documento IN ('TI', 'CC', 'CE', 'MS', 'PA', 'RC'))
;

ALTER TABLE servicio ADD CONSTRAINT "PK_id_servicio"
	PRIMARY KEY (k_id_servicio)
;

CREATE INDEX "IXFK_servicio_cliente" ON servicio (k_num_documento_usuario ASC,k_tipo_documento_usuario ASC)
;

CREATE INDEX "IXFK_servicio_mensajero" ON servicio (k_num_documento_mensajero ASC,k_tipo_documento_mensajero ASC)
;

ALTER TABLE telefono ADD CONSTRAINT "PK_telefono"
	PRIMARY KEY (k_telefono,k_num_documento,k_tipo_documento)
;

CREATE INDEX "IXFK_telefono_cliente" ON telefono (k_num_documento ASC,k_tipo_documento ASC)
;

ALTER TABLE tipo_paquete ADD CONSTRAINT "PK_id_tipo_paquete"
	PRIMARY KEY (k_id_tipo_paquete,n_tipo)
;

ALTER TABLE tipo_paquete ADD CONSTRAINT "CK_n_tipo" CHECK (n_tipo IN ('MP6M','MP6P','DUB','S','DUT','V','AJ','DM','C'))
;

--CREATE INDEX "IXFK_tipo_paquete_servicio" ON tipo_paquete (k_id_servicio ASC);

ALTER TABLE trayecto ADD CONSTRAINT "PK_id_trayecto"
	PRIMARY KEY (k_id_trayecto)
;

CREATE INDEX "IXFK_trayecto_servicio" ON trayecto (k_id_servicio ASC)
;

/* Create Foreign Key Constraints */

ALTER TABLE estado ADD CONSTRAINT "FK_estado_servicio"
	FOREIGN KEY (k_id_servicio) REFERENCES servicio (k_id_servicio) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE horario ADD CONSTRAINT "FK_horario_mensajero"
	FOREIGN KEY (k_num_documento,k_tipo_documento) REFERENCES mensajero (k_num_documento,k_tipo_documento) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE servicio ADD CONSTRAINT "FK_servicio_cliente"
	FOREIGN KEY (k_num_documento_usuario,k_tipo_documento_usuario) REFERENCES cliente (k_num_documento,k_tipo_documento) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE servicio ADD CONSTRAINT "FK_servicio_mensajero"
	FOREIGN KEY (k_num_documento_mensajero,k_tipo_documento_mensajero) REFERENCES mensajero (k_num_documento,k_tipo_documento) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE telefono ADD CONSTRAINT "FK_telefono_cliente"
	FOREIGN KEY (k_num_documento,k_tipo_documento) REFERENCES cliente (k_num_documento,k_tipo_documento) ON DELETE No Action ON UPDATE No Action
;

/*ALTER TABLE tipo_paquete ADD CONSTRAINT "FK_tipo_paquete_servicio"
	FOREIGN KEY (k_id_servicio) REFERENCES servicio (k_id_servicio) ON DELETE No Action ON UPDATE No Action
;*/

ALTER TABLE trayecto ADD CONSTRAINT "FK_trayecto_servicio"
	FOREIGN KEY (k_id_servicio) REFERENCES servicio (k_id_servicio) ON DELETE No Action ON UPDATE No Action

;

INSERT INTO cliente VALUES(1010101010, 'CE', 'Miguel ','de Cervantes','Saavedra ', '','M', '1547-09-29','mdcervantess@gmail.com'  );
INSERT INTO telefono VALUES(7654321, 1010101010, 'CE');
INSERT INTO mensajero VALUES(1010101011, 'CE', 'Raúl','','Chato', 'Padilla',3003003030,'M', '1909-06-29','Tangamandapio',123, 'Bicicleta');

INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Lunes', '07:00' + interval '1 hours','17:00', 1010101011, 'CE' );
INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Martes', '07:00' + interval '1 hours','17:00', 1010101011, 'CE' );
INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Miércoles', '08:00' + interval '1 hours','17:00', 1010101011, 'CE' );
INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Jueves', '07:00' + interval '1 hours','17:00', 1010101011, 'CE' );
INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Viernes', '07:00' + interval '1 hours','17:00', 1010101011, 'CE' );

INSERT INTO tipo_paquete (n_tipo,o_descripcion) VALUES('MP6M', 'Mercancía Premier (hasta 6 Kg)');
INSERT INTO tipo_paquete (n_tipo,o_descripcion) VALUES('MP6P', 'Mercancía Premier (después de 6kg) y múltiples piezas');
INSERT INTO tipo_paquete (n_tipo,o_descripcion) VALUES('DUB', 'Documento Unitario (Origen Bogotá)');
INSERT INTO tipo_paquete (n_tipo,o_descripcion) VALUES('S', 'Sobreporte');
INSERT INTO tipo_paquete (n_tipo,o_descripcion) VALUES('DUT', 'Documento Unitario (Otros orígenes)');
INSERT INTO tipo_paquete (n_tipo,o_descripcion) VALUES('V', 'Valores');
INSERT INTO tipo_paquete (n_tipo,o_descripcion) VALUES('AJ', 'Avisos Judiciales');
INSERT INTO tipo_paquete (n_tipo,o_descripcion) VALUES('DM', 'Documentos Masivos');
INSERT INTO tipo_paquete (n_tipo,o_descripcion) VALUES('C', 'Cajaporte');


INSERT INTO mensajero VALUES(1010101011, 'CC', 'Gabriel','','García', 'Márquez',3003013130,'M', '1927-04-17','Aracataca',125, 'Motocicleta');
INSERT INTO mensajero VALUES(1010551011, 'MS', 'Candelario','','Obeso', 'Hernández',3003223030,'M', '1884-01-12','Mompós',124, 'Vehiculo');
INSERT INTO mensajero VALUES(1066101011, 'PA', 'Rafael ','','Pombo', '',3003333030,'M', '1833-11-07','Bogotá',123, 'Bicicleta');
INSERT INTO mensajero VALUES(7710101011, 'RC', 'Soledad','','Acosta', 'de Samper',3003443030,'F', '1833-05-05','Bogotá',126, 'Motocicleta');

INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Lunes', '07:00','17:00', 1010551011, 'MS' );
INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Martes', '07:00','17:00', 1010551011, 'MS' );
INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Miércoles', '08:00','18:00', 1010551011, 'MS' );
INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Jueves', '07:00','17:00', 1010551011, 'MS' );
INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Viernes', '07:00','17:00', 1010551011, 'MS' );

INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Domingo', '07:00','17:00', 1066101011, 'PA' );

INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Jueves', '07:00','17:00', 7710101011, 'RC' );
INSERT INTO horario (n_dia, o_hora_inicio, o_hora_final,k_num_documento,k_tipo_documento)
		VALUES('Sábado', '08:00','18:00', 7710101011, 'RC' );




INSERT INTO servicio
	(k_id_tipo_paquete,k_num_documento_usuario,k_tipo_documento_usuario, k_num_documento_mensajero, k_tipo_documento_mensajero, f_fecha, f_hora, v_valor_servicio) 
	VALUES(1, 1010101010,'CE',null ,null , '2020-08-15','8:00:00',null);

INSERT INTO servicio
	(k_id_tipo_paquete,k_num_documento_usuario,k_tipo_documento_usuario, f_fecha, f_hora)
	VALUES(1, 1010101010,'CE', '2020-08-15','8:00:00');

UPDATE servicio SET k_id_tipo_paquete=4, f_fecha= '2020-08-16', f_hora= '8:31:54' WHERE k_id_servicio = 2;

INSERT INTO trayecto (k_id_servicio, d_dir_origen, d_dir_destino )
	VALUES (1, 'AV la Esperanza', 'Av el Dorado');

INSERT INTO trayecto (k_id_servicio, d_dir_origen, d_dir_destino )
	VALUES (2, 'AV Jiménez', 'Calle 45');
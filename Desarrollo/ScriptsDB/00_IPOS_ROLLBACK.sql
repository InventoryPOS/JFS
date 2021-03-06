DROP VIEW IPOS_PEDIDO_VIEW;
DROP VIEW IPOS_RECETA_VIEW;
DROP VIEW IPOS_INSUMO_VIEW;
DROP VIEW IPOS_INSUMO_CONSUMO_VIEW;

DROP SEQUENCE SEQ_IPOS_INGREDIENTE;
DROP SEQUENCE SEQ_IPOS_INSUMO_CONSUMO;
DROP SEQUENCE SEQ_IPOS_RECETA;
DROP SEQUENCE SEQ_IPOS_INSUMO;
DROP SEQUENCE SEQ_IPOS_UNIDAD_MEDIDA;
DROP SEQUENCE SEQ_IPOS_PERFIL;
DROP SEQUENCE SEQ_IPOS_USUARIO;
DROP SEQUENCE SEQ_IPOS_FUNCION;
DROP SEQUENCE SEQ_IPOS_PEDIDO;
DROP SEQUENCE SEQ_IPOS_DETALLE_PEDIDO;

DROP TABLE IPOS_DETALLE_PEDIDO;
DROP TABLE IPOS_PEDIDO;
DROP TABLE IPOS_INSUMO_CONSUMO;
DROP TABLE IPOS_INGREDIENTE;
DROP TABLE IPOS_RECETA;
DROP TABLE IPOS_INSUMO;
DROP TABLE IPOS_UNIDAD_MEDIDA; 
DROP TABLE IPOS_PERF_FUNC;
DROP TABLE IPOS_FUNCION;
DROP TABLE IPOS_USUARIO;
DROP TABLE IPOS_PERFIL;
COMMIT;
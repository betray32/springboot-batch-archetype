-- PARAMETRIZACION_SPRING_BATCH
CREATE TABLE PARAMETRIZACION_SPRING_BATCH
(
  ENABLED NUMBER 
, FIXEDRATE NUMBER 
, FIXEDDELAY NUMBER 
, ESTADOINICIALLECTURA NUMBER
);


INSERT INTO "PARAMETRIZACION_SPRING_BATCH" (ENABLED, FIXEDRATE, FIXEDDELAY, ESTADOINICIALLECTURA) VALUES ('1', '1000', '1000', '1');

commit;
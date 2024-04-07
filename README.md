STEPs:

1. Execute docker compose in quarkus-kafka-producer, using the command "docker compose up -d";
2. After, start a postgres in docker, create a database call hlg, and after execute script below;

  CREATE TABLE public.person (
	id int8 NULL,
	"name" varchar(50) NULL
  );

3. Finally, execute projects producer and consumer, using command "mvn quarkus:dev"

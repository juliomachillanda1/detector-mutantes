CREATE TABLE adn_verificacion (
    id SERIAL PRIMARY KEY,
    adn bytea not null,
    es_mutante boolean
);



SELECT
COUNT(CASE WHEN es_mutante = true THEN 1 END) AS cantidadMutantes,
COUNT(CASE WHEN es_mutante = false THEN 1 END) AS cantidadHumanos,
CAST(COUNT(CASE WHEN es_mutante = true THEN 1 END) AS FLOAT)/COUNT(*) AS proporcionMutantes
FROM adn_verificacion;
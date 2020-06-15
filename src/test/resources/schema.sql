CREATE TABLE adn_verificacion (
    id SERIAL PRIMARY KEY,
    adn bytea not null,
    es_mutante boolean
);
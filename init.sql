-- Creacion de la tabla usuarios 
CREATE TABLE IF NOT EXISTS users (
    email VARCHAR(255) NOT NULL PRIMARY KEY,
    contraseña VARCHAR(255) NOT NULL,
    numero_tarjeta CHAR(16) NOT NULL,
    tipo_tarjeta VARCHAR(255) NOT NULL
);

-- Creacion de la tabla de pedidos "orders" 
CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    user_email VARCHAR(255) NOT NULL REFERENCES users(email),
    amount FLOAT NOT NULL
);
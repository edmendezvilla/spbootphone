-- Crear la tabla de clientes
CREATE TABLE IF NOT EXISTS customer (
    id SERIAL PRIMARY KEY,  -- El ID se genera automáticamente
    brand VARCHAR(100) NOT NULL,  -- Marca del cliente
    model VARCHAR(20) NOT NULL,  -- Modelo del cliente
    damage VARCHAR(100) NOT NULL  -- Daño o descripción del daño
    );

-- Crear la tabla de reparaciones
CREATE TABLE IF NOT EXISTS repair (
    id SERIAL PRIMARY KEY,  -- El ID se genera automáticamente
    brand VARCHAR(100) NOT NULL,  -- Marca de la reparación
    flaw VARCHAR(100) NOT NULL,  -- Descripción del daño/flaw
    customer_id INT,  -- Relación con la tabla de clientes
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE SET NULL  -- Restricción de clave foránea con comportamiento ON DELETE SET NULL
    );




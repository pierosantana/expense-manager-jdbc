CREATE TABLE categorias (
    id  BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(16) UNIQUE NOT NULL
);

CREATE TABLE transacciones (
    id BIGSERIAL PRIMARY KEY,
    monto DECIMAL(14,2) NOT NULL CHECK(monto > 0),
    descripcion VARCHAR(50),
    fecha DATE default CURRENT_DATE,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('INGRESO','GASTO')),
    categoria_id BIGINT NOT NULL,
    CONSTRAINT FK_Categoria FOREIGN KEY(categoria_id)
    REFERENCES categorias(id)
);
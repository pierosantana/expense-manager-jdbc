INSERT INTO categorias (nombre) VALUES
    ('Alimentación'),
    ('Transporte'),
    ('Vivienda'),
    ('Ocio'),
    ('Salud'),
    ('Otros');

INSERT INTO transacciones (monto, descripcion, fecha, tipo, categoria_id) VALUES

-- ENERO
(1200.00, 'Salario enero', '2026-01-01', 'INGRESO', 6),
(750.00, 'Alquiler enero', '2026-01-02', 'GASTO', 3),
(62.40, 'Compra supermercado', '2026-01-05', 'GASTO', 1),
(30.00, 'Abono transporte', '2026-01-06', 'GASTO', 2),
(15.99, 'Streaming', '2026-01-07', 'GASTO', 4),
(45.00, 'Gasolina', '2026-01-10', 'GASTO', 2),
(23.50, 'Farmacia', '2026-01-12', 'GASTO', 5),
(18.00, 'Cena kebab', '2026-01-15', 'GASTO', 1),
(200.00, 'Trabajo freelance', '2026-01-20', 'INGRESO', 6),
(60.00, 'Factura luz', '2026-01-25', 'GASTO', 3),

-- FEBRERO
(1200.00, 'Salario febrero', '2026-02-01', 'INGRESO', 6),
(750.00, 'Alquiler febrero', '2026-02-02', 'GASTO', 3),
(80.20, 'Compra supermercado', '2026-02-04', 'GASTO', 1),
(30.00, 'Abono transporte', '2026-02-05', 'GASTO', 2),
(22.00, 'Cine', '2026-02-08', 'GASTO', 4),
(90.00, 'Dentista', '2026-02-10', 'GASTO', 5),
(38.90, 'Internet', '2026-02-12', 'GASTO', 3),
(50.00, 'Venta Wallapop', '2026-02-18', 'INGRESO', 6),
(27.30, 'Cena sushi', '2026-02-21', 'GASTO', 1),
(12.00, 'Comisión bancaria', '2026-02-25', 'GASTO', 6),

-- MARZO
(1200.00, 'Salario marzo', '2026-03-01', 'INGRESO', 6),
(750.00, 'Alquiler marzo', '2026-03-02', 'GASTO', 3),
(70.10, 'Compra supermercado', '2026-03-04', 'GASTO', 1),
(30.00, 'Abono transporte', '2026-03-05', 'GASTO', 2),
(19.99, 'Gimnasio', '2026-03-06', 'GASTO', 4),
(45.80, 'Gasolina', '2026-03-09', 'GASTO', 2),
(25.00, 'Farmacia', '2026-03-11', 'GASTO', 5),
(300.00, 'Proyecto freelance', '2026-03-15', 'INGRESO', 6),
(65.00, 'Factura electricidad', '2026-03-20', 'GASTO', 3),
(40.00, 'Salida con amigos', '2026-03-23', 'GASTO', 4);
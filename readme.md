# Expense Manager - JDBC

Gestor de gastos personales desarrollado en **Java puro con JDBC** para aprender persistencia en bases de datos relacionales.

## Descripción

Aplicación de consola que permite registrar y gestionar transacciones financieras (ingresos y gastos) con categorización y reportes básicos. Implementa arquitectura en capas y conexión directa a PostgreSQL mediante JDBC.

## Tecnologías

- **Java 21**
- **PostgreSQL** 
- **JDBC** 
- **Gradle** 
- **Arquitectura en capas**

## Estructura del Proyecto
```
src/main/java/com/pierosantana/expensemanager/
├── model/
│   ├── Transaccion.java
│   ├── Categoria.java
│   └── TipoTransaccion.java
├── repository/
│   └── // TODO
├── service/
│   └── // TODO
│   └── // TODO
├── exception/
│   └── // TODO
├── ui/
│   └── // TODO
└── ExpenseManagerApplication.java
```

## Base de Datos

### Modelo de datos

**Tabla `categorias`:**
- `id` (BIGSERIAL, PK)
- `nombre` (VARCHAR, UNIQUE, NOT NULL)

**Tabla `transacciones`:**
- `id` (BIGSERIAL, PK)
- `monto` (DECIMAL(14,2), NOT NULL, CHECK > 0)
- `descripcion` (VARCHAR(50))
- `fecha` (DATE, DEFAULT CURRENT_DATE)
- `tipo` (VARCHAR(10), CHECK IN ('INGRESO','GASTO'))
- `categoria_id` (BIGINT, FK → categorias.id)

### Configuración de la base de datos

1. **Crear base de datos:**
```sql
CREATE DATABASE expense_manager_db;
```

2. **Conectarse a la base de datos:**
```bash
psql -U tu_usuario -d expense_manager_db
```

3. **Ejecutar scripts SQL:**
```bash
\i database/schema.sql
\i database/sample_data.sql
```

O desde terminal:
```bash
psql -U tu_usuario -d expense_manager_db -f database/schema.sql
psql -U tu_usuario -d expense_manager_db -f database/sample_data.sql
```

## Instalación y Uso

### Requisitos previos
- Java 21 o superior
- PostgreSQL instalado y corriendo
- Gradle

### Configuración

1. **Clonar repositorio:**
```bash
git clone https://github.com/pierosantana/expense-manager-jdbc.git
cd expense-manager-jdbc
```

2. **Configurar base de datos:**
    - Crear la base de datos `expense_manager_db`
    - Ejecutar `database/schema.sql` para crear las tablas
    - Ejecutar `database/sample_data.sql` para cargar categorías por defecto
    - (Opcional) Configurar tus credenciales de PostgreSQL en `config/DatabaseConnection.java`

3. **Ejecutar aplicación:**
```bash
./gradlew run --console=plain
```

O generar JAR:
```bash
./gradlew clean jar
java -jar build/libs/expense-manager-jdbc-1.0.0.jar
```

## Funcionalidades

- [ ] CRUD de transacciones
- [ ] CRUD de categorías
- [ ] Filtros por categoría, tipo, fecha
- [ ] Balance total
- [ ] Reportes por categoría

## Conceptos Aplicados

- **JDBC** y gestión de conexiones
- **PreparedStatement** para prevenir SQL injection
- **Transacciones** de base de datos
- **BigDecimal** para precisión financiera
- **Singleton pattern** para conexión
- **Arquitectura en capas**
- **Foreign Keys** y relaciones 1:N

## Roadmap

- [x] Diseño de base de datos
- [x] Setup inicial del proyecto
- [ ] Implementar capa de conexión
- [ ] Implementar repositories
- [ ] Implementar services
- [ ] Implementar UI de consola
- [ ] Agregar reportes avanzados

## Autor

- GitHub: [@pierosantana](https://github.com/pierosantana)
- LinkedIn: [santanapiero](https://linkedin.com/in/santanapiero)
- Email: piero.santanalarosa@gmail.com

---

**Proyecto educativo** - Parte de la serie de gestores: [simple-task-manager](https://github.com/pierosantana/simple-task-manager) → expense-manager-jdbc → task-manager-api
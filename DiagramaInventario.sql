-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS gestion_almacen;
USE gestion_almacen;

-- Tabla para almacenar información de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cargo VARCHAR(50),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla principal de productos en el almacén
CREATE TABLE IF NOT EXISTS productos (
    codigo_producto VARCHAR(50) PRIMARY KEY,
    descripcion TEXT,
    fecha_entrada DATETIME NOT NULL,
    fecha_salida DATETIME NULL,
    usuario_ingreso INT NOT NULL,
    usuario_salida INT NULL,
    disponible BOOLEAN DEFAULT TRUE,
    
    -- Restricciones de integridad referencial
    FOREIGN KEY (usuario_ingreso) REFERENCES usuarios(id),
    FOREIGN KEY (usuario_salida) REFERENCES usuarios(id),
    
    -- Validación de fechas lógicas
    CONSTRAINT chk_fechas_validas CHECK (fecha_salida IS NULL OR fecha_salida >= fecha_entrada),
    
    -- Validación de consistencia en disponibilidad
    CONSTRAINT chk_disponibilidad_valida CHECK (
        (disponible = TRUE AND fecha_salida IS NULL) OR 
        (disponible = FALSE AND fecha_salida IS NOT NULL)
    )
);

-- Índices para mejorar el rendimiento en búsquedas comunes
CREATE INDEX idx_fecha_entrada ON productos(fecha_entrada);
CREATE INDEX idx_fecha_salida ON productos(fecha_salida);
CREATE INDEX idx_disponibilidad ON productos(disponible);

-- Tabla de auditoría (opcional para seguimiento de cambios)
CREATE TABLE IF NOT EXISTS auditoria_productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo_producto VARCHAR(50) NOT NULL,
    tipo_operacion ENUM('ENTRADA', 'SALIDA') NOT NULL,
    usuario_id INT NOT NULL,
    fecha_operacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    observaciones TEXT,
    
    FOREIGN KEY (codigo_producto) REFERENCES productos(codigo_producto),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
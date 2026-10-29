-- ==============================================================
-- 1. TABLA: USUARIOS (Hashes 100% exactos calculados de tu Java)
-- ==============================================================
-- Contraseña 'Dieg_025'
INSERT INTO usuarios (id_usuario, nombre, correo, password, telefono, fecha_registro) VALUES (1, 'Diego León', 'diegoleon6431@gmail.com', '34343639363536373566333033323335', '987654321', NOW());

-- Contraseña 'Thirsa_18'
INSERT INTO usuarios (id_usuario, nombre, correo, password, telefono, fecha_registro) VALUES (2, 'Thirsa Alvarez', 'thirsa18utp@gmail.com', '353436383639373237333631356633313338', '999888777', NOW());

-- Contraseña 'Danae_26'
INSERT INTO usuarios (id_usuario, nombre, correo, password, telefono, fecha_registro) VALUES (3, 'Dana Quiñones', 'dana@gmail.com', '34343631366536313635356633323336', '987654567', NOW());

-- ==============================================================
-- 2. TABLA: PERFILES_PREMIUM (Todo en una sola línea por registro)
-- ==============================================================
INSERT INTO perfiles_premium (id_usuario, cantidad_puntos, fecha_vencimiento) VALUES (2, 100, '2026-10-06');
INSERT INTO perfiles_premium (id_usuario, cantidad_puntos, fecha_vencimiento) VALUES (3, 200, '2026-10-07');

-- ==============================================================
-- 3. TABLA: CATEGORIAS
-- ==============================================================
INSERT INTO categorias (id_categoria, nombre, color) VALUES (1, 'Tecnología', '#d5e6f3');
INSERT INTO categorias (id_categoria, nombre, color) VALUES (2, 'Ropa y Accesorios', '#d2ece4');
INSERT INTO categorias (id_categoria, nombre, color) VALUES (3, 'Hogar y Cocina', '#f5eed3');
INSERT INTO categorias (id_categoria, nombre, color) VALUES (4, 'Belleza y Salud', '#e8dbfd');
INSERT INTO categorias (id_categoria, nombre, color) VALUES (5, 'Juguetes', '#fadcd9');

-- ==============================================================
-- 4. TABLA: IMPORTADORES
-- ==============================================================
INSERT INTO importadores (id_importador, nombre_empresa, correo, telefono, direccion, estado) VALUES (1, 'Asia Import Perú S.A.C.', 'ventas@asiaimport.pe', '+51999888777', 'Av. Garcilaso de la Vega 1234, Lima', 'Activo');
INSERT INTO importadores (id_importador, nombre_empresa, correo, telefono, direccion, estado) VALUES (2, 'Logística Global del Pacífico', 'contacto@loglobal.pe', '+51999111222', 'Calle Los Pinos 456, San Isidro', 'Activo');
INSERT INTO importadores (id_importador, nombre_empresa, correo, telefono, direccion, estado) VALUES (3, 'Importaciones Hiraoka S.A.', 'soporte@hiraoka.com.pe', '+5114113000', 'Av. Abancay 483, Lima', 'Activo');
INSERT INTO importadores (id_importador, nombre_empresa, correo, telefono, direccion, estado) VALUES (4, 'MegaDistribuidora Lima', 'info@megadistribuidora.pe', '+51988777666', 'Jr. Cuzco 567, Cercado de Lima', 'Activo');
INSERT INTO importadores (id_importador, nombre_empresa, correo, telefono, direccion, estado) VALUES (5, 'Inversiones Alpa S.A.C.', 'ventas@inversionesalpa.pe', '+51955444333', 'Av. Larco 789, Miraflores', 'Activo');

-- ==============================================================
-- 5. TABLA: PRODUCTOS
-- ==============================================================
INSERT INTO productos (id_producto, id_categoria, nombre, descripcion, imagen) VALUES (1, 1, 'Audífonos Inalámbricos SoundPro X1', 'Audio de alta resolución con cancelación activa de ruido.', '/img/p1.webp');
INSERT INTO productos (id_producto, id_categoria, nombre, descripcion, imagen) VALUES (2, 1, 'Reloj Inteligente FitTrack Pro', 'Smartwatch con monitoreo de frecuencia cardíaca y pasos.', '/img/p2.webp');
INSERT INTO productos (id_producto, id_categoria, nombre, descripcion, imagen) VALUES (3, 3, 'Olla Arrocera Digital ChefMax', 'Olla arrocera inteligente con panel de control digital.', '/img/p3.webp');
INSERT INTO productos (id_producto, id_categoria, nombre, descripcion, imagen) VALUES (4, 3, 'Set de Ollas Antiadherentes 5 Piezas', 'Juego de ollas de aluminio con revestimiento de alta resistencia.', '/img/p4.webp');
INSERT INTO productos (id_producto, id_categoria, nombre, descripcion, imagen) VALUES (5, 2, 'Casaca Impermeable Unisex', 'Casaca térmica ligera y resistente al agua.', '/img/p5.webp');
INSERT INTO productos (id_producto, id_categoria, nombre, descripcion, imagen) VALUES (6, 2, 'Pack de 3 Polos Básicos Algodón', 'Polos de algodón 100% peruano, disponibles en varias tallas.', '/img/p6.webp');

-- ==============================================================
-- 6. TABLA INTERMEDIA: PROD_IMPORTADOR
-- ==============================================================
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (1, 1, 1, 79.9, 50);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (2, 2, 1, 85.0, 20);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (3, 3, 1, 82.5, 15);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (4, 1, 2, 145.0, 30);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (5, 4, 2, 139.9, 100);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (6, 5, 2, 142.5, 45);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (7, 2, 3, 289.9, 12);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (8, 3, 3, 295.0, 40);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (9, 5, 3, 292.5, 18);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (10, 2, 4, 120.0, 25);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (11, 4, 4, 115.9, 60);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (12, 1, 5, 59.9, 80);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (13, 4, 5, 55.0, 200);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (14, 4, 6, 35.0, 150);
INSERT INTO prod_importador (id_prod_importador, id_importador, id_producto, precio, stock) VALUES (15, 5, 6, 39.9, 90);

document.addEventListener('DOMContentLoaded', () => {
    const categoriasLinks = document.querySelectorAll('.nav-link-filter');
    const contenedorProductos = document.getElementById('contenedor-productos');
    const inputBuscador = document.getElementById('input-buscador');

    const txtContador = document.getElementById('contador-productos-texto');
    const txtCategoria = document.getElementById('categoria-actual-texto');

    let categoriaActual = 'Todas';

    const actualizarCatalogo = () => {
        const queryBusqueda = inputBuscador ? inputBuscador.value.trim().toLowerCase() : '';

        let productosFiltrados = productosBase.filter(item => {
            const coincideCategoria = (categoriaActual === 'Todas' || item.categoria_nombre.trim() === categoriaActual);
            const coincideTexto = item.prod_nombre.toLowerCase().includes(queryBusqueda);
            return coincideCategoria && coincideTexto;
        });

        const mapaAgrupado = {};
        productosFiltrados.forEach(item => {
            const id = item.id_producto;
            if (!mapaAgrupado[id] || item.precio < mapaAgrupado[id].precio_minimo) {
                mapaAgrupado[id] = {
                    id_producto: id,
                    prod_nombre: item.prod_nombre,
                    descripcion: item.descripcion,
                    imagen: item.imagen,
                    categoria_nombre: item.categoria_nombre,
                    categoria_color: item.categoria_color,
                    nombre_empresa: item.empresaImportadora,
                    precio_minimo: item.precio
                };
            }
        });

        const listaProductosFinal = Object.values(mapaAgrupado);

        let colorCategoria = '#9ad2c2'; 
         if (categoriaActual !== 'Todas') {
            const catEncontrada = categoriasGlobales.find(c => c.nombre.trim() === categoriaActual);
            if (catEncontrada) {
                colorCategoria = catEncontrada.color;
            }
        }
        document.documentElement.style.setProperty('--color-success', colorCategoria);

        if (txtContador) {
            const total = listaProductosFinal.length;
            txtContador.textContent = `${total} ${total === 1 ? 'producto' : 'productos'}`;
        }
        if (txtCategoria) {
            txtCategoria.textContent = categoriaActual;
        }

        if (!contenedorProductos) return;
        contenedorProductos.innerHTML = '';
        
        if (listaProductosFinal.length === 0) {
            contenedorProductos.innerHTML = `<div class="col-12 text-center text-muted py-5 fw-medium">No se encontraron productos coincidentes.</div>`;
            return;
        }
        
        listaProductosFinal.forEach(prod => {
            const empresaImportadora = prod.nombre_empresa || 'Importador Verificado';
            const precioFormateado = `S/. ${Number(prod.precio_minimo).toFixed(2)}`;

            const tarjetaHtml = `
                <div class="col animate-fade-in">
                    <div class="card h-100 border border-light-subtle shadow-sm rounded-4 bg-white overflow-hidden card-dynamic">
                        <div class="product-img-box overflow-hidden">
                            <img src="${prod.imagen}" class="w-100 h-100 object-fit-cover" alt="${prod.prod_nombre}">
                        </div>
                        <div class="card-body p-4 pt-3 d-flex flex-column">
                            <div class="d-flex justify-content-between align-items-center gap-2 mb-2">
                                <span class="badge text-dark text-uppercase fs-6 fw-bold" style="background-color: ${prod.categoria_color || '#9ad2c2'}">
                                    ${prod.categoria_nombre}
                                </span>
                                <span class="text-success-dark fw-medium small text-truncate">
                                    <i class="bi bi-patch-check-fill me-1"></i> ${empresaImportadora}
                                </span>
                            </div>
                            <h3 class="h5 fw-bold text-dark mb-2">${prod.prod_nombre}</h3>
                            <p class="text-secondary small mb-4 lh-relaxed product-description">
                                ${prod.descripcion || 'Sin descripción disponible.'}
                            </p>
                            <div class="d-flex justify-content-between align-items-center mt-auto pt-2 border-top">
                                <div>
                                    <div class="small text-uppercase text-secondary fw-bold">Por Mayor</div>
                                    <div class="h4 fw-bold text-success-dark mb-0">${precioFormateado}</div>
                                </div>
                                <!-- 🔥 CORRECCIÓN AQUÍ: href dinámico seguro y data-id asignado de manera correcta -->
                                <a href="/comparar?id=${prod.id_producto}" data-id="${prod.id_producto}" class="btn btn-success px-3 py-2 rounded-3 fw-bold d-flex align-items-center gap-1 btn-ver-detalles">
                                    Ver detalles <i class="bi bi-arrow-right small"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            `;
            contenedorProductos.insertAdjacentHTML('beforeend', tarjetaHtml);
        });
    };

    actualizarCatalogo();

    if (inputBuscador) {
        inputBuscador.addEventListener('input', () => actualizarCatalogo());
    }

    categoriasLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault(); 
            categoriaActual = link.textContent.trim();
            categoriasLinks.forEach(item => item.classList.remove('active'));
            categoriasLinks.forEach(item => {
                if (item.textContent.trim() === categoriaActual) {
                    item.classList.add('active');
                }
            });
            if (inputBuscador) inputBuscador.value = '';
            actualizarCatalogo();
        });
    });

    if (contenedorProductos) {
        contenedorProductos.addEventListener('click', (e) => {
            const boton = e.target.closest('.btn-ver-detalles');
            if (boton) {
                e.preventDefault();
                const idProducto = boton.getAttribute('data-id');
                if (idProducto && idProducto !== 'undefined') {
                    sessionStorage.setItem('ultimoProducto', idProducto);
                    window.location.href = `/comparar?id=${idProducto}`;
                }
            }
        });
    }
});
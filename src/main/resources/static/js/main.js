// Volver a ultimo producto visitado
document.querySelectorAll('.btn-nav-comparar').forEach(enlace => {
    enlace.addEventListener('click', (e) => {
        e.preventDefault();
        const ultimoId = sessionStorage.getItem('ultimoProducto');
        if (ultimoId) {
            window.location.href = `/comparar?id=${ultimoId}`;
        } else {
            window.location.href = '/comparar';
        }
    });
});

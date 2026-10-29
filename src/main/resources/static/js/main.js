document.querySelectorAll('.btn-nav-comparar').forEach(enlace => {
    enlace.addEventListener('click', (e) => {
        e.preventDefault();
        const ultimoId = sessionStorage.getItem('ultimoProducto');
        
        if (ultimoId && ultimoId !== 'undefined') {
            window.location.href = `/comparar?id=${ultimoId}`;
        } else {
            window.location.href = '/comparar';
        }
    });
});
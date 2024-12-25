window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('usuarios');
    if (datatablesSimple) {
        cargarUsuario()
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

async function cargarUsuario(){
    const request = await fetch('http://localhost:8080/usuario/123' , {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }

    });
     const usuarios = await request.json();
     console.log(usuarios)
}

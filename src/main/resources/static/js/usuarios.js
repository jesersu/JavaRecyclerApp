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
    const request = await fetch('http://localhost:8080/usuarios' , {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }

    });
     const usuarios = await request.json();
     console.log(usuarios)
    let listadoHtml = ''
    for (let usuario of usuarios){


        let usuarioHTML = '    <tr>\n' +
            '                                            <td>'+usuario.id+'</td>\n' +
            '                                            <td>'+usuario.nombre+' '+usuario.apellido+'</td>\n' +
            '                                            <td>'+usuario.email+'</td>\n' +
            '                                            <td>'+usuario.telefono+'</td>\n' +
            '                                            <td>\n' +
            '                                                <a href="#" onclick="eliminarUsuario(' + usuario.id +')" class="btn btn-danger btn-circle btn-sm">\n' +
            '                                                    <i class="fas fa-trash"></i>\n' +
            '                                                </a>\n' +
            '                                            </td>\n' +
            '                                        </tr>';
        listadoHtml += usuarioHTML;
    }


     document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

async function eliminarUsuario(id){

    if  (!confirm('Desea eliminar el usuario?')){
        return
    }

    const request = await fetch('http://localhost:8080/usuarios/'+id , {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }

    });
    location.reload();
}
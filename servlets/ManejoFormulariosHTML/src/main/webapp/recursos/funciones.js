function validarForma(forma) {
    var usuario = forma.usuario; //usuario y los demas corresponden al atributo "name" del index.html
    if (usuario.value === "" || usuario.value === "Escribir usuario") {
        alert("Ingrese un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }

    var password = forma.password;
    if (password.value === "") {
        alert("Ingrese una contraseña");
        password.focus();
        password.select();
        return false;
    } else if (password.value.length < 4) {
        alert("Debe proporcionar un password de mas de 4 caracteres");
        password.focus();
        password.select();
        return false;
    }

    var tecnologias = forma.tecnologia;
    var checkSeleccionado = false;

    for (var i = 0; i < tecnologias.length; i++) {
        if (tecnologias[i].checked) {
            checkSeleccionado = true;
        }
    }

    if (!checkSeleccionado) {
        alert("Debe seleccionar alguna tecnología");
        return false;
    }

    var generos = forma.genero;
    radioSeleccionado = false;

    for (var i = 0; i < generos.length; i++) {
        if (generos[i].checked) {
            radioSeleccionado = true;
        }
    }

    if (!radioSeleccionado) {
        alert("Debe seleccionar un género");
        return false;
    }

    var ocupacion = forma.ocupacion;
    if (ocupacion.value == "") {
        alert("Debe seleccionar una ocupación");
        return false;
    }

    //Formulario validado hasta este punto
    alert("Formulario válido, enviando datos al servidor");
    return true;
}


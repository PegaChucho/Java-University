package test;

import data.*;
import domain.Usuario;
import java.util.*;

public class TestUsuariosJDBC {
    public static void main(String[] args) {
        IUsuarioDAO usuarioDao= new UsuarioDAOImp();
        
//        Usuario usuario1=new Usuario("elVale52", "valedelas1err4");
//        usuarioDao.insertar(usuario1);

    Usuario usuarioAct= new Usuario(1, "pegachucho", "abrakadabra");
    usuarioDao.actualizar(usuarioAct);
    
    Usuario usuarioDel= new Usuario(5);
    usuarioDao.borrar(usuarioDel);
    

    List<Usuario> usuarios=usuarioDao.seleccionar();
    imprimir(usuarios);
    
        
    }
        public static void imprimir(List<Usuario> usuarios){
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
    }
}

package com.oculus.primerproyecto.servicio;

import com.oculus.primerproyecto.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
	
    Usuario guardarUsuario(Usuario usuario);

    Usuario editarUsuario(Usuario usuario);

    public Usuario findId(Long id);

    public void eliminarUsuario(Long id);

    List<Usuario> AllUsuarios();
}

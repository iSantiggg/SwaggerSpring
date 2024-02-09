package com.oculus.primerproyecto.servicio;

import com.oculus.primerproyecto.entity.Usuario;
import com.oculus.primerproyecto.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UsuarioService implements IUsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario editarUsuario(Usuario usuario) {
        Usuario editar = findId(usuario.getId());
        editar.setId(usuario.getId());
        editar.setPais(usuario.getPais());
        editar.setHobbie(usuario.getHobbie());
        editar.setUsuario(usuario.getUsuario());
        usuarioRepository.save(editar);
        return editar;
    }

    @Override
    public Usuario findId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);

    }

    @Override
    public List<Usuario> AllUsuarios() {
        return usuarioRepository.findAll();
    }
}

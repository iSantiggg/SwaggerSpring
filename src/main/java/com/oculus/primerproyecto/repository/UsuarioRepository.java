package com.oculus.primerproyecto.repository;

import com.oculus.primerproyecto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

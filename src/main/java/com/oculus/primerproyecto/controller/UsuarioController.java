package com.oculus.primerproyecto.controller;

import com.oculus.primerproyecto.entity.Usuario;
import com.oculus.primerproyecto.servicio.IUsuarioService;
import com.oculus.primerproyecto.servicio.UsuarioService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<Usuario>editar(@RequestBody Usuario usuario){
        Usuario editado = usuarioService.editarUsuario(usuario);
        try{
            if(editado != null){
                return new ResponseEntity<>(editado, HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>(editado, HttpStatus.NOT_ACCEPTABLE);
            }
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/mostrar")
    public ResponseEntity<?> obtenerUsuarios(){
        return ResponseEntity.ok(usuarioService.AllUsuarios());
    }

}

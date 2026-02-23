package com.example.demo.Repository;

import com.example.demo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {
}

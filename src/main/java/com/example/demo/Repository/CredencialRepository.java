package com.example.demo.Repository;

import com.example.demo.Model.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CredencialRepository extends JpaRepository<Credencial, BigInteger> {
}

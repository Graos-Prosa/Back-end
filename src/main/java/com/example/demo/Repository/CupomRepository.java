package com.example.demo.Repository;

import com.example.demo.Model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CupomRepository extends JpaRepository<Cupom, BigInteger> {
}

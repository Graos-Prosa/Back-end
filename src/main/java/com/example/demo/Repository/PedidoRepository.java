package com.example.demo.Repository;

import com.example.demo.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PedidoRepository extends JpaRepository<Pedido, BigInteger> {
}

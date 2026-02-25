package com.example.demo.Repository;

import com.example.demo.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

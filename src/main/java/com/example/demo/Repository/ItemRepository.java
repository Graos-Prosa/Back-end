package com.example.demo.Repository;

import com.example.demo.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ItemRepository extends JpaRepository<Item, BigInteger> {
}

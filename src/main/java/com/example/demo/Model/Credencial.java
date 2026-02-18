package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

@Entity
@Table(name = "credencial_table")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id_credencial")

public class Credencial {
    private BigInteger id_credencial
}

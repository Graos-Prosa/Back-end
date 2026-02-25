package com.example.demo.Service;

import com.example.demo.Model.Credencial;

import java.math.BigInteger;
import java.util.List;

public interface CredencialService {
    public Credencial getById(Long id);
    public List<Credencial> getAll();
    public Credencial save(Credencial credencial);
    public Credencial update(Long id, Credencial credencial);
    public void delete(Long id);
}

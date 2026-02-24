package com.example.demo.Service;

import com.example.demo.Model.Credencial;

import java.math.BigInteger;
import java.util.List;

public interface CredencialService {
    public Credencial getById(BigInteger id);
    public List<Credencial> getAll();
    public Credencial save(Credencial credencial);
    public Credencial update(BigInteger id, Credencial credencial);
    public void delete(BigInteger id);
}

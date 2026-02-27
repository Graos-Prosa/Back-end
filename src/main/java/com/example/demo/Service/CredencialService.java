package com.example.demo.Service;

import com.example.demo.Model.Credencial;

import java.util.List;

public interface CredencialService {
    public Credencial findById(Long id);
    public List<Credencial> getAll();
    public Credencial save(Credencial credencial);
    public Credencial update(Long id, Credencial credencial);
    public Credencial updatePartial(Long id, Credencial credencial);
    public String cifrarSenha(String senha);
    public void delete(Long id);
}

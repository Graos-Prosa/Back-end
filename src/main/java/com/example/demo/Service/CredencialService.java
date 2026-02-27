package com.example.demo.Service;

import com.example.demo.DTO.LoginRespostaDTO;
import com.example.demo.Model.Credencial;

import java.util.List;

public interface CredencialService {
    public Credencial findById(Long id);
    public List<Credencial> findAll();
    public Credencial save(Credencial credencial);
    public Credencial update(Long id, Credencial credencial);
    public Credencial updateSenha(Long id, Credencial credencial);
    public LoginRespostaDTO verificarAutenticidade(Credencial credencial);
    public void delete(Long id);
}

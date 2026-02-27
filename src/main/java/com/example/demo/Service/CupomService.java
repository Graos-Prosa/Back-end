package com.example.demo.Service;

import com.example.demo.Model.Cupom;
import com.example.demo.Model.Endereco;

import java.math.BigInteger;
import java.util.List;

public interface CupomService {
    public Cupom findById(Long id);
    public List<Cupom> findAll();
    public Cupom save(Cupom cupom);
    public Cupom update(Long id, Cupom cupom);
    public Cupom updatePartial(Long id, Cupom cupom);
    public void delete(Long id);
}

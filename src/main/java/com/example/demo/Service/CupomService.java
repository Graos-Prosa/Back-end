package com.example.demo.Service;

import com.example.demo.Model.Cupom;

import java.math.BigInteger;
import java.util.List;

public interface CupomService {
    public Cupom getById(BigInteger id);
    public List<Cupom> getAll();
    public Cupom save(Cupom cupom);
    public Cupom update(BigInteger id, Cupom cupom);
    public void delete(BigInteger id);
}

package com.example.demo.Service.Implement;

import com.example.demo.Model.Cupom;
import com.example.demo.Repository.CupomRepository;
import com.example.demo.Service.CupomService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CupomServiceImpl implements CupomService {

    private final CupomRepository cupomRepository;

    public CupomServiceImpl(CupomRepository cupomRepository) {
        this.cupomRepository = cupomRepository;
    }

    @Override
    public Cupom getById(BigInteger id) {
        return cupomRepository.getById(id);
    }

    @Override
    public List<Cupom> getAll() {
        return cupomRepository.findAll();
    }

    @Override
    public Cupom save(Cupom cupom) {
        return cupomRepository.save(cupom);
    }

    //implementar metodo de update
    @Override
    public Cupom update(BigInteger id, Cupom cupom) {
        return null;
    }

    @Override
    public void delete(BigInteger id) {
        cupomRepository.deleteById(id);
    }
}

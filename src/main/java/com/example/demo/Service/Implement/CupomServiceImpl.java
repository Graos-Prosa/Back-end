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
    public Cupom findById(Long id) {
        return cupomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cupom não encontrado."));
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
    public Cupom update(Long id, Cupom cupom) {
        return null;
    }

    @Override
    public void delete(Long id) {
        cupomRepository.deleteById(id);
    }
}

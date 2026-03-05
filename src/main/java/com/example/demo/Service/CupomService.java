package com.example.demo.Service;

import com.example.demo.DTO.CupomCreateDTO;
import com.example.demo.DTO.CupomDTO;
import com.example.demo.DTO.CupomUpdateDTO;
import com.example.demo.Model.Cupom;
import com.example.demo.Model.Endereco;

import java.math.BigInteger;
import java.util.List;

public interface CupomService {
    public CupomDTO findById(Long id);
    public List<CupomDTO> findAll();
    public CupomDTO save(CupomCreateDTO cupom);
    public CupomDTO update(Long id, CupomUpdateDTO cupom);
    public void delete(Long id);
}

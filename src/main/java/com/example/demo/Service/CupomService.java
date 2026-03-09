package com.example.demo.Service;

import com.example.demo.DTO.Cupom.CupomCreateDTO;
import com.example.demo.DTO.Cupom.CupomDTO;
import com.example.demo.DTO.Cupom.CupomUpdateDTO;

import java.util.List;

public interface CupomService {
    public CupomDTO findById(Long id);
    public List<CupomDTO> findAll();
    public CupomDTO save(CupomCreateDTO cupom);
    public CupomDTO update(Long id, CupomUpdateDTO cupom);
    public void delete(Long id);
}

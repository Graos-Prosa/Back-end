package com.example.demo.Controller;

import com.example.demo.Model.Cupom;
import com.example.demo.Service.CupomService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/cupom")
public class CupomController {
    private final CupomService cupomService;

    public CupomController(CupomService cupomService) {
        this.cupomService = cupomService;
    }

    @GetMapping("/{id}")
    public Cupom getById(@PathVariable BigInteger id) {
        return cupomService.getById(id);
    }

    @GetMapping
    public List<Cupom> getAll() {
        return cupomService.getAll();
    }

    @PostMapping
    public Cupom create(@RequestBody Cupom cupom) {
        return cupomService.save(cupom);
    }

    @PutMapping("/{id}")
    public Cupom update( @PathVariable BigInteger id, @RequestBody Cupom cupom) { return cupomService.update(id, cupom);}

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable BigInteger id) {
        cupomService.delete(id);
    }

}

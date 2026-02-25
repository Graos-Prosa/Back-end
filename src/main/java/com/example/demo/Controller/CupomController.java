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
    public Cupom findById(@PathVariable Long id) {
        return cupomService.findById(id);
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
    public Cupom update( @PathVariable Long id, @RequestBody Cupom cupom) { return cupomService.update(id, cupom);}

    @PatchMapping("/{id}")
    public Cupom updatePartial(@PathVariable Long id, @RequestBody Cupom cupom) {
        return cupomService.updatePartial(id, cupom);
    }

    //implementar autenticação de delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cupomService.delete(id);
    }

}

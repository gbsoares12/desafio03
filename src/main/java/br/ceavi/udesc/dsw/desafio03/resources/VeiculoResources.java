
package br.ceavi.udesc.dsw.desafio03.resources;

import br.ceavi.udesc.dsw.desafio03.model.Veiculo;
import br.ceavi.udesc.dsw.desafio03.repositorio.VeiculoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gabriel Soares
 */

@RestController
@RequestMapping("/veiculos")
public class VeiculoResources {

    @Autowired
    private VeiculoRepositorio vr;

    @GetMapping("/{id}")
    public Optional<Veiculo> buscar(@PathVariable long id) {
        return vr.findById(id);
    }

    @GetMapping
    public List<Veiculo> buscar() {
        return vr.findAll();
    }

    @PostMapping
    public Veiculo salvar(@RequestBody Veiculo veiculo) {
        return vr.save(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
        vr.deleteById(id);
    }
}

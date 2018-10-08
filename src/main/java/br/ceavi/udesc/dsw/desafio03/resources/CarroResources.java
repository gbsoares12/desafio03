
package br.ceavi.udesc.dsw.desafio03.resources;

import br.ceavi.udesc.dsw.desafio03.model.Carro;
import br.ceavi.udesc.dsw.desafio03.repositorio.CarroRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gabriel Soares
 */

@RestController
@RequestMapping("/carros")
public class CarroResources {
    
    @Autowired
    private CarroRepositorio cr;
    
    @GetMapping("/{id}")
    public Carro buscar(@PathVariable long id) {
        return cr.findById(id).get();
    }

    @GetMapping
    public List<Carro> buscar() {
        return cr.findAll();
    }

    @PostMapping
    public Carro salvar(@RequestBody Carro carro) {
        return cr.save(carro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
        cr.deleteById(id);
    }
    
    
    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable long id, @RequestBody Carro carro){
        
        Optional<Carro> carroSalvo = cr.findById(id);
        Carro c = carroSalvo.get();//Transforma optional na entidade
        BeanUtils.copyProperties(carro, c, "id");
        cr.save(c);
        
        return c;
    }
    
    @GetMapping("/quilometragemMaiorQue/{quilometragem}")
    public List<Carro> buscaQuilometragemMaiorQue(@PathVariable int quilometragem){
        
        return cr.buscarPelaQuilometragemMaiorQue(quilometragem);
    }
    
    @GetMapping("/quilometragemMenorQue/{quilometragem}")
    public List<Carro> buscaQuilometragemMenorQue(@PathVariable int quilometragem){
        
        return cr.buscarPelaQuilometragemMenorQue(quilometragem);
    }
    
    @GetMapping("/quilometragem/{quilometragem}")
    public List<Carro> buscaQuilometragem(@PathVariable int quilometragem){
        
        return cr.buscarPelaQuilometragem(quilometragem);
    }
    
    @GetMapping("/motorMaiorQue/{motor}")
    public List<Carro> buscaMotorMaiorQue(@PathVariable double motor){
        
        return cr.buscarPeloMotorMaiorQue(motor);
    }
    
    @GetMapping("/motorMenorQue/{motor}")
    public List<Carro> buscaMotorMenorQue(@PathVariable double motor){
        
        return cr.buscarPeloMotorMenorQue(motor);
    }
    
    @GetMapping("/motor/{motor}")
    public List<Carro> buscaQuilometragem(@PathVariable double motor){
        
        return cr.buscarPeloMotor(motor);
    }
    
    @GetMapping("/montadora/{montadora}")
    public List<Carro> buscaQuilometragem(@PathVariable String montadora){
        return cr.buscarPelaMontadora(montadora);
    }
    
    @GetMapping("/cor/{cor}")
    public List<Carro> buscaCor(@PathVariable String cor){
        return cr.buscarPelaCor(cor);
    }
}

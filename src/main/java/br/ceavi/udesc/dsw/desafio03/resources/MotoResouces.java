package br.ceavi.udesc.dsw.desafio03.resources;

import br.ceavi.udesc.dsw.desafio03.model.Moto;
import br.ceavi.udesc.dsw.desafio03.repositorio.MotoRepositorio;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/motos")
public class MotoResouces {

    @Autowired
    private MotoRepositorio mr;

    @GetMapping("/{id}")
    public Optional<Moto> buscar(@PathVariable long id) {
        return mr.findById(id);
    }

    @GetMapping
    public List<Moto> buscar() {
        return mr.findAll();
    }

    @PostMapping
    public Moto salvar(@RequestBody Moto moto) {
        return mr.save(moto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
        mr.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Moto atualizar(@PathVariable long id, @RequestBody Moto moto){
        
        Optional<Moto> motoSalva = mr.findById(id);
        Moto m = motoSalva.get();//Transforma optional na entidade
        BeanUtils.copyProperties(moto, m, "id");
        mr.save(m);
        
        return m;
    }
    
    @GetMapping("/quilometragemMaiorQue/{quilometragem}")
    public List<Moto> buscaQuilometragemMaiorQue(@PathVariable int quilometragem){
        
        return mr.buscarPelaQuilometragemMaiorQue(quilometragem);
    }
    
    @GetMapping("/quilometragemMenorQue/{quilometragem}")
    public List<Moto> buscaQuilometragemMenorQue(@PathVariable int quilometragem){
        
        return mr.buscarPelaQuilometragemMenorQue(quilometragem);
    }
    
    @GetMapping("/quilometragem/{quilometragem}")
    public List<Moto> buscaQuilometragem(@PathVariable int quilometragem){
        
        return mr.buscarPelaQuilometragem(quilometragem);
    }
    
    @GetMapping("/motorMaiorQue/{motor}")
    public List<Moto> buscaMotorMaiorQue(@PathVariable double motor){
        
        return mr.buscarPeloMotorMaiorQue(motor);
    }
    
    @GetMapping("/motorMenorQue/{motor}")
    public List<Moto> buscaMotorMenorQue(@PathVariable double motor){
        
        return mr.buscarPeloMotorMenorQue(motor);
    }
    
    @GetMapping("/motor/{motor}")
    public List<Moto> buscaQuilometragem(@PathVariable double motor){
        
        return mr.buscarPeloMotor(motor);
    }
    
    @GetMapping("/montadora/{montadora}")
    public List<Moto> buscaQuilometragem(@PathVariable String montadora){
        return mr.buscarPelaMontadora(montadora);
    }
    
    @GetMapping("/cor/{cor}")
    public List<Moto> buscaCor(@PathVariable String cor){
        return mr.buscarPelaCor(cor);
    }
}

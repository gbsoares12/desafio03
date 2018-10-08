/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ceavi.udesc.dsw.desafio03.repositorio;

import br.ceavi.udesc.dsw.desafio03.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gabriel Soares
 */
public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long>{
    
}

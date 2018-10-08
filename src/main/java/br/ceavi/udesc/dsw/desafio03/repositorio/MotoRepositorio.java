/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ceavi.udesc.dsw.desafio03.repositorio;

import br.ceavi.udesc.dsw.desafio03.model.Moto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Gabriel Soares
 */
public interface MotoRepositorio extends JpaRepository<Moto, Long> {

    @Query(value = "SELECT v.* FROM Moto m JOIN Veiculo v ON m.id = v.id WHERE v.motor > :motor", nativeQuery = true)
    List<Moto> buscarPeloMotorMaiorQue(@Param("motor") double motor);
    
    @Query(value = "SELECT v.* FROM Moto m JOIN Veiculo v ON m.id = v.id WHERE v.motor < :motor", nativeQuery = true)
    List<Moto> buscarPeloMotorMenorQue(@Param("motor") double motor);
    
    @Query(value = "SELECT v.* FROM Moto m JOIN Veiculo v ON m.id = v.id WHERE v.motor = :motor", nativeQuery = true)
    List<Moto> buscarPeloMotor(@Param("motor") double motor);
    
    @Query(value = "SELECT v.* FROM Moto m JOIN Veiculo v ON m.id = v.id WHERE v.quilometragem > :quilometragem", nativeQuery = true)
    List<Moto> buscarPelaQuilometragemMaiorQue(@Param("quilometragem") int quilometragem);
    
    @Query(value = "SELECT v.* FROM Moto m JOIN Veiculo v ON m.id = v.id WHERE v.quilometragem < :quilometragem", nativeQuery = true)
    List<Moto> buscarPelaQuilometragemMenorQue(@Param("quilometragem") int quilometragem);
    
    @Query(value = "SELECT v.* FROM Moto m JOIN Veiculo v ON m.id = v.id WHERE v.quilometragem = :quilometragem", nativeQuery = true)
    List<Moto> buscarPelaQuilometragem(@Param("quilometragem") int quilometragem);
    
    @Query(value = "SELECT v.* FROM Moto m JOIN Veiculo v ON m.id = v.id WHERE v.montadora = :montadora", nativeQuery = true)
    List<Moto> buscarPelaMontadora(@Param("montadora") String montadora);
    
    @Query(value = "SELECT v.* FROM Moto m JOIN Veiculo v ON m.id = v.id WHERE v.cor = :cor", nativeQuery = true)
    List<Moto> buscarPelaCor(@Param("cor") String cor);
    
}

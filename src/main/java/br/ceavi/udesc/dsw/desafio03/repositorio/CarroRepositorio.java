/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ceavi.udesc.dsw.desafio03.repositorio;

import br.ceavi.udesc.dsw.desafio03.model.Carro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Gabriel Soares
 */
public interface CarroRepositorio extends JpaRepository<Carro, Long> {

    @Query(value = "SELECT v.* FROM Carro c JOIN Veiculo v ON c.id = v.id WHERE v.motor > :motor", nativeQuery = true)
    List<Carro> buscarPeloMotorMaiorQue(@Param("motor") double motor);

    @Query(value = "SELECT v.* FROM Carro c JOIN Veiculo v ON c.id = v.id WHERE v.motor < :motor", nativeQuery = true)
    List<Carro> buscarPeloMotorMenorQue(@Param("motor") double motor);

    @Query(value = "SELECT v.* FROM Carro c JOIN Veiculo v ON c.id = v.id WHERE v.motor = :motor", nativeQuery = true)
    List<Carro> buscarPeloMotor(@Param("motor") double motor);

    @Query(value = "SELECT v.* FROM Carro c JOIN Veiculo v ON c.id = v.id WHERE v.quilometragem > :quilometragem", nativeQuery = true)
    List<Carro> buscarPelaQuilometragemMaiorQue(@Param("quilometragem") int quilometragem);

    @Query(value = "SELECT v.* FROM Carro c JOIN Veiculo v ON c.id = v.id WHERE v.quilometragem < :quilometragem", nativeQuery = true)
    List<Carro> buscarPelaQuilometragemMenorQue(@Param("quilometragem") int quilometragem);

    @Query(value = "SELECT v.* FROM Carro c JOIN Veiculo v ON c.id = v.id WHERE v.quilometragem = :quilometragem", nativeQuery = true)
    List<Carro> buscarPelaQuilometragem(@Param("quilometragem") int quilometragem);

    @Query(value = "SELECT v.* FROM Carro c JOIN Veiculo v ON c.id = v.id WHERE v.montadora = :montadora", nativeQuery = true)
    List<Carro> buscarPelaMontadora(@Param("montadora") String montadora);

    @Query(value = "SELECT v.* FROM Carro c JOIN Veiculo v ON c.id = v.id WHERE v.cor = :cor", nativeQuery = true)
    List<Carro> buscarPelaCor(@Param("cor") String cor);

}

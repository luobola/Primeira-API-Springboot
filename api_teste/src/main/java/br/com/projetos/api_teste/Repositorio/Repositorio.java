package br.com.projetos.api_teste.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projetos.api_teste.Modelo.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {

    List<Pessoa> findAll();

    Pessoa findById(int id);

    List<Pessoa> findByOrderByNome();
    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);

    List<Pessoa> findByNomeContaining(String termo);
    List<Pessoa> findByNomeStartsWith(String termo);
    List<Pessoa> findByNomeEndsWith(String termo);

    @Query(value = "SELECT SUM(idade) FROM pessoas", nativeQuery = true)
    int somaIdades();

    @Query(value = "SELECT * FROM pessoas WHERE idade >= :idade", nativeQuery = true)
    List<Pessoa> idadeMaior(int idade);

    int countById(int id);

}

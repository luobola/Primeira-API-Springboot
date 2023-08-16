package br.com.projetos.api_teste.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.projetos.api_teste.Modelo.Cliente;

@Repository
public interface RepositorioCliente extends CrudRepository<Cliente, Integer>{

    
}

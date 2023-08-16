package br.com.projetos.api_teste.Controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetos.api_teste.Modelo.Cliente;
import br.com.projetos.api_teste.Modelo.Pessoa;
import br.com.projetos.api_teste.Repositorio.Repositorio;
import br.com.projetos.api_teste.Repositorio.RepositorioCliente;
import br.com.projetos.api_teste.Servico.Servico;
import jakarta.validation.Valid;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    @Autowired
    private RepositorioCliente action;

    @Autowired
    private Servico servico;

    @GetMapping("/api")
    public ResponseEntity<?> selecionar(){
        return servico.selecionar();
    }

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj){
        return servico.cadastrar(obj);
    }

    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo){
        return servico.selecionarID(codigo);
    }
    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa obj){
        return servico.editar(obj);
    }

    @GetMapping("")
    public String mensagem(){
        return "Olá, mundo legal!";
    }

    @GetMapping("/boas-vindas")
    public String boasVindas(){
        return "Seja Bem-Vindo(a) a Minha API!!!";
    }

    @GetMapping("/boas-vindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja Bem-Vindo(a), "+ nome +" a Minha API!!!";
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }


    @DeleteMapping("/api/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo){
       return servico.remover(codigo);
    }

    @GetMapping("/api/contador")
    public long contador(){
        return acao.count();
    }

    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarNomes(){
        return acao.findByOrderByNome();
    }

    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordenarNomes2(){
        return acao.findByNomeOrderByIdadeDesc("Tatiana");
    }

    @GetMapping("/api/contem")
    public List<Pessoa> contem(){
        return acao.findByNomeContaining("lu");
    }
    @GetMapping("/api/iniciaCom")
    public List<Pessoa> iniciaNome(){
        return acao.findByNomeStartsWith("a");
    }
    @GetMapping("/api/terminaCom")
    public List<Pessoa> terminaNome(){
        return acao.findByNomeEndsWith("a");
    }

    @GetMapping("/api/somandoIdades")
    public int somaIdades(){
        return acao.somaIdades();
    }
    @GetMapping("/api/idadeMaior")
    public List<Pessoa> idademaior(){
        return acao.idadeMaior(30);
    }

    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente obj){
        action.save(obj);
    }



}

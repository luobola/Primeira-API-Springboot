package br.com.projetos.api_teste.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projetos.api_teste.Modelo.Mensagem;
import br.com.projetos.api_teste.Modelo.Pessoa;
import br.com.projetos.api_teste.Repositorio.Repositorio;

@Service
public class Servico {
        
    @Autowired 
    private Mensagem mensagem;

    @Autowired
    private Repositorio acao;
/*
 * Metodo para cadastrar pessoas
 * @author: Lucas Vasconcelos
 * data: 15/08/2022
 * versão: 1.0
 */
    public ResponseEntity<?> cadastrar(Pessoa obj){
        if(obj.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido!!!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getIdade() < 0){
            mensagem.setMensagem("Informe uma idade valida!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    /*
     * Metodo para selecionar pessoas
     * @author: Lucas Vasconcelos
     * data: 15/08/2022
     * versão: 1.0
     */

     public ResponseEntity<?> selecionar(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
     }

    /*
     * Metodo para selecionar pessoas atraves do codigo
     * @author: Lucas Vasconcelos
     * data: 15/08/2022
     * versão: 1.0
     */
    public ResponseEntity<?> selecionarID(int id){
        if(acao.countById(id) == 0){
            mensagem.setMensagem("Não foi encontrada nenhuma pessoa com esse codigo!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(acao.findById(id), HttpStatus.OK);
        }
    }

    /*
     * Metodo para Editar pessoas atraves do codigo
     * @author: Lucas Vasconcelos
     * data: 15/08/2022
     * versão: 1.0
     */
    public ResponseEntity<?> editar(Pessoa obj){

        if(acao.countById(obj.getId()) == 0){
            mensagem.setMensagem("O codigo informado não existe!!");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(obj.getNome().equals("")){
            mensagem.setMensagem("é necessario informar um nome!!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getIdade() < 0){
            mensagem.setMensagem("A idade inserida é invalida!!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }
    }
     /*
     * Metodo para Remover registros 
     * @author: Lucas Vasconcelos
     * data: 15/08/2022
     * versão: 1.0
     */
    public ResponseEntity<?> remover(int id){

        if(acao.countById(id) == 0){
            mensagem.setMensagem("o codigo informado não existe!!!");
            return new ResponseEntity<>(mensagem,HttpStatus.NOT_FOUND);
        }else{
            Pessoa obj = acao.findById(id);
            acao.delete(obj);
            mensagem.setMensagem("Pessoa removida com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }

    }

}

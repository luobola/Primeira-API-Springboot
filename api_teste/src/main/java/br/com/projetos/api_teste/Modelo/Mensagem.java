package br.com.projetos.api_teste.Modelo;

import org.springframework.stereotype.Component;

@Component
public class Mensagem {

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    
}

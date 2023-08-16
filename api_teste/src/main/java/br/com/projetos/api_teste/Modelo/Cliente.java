package br.com.projetos.api_teste.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "clientes")
public class Cliente {
    
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @NotEmpty(message = "Informe um nome")
    private String nome;
    @Email(message = "informe um email valido")
    private String email;

    //modificadores de acesso 
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}

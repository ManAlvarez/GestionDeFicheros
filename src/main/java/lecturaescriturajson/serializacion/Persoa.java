/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescriturajson.serializacion;

/**
 *
 * @author manuel
 */
public class Persoa {
    
    private String nome;
    private int idade;
    private String apelidos;

    public Persoa() {
    }

    public Persoa(String nome, int idade, String apelidos) {
        this.nome = nome;
        this.idade = idade;
        this.apelidos = apelidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }
    
    
    
}

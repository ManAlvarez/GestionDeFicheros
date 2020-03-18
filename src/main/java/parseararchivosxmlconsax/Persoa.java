/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parseararchivosxmlconsax;

/**
 *
 * @author manuel
 */
public class Persoa {
    private String nome;
    private int idade;


    public Persoa(){
        this.nome = new String("");
        this.idade = 0;
    }

    public Persoa(String _nome,int _idade){
        this.nome = _nome;
        this.idade = _idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}

package app.john.com.listanime.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Usuario {
    //Atributos
    @Id
    public long id;
    private String nome, email, senha;
    public ToMany<Anime> animes;
    private boolean logado;

    //Construtores
    public Usuario() {

    }
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.logado = false;
    }

    //Métodos de negócio

    //Métodos Get/Set
    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public boolean getLogado() {
        return this.logado;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean addAnime(String titulo, String diretor, String estudio) {
        Anime novoAnime = new Anime(titulo, diretor, estudio);
        if (animes.add(novoAnime)) {
            return true;
        }
        return false;
    }
}

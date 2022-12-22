package escola.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private CPF cpf;
    private Email email;
    private List<Telefone> telefones= new ArrayList<>();

    public Aluno(String nome, CPF cpf, Email email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public void adicionarTelefone(String numero){
        this.telefones.add(new Telefone(numero));
    }

    public String getNome() {
        return nome;
    }

    public CPF getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
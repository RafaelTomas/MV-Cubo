package escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private CPF cpf;
    private Email email;
    private List<Telefone> telefones= new ArrayList<>();
    private String senha;

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

    public String getCpf() {
        return cpf.getCpf();
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}

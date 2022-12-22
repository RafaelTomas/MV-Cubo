package escola.dominio.aluno;

public class FabricaDeAluno {
    private Aluno aluno;

    public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(nome, new CPF(cpf), new Email(email));
        return this;
    }
    public FabricaDeAluno comTelefone(String numero){
        this.aluno.adicionarTelefone(numero);
        return this;
    }
    public Aluno criar() {
        return this.aluno;
    }
}

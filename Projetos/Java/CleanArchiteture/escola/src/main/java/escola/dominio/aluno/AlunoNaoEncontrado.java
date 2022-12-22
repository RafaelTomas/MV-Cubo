package escola.dominio.aluno;

public class AlunoNaoEncontrado extends RuntimeException {
    private static final long seralVersionUID = 1L;
    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno nao encontrado com CPF:" + cpf.getCpf());
    }
}

package escola.dominio.aluno;

public interface CifradorDeSenha {
    String cifraSenha(String senha);
    boolean validarSenhaCifrada(String senhaCifrada, String senha);
}

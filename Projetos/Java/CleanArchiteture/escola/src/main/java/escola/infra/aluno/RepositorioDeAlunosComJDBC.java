package escola.infra.aluno;

import escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INT ALUNO VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,aluno.getNome());
            ps.setString(2,aluno.getCpf());
            ps.setString(3,aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONE VALUES(?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getNumero());
                ps.execute();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        try{
            String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getCpf());
            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();
            if (!encontrou) {
                throw new AlunoNaoEncontrado(cpf);
            }
            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Aluno encontrado = new Aluno(nome, cpf, email);

            Long id = rs.getLong("id");
            sql = "SELECT numero FROM TELEFONE WHERE aluno_id = ? ";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                String numero = rs.getString("numero");
                encontrado.adicionarTelefone(numero);
            }
            return encontrado;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return null;
    }
}

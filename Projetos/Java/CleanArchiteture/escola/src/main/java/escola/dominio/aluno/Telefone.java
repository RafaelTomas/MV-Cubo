package escola.aluno;

public class Telefone {
    private String numero;

    public Telefone(String numero) {
        if (numero == null || !numero.matches("^[0-9]{2}-([0-9]{8}|[0-9]{9})")){
            throw new IllegalArgumentException("Telefone inválido!");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

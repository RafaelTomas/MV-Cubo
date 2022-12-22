import escola.dominio.aluno.CPF;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CPFTest {
    @Test
    void NãoDeveriaAdicionarCPFInvalido(){
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(null));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(""));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF("null"));
    }

    @Test
    void DeveRetornarCPF(){
        String numero = "704.385.464-40";
        CPF cpf = new CPF(numero);
        assertEquals(numero, cpf.getCpf());
    }
}

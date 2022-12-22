import escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TelefoneTest {
    @Test
    void NãoDeveriaAdicionarTelefoneInvalido(){
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone(null));
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone(""));
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("null"));
    }

    @Test
    void DeveRetornarTelefone(){
        String numero = "81-996713838";
        Telefone telefone = new Telefone(numero);
        assertEquals(numero, telefone.getNumero());
    }

}

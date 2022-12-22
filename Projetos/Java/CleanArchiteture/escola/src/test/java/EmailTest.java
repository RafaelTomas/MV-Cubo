import escola.dominio.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    @Test
    void NãoDeveriaCriarEmailComEndereçoInvalido(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));
        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));
        assertThrows(IllegalArgumentException.class,
                () -> new Email("null"));
    }

//    @Test
//    void DeveRetornarEmail(){
//        String endereco = "rafael@mv.com";
//        Email email = new Email(endereco);
//        assertEquals(endereco, email.getEndereco());
//    }
}

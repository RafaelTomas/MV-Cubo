package med.global.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.global.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}

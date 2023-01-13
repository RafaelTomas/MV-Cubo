package med.global.api.domain.paciente;

import med.global.api.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente(Long id, String name, String email, String cpf,String telefone, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}

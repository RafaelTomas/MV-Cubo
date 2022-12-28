package med.global.api.controller;

import jakarta.validation.Valid;
import med.global.api.medico.DadosCadastroMedico;
import med.global.api.medico.Medico;
import med.global.api.medico.MedicoRepository;
import med.global.api.paciente.DadosCadastroPaciente;
import med.global.api.paciente.Paciente;
import med.global.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }
}

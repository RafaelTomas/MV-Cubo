package med.global.api.controller;

import jakarta.validation.Valid;
import med.global.api.medico.DadosCadastroMedico;
import med.global.api.medico.DadosListagemMedico;
import med.global.api.medico.Medico;
import med.global.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dado){
        repository.save(new Medico(dado));
    }

    @GetMapping
    public List<DadosListagemMedico> listar() {
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }
}

package com.example.pratica_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionariosController {
    private final FuncionariosRepository funcionariosRepository;

    @Autowired
    public FuncionariosController(FuncionariosRepository funcionariosRepository){
        this.funcionariosRepository = funcionariosRepository;
    }

    //Selecionando todos os funcionários
    @GetMapping("/selecionar")
    public List<Funcionarios> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }

    //Inserindo novos funcionários
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirFuncionarios(@RequestBody Funcionarios funcionarios){
        funcionariosRepository.save(funcionarios);
        return ResponseEntity.ok("Funcionário inserido");
    }

    //Selecionando usuário por id
    @GetMapping("/selecionar/{id}")
    public ResponseEntity<Funcionarios> getFuncionariosPorId(@PathVariable Long id){
        if(funcionariosRepository.existsById(id)){
            Funcionarios funcionarios = funcionariosRepository.findById(id).orElse(null);
            return ResponseEntity.ok(funcionarios);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Excluindo por data de admissão
    @DeleteMapping("/excluirPorDataAdmissao")
    public ResponseEntity<String> excluirFuncionariosPorDataAdmissao(@RequestParam("dataAdmissao") String dataAdmissao) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date data = dateFormat.parse(dataAdmissao);
            List<Funcionarios> funcionariosParaExcluir = funcionariosRepository.findByData(data);
            funcionariosRepository.deleteAll(funcionariosParaExcluir);

            return ResponseEntity.ok("funcionou");
        } catch (ParseException e) {
            return ResponseEntity.badRequest().body("não foi");
        }
    }

    //Atualizando
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarFuncionario(
            @PathVariable Long id,
            @RequestParam(required = false) String cargo,
            @RequestParam(required = false) Double salario,
            @RequestParam(required = false) String departamento) {
        if (!funcionariosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Funcionarios funcionario = funcionariosRepository.findById(id).orElse(null);
        if (cargo != null) {
            funcionario.setCargo(cargo);
        }
        if (salario != null) {
            funcionario.setSalario(salario);
        }
        if (departamento != null) {
            funcionario.setDepartamento(departamento);
        }
        funcionariosRepository.save(funcionario);

        return ResponseEntity.ok("funcionou");
    }
}
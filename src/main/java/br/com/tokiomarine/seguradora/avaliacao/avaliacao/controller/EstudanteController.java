package br.com.tokiomarine.seguradora.avaliacao.avaliacao.controller;

import br.com.tokiomarine.seguradora.avaliacao.avaliacao.service.EstudanteService;
import br.com.tokiomarine.seguradora.avaliacao.avaliacao.entidade.Estudante;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("estudante")
public class EstudanteController {

    @Autowired
    EstudanteService service;

    /**
     *
     * @param estudante
     * @return
     */
    @GetMapping("criar")
    public String iniciarCastrado(Estudante estudante) {
        log.info(estudante.toString());
        return "cadastrar-estudante";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("listar")
    public String listarEstudantes(Model model) {
        List<Estudante> listarEstudantes = service.buscarEstudantes();
        log.info(listarEstudantes.toString());
        model.addAttribute("estudantes", listarEstudantes);
        return "index";
    }

    /**
     *
     * @param estudante
     * @param result
     * @return
     */
    @PostMapping("add")
    public String adicionarEstudante(@Valid Estudante estudante, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            return "cadastrar-estudante";
        }

            log.info(estudante.toString());
            service.cadastrarEstudante(estudante);
            return "redirect:listar";

    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("editar/{id}")
    public String exibirEdicaoEstudante(@PathVariable long id, Model model) {
        Optional<Estudante> estudante = service.buscarEstudante(id);
        log.info(estudante.get().toString());
        model.addAttribute("estudante", estudante.get());
        return "atualizar-estudante";
    }

    /**
     *
     * @param id
     * @param estudante
     * @param result
     * @param model
     * @return
     */
    @PostMapping("atualizar/{id}")
    public String atualizarEstudante(@PathVariable("id") long id, @Valid Estudante estudante, BindingResult result, Model model) {
        if (result.hasErrors()) {
            estudante.setId(id);
            return "atualizar-estudante";
        }

        log.info(estudante.toString());
        service.atualizarEstudante(estudante);
        return "redirect:../listar";
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("apagar/{id}")
    public String apagarEstudante(@PathVariable("id") long id, Model model) {
        Optional<Estudante> estudante = service.buscarEstudante(id);
        log.info(estudante.toString());
        service.removeEstudante(estudante.get());
        return "redirect:../listar";
    }
}
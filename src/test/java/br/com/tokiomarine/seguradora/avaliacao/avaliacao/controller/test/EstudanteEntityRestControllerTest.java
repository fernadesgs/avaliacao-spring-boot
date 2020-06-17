package br.com.tokiomarine.seguradora.avaliacao.avaliacao.controller.test;

import br.com.tokiomarine.seguradora.avaliacao.avaliacao.controller.EstudanteController;
import br.com.tokiomarine.seguradora.avaliacao.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.avaliacao.service.EstudanteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(EstudanteController.class)
public class EstudanteEntityRestControllerTest {

    @MockBean
    EstudanteService estudanteService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void addEstudanteWithPosthenResponseOK() throws Exception {
        Estudante estudante = new Estudante();
        estudante.setEmail("fernandesg10@gmail.com");
        estudante.setNome("Fernandes");
        estudante.setTelefone("123456");
        estudante.setCurso("Ciência da Computação");
        estudante.setMatricula("123456");

        mockMvc.perform(MockMvcRequestBuilders.post("/estudante/add")
                .param("nome", estudante.getNome())
                .param("email", estudante.getEmail())
                .param("telefone", estudante.getTelefone())
                .param("curso", estudante.getCurso())
                .param("matricula", estudante.getMatricula()))
                .andDo(print()).andExpect(status().is(302))
                .andExpect(redirectedUrl("listar"));
         verify(estudanteService).cadastrarEstudante(estudante);
    }

    @Test
    public void testTransferNotFound() throws Exception {
        mockMvc.perform(get("/estudante/listar2"))
         .andExpect(status().isNotFound());
    }
}
package br.com.tokiomarine.seguradora.avaliacao.avaliacao.entidade;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Table(name = "ESTUDANTE")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estudante implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome não preenchido")
    private String nome;

    @NotBlank(message = "Email não preenchido")
    private String email;

    @NotBlank(message = "telefone não preenchido")
    private String telefone;

}

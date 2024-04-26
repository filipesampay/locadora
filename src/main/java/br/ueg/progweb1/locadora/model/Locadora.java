package br.ueg.progweb1.locadora.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "locadora")

public class Locadora {

    @Id
    @SequenceGenerator(
            name = "locadora_sequence",
            sequenceName = "locadora_sequence_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "locadora_sequence"
    )
    @Column(name = "chave", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String name;

    @Column(name = "data_fabricacao", nullable = false)
    private LocalDate manufacturingDate;

    @Column(name = "dono", nullable = false, length = 20)
    private String owner;

    @Column(name = "cor", nullable = false, length = 20)
    private String color;

    @Column(name = "marca", length = 15)
    private String brand;

    @Column(name = "funcionando", nullable = false)
    private Boolean working;

}
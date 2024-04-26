package br.ueg.progweb1.locadora.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocacaoDTO {

    @Schema(description = "Modelo carro", example = "Fiesta")
    private String model;

    @Schema(description = "Lancamento", example = "2014-01-01")
    private LocalDate manufacturingDate;

    @Schema(description = "Proprietario", example = "Filipe")
    private String owner;

    @Schema(description = "Cor", example = "Prata")
    private String color;

    @Schema(description = "Marca", example = "Ford")
    private String brand;

    @Schema(description = "Funionando", example = "True")
    private Boolean working;

}

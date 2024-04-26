package br.ueg.progweb1.locadora.mapper;

import br.ueg.progweb1.locadora.model.Locadora;
import br.ueg.progweb1.locadora.model.dtos.LocacaoDTO;
import org.springframework.stereotype.Component;

@Component
public class LocadoraMapper {
    public Locadora toModel(LocacaoDTO dto) {
        Locadora car = new Locadora();
        car.setName(dto.getModel());
        car.setManufacturingDate(dto.getManufacturingDate());
        car.setOwner(dto.getOwner());
        car.setColor(dto.getColor());
        car.setBrand(dto.getBrand());
        car.setWorking(dto.getWorking());
        return car;
    }
}
package br.ueg.progweb1.locadora.service.impl;

import br.ueg.progweb1.locadora.exceptions.CustomException;
import br.ueg.progweb1.locadora.model.Locadora;
import br.ueg.progweb1.locadora.repository.LocadoraRepository;
import br.ueg.progweb1.locadora.service.LocadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocadoraServiceImpl implements LocadoraService {

    @Autowired
    private LocadoraRepository repository;

    @Override
    public Locadora create(Locadora locadora) {
        locadora.setId(null);
        validateMandatoryFields(locadora);
        validateBusinessLogic(locadora);
        return repository.save(locadora);
    }

    @Override
    public List<Locadora> list() {
        return repository.findAll();
    }

    @Override
    public Locadora get(Long id) {
        return validateIdExists(id);
    }

    @Override
    public Locadora update(Locadora locadora) {
        Locadora locadoraUpdate = validateIdExists(locadora.getId());
        validateMandatoryFields(locadora);
        updateDataDB(locadora, locadoraUpdate);
        return repository.save(locadoraUpdate);
    }

    @Override
    public Locadora delete(Long id) {
        Locadora locadora = validateIdExists(id);
        repository.delete(locadora);
        return locadora;
    }

    private void validateBusinessLogic(Locadora locadora) {
        if (locadora.getWorking()) {
            throw new CustomException("O carro não pode estar em manutenção.");
        }
    }

    private void validateMandatoryFields(Locadora locadora) {
        if (
                locadora.getName().isEmpty() ||
                        locadora.getManufacturingDate().toString().isEmpty() ||
                        locadora.getOwner().isEmpty() ||
                        locadora.getColor().isEmpty() ||
                        locadora.getWorking().toString().isEmpty()
        ) {
            throw new CustomException("Campos obrigatórios não preenchidos.");
        }
    }

    private Locadora validateIdExists(Long id) {

        boolean valid = true;
        Locadora locadora = null;

        if (Objects.nonNull(id)) {
            locadora = this.internalGet(id);
            if (locadora == null) {
                valid = false;
            }
        } else {
            valid = false;
        }

        if (Boolean.FALSE.equals(valid)) {
            throw new CustomException("Não existe um carro com esse ID.");
        }

        return locadora;
    }

    private Locadora internalGet(Long id){
        Optional<Locadora> byId = repository.findById(id);
        return byId.orElse(null);
    }

    private void updateDataDB(Locadora locadoraUpdate, Locadora locadora) {
        locadora.setName(locadoraUpdate.getName());
        locadora.setManufacturingDate(locadoraUpdate.getManufacturingDate());
        locadora.setOwner(locadoraUpdate.getOwner());
        locadora.setColor(locadoraUpdate.getColor());
        locadora.setBrand(locadoraUpdate.getBrand());
        locadora.setWorking(locadoraUpdate.getWorking());
    }
}

package br.ueg.progweb1.locadora.service;

import br.ueg.progweb1.locadora.model.Locadora;

import java.util.List;

public interface LocadoraService {
    Locadora create(Locadora locadora);
    List<Locadora> list();
    Locadora get(Long id);
    Locadora update(Locadora locadora);
    Locadora delete(Long id);
}

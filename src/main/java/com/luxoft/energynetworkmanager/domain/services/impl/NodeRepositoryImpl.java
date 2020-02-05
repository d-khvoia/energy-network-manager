package com.luxoft.energynetworkmanager.domain.services.impl;

import com.luxoft.energynetworkmanager.api.NodeRepository;
import com.luxoft.energynetworkmanager.entities.Node;

import java.util.Optional;

//_TODO implementation
public class NodeRepositoryImpl implements NodeRepository {
    @Override
    public Node findByCode(String code) {
        return null;
    }

    @Override
    public <S extends Node> S save(S s) {
        return null;
    }

    @Override
    public <S extends Node> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Node> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Node> findAll() {
        return null;
    }

    @Override
    public Iterable<Node> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Node node) {

    }

    @Override
    public void deleteAll(Iterable<? extends Node> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}

package com.luxoft.energynetworkmanager.api;

import com.luxoft.energynetworkmanager.entities.Node;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends CrudRepository<Node, Integer> {

    @EntityGraph(value = "User.membershipYearsAndPreferences", type = EntityGraph.EntityGraphType.LOAD)
    Node findByCode(String code);
}

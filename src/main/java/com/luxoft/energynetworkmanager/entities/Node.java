package com.luxoft.energynetworkmanager.entities;

import org.json.JSONObject;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "nodes")
@NamedEntityGraphs({
        @NamedEntityGraph(name="Node.allAttributesButIDs", attributeNodes = {
                @NamedAttributeNode("code"),
                @NamedAttributeNode("type"),
                @NamedAttributeNode("name"),
                @NamedAttributeNode("description"),
                @NamedAttributeNode("params")
        }),
        @NamedEntityGraph(name="Node.allAttributes", attributeNodes = {
                @NamedAttributeNode("id"),
                @NamedAttributeNode("parent_id"),
                @NamedAttributeNode("code"),
                @NamedAttributeNode("type"),
                @NamedAttributeNode("name"),
                @NamedAttributeNode("description"),
                @NamedAttributeNode("params")
        }),
        @NamedEntityGraph(
                name = "Node.allChildren",
                attributeNodes = @NamedAttributeNode(value = "children", subgraph = "Node.children"),
                subgraphs = @NamedSubgraph(name = "Node.children", attributeNodes = @NamedAttributeNode("parent_id")))
})
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "parent_id")
    private int parentID;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Node parent;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    @OrderBy("type")
    private Set<Node> children;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Enumerated
    @Column(name = "type", nullable = false)
    private NodeType type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "params", columnDefinition = "json")
    @Convert(attributeName = "params", converter = ParamsAttributeConverter.class)
    private JSONObject params;
}

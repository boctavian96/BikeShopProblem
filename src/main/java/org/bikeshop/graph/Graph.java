package org.bikeshop.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Node, List<Edge>> nodes;

    public Graph(){
        this.nodes = new HashMap<>();
    }

    public void addNode(Node node){
        this.nodes.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Integer fromId, Integer toId, Integer amount){
        Node parentNode = getNode(fromId);
        nodes.get(parentNode).add(new Edge(toId, amount));
    }

    public Node getNode(Integer id){
        return nodes.keySet().stream().filter(node -> id.equals(node.getId())).findFirst().get();
    }

    public List<Edge> getEdges(Integer id){
        Node n = getNode(id);
        return nodes.get(n);
    }
}

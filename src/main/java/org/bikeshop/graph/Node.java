package org.bikeshop.graph;

public class Node {
    private final Integer id;
    private final String name;

    public Node(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name;
    }
}

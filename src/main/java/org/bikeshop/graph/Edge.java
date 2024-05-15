package org.bikeshop.graph;

public class Edge {
    private final Integer childId;
    private final Integer amount;

    public Edge(Integer childId, Integer amount) {
        this.childId = childId;
        this.amount = amount;
    }

    public Integer getChildId() {
        return childId;
    }

    public Integer getAmount() {
        return amount;
    }
}

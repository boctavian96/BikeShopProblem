package org.bikeshop;

import org.bikeshop.graph.Edge;
import org.bikeshop.graph.Graph;
import org.bikeshop.graph.Node;

import java.util.List;

public class BikeWarehouse {

    public void prepareReport(Integer bikeId, Graph graph, int amount, int level){
        prepareReportHeader();
        prepareReportBody(bikeId, graph, amount, level);
        System.out.printf("------------------------------------------------%n");
    }

    private void prepareReportHeader(){
        System.out.printf("------------------------------------------------%n");
        System.out.printf("|       Bike Warehouse Shopping List           |%n");
        System.out.printf("------------------------------------------------%n");

        System.out.printf("| %-4s | %-18s | %8s | %5s |%n", "ID", "NAME", "NUMBER", "LEVEL");
        System.out.printf("------------------------------------------------%n");
    }

    private void prepareReportBody(Integer id, Graph graph, int amount, int level){

        Node node = graph.getNode(id);
        System.out.printf("| %-4s | %-18s | %8s | %5s |%n", node.getId(), node.getName(), amount, level);
        List<Edge> edges = graph.getEdges(node.getId());

        if(edges.isEmpty()){
            //Found a leaf.
            return;
        }

        level++;
        for(Edge edge : edges){
            prepareReportBody(edge.getChildId(), graph, edge.getAmount() * amount ,level);
        }
    }
}

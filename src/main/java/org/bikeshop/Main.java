package org.bikeshop;

import org.bikeshop.datasource.MockResultSet;
import org.bikeshop.graph.Graph;
import org.bikeshop.graph.Node;

import java.io.File;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class Main {
    public static void main(String[] args) throws IOException {

        //"Querying the 'database'."
        ClassLoader classLoader = Main.class.getClassLoader();
        File nodeFile = new File(classLoader.getResource("datasourcemock/NodesTable.txt").getFile());
        File edgeFile = new File(classLoader.getResource("datasourcemock/EdgesTable.txt").getFile());

        //Creating the graph.
        Graph graph = new Graph();

        //Creating the nodes.
        MockResultSet nodeTable = new MockResultSet(nodeFile);

        String nodeRow = nodeTable.readRow();
        while (nonNull(nodeRow)){
            String[] columns = nodeRow.split(" ");
            graph.addNode(new Node(Integer.parseInt(columns[0]), columns[1]));

            nodeRow = nodeTable.readRow();
        }

        //Creating the edges.
        MockResultSet edgeTable = new MockResultSet(edgeFile);

        String edgeRow = edgeTable.readRow();

        while(nonNull(edgeRow)){
            String[] columns = edgeRow.split(" ");
            graph.addEdge(Integer.parseInt(columns[1]), Integer.parseInt(columns[2]), Integer.parseInt(columns[3]));

            edgeRow = edgeTable.readRow();
        }

        //Creating the report for shop.
        BikeWarehouse bikeWarehouse = new BikeWarehouse();
        bikeWarehouse.prepareReport(1, graph,1, 1);
    }
}
// Dijkstra's Algorithm. 
// Find a shortest path and cost from a source node. (pending)
// Author: kei
// Date  : June 29, 2019

package pack01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class Lab01 {


    public static void main(String[] args) {
        Lab01 solution = new Lab01();

        // Your code here.

        int num = 3;
        Graph graph = new Graph(num);
        graph.addEgde(1, 2, 1);
        graph.addEgde(2, 3, 1);
        graph.addEgde(1, 3, 100);
        graph.printGraph();
        
        createTables(graph);
        
        System.out.println(Arrays.toString(nodeToTable.get(1)));
        System.out.println(Arrays.toString(nodeToTable.get(2)));
        System.out.println(Arrays.toString(nodeToTable.get(3)));



        System.out.println();
        System.out.println("done.");
    }

    

    public static Map<Integer, NodeStatus[]> nodeToTable = new HashMap<>();

    public static void createTables(Graph graph) {
        for (int i = 1; i < graph.adjacencylist.length; i++) {
            NodeStatus[] nodeStatuses = graph.doDijkstra(i);
            nodeToTable.put(i, nodeStatuses);
        }       
    }


}

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    int numNodes;
    LinkedList<Edge>[] adjacencylist;

    Graph(int numNodes) {
        this.numNodes = numNodes;
        adjacencylist = new LinkedList[numNodes + 1];
        // Initialize adjacency lists for all the vertices
        for (int i = 1; i < adjacencylist.length ; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEgde(int source, int destination, int weight) {
        Edge edge1 = new Edge(source, destination, weight);
        adjacencylist[source].addFirst(edge1); 
        Edge edge2 = new Edge(destination, source, weight);
        adjacencylist[destination].addFirst(edge2); 
    }

    public void printGraph(){
        for (int i = 1; i < adjacencylist.length ; i++) {
            LinkedList<Edge> list = adjacencylist[i];
            for (int j = 0; j < list.size() ; j++) {
                System.out.println("vertex-" + i + " is connected to " +
                        list.get(j).destination + " with weight " +  list.get(j).weight);
            }
        }
    }
    
    public NodeStatus[] doDijkstra(int srcNodeId) {
        NodeStatus[] nodeStatuses = new NodeStatus[numNodes + 1];
        for (int i = 1; i < nodeStatuses.length; i++) {
            nodeStatuses[i] = new NodeStatus(i, false, Integer.MAX_VALUE);
        }
        
        nodeStatuses[srcNodeId].dist = 0;
        // Build Min-Heap.
        PriorityQueue<NodeStatus> minHeap = new PriorityQueue<>(numNodes, new Comparator<NodeStatus>(){
            @Override
            public int compare(NodeStatus ns1, NodeStatus ns2) {
                return ns1.dist - ns2.dist;
            }
        });
//      for (int i = 1; i < nodeStatuses.length; i++) {
//          minHeap.offer(nodeStatuses[i]);
//      }
        
        
        minHeap.offer(nodeStatuses[srcNodeId]);
        
        // Dijkstra's.
        while (!minHeap.isEmpty()) {
            NodeStatus node = minHeap.poll();
            int nodeId = node.id;
            node.visited = true;
            for (Edge e : adjacencylist[nodeId]) {
                int dest = e.destination;
                if (!nodeStatuses[dest].visited) {
                    // Do RELAX. 
                    if (nodeStatuses[dest].dist > nodeStatuses[nodeId].dist + e.weight) {
                        nodeStatuses[dest].dist = nodeStatuses[nodeId].dist + e.weight;
                    }
                    minHeap.offer(nodeStatuses[dest]);
                }
            }
        }

        // Dijkstra's. If some nodes are separate from other nodes, this does not work. 
//      for (int i = 1; i < adjacencylist.length; i++) {
//          NodeStatus node = minHeap.poll();
//          int nodeId = node.id;
//          node.visited = true;
//          for (Edge e : adjacencylist[nodeId]) {
//              int dest = e.destination;
//              if (!nodeStatuses[dest].visited) {
//                  // Do RELAX. 
//                  if (nodeStatuses[dest].dist > nodeStatuses[nodeId].dist + e.weight) {
//                      nodeStatuses[dest].dist = nodeStatuses[nodeId].dist + e.weight;
//                  }
//                  minHeap.offer(nodeStatuses[dest]);
//              }
//          }
//      }
        
        return nodeStatuses;
    }
    
    
    
}

class NodeStatus {
    int id;
    boolean visited;
    int dist;
    
    public NodeStatus(int id, boolean visited, int dist) {
        this.id = id;
        this.visited = visited;
        this.dist = dist;           
    }
    
    public String toString() {
        return "\nid: " + id + " dist: " + dist;
    }
    
}



































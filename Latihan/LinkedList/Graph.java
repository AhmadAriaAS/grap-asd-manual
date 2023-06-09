package LinkedList;

public class Graph {
    private int vertex;
    private DLinkedList[] list;
    private Node right;

    public Graph(int vertex) {
        this.vertex = vertex;

        list = new DLinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            list[i] = new DLinkedList();
        }
    }

    public void addEdge(int source, int destination, boolean reverse) {

        // One Direction
        if (!reverse) {
            list[source].addFirst(destination);// add edge
            return;
        }

        list[source].addFirst(destination);// add edge
        list[destination].addFirst(source);// Add back (undirected) edge
    }

    public void degree(int source) throws Exception {
        System.out.println("degree vertex " + source + " : " + list[source].size());// Degree undirected Graph

        // Directed Graph
        // inDegree
        int k, totalIn = 0, totalOut = 0;
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                if (list[i].get(j) == source)
                    ++totalIn;
            }

            for (k = 0; k < list[source].size(); k++) {
                list[source].get(k);
            }

            totalOut = k;
        }

        System.out.println("Indegree dari vertex " + source + " : " + totalIn);
        System.out.println("Outdegree dari vertex " + source + " : " + totalOut);
        System.out.println("degree vertex " + source + " : " + (totalIn + totalOut));
    }

    public void removeEdge(int source, int destination) throws Exception {
        list[source].remove(destination);

        // Unusud Code
        // for (int i = 0; i < vertex; i++) {
        // if (i == destination)
        // }
    }

    public void removeAllEdge() {
        for (int i = 0; i < vertex; i++) {
            list[i].clear();
        }

        System.out.println("Graph telah dikosongkan");
    }

    public void print() throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0) {
                System.out.println("vertex " + i + " terhubung dengan: ");

                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
        System.out.println(" ");
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isUndirected() throws Exception {
        for (int i = 0; i < vertex; i++) {
            DLinkedList adjList = list[i];
            for (int j = 0; j < adjList.size(); j++) {
                int dest = adjList.get(j);

                // Check if the reverse edge exists
                if (!list[dest].contains(i)) {
                    return false;
                }
            }
        }

        return true;

    }
}

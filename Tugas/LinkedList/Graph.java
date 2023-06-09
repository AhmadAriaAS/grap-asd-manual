package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class Graph<T> {
    private int vertex;
    private DLinkedList<T>[] list;
    private Map<T, Integer> vertexIndices;
    private Map<Integer, T> sourceVertices;

    @SuppressWarnings("unchecked")
    public Graph(int vertex) {
        this.vertex = vertex;
        list = new DLinkedList[vertex];
        vertexIndices = new HashMap<>();
        sourceVertices = new HashMap<>();

        for (int i = 0; i < vertex; i++) {
            list[i] = new DLinkedList<>();
        }
    }

    private int searcDirect(T source, T dest) {
        for (int key : sourceVertices.keySet()) {
            if (sourceVertices.get(key).equals(dest)) {
                return vertexIndices.get(sourceVertices.get(key));
            }
        }

        return -1;
    }

    public void addEdge(T source, T destination, boolean reverse) {
        int idx = searcDirect(source, destination);

        if (!vertexIndices.containsKey(source) || !sourceVertices.containsValue(source)) {
            vertexIndices.put(source, ((idx == -1) ? vertexIndices.size() : idx - 1));
            sourceVertices.put(((idx == -1) ? vertexIndices.size() - 1 : idx - 1), source);

        }

        if (!vertexIndices.containsKey(destination) || !sourceVertices.containsValue(destination)) {
            vertexIndices.put(destination, ((idx == -1) ? vertexIndices.size() : idx - 1));
            sourceVertices.put(((idx == -1) ? vertexIndices.size() - 1 : idx - 1), destination);

        }

        int sourceIndex = vertexIndices.get(source);
        int destinationIndex = vertexIndices.get(destination);

        list[sourceIndex].addFirst(destination);
        if (reverse) {
            list[destinationIndex].addFirst(source);
        }
    }

    public void degree(T source) throws Exception {
        int totalIn = 0, totalOut = 0;
        int sourceIndex = vertexIndices.get(source);

        for (int i = 0; i < vertex; i++) {
            DLinkedList<T> adjList = list[i];
            for (int j = 0; j < adjList.size(); j++) {
                T dest = adjList.get(j);

                if (dest.equals(source)) {
                    ++totalIn;
                }
            }
        }

        totalOut = list[sourceIndex].size();

        System.out.println("Indegree dari vertex " + source + " : " + totalIn);
        System.out.println("Outdegree dari vertex " + source + " : " + totalOut);
        System.out.println("degree vertex " + source + " : " + (totalIn + totalOut));
    }

    public void removeEdge(T source, T destination) throws Exception {
        if (!vertexIndices.containsKey(source) ||
                !vertexIndices.containsKey(destination))
            throw new IllegalArgumentException("Invalid source or destination vertex");

        int sourceIndex = vertexIndices.get(source);
        DLinkedList<T> adjList = list[sourceIndex];

        int existance = 0;

        for (int i = 0; i < adjList.size(); i++) {
            if (adjList.get(i).equals(destination)) {
                adjList.remove(i);
                break;
            }

        }

        if (!sourceVertices.get(sourceIndex).equals(null)) {
            if (sourceVertices.get(sourceIndex).equals(source)) {
                sourceVertices.remove(sourceIndex);
            }
        }

        for (DLinkedList<T> dLinkedList : list) {
            if (dLinkedList.head == null)
                continue;

            if (dLinkedList.getHead().getData().equals(source))
                existance++;
        }

        System.out.println("Existance: " + existance);

        if (existance <= 1) {
            vertexIndices.remove(source.toString());
        }
    }

    public void removeAllEdge() {

        for (int i = 0; i < vertex; i++) {
            list[i].clear();
        }

        vertexIndices.clear();
        sourceVertices.clear();

        System.out.println("Graph telah dikosongkan");
    }

    public void print() throws Exception {
        for (T vertex : vertexIndices.keySet()) {
            int vertexIndex = vertexIndices.get(vertex);
            DLinkedList<T> adjList = list[vertexIndex];

            if (adjList.size() > 0) {
                System.out.print("Vertex " + vertex + " is connected to: ");
                for (int i = 0; i < adjList.size(); i++) {
                    System.out.print(adjList.get(i) + ", ");
                }
                System.out.println();
            }
        }
    }

    public boolean isUndirected() throws Exception {
        getVertices();

        for (int i = 0; i < vertex; i++) {
            DLinkedList<T> adjList = list[i];
            T source = sourceVertices.get(i);

            for (int j = 0; j < adjList.size(); j++) {
                T destination = adjList.get(j);

                int destinationIndex = (vertexIndices.get(destination) != null) ? vertexIndices.get(destination) : -1;
                DLinkedList<T> content = (destinationIndex != -1) ? list[destinationIndex] : null;
                boolean isExist = (content == null) ? false : content.contains(source);

                if (!isExist) {
                    return false;
                }

            }
        }

        return true;
    }

    public void getVertices() {
        for (T key : vertexIndices.keySet()) {
            System.out.println("VertexIndices: " + key.toString() + " | " + vertexIndices.get(key));
        }
        for (int key : sourceVertices.keySet()) {
            System.out.println("SourceVertices: " + key + " | " + sourceVertices.get(key));
        }
    }

}

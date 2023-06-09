package Array;

import java.util.Scanner;

public class graphArray<T> {
    private final int vertices;
    private final T[][] twoD_array;

    @SuppressWarnings("unchecked")
    public graphArray(int vertices) {
        this.vertices = vertices;
        // this.twoD_array = new int[this.vertices + 1][this.vertices + 1];
        this.twoD_array = (T[][]) new Object[this.vertices + 1][this.vertices + 1];
    }

    public void makeEdge(int to, int form, T edge) {
        try {
            twoD_array[to][form] = edge;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Vertex tidak ada");
        }
    }

    public T getEdge(int to, int from) {
        try {
            return twoD_array[to][from];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Vertex tidak ada");
        }

        return null;
    }

    public static void main(String[] args) {
        int v, e, count = 1, to = 0, from = 0;
        Scanner sc = new Scanner(System.in);
        graphArray<String> graph;

        try {
            System.out.print("Masukkan jumlah vertices: ");
            v = sc.nextInt();

            System.out.print("Masukkan jumlah edge: ");
            e = sc.nextInt();

            graph = new graphArray<>(v);

            System.out.println("Masukkan edges: <to> <from>");
            while (count <= e) {
                to = sc.nextInt();
                from = sc.nextInt();

                sc.nextLine();
                System.out.print("Value: ");
                String edge = sc.nextLine();

                graph.makeEdge(to, from, edge);
                count++;
            }

            System.out.println("Array 2D sebagai representasi graph: ");
            System.out.println(" ");

            for (int i = 1; i <= v; i++) {
            System.out.print(i + " ");

            for (int j = 1; j <= v; j++) {
            String edge = graph.getEdge(i, j);
            System.out.print((edge == null) ? "0 " : edge + " ");
            }

            System.out.println();
            }
        } catch (Exception E) {
            System.err.println("Error. Silahkan cek kembali\n" + E.getMessage());
        }

        sc.close();
    }

}

package Array;

import java.util.Scanner;

public class graphArray {
    private final int vertices;
    private final int[][] twoD_array;

    public graphArray(int vertices) {
        this.vertices = vertices;
        this.twoD_array = new int[this.vertices + 1][this.vertices + 1];
    }

    public void makeEdge(int to, int form, int edge) {
        try {
            twoD_array[to][form] = edge;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Vertex tidak ada");
        }
    }

    public int getEdge(int to, int from) {
        try {
            return twoD_array[to][from];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Vertex tidak ada");
        }

        return -1;
    }

    public static void main(String[] args) {
        int v, e, count = 1, to = 0, from = 0;
        Scanner sc = new Scanner(System.in);
        graphArray graph;

        try {
            System.out.print("Masukkan jumlah vertices: ");
            v = sc.nextInt();

            System.out.print("Masukkan jumlah edge: ");
            e = sc.nextInt();

            graph = new graphArray(v);

            System.out.println("Masukkan edges: <to> <from>");
            while (count <= e) {
                to = sc.nextInt();
                from = sc.nextInt();

                graph.makeEdge(to, from, 1);
                count++;
            }

            System.out.println("Array 2D sebagai representasi graph: ");
            System.out.println(" ");

            for (int i = 0; i < v; i++) {
                System.out.print(i + " ");

                for (int j = 0; j < v; j++) {
                    System.out.print(graph.getEdge(i, j) + " ");
                }

                System.out.println();
            }
        } catch (Exception E) {
            System.err.println("Error. Silahkan cek kembali\n" + E.getMessage());
        }

        sc.close();
    }

}

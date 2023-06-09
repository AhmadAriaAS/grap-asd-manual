package LinkedList;

import java.util.Scanner;

public class Main {
    private Scanner sc = new Scanner(System.in);
    private static boolean isInit = false;
    private static Graph graph;

    public static void main(String[] args) throws Exception {
        if (!isInit) {
            graph = new Graph(50);

            graph.addEdge(0, 1, true);
            graph.addEdge(1, 2, true);
            graph.addEdge(2, 0, true);
            // boolean result = graph.isUndirected();
            // System.out.println((result) ? "Undirected Graph" : "Directed Graph");
        }

        // graph.print();
        // graph.degree(2);

        // graph.removeEdge(1, 2);
        // graph.print();

        new Main().mainMenu();
    }

    public void mainMenu() {
        System.out.println("=================");
        System.out.println("Linked List Graph");
        System.out.println("=================");
        System.out.print(
                "1. Add Edge\n2. Degree\n3. Remove Edge\n4. Remove All Edge\n5. Print\n6. Detect Type\n7. Exit\n[1-6]: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                degree();
                break;
            case 3:
                remove();
                break;
            case 4:
                removeAll();
                break;
            case 5:
                print();
                break;
            case 6:
                handleType();
                break;
            case 7:
                System.exit(0);
                break;

            default:
                System.out.println("Inputan tidak dikenali!");
                mainMenu();
                break;
        }
    }

    public void add() {
        System.out.println("=================");
        System.out.println("     Add Edge");
        System.out.println("=================");
        System.out.print("Masukkan Source [-100 for exit]: ");
        int source = sc.nextInt();

        if (source == -100)
            mainMenu();

        System.out.print("Masukkan Edge [-100 for exit]: ");
        int dest = sc.nextInt();

        if (dest == -100)
            mainMenu();

        System.out.print("Masukkan Reverse Destination? [Y/N]: ");
        boolean reverse = (sc.next().toLowerCase().charAt(0) == 'y') ? true : false;

        graph.addEdge(source, dest, reverse);

        mainMenu();
    }

    public void degree() {
        System.out.println("=================");
        System.out.println("     Degree");
        System.out.println("=================");
        System.out.print("Masukkan Source [-100 for exit]: ");
        int source = sc.nextInt();

        if (source == -100)
            mainMenu();

        try {
            graph.degree(source);
        } catch (Exception e) {
            System.err.println("Error pada: " + e.getMessage());
        } finally {
            mainMenu();
        }
    }

    public void remove() {
        System.out.println("=================");
        System.out.println("   Remove Edge");
        System.out.println("=================");

        System.out.print("Masukkan Source [-100 for exit]: ");
        int source = sc.nextInt();

        if (source == -100)
            mainMenu();

        System.out.print("Masukkan Edge [-100 for exit]: ");
        int dest = sc.nextInt();

        if (dest == -100)
            mainMenu();

        try {
            graph.removeEdge(source, dest);
        } catch (Exception e) {
            System.err.println("Error pada: " + e.getMessage());
        } finally {
            mainMenu();
        }
    }

    public void removeAll() {
        System.out.println("==================");
        System.out.println(" Remove All Edge");
        System.out.println("==================");

        System.out.print("Masukkan Inputan [Y/N]: ");
        char source = sc.next().toLowerCase().charAt(0);

        if (source != 'y')
            mainMenu();

        graph.removeAllEdge();
        try {
            graph.print();
        } catch (Exception e) {
            System.err.println("Error pada: " + e.getMessage());
        } finally {
            mainMenu();
        }
    }

    public void print() {
        try {
            graph.print();
        } catch (Exception e) {
            System.err.println("Error pada: " + e.getMessage());
        } finally {
            mainMenu();
        }

    }

    public void handleType() {
        try {
            boolean result = graph.isUndirected();

            System.out.println((result) ? "Undirected Graph" : "Directed Graph");
        } catch (Exception e) {
            System.err.println("Error pada: " + e.getMessage());
        } finally {
            mainMenu();
        }
    }
}

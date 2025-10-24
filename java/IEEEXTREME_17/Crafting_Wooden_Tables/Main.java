package IEEEXTREME_17.Crafting_Wooden_Tables;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // I/O
        Scanner scanner = new Scanner(System.in);

        int c = scanner.nextInt(); // requirement for a single table
        int n = scanner.nextInt(); // number of slots
        int p = scanner.nextInt(); // amount of piles in each slot
        int w = scanner.nextInt(); // total pieces of wood

        List pockets = new ArrayList<>(n);

        // distribute the total wood -> w into n slots in pockets, where the max is p
        
        System.out.println(pockets);

        // craft the tables
        // subtract the wood value of a table from each pocket, if it becomes empty, replace it with T
        // for (pocket : pockets) ==> pocket < p || pocket == T

        // i dont see why we should care about n and p

    }
}
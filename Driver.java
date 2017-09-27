package apps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import structures.Graph;
import apps.MST;
import apps.PartialTree;
import apps.PartialTreeList;

public class Driver {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter graph input file name ->");
//		String file=sc.nextLine();
//		Graph graph  = new Graph(file);
//----> Auto
		Graph graph = new Graph("graph2.txt");
		ArrayList<PartialTree.Arc> finished = new ArrayList<PartialTree.Arc>();
		finished = MST.execute(MST.initialize(graph));
		System.out.println("Result is : "+'\n');
	
		System.out.println(finished.toString());
	}
}



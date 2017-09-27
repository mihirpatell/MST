package apps;

import structures.*;
import java.util.ArrayList;

public class MST {
	
	/**
	 * Initializes the algorithm by building single-vertex partial trees
	 * 
	 * @param graph Graph for which the MST is to be found
	 * @return The initial partial tree list
	 */
	public static PartialTreeList initialize(Graph graph) {
	

		PartialTreeList list = new PartialTreeList(); 
		
				int count = 0;
		 		while(count < graph.vertices.length) { 	 			
		 			PartialTree partTree = new PartialTree(graph.vertices[count]); 	 			
		 			partTree.getRoot().parent = partTree.getRoot();  	 		
			 			Vertex.Neighbor vnbor= graph.vertices[count].neighbors;
			 			while(vnbor != null) { 
			 				PartialTree.Arc edge = new PartialTree.Arc(partTree.getRoot(), vnbor.vertex, vnbor.weight);
	
			 				partTree.getArcs().insert(edge); 
			 				vnbor = vnbor.next;
			 			} 	 			
		 			list.append(partTree); 
		 			
		 			 count++;
		 		} 	
		 		
		 return list; 
	}
	/**
	 * Executes the algorithm on a graph, starting with the initial partial tree list
	 * 
	 * @param ptlist Initial partial tree list
	 * @return Array list of all arcs that are in the MST - sequence of arcs is irrelevant
	 */
	public static ArrayList<PartialTree.Arc> execute(PartialTreeList ptlist) {		 
		 
		ArrayList<PartialTree.Arc> list = new ArrayList<PartialTree.Arc>(); 
		
		PartialTreeList partTlist = ptlist ;
		
		int count =partTlist.size();
		
		while(count > 1){
			PartialTree pt1 = partTlist.remove();
			PartialTree.Arc arc = pt1.getArcs().deleteMin();
			Vertex v2 = arc.v2;
			
				while(v2.getRoot().equals(pt1.getRoot()) && !pt1.getArcs().isEmpty()){
					arc = pt1.getArcs().deleteMin();
					v2 = arc.v2;	 
				}
				
			if( arc!=null){
				
			list.add(arc);
			System.out.println(list);
			PartialTree pt2 = partTlist.removeTreeContaining(v2.getRoot());
			
			pt2.getRoot().parent = pt1.getRoot().parent;
			pt1.merge(pt2);
			
			partTlist.append(pt1);}
			
			count--;
		}
		return list;
			
	}

	
}

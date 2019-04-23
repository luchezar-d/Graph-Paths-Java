import java.util.ArrayList;

public class BreadthSearch implements Searchable {
	Graph myMap;
	
	public BreadthSearch(Graph g) {
		this.myMap = g;
		this.myMap.resetAllNodes();
	}

	@Override
	public boolean search(String startName, String endName) {
		
		if(!myMap.containsNode(startName) || !myMap.containsNode(endName)) {
			return false;
		}
		
		Node startNode = myMap.getNode(startName);
		
		ArrayList<Node> queue = new ArrayList<>();
		queue.add(startNode);
		
		Node temp;
		
		while(!queue.isEmpty()) {
			temp = queue.get(0);
			System.out.println("Temp node is : " + temp.name);
			
			if(temp.name.contentEquals(endName)) {
				return true;
			}
			
			temp.isTested = true;
			queue.remove(0);
			
			for(Node node : myMap.getLinkedNodes(temp.name)) {
				if(!node.isTested && !queue.contains(node)) {
					
					//Works Like Queue Adds To Last Element
					queue.add(node);
					
					//Works Like Stack Adds To First Element
					//queue.add(0,node);
				}
			}
			
			temp.isExpanded = true;
			
		}//ends while
		
		return false;
	}
	
	
}

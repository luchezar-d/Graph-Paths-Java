import java.util.HashMap;

public class Graph {
	public HashMap<String, Node> myGraph = new HashMap<String, Node>();
	
	public void addNode(Node node) {
		
		if(node == null || myGraph.containsKey(node.name)) {
			System.err.println("Node with this name exists !");
			return;
		}
		myGraph.put(node.name, node);
	}
	
	public void addLink(String startName, String endName, boolean isBiDirectional) {
		if(myGraph.containsKey(startName) && myGraph.containsKey(endName)) {
			Node startNode = myGraph.get(startName);
			Node endNode = myGraph.get(endName);
			
			startNode.links.add(new Link(endName));
			
			if(isBiDirectional) {
				endNode.links.add(new Link(startName));
			}
		}else {
			System.err.println("Wrong or missing node names !");
		}
	}
}

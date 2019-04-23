import java.security.KeyStore.Entry;
import java.util.ArrayList;
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
	public Node getNode(String name) {
		return myGraph.get(name);
	}
	
	public boolean containsNode(String name) {
		return myGraph.containsKey(name);
	}
	
	public ArrayList<Node> getLinkedNodes(String name){
		ArrayList<Node> linkedNodes = new ArrayList<>(); 
		Node node = myGraph.get(name);
		
		for(Link l : node.links) {
			linkedNodes.add(myGraph.get(l.toNodeName));
		}
		
		return linkedNodes;
	}
	
	public void resetAllNodes() {
		myGraph.forEach((k,v) -> v.reset());
	}
}

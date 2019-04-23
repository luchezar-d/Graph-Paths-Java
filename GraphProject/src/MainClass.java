
public class MainClass {

	static Graph graph = new Graph();
	
	public static void findPath(String startName, String endName, Searchable searcher) {
		if(searcher.search(startName, endName)) {
			System.out.println("Path found ! ");
		}else {
			System.out.println("Path not found .. ");
		}
	}
	
	public static void init() {
		graph.addNode(new Node("A"));
		graph.addNode(new Node("B"));
		graph.addNode(new Node("C"));
		graph.addNode(new Node("D"));
		graph.addNode(new Node("E"));
		graph.addNode(new Node("F"));
		
		graph.addLink("A", "B", true);
		graph.addLink("A", "C", true);
		graph.addLink("D", "B", true);
		graph.addLink("E", "B", true);
		graph.addLink("C", "E", true);
		graph.addLink("C", "F", true);
	}
	
	public static void main(String[] args) {
		init();
		findPath("A", "F", new BreadthSearch(graph));
		//findPath("F", "D", new BreadthSearch(graph));
		
	}

}

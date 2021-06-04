package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdjMatrixGraphTest {

	AdjMatrixGraph<String> adjM;
	
	public void setup1() {
		adjM = new AdjMatrixGraph<String>(false, true, 4);
	}
	
	public void setup2() {
		setup1();
		adjM.addVertex("Bob's House");
		adjM.addVertex("Patrick's House");
		adjM.addVertex("Scissors Shop");
		adjM.addVertex("Card Shop");
	}
	
	public void setup3() {
		setup1();
		adjM.addVertex("Bob's House");
		adjM.addVertex("Patrick's House");
		adjM.addVertex("Scissors Shop");
		adjM.addVertex("Card Shop");
	
		adjM.addEdge("Bob's House", "Patrick's House",20);
		adjM.addEdge("Bob's House", "Squidward's House",35);
		adjM.addEdge("Bob's House", "Card Shop",130);
		adjM.addEdge("Bob's House", "Scissors Shop", 120);
	}
	
	public void setup4() {
		adjM = new AdjMatrixGraph<String>(false, true, 9);

		adjM.addVertex("Bob's House");
		adjM.addVertex("Squidward's House");
		adjM.addVertex("Patrick's House");
		adjM.addVertex("Planton's Restaurant");
		adjM.addVertex("Vehicle School");
		adjM.addVertex("Scissors Shop");
		adjM.addVertex("Massage Shop");
		adjM.addVertex("Card Shop");
		adjM.addVertex("Krabby Crustacio");
		
		adjM.addEdge("Bob's House", "Patrick's House",20);
		adjM.addEdge("Bob's House", "Card Shop",130);
		adjM.addEdge("Bob's House", "Scissors Shop", 120);
		adjM.addEdge("Bob's House", "Squidward's House", 35);
		adjM.addEdge("Squidward's House","Patrick's House",40);
		adjM.addEdge("Squidward's House", "Scissors Shop", 60);
		adjM.addEdge("Patrick's House", "Krabby Crustacio", 140);
		adjM.addEdge("Patrick's House", "Vehicle School", 40);
		adjM.addEdge("Planton's Restaurant", "Krabby Crustacio", 15);
		adjM.addEdge("Card Shop", "Planton's Restaurant", 20);
		adjM.addEdge("Vehicle School", "Card Shop", 50);
		adjM.addEdge("Scissors Shop", "Card Shop", 15);
		adjM.addEdge("Vehicle School","Scissors Shop", 30);
		adjM.addEdge("Scissors Shop", "Krabby Crustacio", 50);
		adjM.addEdge("Scissors Shop", "Planton's Restaurant", 40);
		adjM.addEdge("Massage Shop", "Scissors Shop", 35);
		adjM.addEdge("Massage Shop", "Krabby Crustacio", 45);
		adjM.addEdge("Massage Shop", "Planton's Restaurant", 30);
		adjM.addEdge("Massage Shop","Patrick's House",80);
	}
	@Test
	void test1() {
		setup1();
		assertNotNull(adjM.getAdjMatrix(),"its null");
		adjM.addVertex("Bob's House");
		assertEquals(adjM.getNumVertex(),1);
		assertEquals(adjM.getNumEdges(),0);
		adjM.addVertex("Patrick's House");
		adjM.addEdge("Bob's House", "Patrick's House", 20);
		adjM.addEdge("Bob's House", "Squidward's House",35);
		assertEquals(adjM.getNumVertex(),2);
	}

	@Test
	void test2() {
		setup3();
		boolean removed = false;
		boolean removedV = false;
		removed = adjM.removeEdge("Bob's House", "Patrick's House");
		assertEquals(removed, true);
		removedV = adjM.removeVertex("Bob's House");
		assertEquals(removedV, true);
	}
	
	@Test
	void test3() {
		setup3();
		assertEquals(adjM.getAdjMatrix(), adjM.floyd_Warshall());
	}
	
	@Test 
	void test4() {
		setup4();
		assertEquals(adjM.kruskal(),0);
	}
	
	@Test
	void test5() {
		setup4();
		assertEquals(adjM.dijkstra("Card Shop", "Planton's Restaurant"),22);
		assertEquals(adjM.dijkstra("Bob's House", "Card Shop"),130);
		assertEquals(adjM.dijkstra("Massage Shop","Patrick's House"),80);
	}
	
	@Test
	void test6() {
		setup4();
		 adjM.bfs("Bob's House");
		 adjM.dfs("Card Shop");
	}
	
	@Test
	void test7() {
		setup4();
		assertEquals(adjM.prim("Bob's House", 0),2);
	}
	
	@Test
	void test8() {
		setup4();
		boolean found = false;
		found = adjM.searchInGraph("Card Shop");
		assertEquals(found, true);
	}
}

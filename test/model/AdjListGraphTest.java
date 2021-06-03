package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdjListGraphTest {

	AdjListGraph<String> adjL;
	
	public void setup1() {
		adjL = new AdjListGraph<String>(false, true, 0);
	}
	
	public void setup2() {
		setup1();
		adjL.addVertex("Bob's House");
		adjL.addVertex("Patrick's House");
		adjL.addVertex("Scissors Shop");
		adjL.addVertex("Card Shop");
		
		adjL.addEdge("Bob's House", "Patrick's House",20);
		adjL.addEdge("Bob's House", "Squidward's House",35);
		adjL.addEdge("Bob's House", "Card Shop",130);
		adjL.addEdge("Bob's House", "Scissors Shop", 120);
	
	}
	
	public void setup3() {
		adjL = new AdjListGraph<String>(false, true, 9);

		adjL.addVertex("Bob's House");
		adjL.addVertex("Squidward's House");
		adjL.addVertex("Patrick's House");
		adjL.addVertex("Planton's Restaurant");
		adjL.addVertex("Vehicle School");
		adjL.addVertex("Scissors Shop");
		adjL.addVertex("Massage Shop");
		adjL.addVertex("Card Shop");
		adjL.addVertex("Krabby Crustacio");
		
		adjL.addEdge("Bob's House", "Patrick's House",20);
		adjL.addEdge("Bob's House", "Card Shop",130);
		adjL.addEdge("Bob's House", "Scissors Shop", 120);
		adjL.addEdge("Bob's House", "Squidward's House", 35);
		adjL.addEdge("Squidward's House","Patrick's House",40);
		adjL.addEdge("Squidward's House", "Scissors Shop", 60);
		adjL.addEdge("Patrick's House", "Krabby Crustacio", 140);
		adjL.addEdge("Patrick's House", "Vehicle School", 40);
		adjL.addEdge("Planton's Restaurant", "Krabby Crustacio", 15);
		adjL.addEdge("Card Shop", "Planton's Restaurant", 20);
		adjL.addEdge("Vehicle School", "Card Shop", 50);
		adjL.addEdge("Scissors Shop", "Card Shop", 15);
		adjL.addEdge("Vehicle School","Scissors Shop", 30);
		adjL.addEdge("Scissors Shop", "Krabby Crustacio", 50);
		adjL.addEdge("Scissors Shop", "Planton's Restaurant", 40);
		adjL.addEdge("Massage Shop", "Scissors Shop", 35);
		adjL.addEdge("Massage Shop", "Krabby Crustacio", 45);
		adjL.addEdge("Massage Shop", "Planton's Restaurant", 30);
		adjL.addEdge("Massage Shop","Patrick's House",80);
	}
	@Test
	void test1() {
		setup1();
		assertNotNull(adjL.getVertex(),"its null");
		adjL.addVertex("Bob's House");
		assertEquals(adjL.getVertex().get(0).getValue(),"Bob's House");
		assertEquals(adjL.getVertex().get(0).getIndex(),0);
		assertEquals(adjL.isDirected(),false);
	}
	
	@Test
	void test2() {
		setup2();
		assertEquals(adjL.getVertex().get(2).getValue(),"Scissors Shop");
		adjL.removeVertex("Scissors Shop");
		assertEquals(adjL.getVertex().get(2).getValue(),"Card Shop");
		assertEquals(adjL.kruskal(),0);
	}

	@Test
	void test3() {
		setup3();
		assertEquals(adjL.bfs("Massage Shop","Vehicle School"),2);
		assertEquals(adjL.kruskal(),205);
		assertEquals(adjL.dijkstra("Massage Shop","Patrick's House"),80);
		assertEquals(adjL.dijkstra("Massage Shop","Bob's House"),100);
		assertEquals(adjL.searchAdjVertex("Planton's Restaurant").getAdjList().get(0).getWeight(),15);
		//assertEquals(adjL.prim(adjL.getVertex().get(0)),140);
	}
	
	@Test
	void test4(){
		setup2();
		boolean removed = false;
		assertNotNull(adjL.searchAdjVertex("Scissors Shop"),"its null");
		removed = adjL.removeEdge("Bob's House", "Patrick's House");
		assertEquals(removed,true);
	}
}

package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdjListGraphTest {

	AdjListGraph<String> adjL;
	
	public void setup1() {
		adjL = new AdjListGraph<String>(false, true, 4);
	}
	
	public void setup2() {
		setup1();
		adjL.addEdge("Bob's House", "Patrick's House",20);
		adjL.addEdge("Bob's House", "Squidward's House",35);
		adjL.addEdge("Bob's House", "Card Shop",130);
		adjL.addEdge("Bob's House", "Scissors Shop", 120);
	}
	
	public void setup3() {
		setup1();
		adjL.addVertex("Bob's House");
		adjL.addVertex("Patrick's House");
		adjL.addVertex("Scissors Shop");
		adjL.addVertex("Card Shop");
	}
	@Test
	void test() {
		setup1();
		assertNotNull(adjL.getVertex().get(0),"its null");
		
	}

}

package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdjMatrixGraphTest {

	AdjMatrixGraph<String> adjM;
	
	public void setup1() {
		adjM = new AdjMatrixGraph<String>(false, true, 0);
	}
	
	public void setup2() {
		setup1();
		adjM.addVertex("Bob's House");
		adjM.addVertex("Patrick's House");
		adjM.addVertex("Scissors Shop");
		adjM.addVertex("Card Shop");
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

}

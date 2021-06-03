package threads;
import ui.*;
public class Thread1 extends Thread {
	
	private BobSpongeController bob;
	
	public Thread1(BobSpongeController bob) {
		this.bob = bob;
	}
	
	@Override
	public void run() {
		bob.loadDistance();
		
		try {
			Thread1.sleep(1000);
		}catch(InterruptedException e) {
			
		}
	}
}

public class ServerMain{
	
	public static void main(String[] args) {
		ServerGui gui = new ServerGui();
		
		//ServerSerial serial = new ServerSerial();
		
		System.out.println("Thread network start");
		//Thread net = new Thread(new ServerNetworking());
		
		
		while(true){
			gui.refresh();
		}
		// TODO Auto-generated method stub

	}

}

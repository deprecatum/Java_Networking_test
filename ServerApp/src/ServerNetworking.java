import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServerNetworking implements Runnable{
	
	private class requestHandler implements Runnable{
		
		PrintWriter exit;
		
		String buff;
		
		String command;
		
		Socket ip;
		
		requestHandler(Socket s){
			ip=s;
			
			try {
				exit = new PrintWriter(ip.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					buff=ip.getInputStream().toString();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("no command");
					break;
				}
				if(!buff.isEmpty()){
					command=buff;
				}
				if(buff.substring(0, 6)=="VidData"){
					switch(buff.substring(7, 7)){
						case("1"):{
							for(int f=0; f==SharedResources.frameNum; f++){
								while(!SharedResources.frameComplete[0][f]){
									System.out.println("waiting for frame");
								}
								if(SharedResources.frameComplete[0][f]){
									for(int y=0; y==SharedResources.frameHeight; y++){
										for(int x=0; x==SharedResources.frameWidth; x++){
											exit.println(SharedResources.bufferList.get(0).getRGB(x, y));
										}
									}
								}
								
							}	
						};
						case("2"):{
							for(int f=0; f==SharedResources.frameNum; f++){
								while(!SharedResources.frameComplete[1][f]){
									System.out.println("waiting for frame");
								}
								if(SharedResources.frameComplete[1][f]){
									for(int y=0; y==SharedResources.frameHeight; y++){
										for(int x=0; x==SharedResources.frameWidth; x++){
											exit.println(SharedResources.bufferList.get(1).getRGB(x, y));
										}
									}
								}
							}	
						};
						break;
					}
				}
			}
		}
		
	} //fim requestHandler
	
	int port = 61001;
	
	ArrayList<requestHandler> dataRelayer = new ArrayList<requestHandler>();
	
	ServerSocket requests;
	
	ServerNetworking(){
		try {
			requests = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ipHandler();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub	
		while(true){
			//ipHandler();
			//requestHandler();
			System.out.println("kek");
		}
	}
	
	
	public void ipHandler(){
		try { 
			dataRelayer.add(new requestHandler(requests.accept())); 
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

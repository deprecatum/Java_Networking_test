import java.awt.image.BufferedImage;


public class ServerSerial {
	
	//https://theredblacktree.wordpress.com/2012/08/09/rf24bb/
	//biblioteca de RF
	
	int xCounter;
	int yCounter;
	
	int pixelData;
	
	public void getSerial(){
		//read n format serial data
		
		xCounter++;
		if(xCounter==319){
			xCounter=0;
			yCounter++;
		}
		
		SharedResources.pixelBuffer[xCounter][yCounter]=pixelData;
		SharedResources.frame.setRGB(xCounter, yCounter, pixelData);
		
		if(yCounter==159&&xCounter==319){
			yCounter=0;
			xCounter=0;
			SharedResources.bufferComplete=true;
		}
	}
	
}

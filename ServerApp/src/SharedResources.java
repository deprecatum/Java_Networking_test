import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


public class SharedResources {
	
	static BufferedImage frame = new BufferedImage(319, 159, BufferedImage.TYPE_INT_RGB);
	
	static ArrayList<BufferedImage> bufferList = new ArrayList<BufferedImage>();
	
	static int frameNum=6;
	
	static boolean[][] frameComplete = new boolean[1][frameNum];
	
	static int[][] pixelBuffer= new int[319][159];
	
	static int idSelect=0;
	
	static int scale=3;
	
	static int frameWidth = 319;
	
	static int frameHeight = 159;
	
	static Dimension frameDimension = new Dimension(frameWidth, frameHeight);
	
	static Dimension frameDimensionScaled = new Dimension(frameWidth*scale, frameHeight*scale);
	
}

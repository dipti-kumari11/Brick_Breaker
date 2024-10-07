package BrickBreaker;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class MapGenerator 
{
	public int map[][];
	public static int brickWidth;
	public static int brickHeight;
	
	public MapGenerator (int row, int col)
	{
		map = new int[row][col];		
		for(int i = 0; i<map.length; i++)
		{
			for(int j =0; j<map[0].length; j++)
			{
				map[i][j] = 1;
			}			
		}
		
		brickWidth = 540/col;
		brickHeight = 150/row;
	}	
	
	public void draw(Graphics2D g)
	{
		for(int i = 0; i<map.length; i++)
		{
			for(int j =0; j<map[0].length; j++)
			{
				if(map[i][j] > 0)
				{
					int R = (int)(Math.random()*125);
					int G = (int)(Math.random()*125);
					int B= (int)(Math.random()*125);
					Color color = new Color(R, G, B); //random color, but can be bright or dull

					//to get rainbow, pastel colors
					Random random = new Random();
					final float hue = random.nextFloat();
					final float saturation = 0.9f;//1.0 for brilliant, 0.0 for dull
					final float luminance = 1.0f; //1.0 for brighter, 0.0 for black
					color = Color.getHSBColor(hue, saturation, luminance);
					
					g.setColor(color);
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					
					// this is just to show separate brick, game can still run without it
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);				
				}
			}
		}
	}
	
	public void setBrickValue(int value, int row, int col)
	{
		map[row][col] = value;
	}
}

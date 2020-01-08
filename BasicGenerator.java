package hw4;
import api.Generator;
import api.Position;
import api.Shape;
import java.util.Random;

/**
 * Generator for Shape objects in MagicTetris. All six shapes are equally
 * likely, and the generated shape is magic with 20% probability.
 */
public class BasicGenerator implements Generator
	{
	
	public BasicGenerator()
		{
		}
		
		
		
	@ Override
	public Shape getNext(int width)
		{
		boolean magicState = false;
		Random rand = new Random();
		int shapeNum = 2;
		//int shapeNum = rand.nextInt(6);
		int magicNum = rand.nextInt(5);
		int mid = width / 2;
		if (magicNum == 0)
			{
			magicState = true;
			}
		if (shapeNum == 0)
			{
			Position position = new Position(-1, mid + 1);
			Shape result = new LShape(position, magicState);
			return result;
			}
		if (shapeNum == 1)
			{
			Position position = new Position(-1, mid);
			Shape result = new JShape(position, magicState);
			return result;
			}
		if (shapeNum == 2)
			{
			Position position = new Position(-2, mid);
			Shape result = new IShape(position, magicState);
			return result;
			}
		if (shapeNum == 3)
			{
			Position position = new Position(-1, mid);
			Shape result = new OShape(position, magicState);
			return result;
			}
		if (shapeNum == 4)
			{
			Position position = new Position(-1, mid + 1);
			Shape result = new TShape(position, magicState);
			return result;
			}
		else
			{
			Position position = new Position(-1, mid + 1);
			Shape result = new SZShape(position, magicState);
			return result;
			}
		}
	}

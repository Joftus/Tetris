package hw4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import api.AbstractGame;
import api.Position;

/**
 * MagicTetris implementation.
 */
public class MagicTetris extends AbstractGame
	{
	
	private int score;
	private boolean gravityMode;
	
	
	
	/**
	 * Constructs a game with the given width (columns) and height (rows). This game
	 * will use a new instance of BasicGenerator to generate new shapes.
	 * 
	 * @param width
	 *            width of the game grid (number of columns)
	 * @param height
	 *            height of the game grid (number of rows)
	 */
	public MagicTetris(int width, int height)
		{
		super(width, height, new BasicGenerator());
		}
		
		
		
	@ Override
	public List<Position> determinePositionsToCollapse()
		{
		List<Position> result = new ArrayList<Position>();
		if (gravityMode == true)
			{
			for (int row = 0; row < getHeight() - 1; row++)
				{
				for (int col = 0; col < getWidth(); col++)
					{
					if (!(grid[row][col] == null) && grid[row + 1][col] == null)
						{
						int count = row + 1;
						while (grid[count][col] == null && count < getHeight() - 1)
							{
							Position collapse = new Position(count, col);
							result.add(collapse);
							count++;
							}
						}
					if (grid[getHeight() - 1][col] == null)
						{
						Position bot = new Position(getHeight() - 1, col);
						result.add(bot);
						}
					}
				}
			gravityMode = false;
			}
		else
			{
			for (int row = 0; row < getHeight(); row++)
				{
				int blockCount = 0;
				int magicBlockCount = 0;
				for (int col = 0; col < getWidth(); col++)
					{
					if (!(grid[row][col] == null))
						{
						blockCount++;
						}
					}
				if (blockCount == getWidth())
					{
					for (int count = 0; count < getWidth(); count++)
						{
						Position collapse = new Position(row, count);
						result.add(collapse);
						if (grid[row][count].isMagic() == true)
							{
							magicBlockCount++;
							gravityMode = true;
							}
						}
					score += Math.pow(2, magicBlockCount);
					}
				}
			}
		return result;
		}
		
		
		
	@ Override
	public int determineScore()
		{
		return score;
		}
	}

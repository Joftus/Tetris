package hw4;
import java.awt.Color;
import api.Block;
import api.Cell;
import api.Position;
import api.Shape;

/**
 * Abstract superclass for implementations of the Shape interface.
 */
public abstract class AbstractShape implements Shape
	{
	
	protected Cell[] cells;
	private Position position;
	
	
	
	public void shiftDown()
		{
		int len = cells.length;
		for (int count = 0; count < len; count++)
			{
			cells[count].setRow(cells[count].getRow() + 1);
			}
		}
		
		
		
	public void shiftLeft()
		{
		int len = cells.length;
		for (int count = 0; count < len; count++)
			{
			cells[count].setCol(cells[count].getCol() - 1);
			}
		}
		
		
		
	public void shiftRight()
		{
		int len = cells.length;
		for (int count = 0; count < len; count++)
			{
			cells[count].setCol(cells[count].getCol() + 1);
			}
		}
		
		
		
	public void cycle()
		{
		int len = cells.length;
		Color color = cells[0].getBlock().getColorHint();
		for (int count = 0; count < len; count++)
			{
			Block nonMagic = new Block(color, false);
			Block isMagic = new Block(color, true);
			if (cells[count].getBlock().isMagic() == true)
				{
				cells[count].setBlock(nonMagic);
				if (count + 1 == len)
					{
					cells[0].setBlock(isMagic);
					}
				else
					{
					cells[count + 1].setBlock(isMagic);
					}
				}
			}
		}
		
		
		
	public Cell[] getCells()
		{
		int len = cells.length;
		Cell[] copy = new Cell[len];
		for (int count = 0; count < len; count++)
			{
			copy[count] = new Cell(cells[count]);
			}
		return copy;
		}
		
		
		
	public void transform()
		{
		}
		
		
		
	public Shape clone()
		{
		int len = cells.length;
		try
			{
			AbstractShape clone = (AbstractShape) super.clone();
			clone.cells = new Cell[len];
			for (int count = 0; count < len; count++)
				{
				clone.cells[count] = new Cell(cells[count]);
				clone.position = new Position(cells[count].getRow(), cells[count].getCol());
				}
			return clone;
			}
		catch (CloneNotSupportedException e)
			{
			return null;
			}
		}
	}

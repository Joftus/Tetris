package hw4;
import java.awt.Color;
import api.Block;
import api.Cell;
import api.Position;

// Joshua Loftus ComSci 227 Section A
public class IShape extends AbstractShape
	{
	
	private int transformCount = 4;
	
	
	
	public IShape(Position givenPosition, boolean magic)
		{
		Color color = Color.CYAN;
		cells = new Cell[3];
		cells[0] = new Cell(new Block(color, magic), givenPosition);
		Position position2 = new Position(givenPosition.row() + 1, givenPosition.col());
		cells[1] = new Cell(new Block(color, false), position2);
		Position position3 = new Position(position2.row() + 1, position2.col());
		cells[2] = new Cell(new Block(color, false), position3);
		}
		
		
		
	@ Override
	public void transform()
		{
		if (transformCount % 4 == 0)
			{
			cells[1].setRow(cells[1].getRow() - 1);
			cells[1].setCol(cells[1].getCol() + 1);
			cells[2].setRow(cells[2].getRow() - 2);
			cells[2].setCol(cells[2].getCol() + 2);
			}
		if (transformCount % 4 == 1)
			{
			cells[1].setRow(cells[1].getRow() - 1);
			cells[1].setCol(cells[1].getCol() - 1);
			cells[2].setRow(cells[2].getRow() - 2);
			cells[2].setCol(cells[2].getCol() - 2);
			}
		if (transformCount % 4 == 2)
			{
			cells[1].setRow(cells[1].getRow() + 1);
			cells[1].setCol(cells[1].getCol() - 1);
			cells[2].setRow(cells[2].getRow() + 2);
			cells[2].setCol(cells[2].getCol() - 2);
			}
		if (transformCount % 4 == 3)
			{
			cells[1].setRow(cells[1].getRow() + 1);
			cells[1].setCol(cells[1].getCol() + 1);
			cells[2].setRow(cells[2].getRow() + 2);
			cells[2].setCol(cells[2].getCol() + 2);
			}
		transformCount++;
		}
	}

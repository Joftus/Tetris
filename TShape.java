package hw4;
import java.awt.Color;
import api.Block;
import api.Cell;
import api.Position;

// Joshua Loftus ComSci 227 Section A
public class TShape extends AbstractShape
	{
	
	private int transformCount = 4;
	
	
	
	public TShape(Position givenPosition, boolean magic)
		{
		Color color = Color.MAGENTA;
		cells = new Cell[4];
		Position position1 = new Position(givenPosition.row() - 1, givenPosition.col());
		cells[0] = new Cell(new Block(color, magic), position1);
		Position position2 = new Position(position1.row() + 1, position1.col() - 1);
		cells[1] = new Cell(new Block(color, false), position2);
		Position position3 = new Position(position2.row(), position2.col() + 1);
		cells[2] = new Cell(new Block(color, false), position3);
		Position position4 = new Position(position3.row(), position3.col() + 1);
		cells[3] = new Cell(new Block(color, false), position4);
		}
		
		
		
	@ Override
	public void transform()
		{
		if (transformCount % 4 == 0)
			{
			cells[0].setRow(cells[0].getRow() + 1);
			cells[0].setCol(cells[0].getCol() - 1);
			cells[1].setRow(cells[1].getRow() + 1);
			cells[1].setCol(cells[1].getCol() + 1);
			cells[3].setRow(cells[3].getRow() - 1);
			cells[3].setCol(cells[3].getCol() - 1);
			}
		if (transformCount % 4 == 1)
			{
			cells[0].setRow(cells[0].getRow() + 1);
			cells[0].setCol(cells[0].getCol() + 1);
			cells[1].setRow(cells[1].getRow() - 1);
			cells[1].setCol(cells[1].getCol() + 1);
			cells[3].setRow(cells[3].getRow() + 1);
			cells[3].setCol(cells[3].getCol() - 1);
			}
		if (transformCount % 4 == 2)
			{
			cells[0].setRow(cells[0].getRow() - 1);
			cells[0].setCol(cells[0].getCol() + 1);
			cells[1].setRow(cells[1].getRow() - 1);
			cells[1].setCol(cells[1].getCol() - 1);
			cells[3].setRow(cells[3].getRow() + 1);
			cells[3].setCol(cells[3].getCol() + 1);
			}
		if (transformCount % 4 == 3)
			{
			cells[0].setRow(cells[0].getRow() - 1);
			cells[0].setCol(cells[0].getCol() - 1);
			cells[1].setRow(cells[1].getRow() + 1);
			cells[1].setCol(cells[1].getCol() - 1);
			cells[3].setRow(cells[3].getRow() - 1);
			cells[3].setCol(cells[3].getCol() + 1);
			}
		transformCount++;
		}
	}

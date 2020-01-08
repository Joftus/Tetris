package hw4;
import java.awt.Color;
import api.Block;
import api.Cell;
import api.Position;

// Joshua Loftus ComSci 227 Section A
public class OShape extends AbstractShape
	{
	
	public OShape(Position givenPosition, boolean magic)
		{
		Color color = Color.YELLOW;
		cells = new Cell[4];
		// wrong positions
		cells[0] = new Cell(new Block(color, magic), givenPosition);
		Position position2 = new Position(givenPosition.row(), givenPosition.col() + 1);
		cells[1] = new Cell(new Block(color, false), position2);
		Position position3 = new Position(position2.row() + 1, position2.col() - 1);
		cells[2] = new Cell(new Block(color, false), position3);
		Position position4 = new Position(position3.row(), position3.col() + 1);
		cells[3] = new Cell(new Block(color, false), position4);
		}
	}

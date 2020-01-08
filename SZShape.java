package hw4;
import java.awt.Color;
import api.Block;
import api.Cell;
import api.Position;

// Joshua Loftus ComSci 227 Section A
public class SZShape extends AbstractShape
	{
	
	private int transformCount = 2;
	
	
	
	public SZShape(Position givenPosition, boolean magic)
		{
		cells = new Cell[4];
		Color color = Color.GREEN;
		cells[0] = new Cell(new Block(color, magic), givenPosition);
		Position position2 = new Position(givenPosition.row() + 1, givenPosition.col());
		cells[1] = new Cell(new Block(color, false), position2);
		Position position3 = new Position(position2.row(), position2.col() + 1);
		cells[2] = new Cell(new Block(color, false), position3);
		Position position4 = new Position(position3.row() + 1, position3.col());
		cells[3] = new Cell(new Block(color, false), position4);
		}
		
		
		
	@ Override
	public void transform()
		{
		if (transformCount % 2 == 0)
			{
			Position P0 = new Position(cells[0].getRow(), cells[0].getCol() + 1);
			cells[0] = new Cell(new Block(Color.RED, cells[0].getBlock().isMagic()), P0);
			Position P1 = new Position(cells[1].getRow(), cells[1].getCol() + 1);
			cells[1] = new Cell(new Block(Color.RED, cells[1].getBlock().isMagic()), P1);
			Position P2 = new Position(cells[2].getRow(), cells[2].getCol() - 1);
			cells[2] = new Cell(new Block(Color.RED, cells[2].getBlock().isMagic()), P2);
			Position P3 = new Position(cells[3].getRow(), cells[3].getCol() - 1);
			cells[3] = new Cell(new Block(Color.RED, cells[3].getBlock().isMagic()), P3);
			}
		if (transformCount % 2 == 1)
			{
			Position P0 = new Position(cells[0].getRow(), cells[0].getCol() - 1);
			cells[0] = new Cell(new Block(Color.GREEN, cells[0].getBlock().isMagic()), P0);
			Position P1 = new Position(cells[1].getRow(), cells[1].getCol() - 1);
			cells[1] = new Cell(new Block(Color.GREEN, cells[1].getBlock().isMagic()), P1);
			Position P2 = new Position(cells[2].getRow(), cells[2].getCol() + 1);
			cells[2] = new Cell(new Block(Color.GREEN, cells[2].getBlock().isMagic()), P2);
			Position P3 = new Position(cells[3].getRow(), cells[3].getCol() + 1);
			cells[3] = new Cell(new Block(Color.GREEN, cells[3].getBlock().isMagic()), P3);
			}
		transformCount++;
		}
	}

package turing;



public class Tape extends Cell{
	private Cell currentCell;


	/*  constructor that creates a tape that initially consists of a single cell. 
	 * The cell contains a blank space, and the current cell pointer points to it.
	 * */
	public Tape() {
		Cell newCell = new Cell();
		newCell.content = ' ';
		newCell.prev = null;
		newCell.next = null;
		currentCell = newCell;
	}

	// changes the char in the current cell to the specified value.
	public void setContent(char charAt) {
		currentCell.content = charAt;
	}


	/* moves the current cell one position to the right along the tape. 
	 * Note that if the current cell is the rightmost cell that exists, 
	 * then a new cell must be created and added to the tape at the right of the current cell, 
	 * and then the current cell pointer can be moved to point to the new cell. 
	 * The content of the new cell should be a blank space.
	 *  */
	public void moveRight() {
		if (currentCell.next == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.next = null;
			newCell.prev = currentCell;
			currentCell.next = newCell;
		}
		currentCell = currentCell.next;

	}

	/* moves the current cell one position to the left along the tape. 
	 * Note that if the current cell is the leftmost cell that exists, 
	 * then a new cell must be created and added to the tape at the left of the current cell, 
	 * and then the current cell pointer can be moved to point to the new cell. 
	 * The content of the new cell should be a blank space. 
	 * (Remember that the Turing machine's tape is conceptually infinite, 
	 * so your linked list must be prepared to expand on-demand when the machine wants to move past the current end of the list.)
	 * 
	 *  */
	public void moveLeft() {
		if (currentCell.prev == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.prev = null;
			newCell.next = currentCell;
			currentCell.prev = newCell;
		}
		currentCell = currentCell.prev;

	}
	/* returns a String consisting of the chars from all the cells on the tape, 
	 * read from left to right, except that leading or trailing blank characters should be discarded. 
	 * The current cell pointer should not be moved by this method; 
	 * it should point to the same cell after the method is called as it did before. 
	 * You can create a different pointer to move along the tape and get the full contents. 
	 * (This method is the hardest one to implement.)
	 * */
	public String getTapeContents() {
		Cell pointer = currentCell;
		while (pointer.prev != null)
			pointer = pointer.prev;
		String outputString = "";
		while (pointer != null) {
			outputString += pointer.content;
			pointer = pointer.next;

		}

		return outputString.trim();
	}
	//  returns the char from the current cell.
	public char getContent() {
		return currentCell.content;
	}
	// returns the pointer that points to the current cell.
	public Cell getCurrentCell() {
		return this.currentCell;
	}
}

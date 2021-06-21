package _05_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);
		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		return head.getLocation();
	}

	public void update() {
		/*
		 * Use a switch statement to check on the currentDirection of the snake and
		 * calculate the head's next x and y position. Depending on the direction, the
		 * head's x or y will increase or decrease by 1.
		 */
		int currentX =  head.getLocation().getX();
		int currentY = head.getLocation().getY();
		switch (currentDirection) {
		case DOWN:
		//get heads location then set y to -1
		currentY++;
			break;
		case UP:
			currentY--;
			break;
		case LEFT:
			currentX--;
			break;
		case RIGHT:
			currentX++;
			break;
		default:
			break;
		}
		head.setLocation(new Location(currentX, currentY));
		int nextX;
		int nextY;

		/*
		 * Change the Location of each SnakeSegment in your snake ArrayList to the
		 * Location of the segment in front of it.
		 * 
		 * Use a loop starting at the end of the ArrayList and stop before the head of
		 * the snake (index 0) or you will go out of bounds.
		 */

		/*
		 * Create a new Location object and initialize it with the values calculated in
		 * step 1. Then set the head's location equal to the new location.
		 */

		// Set the canMove member variable to true.
		
		for (int i = snake.size()-1; i > 0 ; i--) {
			snake.get(i).setLocation(snake.get(i-1).getLocation());;
		}
		canMove = true;
	}

	public void setDirection(Direction direction) {

		/*
		 * Set the currentDirection member variable to the passed in direction and
		 * canMove to false if the passed in direction is not the opposite direction and
		 * canMove is true.
		 * 
		 * Hint: Use the isOppositeDirection method to check if Direction d is opposite.
		 */
		currentDirection = direction;
		if (!isOppositeDirection(direction) && canMove == true) {
			canMove = false;
		}
	}

	private boolean isOppositeDirection(Direction direction) {

		/*
		 * Complete the method so it returns true if the passed in Direction is the
		 * opposite value of the currentDirection member variable.
		 * 
		 * Otherwise, return false. For example, if currentDirection is UP and the
		 * passed in direction is DOWN this method should return false.
		 */
		
		boolean isOpposite = true;
		
		if (direction ==  Direction.DOWN && currentDirection == Direction.UP || direction ==  Direction.LEFT && currentDirection == Direction.RIGHT || direction ==  Direction.RIGHT && currentDirection == Direction.LEFT || direction ==  Direction.UP && currentDirection == Direction.DOWN) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public void resetLocation() {

		// Clear the snake.

		/*
		 * Create a new Location object for the head at SnakeGame.WIDTH / 2,
		 * SnakeGame.HEIGHT / 2.
		 */

		/*
		 * Set the head member variable equal to a new SnakeSegment object. Use the
		 * Location created in step 2 for the Location and the BODY_SIZE constant for
		 * the size.
		 */

		// Add the head to the snake.

		snake.clear();
		
		Location location = new Location(SnakeGame.WIDTH / 2, SnakeGame.HEIGHT / 2);
		
		head = new SnakeSegment(location, BODY_SIZE);
		
	}

	public boolean isOutOfBounds() {

		/*
		 * Complete the method so it returns true if the head of the snake is outside of
		 * the window and false otherwise.
		 */
		int currentX =  head.getLocation().getX();
		int currentY = head.getLocation().getY();
		if( currentX > 500 || currentX < 0 || currentY > 500 || currentY < 0  ){
			 return true;
			 }
		else {
			return false;
		}

		

	}

	public boolean isHeadCollidingWithBody() {

		/*
		 * Complete the method so it returns true if the head is located in the same
		 * location as any other body segment.
		 */
		for (int i = 0; i < snake.size()-1 ; i++) {
			if (snake.get(i).getLocation() == head.getLocation()) {
				return true;
			}
			else {
				return false;
			}
			
		}
		return false;
	}

	public boolean isLocationOnSnake(Location loc) {

		/*
		 * Complete the method so it returns true if the passed in location is located
		 * on the snake.
		 */
		
		if (snake.contains(loc)) {
			return true;
		}
		else {
			return false;
		}
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}

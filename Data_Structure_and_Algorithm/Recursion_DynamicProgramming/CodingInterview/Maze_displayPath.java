// Explore 2D array for maze with recursion and 
// display path. O(rc) time, where r is the num of rows and c is the num of columns. 
// Author: CtCI 6th 8.2 p.345 + kei
// Date  : October 6, 2016, January 11, 2019


package whiteboard;

import java.util.ArrayList;
import java.util.HashSet;


public class Lab_whiteboard {

	public static void main(String[] args) {
		
		
		boolean[][] maze = new boolean[][]
			   {{true, true, true, true}, 
                {true, true, true, true},
                {true, false, true, false}, 
                {true, true, true, true}};
		
		boolean[][] maze2 = new boolean[][]
			   {{true, true, true, true}, 
                {true, true, true, true},
                {true, false, false, false}, 
                {false, true, true, true}};

		
		ArrayList<Point2> path = getPath2(maze);
		
		if (path != null) {
			for (Point2 point : path) {
				System.out.println(point);
			}
		} else {
			System.out.println("No path exists.");
		}
		

	}
	
	
	public static ArrayList<Point2> getPath2(boolean[][] maze) {		
		if (maze == null || maze.length == 0) {
			return null;
		}
		
		ArrayList<Point2> path = new ArrayList<Point2>();
		HashSet<Point2> failedPoints = new HashSet<>();
		// The args are coordinates of the goal. 
		if (getPath2(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
			return path;
		}
		
		return null;
	}
	public static boolean getPath2(boolean[][] maze, int row, int col, 
			                       ArrayList<Point2> path, HashSet<Point2> failedPoints) {
		// Base case.
		if (row < 0 || col < 0 || !maze[row][col]) {
			return false;
		}
		
		Point2 p = new Point2(row, col);
		
		if ((row == 0) && (col == 0)) {
			p = new Point2(row, col);
			path.add(p);
			return true;
		}
		
		// Memoization. 
		if (failedPoints.contains(p)) {
			return false;
		}
		
		// General case.
		if (getPath2(maze, row - 1, col, path, failedPoints) || 
			getPath2(maze, row, col - 1, path, failedPoints)) {
			p = new Point2(row, col);
			path.add(p);
			return true;
		} 
			
		// Cache result. 
		failedPoints.add(p);
		
		return false;
	}
	
	
}


class Point2 {
	int row, col;	
	
	public Point2(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public String toString() {
		return "(" + row + ", " + col + ")";
	}
	
}




























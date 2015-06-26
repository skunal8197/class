//UIUC CS125 FALL 2012 MP. File: RecursiveKnight.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2012-11-09T13:47:46-0600.831004000
/**
 * 
 * @author lzhou8
 */
public class RecursiveKnight {

	/**
	 * This method recursively determines which 
	 * board positions the knight can reach in the
	 * next few moves.
	 * 
	 * Base cases: Return immediately if 
	 * 1) x or y are invalid
	 * i.e. visited[x][y] would cause IndexOutOfBounds exceptions.
	 * 
	 * or, 2) visited[x][y] is true and step is a positive integer
	 * i.e. The current coordinates do not represent a valid square that we can hop to.
	 * 
	 * or, 3) steps[x][y] already has a positive integer, which is less than the parameter value. 
	 * i.e. There is a shorter path to this point than the one we are considering.
	 *
	 *Recursive case:
	 *Update steps[x][y]
	 *Recursively call explore() using the eight possible knight moves
	 * {1,2},{-1,-2},{2,1} etc (Work it out!)
	 * 
	 * The recursive call will use a different step value
	 * because it will be evaluating the next move.
	 * 
	 * The 'visited' array is unchanged by this method:.
	 * Assume visited and steps are already initialized to a square array and are the same size.
	 */
	public static void explore(boolean[][] visited, int x, int y, int[][] steps, int step) {
        if (x >= visited.length || x < 0 || y >= visited[0].length || y < 0) return;
        
        if (visited[x][y] && step > 0) return;
        
        if (steps[x][y] > 0 && steps[x][y] <= step) return;
        
        else {  steps[x][y] = step;
                step = step + 1;
                explore(visited, x + 1, y + 2, steps, step);
                explore(visited, x + 2, y + 1, steps, step);
                explore(visited, x + 1, y - 2, steps, step);
                explore(visited, x + 2, y - 1, steps, step);
                explore(visited, x - 1, y + 2, steps, step);
                explore(visited, x - 1, y - 2, steps, step);
                explore(visited, x - 2, y - 1, steps, step);
                explore(visited, x - 2, y + 1, steps, step);

	//Todo: Implement RecursiveKnight.explore
		//throw new RuntimeException("Not yet Implemented!"); // you can remove this line!
}	}}

/*A program called Circle that displays a "circle" in the upper right quadrant 
of the Cartesian plane.
Takes input the radius, the x and y coordinates, and a symbol for which the circle
will be drawn in.
*/

public class Circle{

	/* 
	 * Method to see if the current point is on the circle (i.e to be drawn)
	 * rad = radius of circle
	 * a,b = the coordinates of the origin of the circle
	 * xg, yg = the coordinates where the forloops currently are in the grid*/
	public static boolean onCircle(int rad, int a, int b, int xg, int yg){
		int x = (int)(Math.pow(((double)xg-a),2) + Math.pow((double)(yg-b),2));
		if(Math.pow(rad,2) <= x && x <= (Math.pow(rad,2) + 1)){
			return true;      
		}
		return false;
	}
	
	/*Just the onCircle method but the gridheight adjusted b/c the top
	 of the grid starts at 0) */
	public static boolean circleAdj(int gridHeight, int i, int j, int x, int y, int rad) {
		int adjY = (gridHeight - i);
		if(onCircle(rad, x, y, j, adjY)) {
			return true;
		}
		return false;
	}

	//take as input the radius, and the x,y coordinates of the circle
	//Checks to see if the circle would be on the upper right quadrant
	public static void verifyInput(int rad, int x, int y){
		if(rad <=0 || rad > x || rad > y){
			throw new IllegalArgumentException ("The circle to not fit in the upper right quadrant");
		}
	}

	//takes as input radius of circle, and the coordinates of the centre of the circle
	//also takes in a symbol which the circle will be drawn with
	public static void drawCircle(int rad, int x, int y, char s){ 
		//height and length of the grid, starts at 10
		int gridHeight = 10;
		int gridLength = 10;

		//verify the circle is in the upper right quad
		verifyInput(rad, x, y);

		// Extend x-axis by the difference
		if((x + rad) > gridLength) {
			gridLength += (x + rad) - gridLength;
		}

		// Extend y-axis by the difference
		if((y + rad) > gridHeight) {
			gridHeight += (y + rad) - gridHeight;
		}

		//coordinates of x values
		for(int i = 0; i <= gridHeight; i++) {
			System.out.println();

			//coordinate of y values
			for(int j = 0; j <= gridLength; j++) {
				
				if(circleAdj(gridHeight, i, j, x, y, rad)) {
					if(i == gridHeight || j == 0) {
					}
					System.out.print(s);
				}
				// point (0,0)
				else if(i == gridHeight && j == 0) {
					System.out.print('+');
				} 
				//top of y axis
				else if (i == 0 && j == 0) {
					System.out.print('^');
				}

				//making the y axis bars
				else if(j == 0) {
					System.out.print("|");
				} 

				//when reaches the end put the triangle bracket
				else if(i == gridHeight && j == gridLength) {
					System.out.print('>');
				}

				//making the x axis bars
				else if (i == gridHeight) {
					System.out.print('-');
				} 



				else {
					System.out.print(" ");
				}
			}
		} 
	}




	public static void main(String[] args){
		drawCircle(5, 11,  12, '&');
	}
}


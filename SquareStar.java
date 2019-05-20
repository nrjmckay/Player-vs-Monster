
/**
 * @author Nolan
 *
 */
//Import Scanner for input
import java.util.Scanner;

// Print a square made with input n *'s
public class SquareStar {

	public static void main(String[] args){

		System.out.println("Enter a positive integer for the square size.");
		Scanner sc = new Scanner(System.in);
		if (!sc.hasNextInt()) {
			System.out.println("You did not enter an integer.");
		} else {
			int n = sc.nextInt(); 
			System.out.println("You enterd " + n);

			for(int i =0; i<n; i++) {
				for(int j =0; j<n; j++) {
					if(i==0 || i==n-1) {
						System.out.print("*");
					}else {
						if(j==0 || j==n-1) {
							System.out.print("*");
						}
						else {
							System.out.print(" ");
						}

					}
				}System.out.print("\n");

			}	
		}

		sc.close();
	}
}

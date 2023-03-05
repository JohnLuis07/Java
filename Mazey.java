import java.util.Scanner; 

public class Mazey{
	// checks if out of bounds
	static boolean isOutOfBounds(int input){
		if(input==-1){
			System.out.println("");
			System.out.println("Out of bounds! Please return to the safe zone!");
			return true;
		}
		else {
			return false;
		}
	}
	// checks if there's a wall
	static boolean wallBump(int input){
		if(input==0){
			System.out.println("");
			System.out.println("Oof! That's a wall. Find some other ways...");
			return true;
		}
		else {
			return false;
		}
	}
	// checks input
	static boolean isValid(String input){
		if(input.equalsIgnoreCase("right")){
			return true;
		}
		if(input.equalsIgnoreCase("left")){
			return true;
		}
		if(input.equalsIgnoreCase("up")){
			return true;			
		}
		if(input.equalsIgnoreCase("down")){
			return true;
			
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {

	// maze grid; -1 = out of bounds; 0 = wall; 1 = open lane; 2 = current position; 3 = final position; 
	int[][] maze = {{-1,  -1,-1,-1,-1,-1,-1,-1,  -1},

					{-1,   1, 0, 1, 1, 0, 0, 0,  -1},
					{-1,   2, 1, 0, 1, 0, 1, 1,  -1},
					{-1,   0, 1, 1, 1, 0, 1, 0,  -1},
					{-1,   0, 1, 0, 0, 1, 1, 1,  -1},
					{-1,   1, 1, 0, 1, 1, 0, 1,  -1},
					{-1,   0, 1, 1, 0, 1, 0, 3,  -1},
					{-1,   0, 0, 1, 1, 1, 0, 0,  -1},

					{-1,  -1,-1,-1,-1,-1,-1,-1,  -1}};
	
	//initial position coordinates					
	int x = 2;
	int y = 1;
	maze[x][y] = 2;

	//target position coordinates
	int destination_x = 6;
	int destination_y = 7;

	Scanner user_input = new Scanner(System.in);

	// run program until finding the target
	while(true){
		//print maze
		for(int[] i : maze){
			for(int j : i){
				if(j==0){
					System.out.print("@");
				}
				if(j==1){
					System.out.print(" ");
				}
				if(j==2){
					System.out.print("i");
				}
				if(j==3){
					System.out.print("x");
				}
			}
		System.out.println();
	}
		//user input
		System.out.print("Choose your destiny (up, down, left, right): ");
			String pos = user_input.nextLine();
		//check user inputs
		while(pos.isEmpty()){
			System.out.println("No input at all, try again.");
			System.out.println();
			System.out.print("Choose your destiny (up, down, left, right): ");
			pos = user_input.nextLine();
		}

		while(isValid(pos)==false){
			System.out.println("Wrong input, try again.");
			System.out.println();
			System.out.print("Choose your destiny (up, down, left, right): ");
			pos = user_input.nextLine();
		}
			//movement logic; check bounds, walls, and destination
			if(pos.equalsIgnoreCase("right")){

				if(isOutOfBounds(maze[x][y+1]) || wallBump(maze[x][y+1])){
					continue;
				}
				else{
					maze[x][y] = 1;
					maze[x][y+=1] = 2;

					if(x==destination_x && y==destination_y){
						break;
					}
				}
			}
			if(pos.equalsIgnoreCase("left")){

				if(isOutOfBounds(maze[x][y-1]) || wallBump(maze[x][y-1])){
					continue;
				}
				else{
					maze[x][y] = 1;
					maze[x][y-=1] = 2;

					if(x==destination_x && y==destination_y){
						break;
					}
				}
			}
			if(pos.equalsIgnoreCase("up")){
				
				if(isOutOfBounds(maze[x-1][y]) || wallBump(maze[x-1][y])){
					continue;
				}
				else{
					maze[x][y] = 1;
					maze[x-=1][y] = 2;

					if(x==destination_x && y==destination_y){
						break;
					}
				}
			}
			if(pos.equalsIgnoreCase("down")){
				if(isOutOfBounds(maze[x+1][y]) || wallBump(maze[x+1][y])){
					continue;
				}
				else{
					maze[x][y] = 1;
					maze[x+=1][y] = 2;

					if(x==destination_x && y==destination_y){
						break;
					}
				}
			}
		}
		// congratulatory message
		System.out.println("");
		System.out.println("You found the target! Congratulations!");
		for(int[] i : maze){
			for(int j : i){
				if(j==0){
					System.out.print("@");
				}
				if(j==1){
					System.out.print(" ");
				}
				if(j==2){
					System.out.print("i");
				}
				if(j==3){
					System.out.print("G");
				}
			}
		System.out.println();
	}
	}
}
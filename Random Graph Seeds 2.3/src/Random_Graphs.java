import java.util.Scanner;

public class Random_Graphs {

	public static void main(String[] args) {
		while (true) {
			// random numbers are defined here that will create random grids of graphs
			int random_number_1 = (int) (Math.random() * 8) + 1; // supposed to be inside of the for loop
			int random_number_2 = (int) (Math.random() * 8) + 1;

			// counter used for counting numbers
			int count_1 = 0;
			int count_2 = 0;

			// Foundation for the random graphs, it creates a random number of rows and
			// columns!
			int[][] rand_num = new int[random_number_1][random_number_2];

			// Converts random numbers into String that can be used in if statements
			String[][] int_to_string = new String[random_number_1][random_number_2];

			// Random numbers are generated and displayed here!
			for (int x = 0; x < rand_num.length; x++) { // random int numbers
				for (int y = 0; y < rand_num[x].length; y++) {
					int rand_numbers = (int) (Math.random() * 9);
					rand_num[x][y] = rand_numbers;
					System.out.print(rand_num[x][y] + " ");
				}
				System.out.println();
			}

			// Counter++ will add the number of items in the graph that contain "0"!
			System.out.println();
			for (int y = 0; y < rand_num.length; y++) {
				for (int z = 0; z < rand_num[y].length; z++) {
					String rand_num_text = Integer.toString(rand_num[y][z]);
					int_to_string[y][z] = rand_num_text;

					if (int_to_string[y][z].contentEquals("0")) {
						count_1++;
					}
				}
			}

			// Documents where "/" coordinates are located and store them!
			String[] store_location = new String[count_1]; // STORES WHERE "0" IS LOCATED!
			String[] seed = new String[count_1];
			for (int y = 0; y < rand_num.length; y++) {
				for (int z = 0; z < rand_num[y].length; z++) {

					if (int_to_string[y][z].contentEquals("0")) {
						store_location[count_2] = y + "," + z;
						seed[count_2] = y + "" + z;
						if (count_2 == count_1) {
							break;
						}

						count_2++;
					}
				}
				if (count_2 == count_1) {
					break;
				}
			}

			// Random String Graph will be converted into "/" or "_"
			for (int x = 0; x < rand_num.length; x++) { // random graphs
				for (int y1 = 0; y1 < rand_num[x].length; y1++) {

					if (int_to_string[x][y1].contentEquals("0")) {
						int_to_string[x][y1] = "/";

					} else {
						int_to_string[x][y1] = "_";
					}
					System.out.print(int_to_string[x][y1] + " ");
				}
				System.out.println();
			}

			// The "seed" for the random graph is displayed here in a readable fashion!
			System.out.println();
			System.out.print("Easy to read seed layout: " + "[" + random_number_1 + "x" + random_number_2 + "]" + " ");
			for (int j = 0; j < count_2; j++) {
				System.out.print("(" + store_location[j] + ") "); // index coordinates start at 0
			}

			// "Generates" (it is already generated) the seed for the random graph
			// displayed!
			System.out.println();
			System.out.print("Random Graph Seed: " + random_number_1 + random_number_2);
			for (int k = 0; k < count_2; k++) {
				System.out.print(seed[k]);
			}

			// If the user wants to restart the program
			Scanner restart = new Scanner(System.in);
			System.out.println();
			System.out.println("Do you want to restart the program? y/n");
			String restart_confirmation = restart.next();
			if (restart_confirmation.contentEquals("y")) {
				System.out.println("Restarting...");
			} else {
				System.out.println("Program Halted!"); // add a bit of flavor to this program!
				break;
			}
		}

	}
}

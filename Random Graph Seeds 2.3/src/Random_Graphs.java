import java.util.Scanner;

public class Random_Graphs {

	public static void main(String[] args) {
		Scanner settings = new Scanner(System.in);
		while (true) {
			// Counter when the user types "help"
			int assistant_help = 0;

			// Start menu
			System.out.print("Enter a command: ");
			String command = settings.next();

			if (command.contentEquals("generate")) {
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
				System.out.println();
				System.out.println("Random Numbers:");
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

				// Random String Graph will be converted into "/" or "_" and printed after that
				System.out.println("Random Graph:");
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
				System.out.print(
						"Easy to read seed layout: " + "[" + random_number_1 + "x" + random_number_2 + "]" + " ");
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

			} else if (command.contentEquals("read")) {
				// Asks the user to enter the "seed" for the Random Graph!
				System.out.print("Enter Random Graph Seed: ");
				Scanner input_seed = new Scanner(System.in);
				String get_seed = input_seed.next();

				// Rows and columns are stored here and the array is defined here!
				char row = get_seed.charAt(0);
				char column = get_seed.charAt(1);
				int row_1 = Integer.parseInt(String.valueOf(row));
				int column_1 = Integer.parseInt(String.valueOf(column));
				String[][] random_graph_input = new String[row_1][column_1];

				// Displays easy to read seed layout
				System.out.print("Easy to read seed layout: " + "[" + row_1 + "x" + column_1 + "] ");
				for (int i = 2; i < get_seed.length(); i += 2) {
					char coord21 = get_seed.charAt(i);
					char coord31 = get_seed.charAt(i + 1);
					System.out.print("(" + coord21 + "," + coord31 + ") ");
				}

				// Sets the default value of all array values to "_"!
				System.out.println();
				for (int i = 0; i < random_graph_input.length; i++) {
					for (int k = 0; k < random_graph_input[i].length; k++) {
						random_graph_input[i][k] = "_";
					}
				}

				// Locates "/" and stores the string at the given array coordinates!
				for (int i = 2; i < get_seed.length(); i += 2) {
					char coord2 = get_seed.charAt(i);
					char coord3 = get_seed.charAt(i + 1);
					int coord2_int = Integer.parseInt(String.valueOf(coord2));
					int coord3_int = Integer.parseInt(String.valueOf(coord3));

					random_graph_input[coord2_int][coord3_int] = "/";
				}

				// All graph coordinates are displayed here!
				System.out.println();
				System.out.println("Graph:");
				for (int i = 0; i < random_graph_input.length; i++) {
					for (int k = 0; k < random_graph_input[i].length; k++) {
						System.out.print(random_graph_input[i][k] + " ");
					}
					System.out.println();
				}
			} else if (command.contentEquals("help")) {
				char generate_and_read = '"';
				System.out.print("Type " + generate_and_read + "generate" + generate_and_read
						+ " to generate a random graph or type " + generate_and_read + "read" + generate_and_read
						+ " to input a given seed and output a graph for it!");
				assistant_help++;
			}

			// If the user wants to restart the program
			System.out.println();
			if (assistant_help == 0) {
				System.out.println("Do you want to restart the program? [y/n]");
			} else {
				System.out.println("Do you want to continue?");
			}

			String restart_confirmation = settings.next();
			if (restart_confirmation.contentEquals("y") && assistant_help == 0) {
				System.out.println("Restarting...");
			} else if (assistant_help > 0
					&& (restart_confirmation.contentEquals("yes") || restart_confirmation.contentEquals("yee"))) {
				System.out.println("OK. I hope you enjoy the gameplay...");
			} else {
				System.out.println("Program Halted!"); // add a bit of flavor to this program!
				break;
			}

		} // while loop ends here!

	}
}

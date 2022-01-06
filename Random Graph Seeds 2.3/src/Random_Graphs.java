/*
* Copyright (c) 2020, suncloudsmoon
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/

import java.util.Scanner;

public class Random_Graphs {

	public static void main(String[] args) throws InterruptedException {
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
			} else if (command.contentEquals("pathfinder")) {
				Scanner settings1 = new Scanner(System.in);

				while (true) {
					System.out.print("Enter a pathfinder command: ");
					String command1 = settings1.next();

					if (command1.contentEquals("walk")) {
						String[][] find_path = new String[6][50];

						for (int i = 0; i < find_path.length; i++) {
							for (int j = 0; j < find_path[i].length; j++) {
								find_path[i][j] = "_";
							}

						}
						String sleep = "";
						System.out.println("Generating...");
						System.out.print("|");
						for (int i = 0; i < 12; i++) {
							sleep = "=" + sleep; // sleep inside "=" will take the initial value!
							System.out.print(sleep);
							Thread.sleep(500);
						}
						System.out.print(">");

						int location_1 = (int) (Math.random() * 5);
						int location_2 = (int) (Math.random() * 49);
						int coord_row = location_1, coord_column = location_2;

						int counter = 0;

						System.out.println();
						String seed = "";
						String easy_to_read_seed = "[6x50] ";
						int random_stop = (int) (Math.random() * 20);

						while (true) {
							int pathfinder = (int) (Math.random() * 7);
							if (counter == 0) {
								find_path[coord_row][coord_column] = "/";
								if ((coord_row == 5) || (coord_column == 49)) {
									coord_row -= 2;
									coord_column -= 2;
								}

								seed = seed + Integer.toString(coord_row) + "~" + Integer.toString(coord_column) + "/";
								easy_to_read_seed = easy_to_read_seed + "(" + Integer.toString(coord_row) + ","
										+ Integer.toString(coord_column) + ") ";
							}

							if (pathfinder == 0) { // done
								coord_row = coord_row + 1;
								coord_column = coord_column;
								if ((coord_row > 5) || (coord_column > 49)) {
									coord_row -= 2;
									coord_column -= 2;
								}
								if ((coord_row < 0) || (coord_column < 0)) {
									coord_row++;
									coord_column++;
								} else if ((coord_row == 50) || (coord_column == 50)) {
									coord_row -= 2;
									coord_column -= 2;
								}

								seed = seed + Integer.toString(coord_row) + "~" + Integer.toString(coord_column) + "/";
								easy_to_read_seed = easy_to_read_seed + "(" + Integer.toString(coord_row) + ","
										+ Integer.toString(coord_column) + ") ";
								find_path[coord_row][coord_column] = "/";

							} else if (pathfinder == 1) { // done
								coord_row = coord_row + 1;

								coord_column = coord_column + 1;
								if ((coord_row > 5) || (coord_column > 49) && (counter > random_stop)) {
									break;
								} else if ((coord_row > 5) || (coord_column > 49)) {
									coord_row -= 2;
									coord_column -= 2;
								}
								if ((coord_row < 0) || (coord_column < 0)) {
									coord_row++;
									coord_column++;
								} else if ((coord_row == 50) || (coord_column == 50)) {
									coord_row -= 2;
									coord_column -= 2;
								}

								seed = seed + Integer.toString(coord_row) + "~" + Integer.toString(coord_column) + "/";
								easy_to_read_seed = easy_to_read_seed + "(" + Integer.toString(coord_row) + ","
										+ Integer.toString(coord_column) + ") ";
								find_path[coord_row][coord_column] = "/";

							} else if (pathfinder == 2) { // done
								coord_row = coord_row;

								coord_column = coord_column + 1;
								if ((coord_row > 5) || (coord_column > 49) && (counter > random_stop)) {
									break;
								} else if ((coord_row > 5) || (coord_column > 49)) {
									coord_row -= 2;
									coord_column -= 2;
								}
								if ((coord_row < 0) || (coord_column < 0)) {
									coord_row++;
									coord_column++;
								} else if ((coord_row == 50) || (coord_column == 50)) {
									coord_row -= 2;
									coord_column -= 2;
								}

								seed = seed + Integer.toString(coord_row) + "~" + Integer.toString(coord_column) + "/";
								easy_to_read_seed = easy_to_read_seed + "(" + Integer.toString(coord_row) + ","
										+ Integer.toString(coord_column) + ") ";
								find_path[coord_row][coord_column] = "/";

							} else if (pathfinder == 3) { // done
								coord_row = coord_row - 1;

								coord_column = coord_column + 1;
								if ((coord_row > 5) || (coord_column > 49) && (counter > random_stop)) {
									break;
								} else if ((coord_row > 5) || (coord_column > 49)) {
									coord_row -= 2;
									coord_column -= 2;
								}
								if ((coord_row < 0) || (coord_column < 0)) {
									coord_row++;
									coord_column++;
								} else if ((coord_row == 50) || (coord_column == 50)) {
									coord_row -= 2;
									coord_column -= 2;
								}

								seed = seed + Integer.toString(coord_row) + "~" + Integer.toString(coord_column) + "/";
								easy_to_read_seed = easy_to_read_seed + "(" + Integer.toString(coord_row) + ","
										+ Integer.toString(coord_column) + ") ";
								find_path[coord_row][coord_column] = "/";

							} else if (pathfinder == 4) { // done
								coord_row = coord_row - 1;

								coord_column = coord_column;
								if ((coord_row > 5) || (coord_column > 49) && (counter > random_stop)) {
									break;
								} else if ((coord_row > 5) || (coord_column > 49)) {
									coord_row -= 2;
									coord_column -= 2;
								}
								if ((coord_row < 0) || (coord_column < 0)) {
									coord_row++;
									coord_column++;
								} else if ((coord_row == 50) || (coord_column == 50)) {
									coord_row -= 2;
									coord_column -= 2;
								}

								seed = seed + Integer.toString(coord_row) + "~" + Integer.toString(coord_column) + "/";
								easy_to_read_seed = easy_to_read_seed + "(" + Integer.toString(coord_row) + ","
										+ Integer.toString(coord_column) + ") ";
								find_path[coord_row][coord_column] = "/";

							} else if (pathfinder == 5) { // done
								coord_row = coord_row - 1;

								coord_column = coord_column - 1;
								if ((coord_row > 5) || (coord_column > 49) && (counter > random_stop)) {
									break;
								} else if ((coord_row > 5) || (coord_column > 49)) {
									coord_row -= 2;
									coord_column -= 2;
								}
								if ((coord_row < 0) || (coord_column < 0)) {
									coord_row++;
									coord_column++;
								} else if ((coord_row == 50) || (coord_column == 50)) {
									coord_row -= 2;
									coord_column -= 2;
								}

								seed = seed + Integer.toString(coord_row) + "~" + Integer.toString(coord_column) + "/";
								easy_to_read_seed = easy_to_read_seed + "(" + Integer.toString(coord_row) + ","
										+ Integer.toString(coord_column) + ") ";
								find_path[coord_row][coord_column] = "/";

							} else if (pathfinder == 6) { // done
								coord_row = coord_row;

								coord_column = coord_column - 1;
								if ((coord_row > 5) || (coord_column > 49) && (counter > random_stop)) {
									break;
								} else if ((coord_row > 5) || (coord_column > 49)) {
									coord_row -= 2;
									coord_column -= 2;
								}
								if ((coord_row < 0) || (coord_column < 0)) {
									coord_row++;
									coord_column++;
								} else if ((coord_row == 50) || (coord_column == 50)) {
									coord_row -= 2;
									coord_column -= 2;
								}

								seed = seed + Integer.toString(coord_row) + "~" + Integer.toString(coord_column) + "/";
								easy_to_read_seed = easy_to_read_seed + "(" + Integer.toString(coord_row) + ","
										+ Integer.toString(coord_column) + ") ";
								find_path[coord_row][coord_column] = "/";

							} else if (pathfinder == 7) {
								coord_row = coord_row + 1;

								coord_column = coord_column - 1;
								if ((coord_row > 5) || (coord_column > 49) && (counter > random_stop)) {
									break;
								} else if ((coord_row > 5) || (coord_column > 49)) {
									coord_row -= 2;
									coord_column -= 2;
								}
								if ((coord_row < 0) || (coord_column < 0)) {
									coord_row++;
									coord_column++;
								} else if ((coord_row == 50) || (coord_column == 50)) {
									coord_row -= 2;
									coord_column -= 2;
								}

								seed = seed + Integer.toString(coord_row) + "~" + Integer.toString(coord_column) + "/";
								easy_to_read_seed = easy_to_read_seed + "(" + Integer.toString(coord_row) + ","
										+ Integer.toString(coord_column) + ") ";
								find_path[coord_row][coord_column] = "/";

							}

							counter++;

						}

						for (int i = 0; i < find_path.length; i++) {
							for (int j = 0; j < find_path[i].length; j++) {
								// find_path[i][j] = "_";
								System.out.print(find_path[i][j] + " ");
								// Thread.sleep(10);
							}
							System.out.println();

						}

						System.out.print("\nSeed: ");
						Thread.sleep(500);
						System.out.print(seed);
						System.out.print("\nEasy to read seed layout: ");
						Thread.sleep(500);
						System.out.print(easy_to_read_seed);

					} else if (command1.contentEquals("help")) {
						System.out.println("Type walk in order to generate / in the graph together!");
					}
					
					// Gives the option of going out of this program!
					Thread.sleep(3 * 1000);
					System.out.println();
					System.out.println("Do you want to go to restart this program or go to the main program ? [y/n]");
					String restart_confirmation = settings.next();
					if (restart_confirmation.contentEquals("y")) {
						System.out.println("Restarting...");
					} else {
						System.out.println("Program Halted!"); // add a bit of flavor to this program!
						break;
					}
				}
			} // pathfinder loop ends here!

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

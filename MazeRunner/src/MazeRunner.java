import java.util.Scanner;
import static java.lang.System.exit;
/*
For this project, you will be writing the code for "MazeRunner', a program that navigates through a given maze.
The code for the Maze is already written, and provided in "Maze.java". You just need to write the code the uses
Maze and decides how to move through it.
 */
        public class MazeRunner {

            public static void main(String[] args){
                Scanner input = new Scanner(System.in);

                //calling methods
                Maze myMaze = new Maze();
                introduction();
                myMaze.printMap();//prints the current state of the map

                int steps = 0;
                while (!myMaze.didIWin()) {
                    String action = userMove(input);
                    moves(myMaze, action, input);
                    steps++;
                    movesLimit(steps);
                }
                congratulations(steps);
            }

            public static void introduction(){
                System.out.println("Hello! Welcome to Maze Runner!");
                System.out.println("Here is your current position:");
            }

            public static String userMove(Scanner move){
                System.out.print("How would you like to move? (R)ight, (L)eft, (U)p or (D)own?");
                String action = move.next();
                action=action.toUpperCase();
                return action;
            }

            public static void moves(Maze myMaze, String action, Scanner jump){
                if (myMaze.isThereAPit(action)){
                    System.out.print("There is a pit do you want to jump? (Y)es or (N)o");
                    String choice = jump.next();
                    choice = choice.toUpperCase();
                    if (choice.equals("Y")){
                        myMaze.jumpOverPit(action);
                    }
                }
                if (action.equals("R")) {
                    if (myMaze.canIMoveRight()) {
                        myMaze.moveRight();
                    } else {
                        System.out.println("Sorry, you have hit a wall.");
                    }
                }else if (action.equals("L")) {
                    if (myMaze.canIMoveLeft()){
                        myMaze.moveLeft();
                    }else{
                        System.out.println("Sorry, you have hit a wall.");
                    }
                } else if (action.equals("U")) {
                    if (myMaze.canIMoveUp()) {
                        myMaze.moveUp();
                    } else {
                        System.out.println("Sorry, you have hit a wall.");
                    }
                } else if (action.equals("D")) {
                    if (myMaze.canIMoveDown()) {
                        myMaze.moveDown();
                    } else {
                        System.out.println("Sorry, you have hit a wall.");
                    }
                } else{
                    System.out.println("That is not a valid move. Try again.");
                }
                myMaze.printMap();//prints the current state of the map
            }

            public static void movesLimit(int steps){
                if (steps == 50){
                    System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes.");
                }
                if (steps==75){
                    System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
                }
                if (steps==90){
                    System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
                }
                if (steps==100){
                    System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                    exit(0);
                }
            }

            public static void congratulations(int steps){
                System.out.println("Congratulations! You have successfully completed the maze!");
                System.out.println("And you did it in "+steps+" moves.");
            }
        }
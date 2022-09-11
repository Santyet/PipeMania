package ui;
import model.MainGame;

/*
TO DO LIST
* agregar pipes donde se quiera y que se pueda editar cuando se quiera
* verificar la continuidad del flujo de agua
* verificar que la tuberia "o" funcione correctamente
* verificar que el camino esta bien conectado
* calculaar el score
* hacer arbol binario con scores
* hacer uml
*
 */

import java.util.Scanner;

public class Main {

    private Scanner sc;
    private MainGame game;

    public Main(){
        sc = new Scanner(System.in);
        game = new MainGame();
    }

    public static void main(String[] args) {

        Main m = new Main();
        MainGame game = new MainGame();


       /* game.insert(new Player("Santiago", 123));
        game.insert(new Player("Ana", 324));
        game.insert(new Player("pito", 123));
        game.insert(new Player("hola", 432));
        game.insert(new Player("juan\uD83D\uDC34", 1000000000));
        game.insert(new Player("pablo", 100));
        game.insert(new Player("pedro", 100));
        game.printScore();*/
//        game.genGame();
//
//        game.showBoard();
       /* game.placePipe(5, 3, "|| ");
        game.placePipe(5, 4, "o ");*/
//        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEee");
//        game.showBoard();
        int option = 0;
        boolean hasStarted=false;
        do{
            option = m.showMenu(hasStarted);
            hasStarted=m.executeOperation(option,hasStarted);
        }while(option!=0);

    }

    public int showMenu(boolean hasStarted) {
        int option=0;
        if(!hasStarted) {
            System.out.println(
                    ANSI_GREEN + "===========================\n" +
                            "||\t\tPIPE MANIA\t\t ||\n" +
                            "===========================\n" + ANSI_RESET +
                            "(1) To start a new game.\n" +
                            "(2) To check the scoreboard.\n" +
                            "(0) Exit game.\n");
        }else {
            System.out.println(
                    ANSI_GREEN + "===========================\n" +
                            "(1) To place a pipe.\n" +
                            "(2) To simulate.\n" +
                            "(3) To give up.\n");
        }
        option = Integer.parseInt(sc.nextLine());
        return option;
    }

    public boolean executeOperation(int operation, boolean hasStarted) {
        switch (operation) {
            case 1:
                if(!hasStarted){
                    System.out.println("Welcome to Pipe Mania, please enter your nickname.");
                    String name=sc.nextLine();
                    game.genGame(name);
                }else{
                    System.out.println("Type the row where you want to place the pipe.");
                    int row=sc.nextInt();
                    sc.nextLine();
                    if(row>8 || row<1){
                        System.out.println("Type a valid option.\nType the row where you want to place the pipe.");
                        row=sc.nextInt();
                        sc.nextLine();
                    }
                    System.out.println("Type the column where you want to place the pipe.");
                    int column=sc.nextInt();
                    sc.nextLine();
                    if(column>8 || column <1){
                        System.out.println("Type a valid option.\nType the column where you want to place the pipe.");
                        column = sc.nextInt();
                        sc.nextLine();
                    }
                    System.out.println("What kind of pipe you want to place: \n"+
                                        "(1) ||\n"+
                                        "(2) =\n"+
                                        "(3) o\n");
                    int choice=sc.nextInt();
                    sc.nextLine();
                    while(choice>3 || choice<1){
                        System.out.println("Type a valid option.\nWhat kind of pipe you want to place: \n"+
                                "(1) ||\n"+
                                "(2) =\n"+
                                "(3) o\n");
                        choice=sc.nextInt();
                        sc.nextLine();
                    };
                    String type = switch (choice) {
                        case 1 -> "||";
                        case 2 -> "=";
                        case 3 -> "o";
                        default -> "";
                    };
                    //game.placePipe(column, row, "||");
                    game.placePipe(column, row, "||");
                }
                return true;
            case 2:
                if(!hasStarted){
                    System.out.println("Le muestra los puntajes");
                    return false;
                }else {
                    System.out.println("Simula");
                    return true;
                }
            case 3:
                return false;
            case 0:
                System.out.println("Bye!");
                break;

            default:
                System.out.println("Please type a valid option.\n");
                break;
        }
        return false;
    }

    public int showSecondMenu() {

        Long start = game.timer();
        Long stop;
        int option = 0;

        System.out.println("(1) To place a pipe.\n" +
                "(2) To simulate.\n" +
                "(3) To exit.\n");

        option = Integer.parseInt(sc.nextLine());

        //cuando la simulacion este correcta, hacer un if que permita cambiar el valor de "option" a 3 para acabar el loop
        //ademas, cuando la simulacion este correcta, se ejecutara el metodo timer para saber el momento en el que el juego acabo
        return option;
    }

    public boolean executeSecondOperation(int operation) {

        switch (operation) {

            case 1:

                break;

            case 2:
                    //acordarse de que esto devuelva el boolean que permita acabar el loop
                break;

            case 3:
                System.out.println("Bye!");
                break;

            default:
                System.out.println("Please type a valid option.\n");
                break;
        }

        return true;
    }

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String	BACKGROUND_WHITE	= "\u001B[47m";
    public static final String	BACKGROUND_CYAN		= "\u001B[46m";
    public static final String	BLINK				= "\u001B[5m";

}

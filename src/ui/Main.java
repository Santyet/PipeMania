package ui;
import Model.MainGame;
import Model.Node;
import Model.Player;

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
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String	BACKGROUND_WHITE	= "\u001B[47m";
    public static final String	BACKGROUND_CYAN		= "\u001B[46m";
    public static final String	BLINK				= "\u001B[5m";


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
        do{
            option = m.showMenu();
            m.executeOperation(option);
        }while(option!=3);

    }

    public int showMenu() {

        int option=0;

        System.out.println(
                ANSI_GREEN + "===========================\n" +
                        "||\t\tPIPE MANIA\t\t ||\n" +
                        "===========================\n" + ANSI_RESET +
                        "(1) To start a new game.\n" +
                        "(2) To check the scoreboard.\n" +
                        "(3) To exit.\n");
        option= Integer.parseInt(sc.nextLine());
        return option;
    }

    public void executeOperation(int operation) {

        switch (operation) {

            case 1:

                break;

            case 2:

                break;

            case 3:

                System.out.println("Bye!");
                break;

            default:
                System.out.println("Please type a valid option.\n");
                break;
        }
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


}

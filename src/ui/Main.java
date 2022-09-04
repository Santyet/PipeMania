package ui;
import Model.MainGame;
import Model.Node;

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
    }

    public static void main(String[] args) {

        Main m = new Main();
        MainGame game = new MainGame();

        //game.genGame();

        //game.addLast(new Node(5, 3, "a "));
        game.showBoard();



        int option = 0;
        do{
            //option = m.showMenu();
            //m.executeOperation(option);
        }while(option!=3);

    }

    public int showMenu() {

        int option=0;

        System.out.println(
                "***************************\n" +
                        "PIPE MANIA\n" +
                        "***************************\n" +
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
}


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
        game.placePipe(5, 4, "||");
        game.placePipe(5, 3, "o");
        game.placePipe(5, 2, "||");
        game.placePipe(5, 1, "o");
        game.placePipe(4, 1, "=");
        game.placePipe(2,5,"||");
        game.placePipe(4, 3, "=");
        game.placePipe(3, 3, "o");
        game.placePipe(2, 3, "=");
        game.placePipe(3, 2, "||");

        int option = 0;
        boolean isStarted=false;
        do{
            //option = m.showMenu(isStarted);
            //m.executeOperation(option,isStarted);
        }while(option!=0);

    }

    public int showMenu(boolean isStarted) {

        int option=0;
        if(!isStarted) {
            System.out.println(
                    "***************************\n" +
                            "PIPE MANIA\n" +
                            "***************************\n" +
                            "(0) To exit.\n"+
                            "(1) To start a new game.\n" +
                            "(2) To check the scoreboard.\n");
            option = Integer.parseInt(sc.nextLine());
        }else{
            System.out.println(
                    "***************************\n" +
                            "PIPE MANIA\n" +
                            "***************************\n" +
                            "(0) To exit.\n"+
                            "(1) To place pipe.\n" +
                            "(2) To check the scoreboard.\n"+
                            "(3) To simulate.\n");
            option = Integer.parseInt(sc.nextLine());
        }
        return option;
    }

    public void executeOperation(int operation,boolean isStarted) {

        switch (operation) {

            case 1:
                if(!isStarted){
                    //game.genGame();
                }else{
                    game.placePipe(1, 1, "a ");
                    game.showBoard();

                }
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
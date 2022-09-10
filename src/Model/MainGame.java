package Model;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainGame {

    private Node head;
    private Node tail;
    private String[][] board;
    private ScoreBoard scoreBoard;

    public MainGame() {
        scoreBoard = new ScoreBoard();
        head = new Node(5, 5, "V");
        tail = new Node(2, 6, "D");
        board = new String[8][8];
        head.setNext(tail);
    }


    public void genGame() {
        Random value = new Random();
        int r1 = value.nextInt(7 + 1) + 1;
        int c1 = value.nextInt(7 + 1) + 1;
        head.setRow(4);
        head.setColumn(3);
        int r2;
        int c2;
        do {
            r2 = value.nextInt(7 + 1) + 1;
            c2 = value.nextInt(7 + 1) + 1;
        } while (r2 == r1 && c2 == c1);
        tail.setRow(7);
        tail.setColumn(8);
    }

    public void showBoard() {
        fillBoard(head);
        fillBoard();
    }

    private void fillBoard(Node current) {
        if (current.getNext() == null) {
            board[tail.getRow() - 1][tail.getColumn() - 1] = tail.getType();
            return;
        }
        board[current.getRow() - 1][current.getColumn() - 1] = current.getType();
        fillBoard(current.getNext());
    }

    private void fillBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print("X\t");
                } else {
                    System.out.print(board[i][j] + "\t");
                }
            }
            System.out.print("\n");
        }
    }

    public void placePipe(int column, int row, String type) {
        Node node = new Node(column, row, type);
        addPipe(node, head);
        showBoard();
    }

    public void addPipe(Node node, Node current) {
        if (current.getNext().getNext() == null) {
            if (canitBeAdded(node, current)) {
                current.setNext(node);
                node.setPrev(current);
                node.setNext(tail);
                return;
            } else {
                return;
            }
        }
        addPipe(node, current.getNext());
    }

    public boolean canitBeAdded(Node node, Node current) {

        boolean out = true;

        String cuType = current.getType(), noType = node.getType();

        int cuRow = current.getRow(), cuColu = current.getColumn(), noRow = node.getRow(), noColu = node.getColumn();

        System.out.println(noColu + " " + cuColu + " " + cuRow + " " + noRow);
        //En caso que se salga del rango de movimiento
        if (noRow > cuRow + 1 || noRow < cuRow - 1 || noColu > cuColu + 1 || noColu < cuColu - 1) {
            System.out.println("1");
            return false;
        }
        //En caso que se pongan tipos de tuberias incompatibles
        if (noType.equals("=") && cuType.equals("||") || noType.equals("||") && cuType.equals("=") || noType.equals("o") && cuType.equals("o")) {
            System.out.println("2");
            return false;
        }
        //En caso que se quiera reemplazar tuberias en esta opcion (Vaya a la otra xd)
        if (noRow == cuRow && cuColu == noColu) {
            System.out.println("3");
            return false;
        }
        //En caso que vaya a haber cambior de fila (verticalmente) y se intente conectar tuberias que verticalmente no van
        if ((noRow - cuRow != 0) && (cuType.equals("=") && noType.equals("o") || cuType.equals("o") && noType.equals("=") || cuType.equals("=") && noType.equals("="))) {
            System.out.println("4");
            return false;
        }
        //En caso que vaya a haber cambior de columna (horizontalmente) y se intente conectar tuberias que horizontalmente no van
        if ((noColu - cuColu != 0) && (cuType.equals("||") && noType.equals("o") || cuType.equals("o") && noType.equals("||") || cuType.equals("||") && noType.equals("||"))) {
            System.out.println("5");
            return false;
        }
        //Si se va a iniciar con tuberias en cierta posicion que lo hace inaccesible
        if (cuType.equals("V") && (noType.equals("=") && noRow - cuRow != 0 || noType.equals("||") && noColu - cuColu != 0 || noType.equals("o"))) {
            System.out.println("6");
            return false;
        }
        //En caso que puso la tuberia de cambiar direccion pero no cambio la direccion xd
        if (cuType.equals("o") && noType.equals("||") && current.getPrev().getType().equals("||") || cuType.equals("o") && noType.equals("=") && current.getPrev().getType().equals("=")) {
            System.out.println("7");
            return false;
        }
        return out;
    }


    public void printScore() {
        scoreBoard.setCount(1);
        System.out.println(" Jugador      Puntos");
        scoreBoard.printScore(scoreBoard.getRoot(), 1);
    }

    public void insert(Player current) {

        if (scoreBoard.getRoot() == null) {
            scoreBoard.setRoot(current);
        } else {
            scoreBoard.insert(current, scoreBoard.getRoot());
        }
    }

    public Long timer() {

        Date secs = Calendar.getInstance().getTime();

        return secs.getTime();
    }

    public int calcScore(int usedPipes, Long start, Long stop) {

        int startI = convertLongToInt(start);
        int stopI = convertLongToInt(stop);

        System.out.println(startI + "\n" + stopI);

        System.out.println(stopI-startI);

        return usedPipes * 100 - (60 - (stopI-startI)) * 10;

    }

    private int convertLongToInt(Long time){

        String timeS = time + "";
        String process = "";

        char[] startA = timeS.toCharArray();

        for(int i = 5; i<=9; i++){
            process = process + startA[i] + "";
        }

        return Integer.parseInt(process);
    }

}
package Model;

import java.util.Random;

import ui.Main;

public class MainGame {

    private Node head;
    private Node tail;
    private String[][] board;

    public MainGame() {

        head = new Node(5, 5, "V");
        tail = new Node(2, 6, "D");
        Node temp = new Node(5,4,"||");
        board = new String[8][8];
        head.setNext(temp);
        temp.setNext(tail);

        System.out.println(head.getNext().getNext().getColumn() + " " +head.getNext().getNext().getRow() );
        //tail.setPrev(head);
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
    public void showBoard(){
        fillBoard(head);
        fillBoard();
    }
    private void fillBoard(Node current){
        if(current.getNext()==null){
            board[tail.getRow()-1][tail.getColumn()-1]= tail.getType();
            return;
        }
        board[current.getRow()-1][current.getColumn()-1]= current.getType();
        fillBoard(current.getNext());
    }
    private void fillBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j]==null){
                    System.out.print("X\t");
                } else{
                    System.out.print(board[i][j]+"\t");
                }
            }
            System.out.print("\n");
        }
    }
    public void placePipe(int column, int row, String type){
        Node node = new Node();
        addLast(node);
    }

    public void addLast (Node node){
        if(current.getNext()==null){
            board[tail.getRow()-1][tail.getColumn()-1]= tail.getType();
            return;
        }
        board[current.getRow()-1][current.getColumn()-1]= current.getType();
        fillBoard(current.getNext());
        Node temp = tail;
        tail.getPrev().setNext(node);
        node.setNext(temp);
        tail = temp;
        tail.setPrev(node);
    }
}

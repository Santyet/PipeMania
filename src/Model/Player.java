package Model;

import java.util.ArrayList;

public class Player {

    private String name;
    public ArrayList<String> names;
    private int score;
    private Player left;
    private Player right;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        names = new ArrayList<String>();
    }

    public ArrayList<String> getNames() {
        return this.names;
    }

    public void addArray(String value){
        names.add(value);
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player getLeft() {
        return left;
    }

    public void setLeft(Player left) {
        this.left = left;
    }

    public Player getRight() {
        return right;
    }

    public void setRight(Player right) {
        this.right = right;
    }

    public void add(String name){
            names.add(name);

    }

    public boolean empty(){
        return name.isEmpty();
    }

    public int print(int count){

            for(int i = 0; i < names.size(); i++){
                System.out.println((count)+". "+names.get(i)+"      "+this.score);
                count++;
            }
            return count;
    }
}

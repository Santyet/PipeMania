package model;

public class ScoreBoard {

    private Player root;
    private int count = 1;

    public ScoreBoard() {

    }

    public void insert(Player player, Player current) {

        if (player.getScore() == current.getScore()) {
            //si es igual, en este caso lo guardamos en el arraylist de nombres del nodo con el mismo score
            current.addArray(player.getName());

        }
        if (player.getScore() < current.getScore()) {
            //izauierda
            if (current.getLeft() != null) {
                insert(player, current.getLeft());
            } else {
                current.setLeft(player);
            }
        } else if (player.getScore() > current.getScore()) {
            //derecha
            if (current.getRight() != null) {
                insert(player, current.getRight());
            } else {
                current.setRight(player);
            }
        }
    }


    public void printScore(Player current, int n) {

        if (current == null) {
            return;
        }
        printScore(current.getRight(), n);
        System.out.println((count++) + ". " + current.getName() + "\t\t" + current.getScore());
        if (!current.empty()) {

            count = current.print(count);
        }

        n++;

        printScore(current.getLeft(), n);

    }

    public Player getRoot() {
        return root;
    }

    public void setRoot(Player root) {
        this.root = root;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

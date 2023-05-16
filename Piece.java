import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Piece {
    private int[][] coords;
    private int[][] originalCoords;
    private final int[] startCoords = { 6, 1 };
    private Square[] squares = new Square[4];
    private Pane pane;
    private Color color;
    private int type;

    public Piece(Pane pane) {
        this.pane = pane;
        int random = (int) (Math.random() * 7);
        this.type = random;
        switch (random) {
            case 0:
                this.coords = new int[][] { { -1, 0 }, { 0, 0 }, { 1, 0 }, { 2, 0 } };
                this.originalCoords = new int[][] { { -1, 0 }, { 0, 0 }, { 1, 0 }, { 2, 0 } };
                this.color = Color.AQUA;
                break;
            case 1:
                this.coords = new int[][] { { 0, -1 }, { 0, 0 }, { 1, 0 }, { 0, 1 } };
                this.originalCoords = new int[][] { { 0, -1 }, { 0, 0 }, { 1, 0 }, { 0, 1 } };
                this.color = Color.PURPLE;
                break;
            case 2:
                this.coords = new int[][] { { -1, 0 }, { 0, 0 }, { 1, 0 }, { 1, 1 } };
                this.originalCoords = new int[][] { { -1, 0 }, { 0, 0 }, { 1, 0 }, { 1, 1 } };
                this.color = Color.ORANGE;
                break;
            case 3:
                this.coords = new int[][] { { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 } };
                this.originalCoords = new int[][] { { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 } };
                this.color = Color.PINK;
                break;
            case 4:
                this.coords = new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
                this.originalCoords = new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
                this.color = Color.YELLOW;
                break;
            case 5:
                this.coords = new int[][] { { 1, -1 }, { 1, 0 }, { 0, 0 }, { 0, 1 } };
                this.originalCoords = new int[][] { { 1, -1 }, { 1, 0 }, { 0, 0 }, { 0, 1 } };
                this.color = Color.RED;
                break;
            case 6:
                this.coords = new int[][] { { 0, -1 }, { 0, 0 }, { 1, 0 }, { 1, 1 } };
                this.originalCoords = new int[][] { { 0, -1 }, { 0, 0 }, { 1, 0 }, { 1, 1 } };
                this.color = Color.GREEN;
                break;
        }
        this.addToPane();
    }

    public void addToPane() {
        for (int i = 0; i < this.coords.length; i++) {
            int[] duple = this.coords[i];
            Square newSquare = new Square(startCoords[0] + duple[1], startCoords[1] + duple[0]);
            newSquare.setColor(this.color);
            this.squares[i] = newSquare;
            this.pane.getChildren().addAll(newSquare.getShape());
        }
    }

    public void removeFromPane() {
        this.pane.getChildren().removeAll(this.squares[0].getShape(), this.squares[1].getShape(),
                this.squares[2].getShape(), this.squares[3].getShape());
    }

    public void moveDown() {
        this.removeFromPane();
        for (int i = 0; i < 4; i++) {
            this.coords[i][0]++;
        }
        this.addToPane();
    }

    public void moveRight() {
        this.removeFromPane();
        for (int i = 0; i < 4; i++) {
            this.coords[i][1]++;
        }
        this.addToPane();
    }

    public void moveLeft() {
        this.removeFromPane();
        for (int i = 0; i < 4; i++) {
            this.coords[i][1]--;
        }
        this.addToPane();
    }

    public int[][] getCoords() {
        return this.coords;
    }

    public void rotate(int x, int y) {
        this.removeFromPane();
        for (int[] coord : this.originalCoords) {
            int temp = coord[0];
            coord[0] = -1 * coord[1];
            coord[1] = temp;
        }
        for (int i = 0; i < this.coords.length; i++) {
            int[] coord = this.coords[i];
            coord[0] = this.originalCoords[i][0] + y;
            coord[1] = this.originalCoords[i][1] + x;
        }
        this.addToPane();
    }

    public int[][] getOriginalCoords() {
        return this.originalCoords;
    }

    public Color getColor() {
        return this.color;
    }
}

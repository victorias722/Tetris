import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Square {
	private Rectangle _rect;
    private Rectangle shape;
	
	public Square(double x, double y) {
        this.x = x;
        this.y = y;
        this.shape = new Rectangle(Constants.SQUARE_WIDTH, Constants.SQUARE_WIDTH,
                x < 1 || x > 12 || y < 1 || y > 24 ? Color.LIGHTCYAN : Color.BLACK);
        this.shape.setX(x * Constants.SQUARE_WIDTH);
        this.shape.setY(y * Constants.SQUARE_WIDTH);
        this.shape.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
    }
	
	public void setXLocation(double x){
		_rect.setX(x*Constants.SQUARE_WIDTH);
	}
	public void setYLocation(double y){
		_rect.setY(y*Constants.SQUARE_WIDTH);
	}
	public double getXLocation(){
		return _rect.getX()/Constants.SQUARE_WIDTH;
	}
	public double getYLocation(){
		return _rect.getY()/Constants.SQUARE_WIDTH;
		
	}
	public Node getNode(){
		return _rect;
	}
    public Rectangle getShape() {
        return this.shape;
    }
	public void setColor(Color color){
		_rect.setFill(color);                                                                                                         
	}
	public Paint getColor(){
		return _rect.getFill();
	}
}	

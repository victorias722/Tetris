import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Square {
	private Rectangle _rect;
	
	public Square(){
		_rect = new Rectangle(Constants.SQUARE_WIDTH,Constants.SQUARE_WIDTH);
		_rect.setStroke(Color.BLACK);
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
	public void setColor(Color color){
		_rect.setFill(color);                                                                                                         
	}
	public Paint getColor(){
		return _rect.getFill();
	}
}	

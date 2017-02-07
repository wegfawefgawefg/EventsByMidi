import java.awt.*;
import javax.swing.*;

public class CustomPanel extends JPanel
{
	Color color;
	boolean message = false;

	public CustomPanel()
	{
		super();
		randomizeColor();
	}

	//	a JPanel has a paintComponent method that gets called all the time
	//	you have to overload it with your own
	public void paintComponent( Graphics graphics )
	{
		Graphics2D g2d = ( Graphics2D ) graphics;

		//g2d.fillRect( 0, 0, this.getWidth(), this.getHeight() );

		Color colorOne = randomizeColor();
		Color colorTwo = randomizeColor();

		int randomX1 = (int) ( Math.random() * this.getWidth() 	);
		int randomY1 = (int) ( Math.random() * this.getHeight() 	);
		int randomX2 = (int) ( Math.random() * this.getWidth()	);
		int randomY2 = (int) ( Math.random() * this.getHeight() 	);

		GradientPaint gradient = new GradientPaint( randomX1, randomY1, colorOne, randomX2, randomY2, colorTwo );
		g2d.setPaint( gradient );
		//graphics.setColor( colorOne );

		randomX1 = (int) ( Math.random() * this.getWidth() 	);
		randomY1 = (int) ( Math.random() * this.getHeight() 	);
		randomX2 = (int) ( Math.random() * this.getWidth()	);
		randomY2 = (int) ( Math.random() * this.getHeight() 	);

		g2d.fillRect( randomX1, randomY1, randomX2, randomY2 );
	}

	public Color randomizeColor()
	{
		int r = (int) ( Math.random() * 255 );
		int g = (int) ( Math.random() * 255 );
		int b = (int) ( Math.random() * 255 );

		color = new Color( r, g, b );
		return color;
	}

}
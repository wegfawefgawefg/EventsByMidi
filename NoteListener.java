import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.*;


public class NoteListener implements ControllerEventListener
{
	JFrame frame;
	//JButton button;
	CustomPanel customPanel;

	public void controlChange( ShortMessage event )
	{
		customPanel.repaint();
		//customPanel.paintComponent( frame.getGraphics() );
	}

	/*
	public void setButton( JButton inButton )
	{
		button = inButton;
	}
	*/

	public void setCustomPanel( CustomPanel inCustomPanel )
	{
		customPanel = inCustomPanel;
	}

	public void setFrame( JFrame inFrame )
	{
		frame = inFrame;
	}

}
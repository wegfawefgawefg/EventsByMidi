import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiDemo
{
	public static final int FRAME_WIDTH = 400;
	public static final int FRAME_HEIGHT = 300;

	JFrame frame;
	CustomPanel customPanel;
	EventsByMidi eventsByMidi;
	NoteListener noteListener;
	//JButton button;

	public static void main( String[] args )
	{
		GuiDemo guiDemo = new GuiDemo();
		guiDemo.prepListeners();
		guiDemo.prepGUI();
		guiDemo.prepMusic();
		guiDemo.eventsByMidi.play();
	}

	public void prepGUI()
	{
		//	make a frame
		frame = new JFrame();

		//	make a CustomPanel and add it to the JFrame
		customPanel = new CustomPanel();

		//	make a new button
		//JButton button = new JButton( "[ dummy button ]" );

		//	connect the transmitters and the appropriate listener
		//button.addActionListener( noteListener );

		//	give the listener access references
		//noteListener.setButton( button );
		noteListener.setCustomPanel( customPanel );
		noteListener.setFrame( frame );

		//	add the shit to the frame
		//frame.getContentPane().add( BorderLayout.SOUTH, button );
		frame.getContentPane().add( BorderLayout.CENTER, customPanel );

		//	set the frame size
		frame.setSize( GuiDemo.FRAME_WIDTH, GuiDemo.FRAME_HEIGHT );

		frame.setBounds( 20, 20, GuiDemo.FRAME_WIDTH-20, GuiDemo.FRAME_HEIGHT-20 );

		//	make the frame close the java program when it is closed
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		//	make the frame visible
		frame.setVisible( true );

	}

	public void prepMusic()
	{
		//	make a midi event and music player		
		eventsByMidi = new EventsByMidi();

		//	connect the transmitters and the appropriate listener
		eventsByMidi.setNoteListener( noteListener );
	}

	public void prepListeners()
	{
		noteListener = new NoteListener();
	}

}
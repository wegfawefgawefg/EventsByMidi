import javax.sound.midi.*;

public class EventsByMidi
{
	public static final int NOTE_ON = 144;
	public static final int NOTE_OFF = 128;
	public static final int EVENT = 176;
	public static final int CHANGE_INSTRUMENT = 192;
	public static final int INSTRUMENT = 42;

	NoteListener noteListener;

	public void play()
	{
		try
		{
			Sequencer player = MidiSystem.getSequencer();

			player.setTempoInBPM( 1.0f * 60.0f );

			player.open();

			//	you pass in an array of the #type of the kind of events you want
			int[] eventsTypeList = { 127 };
			player.addControllerEventListener( noteListener, eventsTypeList );

			Sequence sequence = new Sequence( Sequence.PPQ, 4 );
			Track track = sequence.createTrack();

			MidiEvent event = null;
			
			//	set instrument first
			MidiEvent changeInstrument = createMidiEvent( CHANGE_INSTRUMENT, 1, INSTRUMENT, 0, 0 );
			track.add( changeInstrument );

			int start = 0;
			int finish = start + 1;
			//	line some notes up to play

			for( int skipSize = 1; skipSize < 109; skipSize++ )
			{
				for( int i = 10; i < 120; i+=skipSize )
				{
					int note = i;
					//	add note on
					MidiEvent noteOn = createMidiEvent( NOTE_ON, 1, note, 100, start );
					track.add( noteOn );

					//
					//	add trackable event at note NOTE_ON
					MidiEvent eventTrigger = createMidiEvent( EVENT, 2, 127, 0, start );
					track.add( eventTrigger );

					//	add note off
					MidiEvent noteOff = createMidiEvent( NOTE_OFF, 1, note, 100, finish );
					track.add( noteOff );

					start++;
					finish = start + 1;
				}
			}

			player.setSequence( sequence );

			player.start();
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}

	public void controlChange( ShortMessage event )
	{
		System.out.println( "REE" );
	}

	public static MidiEvent createMidiEvent(	int commandType, 
												int channel,
												int one,
												int two,
												int tick		)
	{
		MidiEvent midiEvent = null;
		try
		{
			ShortMessage message = new ShortMessage();
			message.setMessage( commandType, channel, one, two );
			midiEvent = new MidiEvent( message, tick );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			return midiEvent;
		}
	}

	public void setNoteListener( NoteListener inNoteListener )
	{
		noteListener = inNoteListener;
	}


}
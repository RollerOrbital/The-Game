package robD;

import java.io.*;
import javax.sound.sampled.*;

public class Sound
{
    public Sound()
    {

        new Thread(play).start();
    }

    static File sound = new File("C:\\Users\\Rob\\Intelij\\The-Game\\src\\robD\\mission impossible.wav");
    static boolean muted = false; // This should explain itself
    static float volume = 100.0f; // This is the volume that goes from 0 to 100
    static float pan = 0.0f; // The balance between the speakers 0 is both sides and it goes from -1 to 1

    static double seconds = 0.0d; // The amount of seconds to wait before the sound starts playing

    static boolean looped_forever = false; // It will keep looping forever if this is true

    static int loop_times = 0; // Set the amount of extra times you want the sound to loop (you don't need to have looped_forever set to true)
    static int loops_done = 0; // When the program is running this is counting the times the sound has looped so it knows when to stop

    final static Runnable play = new Runnable() // This Thread/Runnabe is for playing the sound
    {
        public void run()
        {
            try
            {
                if (sound.getName().toLowerCase().contains(".wav"))
                {
                    AudioInputStream stream = AudioSystem.getAudioInputStream(sound);

                    AudioFormat format = stream.getFormat();

                    if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED)
                    {
                        format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                                format.getSampleRate(),
                                format.getSampleSizeInBits() * 2,
                                format.getChannels(),
                                format.getFrameSize() * 2,
                                format.getFrameRate(),
                                true);

                        stream = AudioSystem.getAudioInputStream(format, stream);
                    }

                    SourceDataLine.Info info = new DataLine.Info(
                            SourceDataLine.class,
                            stream.getFormat(),
                            (int) (stream.getFrameLength() * format.getFrameSize()));

                    SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                    line.open(stream.getFormat());
                    line.start();

                    // Set Volume
                    FloatControl volume_control = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
                    volume_control.setValue((float) (Math.log(volume / 100.0f) / Math.log(10.0f) * 20.0f));

                    // Mute
                    BooleanControl mute_control = (BooleanControl) line.getControl(BooleanControl.Type.MUTE);
                    mute_control.setValue(muted);

                    long last_update = System.currentTimeMillis();
                    double since_last_update = (System.currentTimeMillis() - last_update) / 1000.0d;

                    // Wait the amount of seconds set before continuing
                    while (since_last_update < seconds)
                    {
                        since_last_update = (System.currentTimeMillis() - last_update) / 1000.0d;
                    }

                    int num_read = 0;
                    byte[] buf = new byte[line.getBufferSize()];

                    while ((num_read = stream.read(buf, 0, buf.length)) >= 0)
                    {
                        int offset = 0;

                        while (offset < num_read)
                        {
                            offset += line.write(buf, offset, num_read - offset);
                        }
                    }

                    line.drain();
                    line.stop();

                    if (looped_forever)
                    {
                        new Thread(play).start();
                    }
                    else if (loops_done < loop_times)
                    {
                        loops_done++;
                        new Thread(play).start();
                    }
                }
            }
            catch (Exception ex) { ex.printStackTrace(); }
        }
    };
}

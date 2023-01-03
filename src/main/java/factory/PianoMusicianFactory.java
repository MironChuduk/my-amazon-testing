package factory;

public class PianoMusicianFactory implements MusicianFactory {
    @Override
    public Musician createMusician() {
        return new PianoMusician();
    }
}

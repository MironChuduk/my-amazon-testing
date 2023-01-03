package factory;

public class GuitarMusicianFactory implements MusicianFactory {
    @Override
    public Musician createMusician() {
        return new GuitarMusician();
    }
}

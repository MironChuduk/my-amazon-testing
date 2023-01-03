import decorator.Developer;
import decorator.JavaDeveloper;
import decorator.SeniorJavaDeveloper;
import decorator.TeemLeadJavaDeveloper;
import factory.GuitarMusicianFactory;
import factory.Musician;
import factory.MusicianFactory;
import factory.PianoMusicianFactory;
import strategy.Coding;
import strategy.Person;
import strategy.Reading;

public class Main {
    public static void main(String[] args) {
        // Strategy pattern
        System.out.println("STRATEGY:");
        Person person = new Person();

        person.setActivity(new Coding());
        person.executeActivity();

        person.setActivity(new Reading());
        person.executeActivity();
        System.out.println("\n\n");

        // Decorator pattern
        System.out.println("DECORATOR:");
        Developer developer = new TeemLeadJavaDeveloper(new SeniorJavaDeveloper(new JavaDeveloper()));

        System.out.println(developer.doWork());
        System.out.println("\n\n");

        //Factory pattern
        System.out.println("FACTORY:");
        MusicianFactory musicianFactory = createMusicianBySpeciality("Piano");
        Musician musician = musicianFactory.createMusician();
        musician.playMusic();

        musicianFactory = createMusicianBySpeciality("Guitar");
        musician = musicianFactory.createMusician();
        musician.playMusic();
    }

    static MusicianFactory createMusicianBySpeciality(String speciality) {
        if (speciality.equalsIgnoreCase("piano")) {
            return new PianoMusicianFactory();
        } else if (speciality.equalsIgnoreCase("guitar")) {
            return new GuitarMusicianFactory();
        } else {
            throw new RuntimeException(speciality + " is unknown speciality!");
        }
    }
}

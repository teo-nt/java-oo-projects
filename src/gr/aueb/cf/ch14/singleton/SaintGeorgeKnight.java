package gr.aueb.cf.ch14.singleton;

/**
 * Defines a Singleton {@link SaintGeorgeKnight} class.
 */
public class SaintGeorgeKnight {
    private static final SaintGeorgeKnight INSTANCE = new SaintGeorgeKnight();

    private SaintGeorgeKnight() {

    }

    public static SaintGeorgeKnight getInstance() {
        return INSTANCE;
    }

    public void embarkOnMission() {
        System.out.println("Embarked on mission.");
    }
}

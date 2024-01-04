package gr.aueb.cf.ch14.singleton;

/**
 * Checks the function of singleton {@link SaintGeorgeKnight} class.
 *
 * @author thodoris
 */
public class Main {

    public static void main(String[] args) {
        SaintGeorgeKnight saintGeorgeKnight = SaintGeorgeKnight.getInstance();
        saintGeorgeKnight.embarkOnMission();
    }
}

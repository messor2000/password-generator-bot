import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class PasswordGenerator {
    private final int Characters;
    private SecureRandom scrand;
    private ArrayList<Character> valid;

    public PasswordGenerator(int n) {
        this.Characters = n;
    }
    public char randChar() {
        return this.valid.get(scrand.nextInt(this.valid.size()));
    }

    public String passwordGenerator() {
        scrand = new SecureRandom();
        valid = new ArrayList<>();
        //Filling the ArrayList with the characters we want to use based on ascii table:
        for (int i = 65; i < 91; i++) {
            valid.add((char) i);         //A-Z
            valid.add((char) (i+32));    //a-z
        }
        for (int i = 48; i < 58; i++) {
            valid.add((char) i);
        }
        for (int i = 35; i < 39; i++) {
            valid.add((char) i);
        }
        valid.add((char) 64);
        Collections.shuffle(valid);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Characters; i++) {
            stringBuilder.append(randChar());
        }
        return stringBuilder.toString();
    }
}

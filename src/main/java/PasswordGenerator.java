import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class PasswordGenerator {
//    private final int Characters;
//    private SecureRandom scrand;
//    private ArrayList<Character> valid;
//
//    public PasswordGenerator(int n) {
//        this.Characters = n;
//    }
//    public char randChar() {
//        return this.valid.get(scrand.nextInt(this.valid.size()));
//    }
//
//    public String passwordGenerator() {
//        scrand = new SecureRandom();
//        valid = new ArrayList<>();
//        //Filling the ArrayList with the characters we want to use based on ascii table:
//        for (int i = 65; i < 91; i++) {
//            valid.add((char) i);         //A-Z
//            valid.add((char) (i+32));    //a-z
//        }
//        for (int i = 48; i < 58; i++) {
//            valid.add((char) i);
//        }
//        for (int i = 35; i < 39; i++) {
//            valid.add((char) i);
//        }
//        valid.add((char) 64);
//        Collections.shuffle(valid);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < Characters; i++) {
//            stringBuilder.append(randChar());
//        }
//        return stringBuilder.toString();
//    }
private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";
    private final boolean useLower;
    private final boolean useUpper;
    private final boolean useDigits;
    private final boolean usePunctuation;

    private PasswordGenerator(PasswordGeneratorBuilder builder) {
        this.useLower = builder.useLower;
        this.useUpper = builder.useUpper;
        this.useDigits = builder.useDigits;
        this.usePunctuation = builder.usePunctuation;
    }

    public static class PasswordGeneratorBuilder {

        private boolean useLower;
        private boolean useUpper;
        private boolean useDigits;
        private boolean usePunctuation;

        public PasswordGeneratorBuilder() {
            this.useLower = false;
            this.useUpper = false;
            this.useDigits = false;
            this.usePunctuation = false;
        }

        public PasswordGeneratorBuilder useLower(boolean useLower) {
            this.useLower = useLower;
            return this;
        }

        public PasswordGeneratorBuilder useUpper(boolean useUpper) {
            this.useUpper = useUpper;
            return this;
        }

        public PasswordGeneratorBuilder useDigits(boolean useDigits) {
            this.useDigits = useDigits;
            return this;
        }

        public PasswordGeneratorBuilder usePunctuation(boolean usePunctuation) {
            this.usePunctuation = usePunctuation;
            return this;
        }

        public PasswordGenerator build() {
            return new PasswordGenerator(this);
        }
    }

    public String generate(int length) {
        // Argument Validation.
        if (length <= 0) {
            return "";
        }

        // Variables.
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        // Collect the categories to use.
        List<String> charCategories = new ArrayList<>(4);
        if (useLower) {
            charCategories.add(LOWER);
        }
        if (useUpper) {
            charCategories.add(UPPER);
        }
        if (useDigits) {
            charCategories.add(DIGITS);
        }
        if (usePunctuation) {
            charCategories.add(PUNCTUATION);
        }

        // Build the password.
        for (int i = 0; i < length; i++) {
            String charCategory = charCategories.get(random.nextInt(charCategories.size()));
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }
        return new String(password);
    }
}





























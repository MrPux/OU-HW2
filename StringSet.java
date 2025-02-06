public class StringSet {
    String[] strings;
    int size;

    // ---------- Constructors ------------

    // Pre-condition(s): a number greater than zero.
    public StringSet(int intialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Hey man, your number can't be negative.");
        }

        this.strings = new Strings[initialCapacity];
        this.size = 0;
    }

    // Pre-condition(s): none, initialize the string Array of length ten.
    public StringSet() {
        this.strings = new Strings[10];
        this.size = 0;
    }

    // Pre-codniton(s): StringSet object. Copy the the object elements into
    // this.StringSet

}

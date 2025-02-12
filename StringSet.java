import java.util.Arrays;

public class StringSet {
    String[] strings;
    int size;

    // ---------- Constructors ------------

    // Pre-condition(s): a number greater than zero.
    public StringSet(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Hey man, your number can't be negative.");
        }

        this.strings = new String[initialCapacity];
        this.size = 0;
    }

    // Pre-condition(s): none, initialize the string Array of length ten.
    public StringSet() {
        this.strings = new String[10];
        this.size = 0;
    }

    // Pre-codniton(s): StringSet object. Copy the the object elements into
    // this.StringSet.

    @Override
    public String toString() {
        return "StringSet: " + this.size + " + " + Arrays.toString(strings);
    }

    // Pre-condition(s): int, which will be used to compare it with our initial
    // String[] initialCapacity.
    public void ensureCapacity(int givenCapacity) {
        if (strings.length >= givenCapacity) {
            System.out.println("Your capacity is good buddy!");
        }
        // Otherwise, I will create a new array with a greater capacity, and the same
        // elements as it orginally had.
        trimToSize(givenCapacity);

    }

    public void add(String string) {
        //I will mesure to increase size to 1, so to not gett empty list error
        if (size == 0) {
            ensureCapacity(1);
        }
        //I will make sure that if item string being added is not yet in the list 
        if (binarySearch(this.strings, string) != -1) {
            throw new IllegalArgumentException(
                    "Hey buddy, we already got a " + string + " in our inventory. Try adding something knew.");
        }
        //If I am adding a new item, I need to ensure that my list is not full
        if (size == strings.length) {
            ensureCapacity(size * 2);
        }
        // Insert while maintaining sorted order
        int insertPosition = 0;
        while (insertPosition < size && strings[insertPosition].compareTo(string) < 0) {
            insertPosition++;
        }
        // Shift elements to make space/ sort in other words
        for (int i = size; i > insertPosition; i--) {
            strings[i] = strings[i - 1];
        }

        // Insert the new element
        strings[insertPosition] = string;
        size++;
    }

    public int binarySearch(String[] array, String target) {
        //I am declaring + Initializing my starting and end positon of the current list
        int left = 0, right = array.length - 1;

        //I am making sure I don't go out towards negative infinity
        while (left <= right) {
            //I am declaring my current middle of the current list
            int middle = left + (right - left) / 2;

            //Making sure that when I hit "null"s I pretty much know nothing is to the right.
            if (array[middle] == null || target == null) { // Prevent NullPointerException
                return -1;
            }

            // I take my currentValue at middle if target > middle (aka target > 0) is positve and my target is on the right, or target < middle is negative, my target is on the left(aka target < 0)
            int currentValue = target.compareTo(array[middle]);

            // If is netural (meaning 0) is because target found at middle
            if (currentValue == 0) {
                return middle;
            }

            // Potentially in the right, so currentValue is a positive number
            if (currentValue > 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }
        // I return -1 as to indicate target wasn't found
        return -1;
    }

    public void trimToSize(int newSize)
    {
        // I first make sure the new given size is not less than the current size, otherwise why would we need more space when already got enough...
        if (newSize < this.size)
        {
            throw new IllegalArgumentException("hey buddy, new size must be greater or equal to the current size");
        }

        //I initialize a temporary array as to keep my original array values
        String[] tempArray = new String[newSize];
        //I iterate through the current size of values kept on my original array and append them to the temporary one
        for (int i = 0; i < size; i++)
        {
            tempArray[i] = this.strings[i];
        }
        //I then set the original array values to be the temproary array values
        this.strings = tempArray;
    }

    public void remove(String value)
    {
        //First of all I make sure the item value is on the array
        if(binarySearch(this.strings, value) != -1)
        {
            //If the item value is in the array I set it to null, as to indicate we no longer need it
            this.strings[binarySearch(strings, value)] = null;

            //I then traverse null to the end
            shiftNullsToEnd(this.strings);
            //I make sure to update my size of values found in my array, that of course are not null
            this.size--;
        }
        else
        {
            throw new IllegalArgumentException("Hey buddy, the item you are trying to remove is not on the list of strigns, try adding it first.");
        }

    }

    public void shiftNullsToEnd(String[] array) {
        int insertPos = 0; // Position to insert the next non-null value

        // Move non-null elements to the front
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[insertPos++] = array[i]; // Shift element to the left
            }
        }

        // Fill the remaining positions with null
        while (insertPos < array.length) {
            array[insertPos++] = null;
        }
    }

    
}
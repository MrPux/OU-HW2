class Main_StringSet {
    public static void main(String[] args) {
      StringSet mySet = new StringSet(3);
      System.out.println(mySet);
    //   mySet.add("Hello");
    //   mySet.add("World");
    //   mySet.add("World"); //duplicate
    //   System.out.println(mySet);
    //   mySet.add("and");
    //   mySet.add("over");
    //   mySet.add("cap");
    //   System.out.println(mySet);
    //   StringSet otherSet = new StringSet(mySet);
    //   otherSet.add("Hi");
    //   otherSet.add("Bob");
    //   System.out.println(mySet);
    //   System.out.println(otherSet);
  
    //   mySet.trimToSize(5);
    //   System.out.println(mySet);
    //   try {
    //     mySet.trimToSize(2); //Too small
    //   } catch (IllegalArgumentException e) {
    //     System.out.println("Correctly throws trim error");
    //   }
    //   mySet.remove("and");
    //   System.out.println(mySet);
    //   mySet.remove("Hello");
    //   mySet.remove("World");
    //   mySet.remove("Bob"); //Does nothing
    //   mySet.remove("over");
    //   System.out.println(mySet); //Should shrink!
    //   mySet.add("You");
    //   System.out.println(mySet);
  
    //   //Union test
    //   StringSet thirdSet = StringSet.union(mySet,otherSet);
    //   System.out.println(thirdSet); //cap should NOT appear twice!
  
    //   //Intersect test
    //   mySet = new StringSet(10);
    //   mySet.add("Hi");
    //   mySet.add("not");
    //   mySet.add("in");
    //   mySet.add("Only");
    //   mySet.add("Bob");
    //   thirdSet = StringSet.intersect(mySet,thirdSet);
    //   System.out.println(thirdSet);
    }
  }
  
  /*
  Output does not need to match exactly but should be close!
  
  [null, null, null]
  [Hello, World, null]
  [Hello, World, and, over, cap, null]
  [Hello, World, and, over, cap, null]
  [Hello, World, and, over, cap, Hi, Bob, null, null, null, null, null]
  [Hello, World, and, over, cap]
  [Hello, World, cap, over, cap] //Last cap may instead be null
  [cap, null] //1 item left * 2 is the size after trim
  [cap, You]
  [Hello, World, and, over, cap, Hi, Bob, You, null, null, null, null] //May be in a completely different order
  [in, Bob] //Possibly more nulls
  */
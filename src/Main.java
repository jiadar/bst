import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
   public static void main(String[] args) {
      //      doSearch();
      doRemoveTest();
   }

   private static void doRemoveTest() {
      Btree<Integer>  b = new Btree<Integer>();
      b.add(10);
      b.add(5);
      b.add(3);
      b.add(20);
      b.add(17);
      b.add(1);
      b.add(4);
      b.add(13);
      System.out.println(b.toString());
   }
   
   private static void doSearch() {
      int SIZE=100000;
      long startTime, endTime, duration;

      System.out.println("Hello BST!");
      Btree<Integer>  b = new Btree<Integer>();
      ArrayList<Integer> a = new ArrayList<Integer>();

      System.out.println("Generating...");
      for(int i=0; i<SIZE; i++) {
         Integer num = ThreadLocalRandom.current().nextInt(1, SIZE*16);
         a.add(num);
         b.add(num);
      }

      System.out.println("Searching BST...");
      startTime = System.nanoTime();
      for(int i=0; i<1000; i++) {
         b.contains(i);
      }
      endTime = System.nanoTime();
      System.out.println("Binary Tree Search: " + ms(startTime, endTime) + " ms");
      //      System.out.println(b.toString());

      System.out.println("Searching Array List...");
      startTime = System.nanoTime();
      for(int i=0; i<1000; i++) {
         a.contains(i);  
      }      
      endTime = System.nanoTime();
      System.out.println("Array List Search: " + ms(startTime, endTime) + " ms");
   }

   private static String ms(long s, long e) {
      return "" + (e-s)/1000000;        
   }
}

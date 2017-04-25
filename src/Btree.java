import java.util.ArrayDeque;

public class Btree<T extends Comparable<? super T>> {

   /* Controls debug output bitwise from LSB: 
      Bit 0: getEntry 
    */
   private int DEBUG = 0;

   private T data;
   private Btree<T> left;
   private Btree<T> right;

   private enum Branch {
      ROOT, LEFT, RIGHT;
   }
   
   public Btree() {
      data = null;
      left = null;
      right = null;
   }

   public Btree(T value) {
      data = value;
      left = null;
      right = null;
   }


   public boolean isEmpty() {      
      return (data == null && left == null && right == null);
   }

   public boolean isLeaf() {
      return (data != null && left == null && right == null);
   }

   public void preorder() {
      preorderR(this);
   }

   public void preorderR(Btree<T> cur)
   {
      if (! cur.isEmpty()) {
         System.out.print(cur.data + " - ");
         preorderR(cur.left);
         preorderR(cur.right);
      }
   }

   public T add(T value)
   {
      return addRecursive(this, value);
   }
   
   private T addRecursive(Btree<T> cur, T value) {
      T result = null;

      if (cur.isEmpty()) {
         cur.data = value;
         cur.left = new Btree<T>();
         cur.right = new Btree<T>();
         result = cur.data;
      }

      else if (value.compareTo(cur.data) < 0) {
         result = addRecursive(cur.left, value);
      }

      else if (value.compareTo(cur.data) > 0) {
            result = addRecursive(cur.right, value);
      }

      else
         d(2, "Duplicate"); 

      return result;
   }

   public boolean contains(T value) {
      return (getEntry(value) == value); 
   }
   
   public T getEntry(T value) {
      return getEntryR(this, value);
   }

   private void d(int bit, String s) {
      if (DEBUG == bit)
         System.out.println(s);
   }
   
   private T getEntryR(Btree<T> cur, T value) {
      T result = null;

      if (! cur.isEmpty()) {

         if (cur.data.equals(value)) {
            result = cur.data;
         }
         
         else if (cur.data.compareTo(value) > 0) {
            result = getEntryR(cur.left, value);
         }
         
         else {
            result = getEntryR(cur.right, value);
         }

      }
      return result;
   }
   
   
   public String toLine() {
      StringBuilder builder = new StringBuilder();
      if (this.data != null && this.left != null)
         builder.append(this.left.toLine()).append(", ");
      if (this.data != null && this.right != null)
         builder.append(this.right.toLine()).append(", ");
      return (this.data==null) ? "N" : builder.append(this.data.toString()).toString();    
   }

   public String toCompressedString() {
      return this.toString().replaceAll("\n","").replaceAll("\\+", " ").replaceAll(" ","").replaceAll("-","").replaceAll("\\|", "\\.").toLowerCase();
   }
  
   public String toString() {
      Btree root=this;
      StringBuilder builder=new StringBuilder();
      printTree(root, 0, builder, Branch.ROOT);
      return builder.toString();
   }

   private static void printTree(Btree root, int indent, StringBuilder builder, Branch branch) {
      if (root.data != null) {
         builder.append(genIndent(indent));
         if (branch==Branch.ROOT) builder.append("+--");
         else builder.append((branch == Branch.LEFT) ? "L--" : "R--");
         builder.append(root.data.toString());
         builder.append("\n");
      }
      if (root.left != null) {
         printTree(root.left, indent+1, builder, Branch.LEFT);        
      } 
      if (root.right != null) {
         printTree(root.right, indent+1, builder, Branch.RIGHT);
      } 
   }
    
   private static String genIndent(int indent) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < indent; i++) {
         sb.append("|  ");
      }
      return sb.toString();
   }

}


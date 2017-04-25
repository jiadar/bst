package bst;

import java.util.Iterator;

public class Dictionary<K,V> implements DictionaryInterface<K,V> {

   Btree<Entry> st = new Btree<>();
   
   public V add(K key, V value) {
      V result = null;
      Entry<K, V> e = new Entry<>(key, value);
      Entry<K, V> r = st.add(e);

      if (r != null)
         result = r.value;
      
      return result;
   }

   public V remove(K key) {
      V result = null;
      return result;

   }
   
   public V getValue(K key) {
      V result = null;
      return result;

   }
   
   public boolean contains(K key) {
      boolean result = false;
      return result;
   }

   public Iterator<K> getKeyIterator() {
      Iterator<K> itr = null;
      return itr;
   }
   
   public Iterator<V> getValueIterator() {
      Iterator<V> itr = null;
      return itr;

   }
   
   public boolean isEmpty() {
      boolean result = false;
      return result;
   }
   
   public int getSize() {
      int result = 0;
      return result;
   }

   public void clear() {

   }

   
   private class Entry<S extends Comparable<? super S>, T>
      implements Comparable<Entry<S, T>> {

      public S key;
      public T data;

      private Entry(S k, T d) {
         key = k;
         data = d;
      }

      public int compareTo(Entry<S, T> other) {
         return key.compareTo(other.key);
      }

      public boolean equals(Entry<S, T> other) {
         return key.compareTo(other.key)==0;
      }

      public String toString() {
         return key.toString() + ": " + data.toString();
      }
   }
}

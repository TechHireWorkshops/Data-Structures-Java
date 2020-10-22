import java.util.ArrayList;

class HashNode<K, V> {
  K key;
  V value;
  HashNode<K, V> next;
  HashNode<K, V> prev;

  public HashNode(K key, V value) {
    this.key = key;
    this.value = value;
    this.next = null;
    this.prev = null;
  }
}

class HashTable<K, V> {
  private ArrayList<HashNode<K, V>> bucketArray;
  private int numBuckets;

  public HashTable(int bucketNum) {
    bucketArray = new ArrayList<HashNode<K, V>>();
    numBuckets = bucketNum;

    for (int i = 0; i < numBuckets; i++)
      bucketArray.add(null);
  }

  // This implements hash function to find index
  // for a key
  private int getBucketIndex(K key) {
    int hashCode = key.hashCode();
    int index = hashCode % numBuckets;
    return index;
  }

  public V remove(K key) {
    int bucketIndex = getBucketIndex(key);
    HashNode<K, V> current = bucketArray.get(bucketIndex);
    HashNode<K, V> previous = null;
    while (current != null) {
      if (current.key.equals(key)) {
        if (previous != null) {
          previous.next = current.next;
          current.next.prev = previous;
          current.prev = null;
          current.next = null;
        } else {
          bucketArray.set(bucketIndex, current.next);
        }
        return current.value;
      }
    }
    previous = current;
    current = current.next;
    return null;

  }

  // Returns value for a key
  public V get(K key) {
    // Find head of chain for given key
    int bucketIndex = getBucketIndex(key);
    HashNode<K, V> current = bucketArray.get(bucketIndex);

    // Search key in chain
    while (current != null) {
      if (current.key.equals(key))
        return current.value;
      current = current.next;
    }

    // If key not found
    return null;
  }

  // Adds a key value pair to hash
  public void add(K key, V value) {
    int bucketIndex = getBucketIndex(key);
    HashNode<K, V> current = bucketArray.get(bucketIndex);
    HashNode<K, V> newNode = new HashNode<K, V>(key, value);
    if (current == null) {
      bucketArray.set(bucketIndex, newNode);
      return;
    }
    HashNode<K, V> previous = null;
    while (current != null) {
      previous = current;
      current = current.next;
    }
    previous.next = newNode;
    newNode.prev = previous;
  }

  public static void main(String[] args) {
    HashTable<String, Integer> hashTable = new HashTable<>(10);
    hashTable.add("this", 1);
    hashTable.add("coder", 2);
    hashTable.add("this", 4);
    hashTable.add("hi", 5);
    // for (int i = 0; i < hashTable.bucketArray.size(); i++) {
    // System.out.println(hashTable.bucketArray.get(i));
    // }
    System.out.println(hashTable.bucketArray.get(0).value);
    System.out.println(hashTable.bucketArray.get(0).next.value);
    System.out.println(hashTable.remove("this"));
    System.out.println(hashTable.bucketArray.get(0).value);
    // System.out.println(hashTable.remove("this"));
    // System.out.println(hashTable.bucketArray.get(0).value);
    // System.out.println(hashTable.remove("this"));

  }
}
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
    bucketArray = new ArrayList<>();
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
    HashNode<K, V> head = bucketArray.get(bucketIndex);
    HashNode<K, V> prev = null;
    while (head != null) {
      // If Key found
      if (head.key.equals(key))
        break;

      // Else keep moving in chain
      prev = head;
      head = head.next;
    }

    // If key was not there
    if (head == null)
      return null;

    // Remove key
    if (prev != null)
      prev.next = head.next;
    else
      bucketArray.set(bucketIndex, head.next);

    return head.value;
  }

  // Returns value for a key
  public V get(K key) {
    // Find head of chain for given key
    int bucketIndex = getBucketIndex(key);
    HashNode<K, V> head = bucketArray.get(bucketIndex);

    // Search key in chain
    while (head != null) {
      if (head.key.equals(key))
        return head.value;
      head = head.next;
    }

    // If key not found
    return null;
  }

  // Adds a key value pair to hash
  public void add(K key, V value) {
    // Find head of chain for given key
    int bucketIndex = getBucketIndex(key);
    HashNode<K, V> head = bucketArray.get(bucketIndex);

    // Check if key is already present
    while (head != null) {
      if (head.key.equals(key)) {
        head.value = value;
        return;
      }
      head = head.next;
    }

    // Insert key in chain
    head = bucketArray.get(bucketIndex);
    HashNode<K, V> newNode = new HashNode<K, V>(key, value);
    newNode.next = head;
    bucketArray.set(bucketIndex, newNode);
  }

  public static void main(String[] args) {
    HashTable<String, Integer> hashTable = new HashTable<>(10);
    hashTable.add("this", 1);
    hashTable.add("coder", 2);
    hashTable.add("this", 4);
    hashTable.add("hi", 5);
    System.out.println(hashTable.remove("this"));
    System.out.println(hashTable.remove("this"));

  }
}
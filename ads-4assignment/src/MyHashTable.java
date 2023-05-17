import java.security.Key;

public class MyHashTable<K, V> {
    public class HashNode<K, V> {
        public K key;
        public V value;
        public HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key=key;
            this.value=value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    public HashNode<K, V>[] chainArray;
    public int M=11;
    public int size;

    public MyHashTable() {
        chainArray=new HashNode[M];
    }

    public MyHashTable(int M) {
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];

        while (node !=null) {
            if (node.key.equals(key)) {
                node.value=value;
                return;
            }
            node=node.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next=chainArray[index];
        chainArray[index]=newNode;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];

        while (node !=null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node=node.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> prev = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }



    public boolean containsValue(V value) {
        for (HashNode<K, V> node: chainArray) {
            while (node!=null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node=node.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (HashNode<K, V> node: chainArray) {
            while (node!=null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node=node.next;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];

        while (node!=null) {
            if (node.key.equals(key)) {
                return true;
            }
            node=node.next;
        }
        return false;
    }


}

public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        // Custom hashCode implementation
        int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + (name == null ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // Custom equals implementation
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MyTestingClass other = (MyTestingClass) obj;
        return id == other.id && (name == null ? other.name == null : name.equals(other.name));
    }

    @Override
    public String toString() {
        return "MyTestingClass [id=" + id + ", name=" + name + "]";
    }

    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();

        // Put elements in the hashtable
        MyTestingClass key1 = new MyTestingClass(1, "Element1");
        String value1 = "Value1";
        table.put(key1, value1);

        MyTestingClass key2 = new MyTestingClass(2, "Element2");
        String value2 = "Value2";
        table.put(key2, value2);

        MyTestingClass key3 = new MyTestingClass(3, "Element3");
        String value3 = "Value3";
        table.put(key3, value3);

        // Get values using keys
        System.out.println("Value for key1: " + table.get(key1));
        System.out.println("Value for key2: " + table.get(key2));
        System.out.println("Value for key3: " + table.get(key3));

        // Remove an element
        table.remove(key2);

        // Check if a value exists in the hashtable
        System.out.println("Contains value 'Value2': " + table.containsValue("Value2"));

        // Get the key for a value
        System.out.println("Key for value 'Value3': " + table.getKey("Value3"));

        // Check if a key exists in the hashtable
        System.out.println("Contains key key2: " + table.containsKey(key2));

    }
}



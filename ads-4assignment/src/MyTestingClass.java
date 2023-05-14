public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public int hashCode() {
        int result=17;
        result=31*result+id;
        result=31*result+name.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void  setName() {
        this.name=name;
    }

    public static void main(String[] args) {
        MyTestingClass obj1 = new MyTestingClass(1, "Yerkebulan");
        MyTestingClass obj2 = new MyTestingClass(2, "Temirlan");
        MyTestingClass obj3 = new MyTestingClass(3, "Sagidolla");

        System.out.println("obj1.hashCode() = "+obj1.hashCode());
        System.out.println("obj2.hashCode() = "+obj2.hashCode());
        System.out.println("obj3.hashCode() = "+obj3.hashCode());
    }

}

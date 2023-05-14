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

}

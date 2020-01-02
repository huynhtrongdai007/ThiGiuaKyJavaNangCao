package model;

public class Employee {
    private int id;
    private String fullName;
    private boolean genDer;

    public Employee(){

    }

    public Employee(int id,String fullName,boolean genDer)
    {
        this.id = id;
        this.fullName = fullName;
        this.genDer = genDer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

   public boolean getGenDer() {
        return genDer;
    }

    public void setGenDer(boolean genDer) {
        this.genDer = genDer;
    }
}

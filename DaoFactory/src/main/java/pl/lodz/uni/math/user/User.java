package pl.lodz.uni.math.user;

public class User {
    
    private int ID;
    private String name;

    
    public User(int ID, String name){
        super();
        this.ID = ID;
        this.name = name;
    }
    
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
    
     public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

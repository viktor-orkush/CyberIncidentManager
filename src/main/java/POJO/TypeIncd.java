package POJO;

/**
 * Created by Viktor on 14.06.2017.
 */
public class TypeIncd {
    private int id;
    private String shotName;
    private String name;

    public TypeIncd(int id, String shotName, String name){
         this.id = id;
         this.shotName = shotName;
         this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShotName() {
        return shotName;
    }

    public void setShotName(String shotName) {
        this.shotName = shotName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

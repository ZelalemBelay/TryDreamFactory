package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Zelalem Belay on 1/26/2017.
 */
@Entity
public class Test
{
  @Id @GeneratedValue
    int id;
    String name;

    public Test() {
    }

    public Test(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

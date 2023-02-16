package Mock;

import Entities.Boots;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Boots> data = new ArrayList<>();

    public Data() {
        this.data.add(new Boots(1, "FirstName", 40, 25090, "assets/boot1.JPG" ));
        this.data.add(new Boots(2, "SecondName", 37, 6100, "assets/boot2.JPG"));
        this.data.add(new Boots(3, "ThirdName", 44, 4900, "assets/boot3.JPG"));
    }

    public List<Boots> getData() {
        return data;
    }

    public void setData(List<Boots> data) {
        this.data = data;
    }
}

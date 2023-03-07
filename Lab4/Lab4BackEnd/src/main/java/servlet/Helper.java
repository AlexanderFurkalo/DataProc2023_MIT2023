package servlet;
import Entities.Boots;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
public class Helper {
    public static JsonElement bodyParse(HttpServletRequest request){
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    public static Boots Parse(HttpServletRequest request){
        Boots it = new Boots();
        JsonElement jsonElement = bodyParse(request);
        it.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        it.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        it.setSize(jsonElement.getAsJsonObject().get("size").getAsInt());
        it.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        it.setImage(jsonElement.getAsJsonObject().get("image").getAsString());
        return it;
    }

    public static int getNextId(List<Boots> list) {
        int maxId = 0;

        Iterator<Boots> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public static int getIndexById(int id, List<Boots> list) {
        int listId = id;

        Iterator<Boots> iterator = list.iterator();
        while(iterator.hasNext()) {
            Boots temp = iterator.next();
            if(temp.getId() == listId) {
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
}

package Crud;

import Entities.Boots;
import FileIO.FileIO;
import FileIO.FileIOInterface;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;

public class FileCrud implements CrudInterface{

    FileIOInterface fio;

    public FileCrud(){
        this.fio = new FileIO();
    }
    @Override
    public Boots readEntity() {
        return (Boots) fio.loadFromFile();
    }

    @Override
    public void updateEntity(Boots entities) {
        fio.saveToFile(entities);
    }

    public JsonElement bodyParse(HttpServletRequest request){
        JsonElement jsonElement = null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    @Override
    public Boots watchParse(HttpServletRequest request){
        Boots watch = new Boots();
        JsonElement jsonElement = bodyParse(request);
        watch.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        watch.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        watch.setSize(jsonElement.getAsJsonObject().get("size").getAsInt());
        watch.setPrice(jsonElement.getAsJsonObject().get("price").getAsInt());
        watch.setImage(jsonElement.getAsJsonObject().get("image").getAsString());
        return watch;
    }

    public int getNextId(List<Boots> list) {
        int maxId = 0;

        Iterator<Boots> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public int getIndexByWatchId(int id, List<Boots> list) {
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

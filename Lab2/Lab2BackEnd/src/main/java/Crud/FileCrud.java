package Crud;

import Entities.Boots;
import FileIO.FileIO;
import FileIO.FileIOInterface;

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
    public void updateEntity(Boots entity) {
        fio.saveToFile(entity);
    }
}

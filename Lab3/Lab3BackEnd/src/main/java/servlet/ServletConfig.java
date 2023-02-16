package servlet;

import Crud.CrudInterface;
import Crud.FileCrud;
public class ServletConfig implements ServletConfigInterface {
    CrudInterface CrInt;

    public ServletConfig() {
        this.CrInt = new FileCrud();
    }
    public void setCrInt(CrudInterface CrInt){
        this.CrInt = CrInt;
    }
    @Override
    public CrudInterface getCrud(){
        return CrInt;
    }
}

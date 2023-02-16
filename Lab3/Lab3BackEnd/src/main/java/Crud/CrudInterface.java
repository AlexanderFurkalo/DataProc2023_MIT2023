package Crud;
import Entities.Boots;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public interface CrudInterface {
    public Boots readEntity();
    public void updateEntity(Boots Entities);
    Boots watchParse(HttpServletRequest request);
    int getIndexByWatchId(int id, List<Boots> le);
    int getNextId(List<Boots> le);
}

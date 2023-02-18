package Crud;
import Entities.Boots;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public interface CrudInterface {
    Boots readEntity();
    void updateEntity(Boots Entities);
    Boots watchParse(HttpServletRequest request);
    int getIndexByWatchId(int id, List<Boots> listd);
    int getNextId(List<Boots> listd);
}

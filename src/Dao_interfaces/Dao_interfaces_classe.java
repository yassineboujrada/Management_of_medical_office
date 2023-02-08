package Dao_interfaces;
import java.util.List;

public interface Dao_interfaces_classe<Name> {
    public List<Name> getAllData();
    public Name getData(int id);
    public void addData(Name classe_plz);
    public void updateData(Name classe_plz);
    public void deleteData(Name classe_plz);
}

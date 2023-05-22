package jualbelitanah.DAOImplement;

import java.util.List;
import jualbelitanah.Model.Model_jualbeli;

public interface Implement_jualbeli {
    
    public void insert(Model_jualbeli jualBeli);
    
    public void update(Model_jualbeli jualBeli);
    
    public void delete(int id);
    
    public List<Model_jualbeli> getAll();
    
    public List<Model_jualbeli> getByKeyword(String keyword);
    
}

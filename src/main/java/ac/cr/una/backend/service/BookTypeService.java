
package ac.cr.una.backend.service;

import ac.cr.una.backend.model.BookType;
import java.util.List;

/**
 *
 * @author Gabo Quesada
 */


public interface BookTypeService {
    
    public boolean deleteAll();
    public BookType save(BookType bookType);
    public BookType findByName(String name);
  
}

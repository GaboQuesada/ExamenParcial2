
package ac.cr.una.backend.service;

import ac.cr.una.backend.model.BookType;
import java.util.List;

/**
 *
 * @author Gabo Quesada
 */


public interface BookTypeService {
    
    /**
     *
     * @return
     */
    public boolean deleteAll();

    /**
     *
     * @param bookType
     * @return
     */
    public BookType save(BookType bookType);

    /**
     *
     * @param name
     * @return
     */
    public BookType findByName(String name);
  
}

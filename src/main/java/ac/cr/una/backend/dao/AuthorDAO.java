package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Author;

/**
 *
 * @author Gabo Quesada
 */
public interface AuthorDAO {

    /**
     *
     * @param name
     * @return
     */
    public Author findByName(String name);
}

package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.model.Book;
import ac.cr.una.backend.model.BookType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabo Quesada
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    /**
     *
     */
    public BookServiceImpl() {
    }

    /**
     *
     * @param bookDAO
     */
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     *
     * @return
     */
    public BookDAO getBookDAO() {
        return bookDAO;
    }

    /**
     *
     * @param bookDAO
     */
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean deleteAll() {
        return bookDAO.deleteAll();
    }

    @Override
    public Book save(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Float totalPriceAll() {

        List<Book> lista = bookDAO.findAll();

        int tan = lista.size();
        float calculo = 0;

        for (int i = 0; i < tan; i++) {

            calculo = calculo + lista.get(i).getPrice();

        }

        return calculo;

    }

}

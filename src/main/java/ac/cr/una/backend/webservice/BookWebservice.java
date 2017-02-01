package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.dao.BookDAOImpl;
import ac.cr.una.backend.model.Book;
import ac.cr.una.backend.service.BookService;
import ac.cr.una.backend.service.BookServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Gabo Quesada
 */
@Path("books")
public class BookWebservice {

    private BookDAO bookDAO;
    private BookService bookService;

    @Context
    private UriInfo context;

    /**
     *
     */
    public BookWebservice() {
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        List<Book> studentList = null;
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);

        studentList = bookService.findAll();
        return studentList;
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/totalprice")
    @Produces(MediaType.APPLICATION_JSON)
    public float getTotalPrice() {
        float resultado;
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);

        resultado = bookService.totalPriceAll();
        return resultado;
    }

    /**
     *
     * @param book
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book createBook(Book book) {

        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);

        book = bookService.save(book);

        return book;
    }

    /**
     *
     * @return
     */
    @DELETE
    @Path("/")
    public boolean deleteAll() {
        boolean result;
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);

        result = bookService.deleteAll();

        return result;
    }

}

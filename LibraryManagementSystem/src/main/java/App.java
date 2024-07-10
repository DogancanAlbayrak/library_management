import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        //Author ekleme
        Author author = new Author();
        author.setName ("Jean-Christophe Grange");
        author.setBirthdate(LocalDate.of(1961, 7, 15));
        author.setCountry("France");
        entityManager.persist(author);

        //Category ekleme
        Category category = new Category();
        category.setName("Polisiye");
        category.setDescription("Polisiye ve gerilim türündeki kitaplar");
        entityManager.persist(category);

        //Publisher ekleme
        Publisher publisher = new Publisher();
        publisher.setName("Dogan Kitap");
        publisher.setEstablishmentYear(1997);
        publisher.setAddress("New York, USA");
        entityManager.persist(publisher);

        //Book ekleme
        Book book = new Book();
        book.setName("Kızıl Nehirler");
        book.setPublicationYear(1997);
        book.setStock(100);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCategories(List.of(category));
        entityManager.persist(book);

        //BookBorrowing Ekleme
        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Jane Doe");
        bookBorrowing.setBorrowingDate(LocalDate.now());
        bookBorrowing.setBook(book);
        entityManager.persist(bookBorrowing);

        transaction.commit();

    }
}

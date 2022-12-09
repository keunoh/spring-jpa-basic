package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbb");
            movie.setName("바람과함께사라지다.");
            movie.setPrice(10000);

            Movie movie2 = new Movie();
            movie2.setDirector("aaaa123");
            movie2.setActor("bb312b");
            movie2.setName("바람과함께사라지다.11");
            movie2.setPrice(10000);

            em.persist(movie);
            em.persist(movie2);

            em.flush();
            em.clear();

            Item item = em.find(Item.class, movie.getId());
            System.out.println("findMovie = " + item);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}

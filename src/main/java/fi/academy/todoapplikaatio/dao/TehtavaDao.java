package fi.academy.todoapplikaatio.dao;
import fi.academy.todoapplikaatio.Tehtava;
import java.util.List;

public interface TehtavaDao {

        List<Tehtava> haeKaikki();
        int lisaa(Tehtava tehtava);
        Tehtava poista(int id);

}

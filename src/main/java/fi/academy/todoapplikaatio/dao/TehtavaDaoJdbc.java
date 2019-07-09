package fi.academy.todoapplikaatio.dao;


import fi.academy.todoapplikaatio.Tehtava;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jdbc")
public class TehtavaDaoJdbc implements TehtavaDao {

    private Connection con;

    @Override
    public List<Tehtava> haeKaikki() {
        return null;
    }

    @Override
    public Optional<Tehtava> haeIdlla(int id) {
        return Optional.empty();
    }

    @Override
    public int lisaa(Tehtava tehtava) {
        return 0;
    }

    @Override
    public Tehtava poista(int id) {
        return null;
    }

    @Override
    public boolean muuta(int id, Tehtava tiedot) {
        return false;
    }
}

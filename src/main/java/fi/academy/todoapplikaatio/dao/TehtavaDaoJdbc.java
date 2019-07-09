package fi.academy.todoapplikaatio.dao;


import fi.academy.todoapplikaatio.Tehtava;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jdbc")
public class TehtavaDaoJdbc implements TehtavaDao {

    private Connection con;

    public TehtavaDaoJdbc(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Ajurin lataus epäonnistui!" + e);
        }
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tehtavalista",
                    "postgres", "Sovelto1");
        } catch (SQLException e) {
            System.err.println("Tapahtui virhe!" + e);
        }
    }

    @Override
    public List<Tehtava> haeKaikki() {
        String sql = "SELECT id,teksti FROM tehtavalista";
        List<Tehtava> haetut = new ArrayList<>();
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            for (ResultSet rs = pstmt.executeQuery(); rs.next() ;) {
                Tehtava t = new Tehtava();
                t.setId(rs.getInt("id"));
                t.setTeksti(rs.getString("teksti"));
                haetut.add(t);
            }
            } catch (SQLException e) {
                e.printStackTrace();
                return Collections.EMPTY_LIST;
            }
        return haetut;
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

}

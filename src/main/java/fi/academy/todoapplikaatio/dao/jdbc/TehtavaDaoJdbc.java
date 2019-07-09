package fi.academy.todoapplikaatio.dao.jdbc;


import fi.academy.todoapplikaatio.Tehtava;
import fi.academy.todoapplikaatio.dao.TehtavaDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public int lisaa(Tehtava tehtava) {
        String teksti = tehtava.getTeksti();
        int avain = -1;
        String sql = "INSERT INTO tehtavalista(teksti) VALUES (?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, teksti);
            pstmt.executeUpdate();
            ResultSet avaimet = pstmt.getGeneratedKeys();
            while (avaimet.next()) {
                avain = avaimet.getInt(1);
                tehtava.setId(avain);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return avain;
    }

    @Override
    public Tehtava poista(int id) {
        String sql = "DELETE FROM tehtavalista WHERE id=?";
        try (PreparedStatement statement = con.prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

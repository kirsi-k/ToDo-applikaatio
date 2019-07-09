package fi.academy.todoapplikaatio;

public class Tehtava {
    private int id;
    private String teksti;

    public Tehtava() {

    }

    public Tehtava(String teksti) {
        this.teksti = teksti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeksti() {
        return teksti;
    }

    public void setTeksti(String teksti) {
        this.teksti = teksti;
    }

    @Override
    public String toString() {
        return "Tehtava{" +
                "id=" + id +
                ", teksti='" + teksti + '\'' +
                '}';
    }
}

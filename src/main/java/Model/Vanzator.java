package Model;

public class Vanzator {
    private int id;
    private String nume;
    private String parola;

    public Vanzator(int id, String nume, String parola){
        this.id=id;
        this.nume=nume;
        this.parola=parola;
    }

    public Vanzator(String nume, String parola){
        this.nume=nume;
        this.parola=parola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Vanzator{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}

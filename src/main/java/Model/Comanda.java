package Model;

import java.time.LocalDateTime;

public class Comanda {
    private int id;
    private String client;
    private LocalDateTime data;
    private String adresa;

    public Comanda(String client, String data, String adresa) {
        this.client = client;
        this.data = convertStringLocalDateTime(data);
        this.adresa = adresa;
    }

    public Comanda(int id, String client, String data, String adresa) {
        this.id = id;
        this.client = client;
        this.data = convertStringLocalDateTime(data);
        this.adresa = adresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", data=" + data +
                ", adresa='" + adresa + '\'' +
                '}';
    }

    public static String convertLDTtoStringTFormat(LocalDateTime ldt){
        return String.format("%s",ldt);
    }

    public static String parameterStringConvert(String data){
        String dataF="";
        String[] p1=data.split("T");
        String[] p2=p1[0].split("-");
        String[] p3=p1[1].split(":");
        dataF+=p2[2]+","+p2[1]+","+p2[0]+","+p3[0]+","+p3[1];
        return dataF;
    }

    public static LocalDateTime convertStringLocalDateTime(String data){
        int ddi = Integer.parseInt(data.split(",")[0]);
        int mmi = Integer.parseInt(data.split(",")[1]);
        int yyi = Integer.parseInt(data.split(",")[2]);
        int hhi = Integer.parseInt(data.split(",")[3]);
        int mini = Integer.parseInt(data.split(",")[4]);
        return LocalDateTime.of(yyi, mmi, ddi, hhi, mini);
    }
}

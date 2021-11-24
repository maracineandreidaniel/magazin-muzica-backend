package Model;

import java.time.LocalDateTime;

public class Calatorie {
    private int id;
    private String client;
    private LocalDateTime data;
    private String agent;
    private String destinatie;

    public Calatorie(String client, String data, String agent, String destinatie) {
        this.client = client;
        this.data = convertStringLocalDateTime(data);
        this.agent=agent;
        this.destinatie=destinatie;
    }

    public Calatorie(int id, String client, String data, String agent, String destinatie) {
        this.id = id;
        this.client = client;
        this.data = convertStringLocalDateTime(data);
        this.destinatie=destinatie;
        this.agent=agent;
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

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", agent='" + agent + '\'' +
                ", data=" + data +
                ", destinatie='" + destinatie + '\'' +
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

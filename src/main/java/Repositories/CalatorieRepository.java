package Repositories;

import Model.Calatorie;
import Model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalatorieRepository {
    private String jdbcurl = "jdbc:mysql://localhost:3306/agentie_calatorii_db?autoreconnect=true&useSSL=false";
    private String user = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public CalatorieRepository() {
        try {
            this.connection = DriverManager.getConnection(this.jdbcurl, this.user, this.password);
            this.statement = this.connection.createStatement();
        } catch (SQLException var2) {
            System.out.println("eroare de conectare baza de date");
        }

    }

    public void executeStatement(String execute) {
        try {
            this.statement.execute(execute);
        } catch (SQLException var3) {
            System.out.println("Nu am reusit " + execute);
        }
    }


    public void insertCalatorie(Calatorie calatorie) {
        String insertTo = " ";
        insertTo = insertTo + "insert into calatorii(client,data,agent,destinatie) values (";
        insertTo = insertTo + String.format("'%s','%s','%s','%s'",calatorie.getClient(),Calatorie.convertLDTtoStringTFormat(calatorie.getData()),calatorie.getAgent(),calatorie.getDestinatie());
        insertTo = insertTo + ");";
        this.executeStatement(insertTo);
    }

    public void removeCalatorie(int numar){
        String removeTo="";
        removeTo+=String.format("%s", "delete from calatorii where id='"+numar+"';");
        executeStatement(removeTo);

    }

    public void updateID(int numar,int numarNou){
        String update="";
        update+=String.format("update calatorii set id=%d", numarNou);
        update+=String.format(" where id=%d", numar);
        executeStatement(update);
    }

    public void updateClient(int numar , String clientNou){
        String update="";
        update+=String.format("update calatorii set client='%s'", clientNou);
        update+=String.format(" where id=%d", numar);
        executeStatement(update);
    }

    public void updateData(int numar , String dataNoua){
        String update="";
        update+=String.format("update bilete set data='%s'", Calatorie.convertLDTtoStringTFormat(Calatorie.convertStringLocalDateTime(dataNoua)));
        update+=String.format(" where id=%d", numar);
        executeStatement(update);
    }

    public void updateAgent(int numar , String agentNou){
        String update="";
        update+=String.format("update calatorii set agent='%s'", agentNou);
        update+=String.format(" where id=%d", numar);
        executeStatement(update);
    }

    public void updateDestinatie(int numar , String destinatieNoua){
        String update="";
        update+=String.format("update calatorii set destinatie='%s'", destinatieNoua);
        update+=String.format(" where id=%d", numar);
        executeStatement(update);
    }

    private ResultSet lista(){
        executeStatement("select * from calatorii");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<Calatorie> allCalatorii(){
        ResultSet set=lista();
        List<Calatorie> calatorii = new ArrayList<>();
        try {
            while (set.next()){
              calatorii.add(new Calatorie(set.getInt(1),set.getString(2),Calatorie.parameterStringConvert(set.getString(3)),set.getString(4),set.getString(5)));
            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
            return null;
        }
        return calatorii;
    }





}

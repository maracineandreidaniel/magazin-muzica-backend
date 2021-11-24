package Repositories;

import Model.Agent;
import Model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgentRepository {
    private String jdbcurl = "jdbc:mysql://localhost:3306/agentie_calatorii_db?autoreconnect=true&useSSL=false";
    private String user = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public AgentRepository() {
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


    public void insertAgent(Agent agent) {
        String insertTo = " ";
        insertTo = insertTo + "insert into agenti (nume,parola) values (";
        insertTo = insertTo + String.format("'%s','%s'",agent.getNume(),agent.getParola());
        insertTo = insertTo + ");";
        this.executeStatement(insertTo);
    }

    public void removeAgent(String nume){
        String removeTo="";
        removeTo+=String.format("%s", "delete from agenti where nume='"+nume+"';");
        executeStatement(removeTo);

    }

    public void updateNume(String nume, String numeNou){
        String update="";
        update+=String.format("update agenti set nume='%s'", numeNou);
        update+=String.format(" where nume='%s'", nume);
        executeStatement(update);
    }

    public void updateParola(String nume , String parolaNoua){
        String update="";
        update+=String.format("update agenti set parola='%s'", parolaNoua);
        update+=String.format(" where nume='%s'", nume);
        executeStatement(update);
    }

    private ResultSet lista(){
        executeStatement("select * from agenti");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<Agent> allAgenti() {
        ResultSet set = lista();
        List<Agent> agenti = new ArrayList<>();
        try {
            while (set.next()) {
                agenti.add(new Agent(set.getString(2), set.getString(3)));
            }
        } catch (Exception e) {
            System.out.println("Nu s-a creat lista");
            return null;
        }
        return agenti;
    }


}

package Controllers;

import Model.Agent;
import Model.Client;
import Repositories.AgentRepository;
import Repositories.ClientRepository;

import java.util.List;

public class AgentController {

    private AgentRepository agenti;

    public AgentController(){
        agenti=new AgentRepository();
    }

    public void insert(Agent agent){
        agenti.insertAgent(agent);
    }

    public void remove(String nume){
        if(existAgent(nume)==false)
            System.out.println("Agentul nu exista");
        else
            agenti.removeAgent(nume);
    }

    public void updateNume(String nume, String numeNou){
        if(existAgent(nume)==false)
            System.out.println("Agentul nu exista");
        else
            agenti.updateNume(nume,numeNou);
    }

    public void updateParola(String nume, String parolaNoua){
        if(existAgent(nume)==false)
            System.out.println("Agentul nu exista");
        else
            agenti.updateParola(nume,parolaNoua);
    }

    public List<Agent> allAgenti(){
        return agenti.allAgenti();
    }

    public boolean existAgent(String nume){
        for(Agent a: agenti.allAgenti())
            if(a.getNume().equals(nume))
                return true;
        return false;
    }

    public Agent getAgentNumeParola(String nume,String parola){
        if(existAgent(nume)==true)
            for(Agent a:agenti.allAgenti())
                if(a.getNume().equals(nume) && a.getParola().equals(parola))
                    return a;
        return null;
    }



}

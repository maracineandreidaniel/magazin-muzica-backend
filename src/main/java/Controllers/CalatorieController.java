package Controllers;

import Model.Calatorie;
import Repositories.CalatorieRepository;
import Repositories.ClientRepository;

import java.util.List;

public class CalatorieController {
    private ClientRepository clienti;
    private CalatorieRepository calatorii;


    public CalatorieController(){
       clienti=new ClientRepository();
       calatorii=new CalatorieRepository();
    }

    public void insert(Calatorie calatorie){
        calatorii.insertCalatorie(calatorie);
    }


    public void remove(int nr){
        if(existCalatorie(nr)==true)
           calatorii.removeCalatorie(nr);
        else
            System.out.println("Calatoria nu exista");
    }

    public void updateClient(int nr, String clientNou){
        if(existCalatorie(nr)==true)
            calatorii.updateClient(nr,clientNou);
        else
            System.out.println("Calatoria nu exista.");
    }

    public void updateData(int nr, String dataNoua){
        if(existCalatorie(nr)==true)
           calatorii.updateData(nr,dataNoua);
        else
            System.out.println("Calatoria nu exista.");
    }

    public void updateAgent(int nr, String agentNou){
        if(existCalatorie(nr)==true)
            calatorii.updateAgent(nr,agentNou);
        else
            System.out.println("Calatoria nu exista.");
    }

    public void updateDestinatie(int nr, String destinatieNoua){
        if(existCalatorie(nr)==true)
            calatorii.updateDestinatie(nr,destinatieNoua);
        else
            System.out.println("Calatoria nu exista.");
    }

    public List<Calatorie> allCalatorii(){
        return calatorii.allCalatorii();
    }

    public boolean existCalatorie(int nr){
        for(Calatorie c:this.allCalatorii())
            if(c.getId()==nr)
                return true;
        return false;
    }

    public Calatorie getCalatorieNr(int nr){
        if(existCalatorie(nr)==true)
            for(Calatorie c:allCalatorii())
                if(c.getId()==nr)
                    return c;
        return null;
    }
}

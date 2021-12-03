import Model.Agent;
import Model.Calatorie;
import Model.Client;
import Repositories.AgentRepository;
import Repositories.CalatorieRepository;
import Repositories.ClientRepository;

public class Main {

    public static void main(String[] args) {
        CalatorieRepository c=new CalatorieRepository();
        //ClientRepository clientRepository=new ClientRepository();
        //clientRepository.insertClient(new Client("ionut","1234"));
        //AgentRepository agentRepository=new AgentRepository();
        //agentRepository.insertAgent(new Agent("dan","12345"));
        c.insertCalatorie(new Calatorie("ionut","6,6,2006,6,6","dan","sinaia"));
    }
}

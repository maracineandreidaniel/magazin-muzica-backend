package Views;

import Controllers.CalatorieController;
import Controllers.ClientController;
import Model.Calatorie;
import Model.Client;

import java.util.Scanner;

public class ViewClient {
    private Scanner scanner;
    private Client client;
    private CalatorieController calatorii;
    private ClientController clienti;


    public ViewClient(Client client){
        this.client=client;
        scanner=new Scanner(System.in);
        clienti=new ClientController();
    }

    private String meniu(){
        String text="";
        text+="Apasati 0 pentru a incheia.\n";
        text+="Apasati tasta 1 pentru a vizualiza toate calatoriile dumneavoastra.\n";
        text+="Apasati tasta 2 pentru a cumpara o calatorie.\n";
        text+="Apasati tasta 3 pentru a anula o calatorie.\n";
        text+="Apasati tasta 4 pentru a edita username-ul.\n";
        text+="Apasati tasta 5 pentru a edita parola.\n";
        text+="Apasati tasta 6 pentru a edita destinatia unei calatorii.\n";
        text+="Apasati tasta 7 pentru a edita data unei calatorii.\n";
        return text;
    }

    public void play() throws Exception {
        System.out.println(meniu());
        boolean run=true;
        while(run){
            int alegere=scanner.nextInt();
            switch (alegere){
                case 0:
                    run=false;
                    break;
                case 1:
                    vizualizareCalatorii();
                    break;
                case 2:
                    cumparaCalatorie();
                    break;
                case 3:
                    anuleazaCalatorie();
                    break;
                case 4:
                    modificaNume();
                    break;
                case 5:
                    modificaParola();
                    break;
                case 6:
                   modificaData();
                    break;
                case 7:
                   modificaDestinatia();
                    break;
            }
        }
    }

    public void vizualizareCalatorii(){
        for(Calatorie c: calatorii.allCalatorii())
            if(c.getClient().equals(client.getNume()))
                System.out.println(c);
    }

    public void cumparaCalatorie(){
        System.out.println("Introdu data la care doresti sa achizitionezi calatoria");
        String data=scanner.next();
        System.out.println("Introdu numele destinatiei pe care vrei sa o iei.");
        String dest=scanner.next();
        Calatorie calatorie=new Calatorie(client.getNume(),data,null,dest);
        calatorii.insert(calatorie);

    }

    public void anuleazaCalatorie(){
        System.out.println("Introdu numarul calatoriei pe care vreti sa o anulati.");
        int nr=scanner.nextInt();
        calatorii.remove(nr);
    }

    public void modificaNume(){
        System.out.println("Introdu noul nume al dvs:");
        String nn=scanner.next();
        clienti.updateNume(client.getNume(),nn);
    }

    public void modificaParola(){
        System.out.println("Introdu noua parola a dvs:");
        String pn=scanner.next();
        clienti.updateParola(client.getNume(),pn);
    }

    public void modificaData(){
        System.out.println("Introdu noua data la care doresti sa achizitionezi calatoria");
        String data=scanner.next();
        System.out.println("Introdu numarul calatoriei pe care vreti sa o editezi.");
        int nr=scanner.nextInt();
        calatorii.updateData(nr,data);
    }

    public void modificaDestinatia(){
        System.out.println("Introdu noua destinatie la care doresti sa achizitionezi calatoria");
        String dest=scanner.next();
        System.out.println("Introdu numarul calatoriei pe care vreti sa o editezi.");
        int nr=scanner.nextInt();
        calatorii.updateDestinatie(nr,dest);
    }


}

package kontroler;

import model.Badanie;
import model.Model;
import model.Pacjent;
import widok.WidokGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ZdarzenieGui implements ActionListener {

    private WidokGui widok = null;
    private Model model = null;

    public static final String DB_URL="jdbc:derby:MojaBazaDanych;create=true";
    public static final String DB_USER="";
    public static final String DB_PASSWORD="";

    /**
     * Konstruktor
     * @param w
     * @param m
     */
    public ZdarzenieGui(WidokGui w, Model m){
        this.widok = w;
        this.model = m;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addRekord")) {

            Pacjent p = this.widok.getPacjent();
            Badanie b = this.widok.getBadanie();

            this.model.add(p,b);

            System.out.println("Pacjent został utworzony");
            System.out.println("Badanie zostało utworzone");

        }
        else{
            System.out.println("Mamy problem!");
        }

        if (e.getActionCommand().equals("dodajBadanie")){
            this.widok.oknoDodaj();

            System.out.println("Wybrano opcję - Dodaj badanie");
        } else {
            System.out.println("Mamy problem!");
        }

        if (e.getActionCommand().equals("przegladajBadania")){
            this.widok.oknoDodaj();

            System.out.println("Wybrano opcję - Przeglądaj");
        } else {
            System.out.println("Mamy problem!");
        }

    }
}

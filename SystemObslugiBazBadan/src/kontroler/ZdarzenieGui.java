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

/**
 * Klasa reprezentująca zdarzenia występujące w aplikacji
 */
public class ZdarzenieGui implements ActionListener {

    private WidokGui widok = null;
    private Model model = null;

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
    }
}

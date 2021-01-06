package kontroler;

import model.Badanie;
import model.Model;
import model.Pacjent;
import widok.WidokGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        if (e.getActionCommand().equals("addRekord")){
            Pacjent p = this.widok.getPacjent();
            Badanie b = this.widok.getBadanie();

            System.out.println("Pacjent został utworzony");
            System.out.println("Badanie zostało utworzone");
        }
        else {
            System.out.println("Mamy problem!");
        }
    }
}

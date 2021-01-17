package kontroler;

import model.Badanie;
import model.Model;
import model.Pacjent;
import widok.WidokGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            if(!model.checkPacjent(p.getPesel())){
                this.model.addPacjent(p);
                this.model.addBadanie(b);
            } else {
                this.model.addBadanie(b);
            }
            this.widok.clearGui();

            System.out.println("Pacjent został utworzony");
            System.out.println("Badanie zostało utworzone");

        }
        else if (e.getActionCommand().equals("checkPacjent")){
                this.widok.setPacjent(this.model.findPacjent(this.widok.getPESEL()));
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

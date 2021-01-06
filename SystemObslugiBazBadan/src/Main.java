import kontroler.ZdarzenieGui;
import model.Model;
import widok.WidokGui;

import javax.swing.SwingUtilities;

/**
 * Klasa startujaca aplikacje
 */
public class Main {
    /**
     * Metoda glowna
     * @param args
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater( new Runnable() {
            public void run()
            {
                //model
                //AppModel m=new AppModel();

                //m.add(new Patient("Jan Kowalski","75101500123",false));
                //m.add(new Patient("Agata Malinowska","70091000453",true));
                //m.add(new Patient("Ktos Inny","11111111111",true));

                //model
                Model m = new Model();

                //widok
                WidokGui w = new WidokGui(m);

                //kontroler
                ZdarzenieGui z =new ZdarzenieGui(w, m);
                w.setController(z);

                w.setVisible(true);
            }
         });
    }
}

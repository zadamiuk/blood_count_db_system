package system;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                WidokGui proba = new WidokGui();
                proba.setVisible(true);
                TworzenieBazy proba2 = new TworzenieBazy();
                proba2.tworzenieBazy();
                proba2.dodanieRekordow();
                System.out.println(proba2);}

        }));
    };
}
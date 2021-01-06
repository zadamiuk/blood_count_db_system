package system;
import javax.swing.*;
import java.awt.*;

public class WidokGui extends JFrame {

    public WidokGui(){
        /*
         * Główny Panel
         */
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        this.getContentPane().add(mainPanel);

        /*
         * Panel do dodawania nowego Pacjenta/ lub istniejącego wyniki badań krwi
         */
        JPanel addPanel = new JPanel();
        addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.X_AXIS));
        mainPanel.add(addPanel);

        /*
         * Lewy Panel odpowiedzialny za dodawanie informacji o Pacjent
         */
        JPanel dodPacjent = new JPanel();
        dodPacjent.setBorder(BorderFactory.createTitledBorder("Dane pacjenta"));
        dodPacjent.setLayout(new BoxLayout(dodPacjent, BoxLayout.Y_AXIS));
        addPanel.add(dodPacjent);

        //Panel PESEL
        JPanel subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodPacjent.add(subpanel);

        JLabel LabelPESEL = new JLabel("PESEL:");
        LabelPESEL.setPreferredSize(new Dimension(90,25));
        LabelPESEL.setMinimumSize(new Dimension(90,25));
        LabelPESEL.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelPESEL);

        JTextField TextPESEL = new JTextField();
        TextPESEL.setPreferredSize(new Dimension(180,20));
        TextPESEL.setMinimumSize(new Dimension(180,20));
        TextPESEL.setMaximumSize(new Dimension(180,20));
        subpanel.add(TextPESEL);

        subpanel.add(Box.createRigidArea(new Dimension(0,40)));

        //Panel Nazwisko
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodPacjent.add(subpanel);

        JLabel LabelNazwisko = new JLabel("Nazwisko:");
        LabelNazwisko.setPreferredSize(new Dimension(90,25));
        LabelNazwisko.setMinimumSize(new Dimension(90,25));
        LabelNazwisko.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelNazwisko);

        JTextField TextNazwisko = new JTextField();
        TextNazwisko.setPreferredSize(new Dimension(180,20));
        TextNazwisko.setMinimumSize(new Dimension(180,20));
        TextNazwisko.setMaximumSize(new Dimension(180,20));
        subpanel.add(TextNazwisko);

        subpanel.add(Box.createRigidArea(new Dimension(0,40)));

        //Panel Imię
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodPacjent.add(subpanel);

        JLabel LabelImie = new JLabel("Imię:");
        LabelImie.setPreferredSize(new Dimension(90,25));
        LabelImie.setMinimumSize(new Dimension(90,25));
        LabelImie.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelImie);

        JTextField TextImie = new JTextField();
        TextImie.setPreferredSize(new Dimension(180,20));
        TextImie.setMinimumSize(new Dimension(180,20));
        TextImie.setMaximumSize(new Dimension(180,20));
        subpanel.add(TextImie);

        subpanel.add(Box.createRigidArea(new Dimension(0,40)));

        //Panel Płeć
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodPacjent.add(subpanel);

        JLabel LabelPlec = new JLabel("Płeć:");
        LabelPlec.setPreferredSize(new Dimension(90,25));
        LabelPlec.setMinimumSize(new Dimension(90,25));
        LabelPlec.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelPlec);

        JTextField TextPlec = new JTextField();
        TextPlec.setPreferredSize(new Dimension(180,20));
        TextPlec.setMinimumSize(new Dimension(180,20));
        TextPlec.setMaximumSize(new Dimension(180,20));
        subpanel.add(TextPlec);

        subpanel.add(Box.createRigidArea(new Dimension(0,40)));

        //Panel Wiek
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodPacjent.add(subpanel);

        JLabel LabelWiek = new JLabel("Wiek:");
        LabelWiek.setPreferredSize(new Dimension(90,25));
        LabelWiek.setMinimumSize(new Dimension(90,25));
        LabelWiek.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelWiek);

        JTextField TextWiek = new JTextField();
        TextWiek.setPreferredSize(new Dimension(180,20));
        TextWiek.setMinimumSize(new Dimension(180,20));
        TextWiek.setMaximumSize(new Dimension(180,20));
        subpanel.add(TextWiek);

        subpanel.add(Box.createRigidArea(new Dimension(0,40)));

        /*
         * Prawy Panel odpowiedzialny za dodawanie informacji o Badanie
         */
        JPanel dodBadanie = new JPanel();
        dodBadanie.setBorder(BorderFactory.createTitledBorder("Wyniki badania"));
        dodBadanie.setLayout(new BoxLayout(dodBadanie, BoxLayout.Y_AXIS));
        addPanel.add(dodBadanie);

        //Panel ID badania
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodBadanie.add(subpanel);

        JLabel LabelIDBadania = new JLabel("ID badania:");
        LabelIDBadania.setPreferredSize(new Dimension(90,25));
        LabelIDBadania.setMinimumSize(new Dimension(90,25));
        LabelIDBadania.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelIDBadania);

        JTextField TextIDBadania = new JTextField();
        TextIDBadania.setPreferredSize(new Dimension(180,20));
        TextIDBadania.setMinimumSize(new Dimension(180,20));
        TextIDBadania.setMaximumSize(new Dimension(180,20));
        subpanel.add(TextIDBadania);

        //Panel Data
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodBadanie.add(subpanel);

        JLabel LabelData = new JLabel("Data:");
        LabelData.setPreferredSize(new Dimension(90,25));
        LabelData.setMinimumSize(new Dimension(90,25));
        LabelData.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelData);

        JTextField TextData = new JTextField();
        TextData.setPreferredSize(new Dimension(180,20));
        TextData.setMinimumSize(new Dimension(180,20));
        TextData.setMaximumSize(new Dimension(180,20));
        subpanel.add(TextData);

        subpanel.add(Box.createRigidArea(new Dimension(0,50)));

        //Panel Leukocyty
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodBadanie.add(subpanel);

        JLabel LabelLeuko = new JLabel("Leukocyty:");
        LabelLeuko.setPreferredSize(new Dimension(90,25));
        LabelLeuko.setMinimumSize(new Dimension(90,25));
        LabelLeuko.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelLeuko);

        JTextField TextLeuko = new JTextField();
        TextLeuko.setPreferredSize(new Dimension(50,20));
        TextLeuko.setMinimumSize(new Dimension(50,20));
        TextLeuko.setMaximumSize(new Dimension(50,20));
        subpanel.add(TextLeuko);

        JLabel LabelLeukoJed = new JLabel("tys/l");
        LabelLeukoJed.setPreferredSize(new Dimension(50,20));
        LabelLeukoJed.setMinimumSize(new Dimension(50,20));
        LabelLeukoJed.setMaximumSize(new Dimension(50,20));
        subpanel.add(LabelLeukoJed);

        //Panel Erytrocyty
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodBadanie.add(subpanel);

        JLabel LabelErytro = new JLabel("Erytrocyty:");
        LabelErytro.setPreferredSize(new Dimension(90,25));
        LabelErytro.setMinimumSize(new Dimension(90,25));
        LabelErytro.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelErytro);

        JTextField TextErytro = new JTextField();
        TextErytro.setPreferredSize(new Dimension(50,20));
        TextErytro.setMinimumSize(new Dimension(50,20));
        TextErytro.setMaximumSize(new Dimension(50,20));
        subpanel.add(TextErytro);

        JLabel LabelErytroJed = new JLabel("tys/l");
        LabelErytroJed.setPreferredSize(new Dimension(50,20));
        LabelErytroJed.setMinimumSize(new Dimension(50,20));
        LabelErytroJed.setMaximumSize(new Dimension(50,20));
        subpanel.add(LabelErytroJed);

        //Panel Trombocyty
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodBadanie.add(subpanel);

        JLabel LabelTrombo = new JLabel("Trombocyty:");
        LabelTrombo.setPreferredSize(new Dimension(90,25));
        LabelTrombo.setMinimumSize(new Dimension(90,25));
        LabelTrombo.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelTrombo);

        JTextField TextTrombo = new JTextField();
        TextTrombo.setPreferredSize(new Dimension(50,20));
        TextTrombo.setMinimumSize(new Dimension(50,20));
        TextTrombo.setMaximumSize(new Dimension(50,20));
        subpanel.add(TextTrombo);

        JLabel LabelTromboJed = new JLabel("tys/l");
        LabelTromboJed.setPreferredSize(new Dimension(50,20));
        LabelTromboJed.setMinimumSize(new Dimension(50,20));
        LabelTromboJed.setMaximumSize(new Dimension(50,20));
        subpanel.add(LabelTromboJed);

        //Panel Monocyty
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodBadanie.add(subpanel);

        JLabel LabelMono = new JLabel("Monocyty:");
        LabelMono.setPreferredSize(new Dimension(90,25));
        LabelMono.setMinimumSize(new Dimension(90,25));
        LabelMono.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelMono);

        JTextField TextMono = new JTextField();
        TextMono.setPreferredSize(new Dimension(50,20));
        TextMono.setMinimumSize(new Dimension(50,20));
        TextMono.setMaximumSize(new Dimension(50,20));
        subpanel.add(TextMono);

        JLabel LabelMonoJed = new JLabel("tys/l");
        LabelMonoJed.setPreferredSize(new Dimension(50,20));
        LabelMonoJed.setMinimumSize(new Dimension(50,20));
        LabelMonoJed.setMaximumSize(new Dimension(50,20));
        subpanel.add(LabelMonoJed);

        //Panel Limfocyty
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodBadanie.add(subpanel);

        JLabel LabelLimfo = new JLabel("Limfocyty:");
        LabelLimfo.setPreferredSize(new Dimension(90,25));
        LabelLimfo.setMinimumSize(new Dimension(90,25));
        LabelLimfo.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelLimfo);

        JTextField TextLimfo = new JTextField();
        TextLimfo.setPreferredSize(new Dimension(50,20));
        TextLimfo.setMinimumSize(new Dimension(50,20));
        TextLimfo.setMaximumSize(new Dimension(50,20));
        subpanel.add(TextLimfo);

        JLabel LabelLimfoJed = new JLabel("tys/l");
        LabelLimfoJed.setPreferredSize(new Dimension(50,20));
        LabelLimfoJed.setMinimumSize(new Dimension(50,20));
        LabelLimfoJed.setMaximumSize(new Dimension(50,20));
        subpanel.add(LabelLimfoJed);

        //Przycisk ,,Zapisz"
        JPanel ButtonZapisz = new JPanel();
        JButton PrzyciskZapisz = new JButton("Zapisz wyniki");
        PrzyciskZapisz.setBackground(Color.decode("#EA6B66"));
        ButtonZapisz.add(PrzyciskZapisz, BorderLayout.CENTER);
        ButtonZapisz.setBorder(BorderFactory.createTitledBorder("Zapisz wyniki"));
        mainPanel.add(ButtonZapisz);



        this.setTitle("Dodawanie informacji");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


    }


}

package widok;

import kontroler.ZdarzenieGui;
import model.Badanie;
import model.Pacjent;
import model.Model;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa odpowiedzialana za widok aplikacji
 */
public class WidokGui extends JFrame {

    private Model model = null;

    private JTextField TextPESEL, TextNazwisko, TextImie, TextPlec, TextWiek, TextIDBadania, TextData, TextLeuko,
                                            TextErytro, TextTrombo, TextMono, TextLimfo;

    private JButton PrzyciskZapisz = null;
    private JButton sprawdzPacjent = null;

    /**
     * Konstruktor
     * @param m
     */
    public WidokGui(Model m){

        this.model = m;

        this.createGui();
    }

    public String getPESEL(){
        return this.TextPESEL.getText();
    }

    /**
     * Metoda tworzaca pacjenta na podstawie pol edycyjnych
     * @return
     */
    public Pacjent getPacjent(){
        Pacjent p = null;

        String PESEL = this.TextPESEL.getText();
        String nazwisko = this.TextNazwisko.getText();
        String imie = this.TextImie.getText();
        String plec = this.TextPlec.getText();
        int wiek = Integer.parseInt(this.TextWiek.getText());

        if(!nazwisko.isBlank() && !plec.isBlank() && !imie.isBlank()){
            p = new Pacjent(PESEL, nazwisko, imie, plec, wiek);
        }

        return(p);
    }

    /**
     * Metoda ustawiająca pola edycyjne na podstawie Pacjenta
     * @param p
     */
    public void setPacjent(Pacjent p){
        if (p!=null){
            this.TextNazwisko.setText(p.getNazwisko());
            this.TextImie.setText(p.getImie());
            this.TextPlec.setText(p.getPlec());
            this.TextWiek.setText(String.valueOf(p.getWiek()));
        }
        else {
            this.TextNazwisko.setText("");
            this.TextImie.setText("");
            this.TextPlec.setText("");
            this.TextWiek.setText("");
        }
    }

    /**
     * Metoda tworzaca badanie na podstawie pol edycyjnych
     */
    public Badanie getBadanie(){
        Badanie b = null;

        String PESEL = this.TextPESEL.getText();
        String dataBadania = this.TextData.getText();
        float leukocyty = Float.parseFloat(this.TextLeuko.getText());
        float erytrocyty = Float.parseFloat(this.TextErytro.getText());
        float trombocyty = Float.parseFloat(this.TextTrombo.getText());
        float monocyty = Float.parseFloat(this.TextMono.getText());
        float limfocyty = Float.parseFloat(this.TextLimfo.getText());

        if (!dataBadania.isBlank()){
            b = new Badanie(PESEL, dataBadania, leukocyty,erytrocyty, trombocyty, monocyty, limfocyty);
        }

        return (b);
    }

    public void oknoDodaj(){
    /**
     * Metoda odpowiedzialna za oczyszczanie pól tekstowych
     */
    public void clearGui(){
        this.TextPESEL.setText(null);
        this.TextNazwisko.setText(null);
        this.TextImie.setText(null);
        this.TextPlec.setText(null);
        this.TextWiek.setText(null);
        this.TextData.setText(null);
        this.TextLeuko.setText(null);
        this.TextErytro.setText(null);
        this.TextTrombo.setText(null);
        this.TextMono.setText(null);
        this.TextLimfo.setText(null);
    }

        /*
         * Panel do dodawania nowego Pacjenta lub Badania
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

        this.TextPESEL = new JTextField();
        this.TextPESEL.setPreferredSize(new Dimension(90,20));
        this.TextPESEL.setMinimumSize(new Dimension(90,20));
        this.TextPESEL.setMaximumSize(new Dimension(90,20));
        subpanel.add(this.TextPESEL);

        this.sprawdzPacjent = new JButton("Sprawdz");
        this.sprawdzPacjent.setActionCommand("checkPacjent");
        this.sprawdzPacjent.setPreferredSize(new Dimension(90,20));
        this.sprawdzPacjent.setMinimumSize(new Dimension(90,20));
        this.sprawdzPacjent.setMinimumSize(new Dimension(90,20));
        subpanel.add(this.sprawdzPacjent);

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

        this.TextNazwisko = new JTextField();
        this.TextNazwisko.setPreferredSize(new Dimension(180,20));
        this.TextNazwisko.setMinimumSize(new Dimension(180,20));
        this.TextNazwisko.setMaximumSize(new Dimension(180,20));
        subpanel.add(this.TextNazwisko);

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

        this.TextImie = new JTextField();
        this.TextImie.setPreferredSize(new Dimension(180,20));
        this.TextImie.setMinimumSize(new Dimension(180,20));
        this.TextImie.setMaximumSize(new Dimension(180,20));
        subpanel.add(this.TextImie);

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

        this.TextPlec = new JTextField();
        this.TextPlec.setPreferredSize(new Dimension(180,20));
        this.TextPlec.setMinimumSize(new Dimension(180,20));
        this.TextPlec.setMaximumSize(new Dimension(180,20));
        subpanel.add(this.TextPlec);

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

        this.TextWiek = new JTextField();
        this.TextWiek.setPreferredSize(new Dimension(180,20));
        this.TextWiek.setMinimumSize(new Dimension(180,20));
        this.TextWiek.setMaximumSize(new Dimension(180,20));
        subpanel.add(this.TextWiek);

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

        this.TextIDBadania = new JTextField();
        this.TextIDBadania.setPreferredSize(new Dimension(180,20));
        this.TextIDBadania.setMinimumSize(new Dimension(180,20));
        this.TextIDBadania.setMaximumSize(new Dimension(180,20));
        subpanel.add(this.TextIDBadania);

        //Panel Data
        subpanel = new JPanel();
        subpanel.setLayout(new BoxLayout(subpanel, BoxLayout.X_AXIS));
        dodBadanie.add(subpanel);

        JLabel LabelData = new JLabel("Data:");
        LabelData.setPreferredSize(new Dimension(90,25));
        LabelData.setMinimumSize(new Dimension(90,25));
        LabelData.setMaximumSize(new Dimension(90,25));
        subpanel.add(LabelData);

        this.TextData = new JTextField();
        this.TextData.setPreferredSize(new Dimension(180,20));
        this.TextData.setMinimumSize(new Dimension(180,20));
        this.TextData.setMaximumSize(new Dimension(180,20));
        subpanel.add(this.TextData);

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

        this.TextLeuko = new JTextField();
        this.TextLeuko.setPreferredSize(new Dimension(50,20));
        this.TextLeuko.setMinimumSize(new Dimension(50,20));
        this.TextLeuko.setMaximumSize(new Dimension(50,20));
        subpanel.add(this.TextLeuko);

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

        this.TextErytro = new JTextField();
        this.TextErytro.setPreferredSize(new Dimension(50,20));
        this.TextErytro.setMinimumSize(new Dimension(50,20));
        this.TextErytro.setMaximumSize(new Dimension(50,20));
        subpanel.add(this.TextErytro);

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

        this.TextTrombo = new JTextField();
        this.TextTrombo.setPreferredSize(new Dimension(50,20));
        this.TextTrombo.setMinimumSize(new Dimension(50,20));
        this.TextTrombo.setMaximumSize(new Dimension(50,20));
        subpanel.add(this.TextTrombo);

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

        this.TextMono = new JTextField();
        this.TextMono.setPreferredSize(new Dimension(50,20));
        this.TextMono.setMinimumSize(new Dimension(50,20));
        this.TextMono.setMaximumSize(new Dimension(50,20));
        subpanel.add(this.TextMono);

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

        this.TextLimfo = new JTextField();
        this.TextLimfo.setPreferredSize(new Dimension(50,20));
        this.TextLimfo.setMinimumSize(new Dimension(50,20));
        this.TextLimfo.setMaximumSize(new Dimension(50,20));
        subpanel.add(this.TextLimfo);

        JLabel LabelLimfoJed = new JLabel("tys/l");
        LabelLimfoJed.setPreferredSize(new Dimension(50,20));
        LabelLimfoJed.setMinimumSize(new Dimension(50,20));
        LabelLimfoJed.setMaximumSize(new Dimension(50,20));
        subpanel.add(LabelLimfoJed);

        //Przycisk ,,Zapisz"
        JPanel ButtonZapisz = new JPanel();
        this.PrzyciskZapisz = new JButton("Zapisz wyniki");
        this.PrzyciskZapisz.setActionCommand("addRekord");
        this.PrzyciskZapisz.setBackground(Color.decode("#EA6B66"));
        ButtonZapisz.add(this.PrzyciskZapisz, BorderLayout.CENTER);
        ButtonZapisz.setBorder(BorderFactory.createTitledBorder("Zapisz wyniki"));
        mainPanel.add(ButtonZapisz);

        this.setTitle("Dodawanie informacji");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public void oknoPrzegladaj(){}

    /**
     * Metoda definiujaca wyglad aplikacji
     */
    private void createGui(){

        /*
         * Panel okna startowego aplikacji
         */
        JFrame homePage = new JFrame("ZUAL");
        homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homePage.setSize(400,250);
        /*
         * Panel tytułowy
         */
        JPanel welcomeMessage = new JPanel();
        welcomeMessage.setSize(250, 150);
        GridLayout opisGrid = new GridLayout(2,1,0,0);
        welcomeMessage.setLayout(opisGrid);

        JLabel ZUAL = new JLabel("ZUAL",SwingConstants.CENTER);
        ZUAL.setPreferredSize(new Dimension(250, 100));
        ZUAL.setFont(new Font("Calibri", Font.PLAIN, 70));
        welcomeMessage.add(ZUAL, BorderLayout.CENTER);
        JLabel systemOpis = new JLabel("System obsługi bazy badań krwi",SwingConstants.CENTER);
        systemOpis.setPreferredSize(new Dimension(250, 50));
        systemOpis.setFont(new Font("Calibri", Font.PLAIN, 25));
        welcomeMessage.add(systemOpis, BorderLayout.CENTER);

        homePage.add(welcomeMessage,BorderLayout.CENTER);

        /*
         * Panel z przyciskami do wyboru funkcji, z której funkcji chce korzystać użytkownik
         */
        JPanel buttons = new JPanel();

        JButton bPrzegladaj = new JButton("Przegladaj");
        bPrzegladaj.setBackground(Color.decode("#EA6B66"));
        bPrzegladaj.setActionCommand("przegladajBadania");
        bPrzegladaj.setMargin(new Insets(5, 10, 5, 10));
        buttons.add(bPrzegladaj, BorderLayout.CENTER);

        JButton bDodaj = new JButton("Dodaj badanie");
        bDodaj.setBackground(Color.decode("#EA6B66"));
        bDodaj.setActionCommand("dodajBadanie");
        bDodaj.setMargin(new Insets(5, 10, 5, 10));
        buttons.add(bDodaj, BorderLayout.CENTER);

        homePage.add(buttons, BorderLayout.SOUTH);
        homePage.setVisible(true);

        //oknoDodaj();
        oknoPrzegladaj();
    }
    public void setController(ZdarzenieGui z) {

        this.PrzyciskZapisz.addActionListener(z);
        this.sprawdzPacjent.addActionListener(z);
    }

}

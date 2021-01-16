package model;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca Model
 */
public class Model {

    /**
     * Przygotowanie do stworzenia systemu bazodanowego Apache Derby - tryb embedded
     */
    public static final String JDBC_DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
    public static final String DB_URL="jdbc:derby:BazaBadan;create=true";
    public static final String DB_USER="";
    public static final String DB_PASSWORD="";

    /**
     * Metoda odpowiedzialna za połaczenie i stworzenie bazy oraz uzupełnienie początkowymi danymi
     */
    public void ConnCreateInsert(){

        /**
         * Rejestrowanie streownika bazy danych
         */
        try
        {
            Class.forName(JDBC_DRIVER);
            System.out.println("Sterownik bazy danych zostal wczytany\n");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Blad przy wczytywaniu sterownika\n");
            e.printStackTrace();
            System.exit(1);
        }

        /*
         * Tworzenie polaczenia z baza danych
         */
        try (Connection conn= DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD))
        {
            System.out.println("Polaczenie z baza danych: " + conn.getMetaData().getURL());

            /*
             * Wykonywanie polecen SQL (tworzenie tabel i dodawanie bazowych informacji)
             */
            try (Statement stmt = conn.createStatement())
            {
                if (!tableExists(conn,"Pacjent"))
                {
                    stmt.execute("CREATE TABLE Pacjent (idPacjent INTEGER NOT NULL PRIMARY KEY " +
                            "GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1)," +
                            "PESEL VARCHAR(128) NOT NULL UNIQUE," +
                            "Nazwisko VARCHAR(128) NOT NULL," +
                            "Imie VARCHAR(128) NOT NULL," +
                            "Plec VARCHAR(1) NOT NULL," +
                            "Wiek INTEGER NOT NULL )");

                    System.out.println("Utworzono tabele Pacjent");
                }

                if (!tableExists(conn,"Badanie"))
                {
                    stmt.execute("CREATE TABLE Badanie (idBadania INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                            "PESELBadanie VARCHAR(128) NOT NULL REFERENCES Pacjent(PESEL)," +
                            "DataBadania VARCHAR(128) NOT NULL," +
                            "Leukocyty FLOAT NOT NULL," +
                            "Erytrocyty FLOAT NOT NULL," +
                            "Trombocyty FLOAT NOT NULL," +
                            "Monocyty FLOAT NOT NULL," +
                            "Limfocyty FLOAT NOT NULL)");


                    System.out.println("Utworzono tabele Badanie");
                }

                //dodawanie informacji do tabeli Pacjent
                stmt.executeUpdate("INSERT INTO Pacjent (PESEL, Nazwisko, Imie, Plec, Wiek) " +
                        "VALUES ('980516','Krakowiak','Aleksandra','K',22)");
                stmt.executeUpdate("INSERT INTO Pacjent (PESEL, Nazwisko, Imie, Plec, Wiek) " +
                        "VALUES ('990205','Adamiuk','Zuzanna','K',21)");

                //dodawanie informacji do tabeli Badanie
                stmt.executeUpdate("INSERT INTO Badanie (PESELBadanie, DataBadania, Leukocyty, " +
                        "Erytrocyty, Trombocyty, Monocyty, LIMFOCYTY)" +
                        "VALUES ('990205','06.01.2020',5,6,7,8,9)");
                stmt.executeUpdate("INSERT INTO Badanie (PESELBadanie, DataBadania, Leukocyty," +
                        "Erytrocyty, Trombocyty, Monocyty, LIMFOCYTY)" +
                        "VALUES ('980516','07.01.2020',2,3,4,5,6)");
            }
            catch (SQLException e)
            {
                System.out.println("Blad przy wykonywaniu polecania\n");
                e.printStackTrace();
            }
        }
        catch (SQLException e)
        {
            System.out.println("Blad przy tworzeniu polaczenia\n");
            e.printStackTrace();
        }
    }

    /**
     * Funkcja sprawdzająca czy istnieje tabela o podanej nazwie
     * @param conn otwarte polaczenie
     * @param tableName nazwa tabeli
     * @return
     * @throws SQLException
     */
    public static boolean tableExists(Connection conn, String tableName) throws SQLException
    {
        boolean exists=false;

        DatabaseMetaData dbmd=conn.getMetaData();

        try (ResultSet rs=dbmd.getTables(null,null,tableName.toUpperCase(),null))
        {
            exists=rs.next();
        }

        return(exists);
    }

    /**
     * Metoda do dodawania obiektów do bazy danych
     * @param p Pacjent
     */
    public void addPacjent(Pacjent p){
        /**
         * Rejestrowanie streownika bazy danych
         */
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Sterownik bazy danych zostal wczytany\n");
        } catch (ClassNotFoundException e) {
            System.out.println("Blad przy wczytywaniu sterownika\n");
            e.printStackTrace();
            System.exit(1);
        }

        /*
         * Tworzenie polaczenia z baza danych
         */
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Polaczenie z baza danych: " + conn.getMetaData().getURL());

            /*
             * Wykonywanie polecen SQL - pobieranie informacji od użytkownika i dodawanie do bazy
             */
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO Pacjent(PESEL, Nazwisko, Imie, Plec, Wiek) " +
                    "VALUES (?,?,?,?,?)")) {
                stmt.setString(1, p.getPesel());
                stmt.setString(2, p.getNazwisko());
                stmt.setString(3, p.getImie());
                stmt.setString(4, p.getPlec());
                stmt.setString(5, String.valueOf(p.getWiek()));

                stmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Blad przy wykonywaniu polecania\n");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Blad przy wykonywaniu polecania\n");
            e.printStackTrace();
        }
    }

    /**
     * Metodado dodawania obiektów do bazy danych
     * @param b Badanie
     */
    public void addBadanie(Badanie b){
        /**
         * Rejestrowanie streownika bazy danych
         */
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Sterownik bazy danych zostal wczytany\n");
        } catch (ClassNotFoundException e) {
            System.out.println("Blad przy wczytywaniu sterownika\n");
            e.printStackTrace();
            System.exit(1);
        }

        /*
         * Tworzenie polaczenia z baza danych
         */
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Polaczenie z baza danych: " + conn.getMetaData().getURL());

            /*
             * Wykonywanie polecen SQL - pobieranie informacji od użytkownika i dodawanie do bazy
             */
            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO Badanie (PESELBadanie, DataBadania, " +
                    "Leukocyty, Erytrocyty, Trombocyty, Monocyty, LIMFOCYTY) VALUES (?,?,?,?,?,?,?)")){
                stmt.setString(1, b.getPesel());
                stmt.setString(2, b.getDataBadania());
                stmt.setString(3, String.valueOf(b.getLeukocyty()));
                stmt.setString(4, String.valueOf(b.getErytrocyty()));
                stmt.setString(5, String.valueOf(b.getTrombocyty()));
                stmt.setString(6, String.valueOf(b.getMonocyty()));
                stmt.setString(7, String.valueOf(b.getLimfocyty()));

                stmt.executeUpdate();

            } catch(SQLException e){
                System.out.println("Blad przy wykonywaniu polecania\n");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Blad przy wykonywaniu polecania\n");
            e.printStackTrace();
        }

    }

    /**
     * Metoda szukajaca czy dany Pacjent istnieje w bazie
     * @param PESEL atrybut szukający
     * @return
     */
    public Pacjent findPacjent(String PESEL){

        Pacjent p = null;

        /**
         * Rejestrowanie streownika bazy danych
         */
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Sterownik bazy danych zostal wczytany\n");
        } catch (ClassNotFoundException e) {
            System.out.println("Blad przy wczytywaniu sterownika\n");
            e.printStackTrace();
            System.exit(1);
        }

        /*
         * Tworzenie polaczenia z baza danych
         */
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            System.out.println("Polaczenie z baza danych: " + conn.getMetaData().getURL());

            /*
             * Wykonywanie polecen SQL - szuka wprowadzonego PESEL
             */
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Pacjent WHERE PESEL =?")){

                stmt.setString(1, PESEL);


                ResultSet rs = stmt.executeQuery();
                if (rs.next() == false) {
                    System.out.println("Taki pacjent jeszcze nie istnieje");
                    return null;
                } else {
                    p = new Pacjent(rs.getString("PESEL"),
                            rs.getString("Nazwisko"), rs.getString("Imie"),
                            rs.getString("Plec"), rs.getInt("Wiek"));
                    System.out.println(p.getNazwisko());
                }

            } catch (SQLException e) {
                System.out.println("Blad przy wykonywaniu polecania\n");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Blad przy wykonywaniu polecania\n");
            e.printStackTrace();
        }
        return p;
    }

    /**
     * Metoda sprawdzajaca czy dany Pacjent istnieje w bazie
     * @param pesel atrybut sprawdzajacy
     * @return
     */
    public boolean checkPacjent(String pesel) {
        if (findPacjent(pesel)!= null) {
            return true;
        }
        return false;
    }

    public Model(){
    }

}

package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Klasa reprezentująca Model
 *
 */
public class Model {

    /**
     * Przygotowanie do stworzenia systemu bazodanowego Apache Derby - tryb embedded
     */
    public static final String JDBC_DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
    public static final String DB_URL="jdbc:derby:MojaBazaTestTEST;create=true";
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


    //void insert(Pacjent p){};

   //Pacjent selectByPesel(String pesel){
       ///return null;
   //};

    //List<Pacjent> selectAll() {
       // return null;
   // }

    //void update(Pacjent p, int id){};

    public Model(){
    }

    private List<Pacjent> pacjentList = new ArrayList<Pacjent>();;
    private List<Badanie> badanieList = new ArrayList<Badanie>();;


    public boolean add(Pacjent p, Badanie b){
        if(!this.pacjentList.contains(p)){
            return(this.pacjentList.add(p) && this.badanieList.add(b));
        }
        return (this.badanieList.add(b));
    }
}

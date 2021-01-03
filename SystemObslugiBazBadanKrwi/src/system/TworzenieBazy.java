package system;

import java.sql.*;
import java.util.Locale;

import org.apache.derby.jdbc.EmbeddedDriver;

public class TworzenieBazy {

    public static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String DB_URL = "jdbc:derby:BazaDanych;create=true";
    public static final String DB_USER = "";
    public static final String DB_PASSWORD = "";

    public static void tworzenieBazy() {

        /*
         * Rejestrowanie sterownika bazy
         */
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Sterownik bazy danych zostal wczytany\n");
        } catch (ClassNotFoundException e) {
            System.out.println("Blad przy wczytywaniu sterownika \n");
            e.printStackTrace();
            System.exit(1);
        }

        /*
         * Tworzenie polaczenia z baza danych
         */
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Polaczenie z baza danych: " + conn.getMetaData().getURL());
            /*
             * Wykonywanie polecen SQL - tworzenie tabel
             */
            try (Statement stmt = conn.createStatement()) {

                if (!tableExists(conn, "Pacjent")) {
                    stmt.execute("CREATE TABLE Pacjent ( PESEL CHAR(11) NOT NULL UNIQUE ," +
                            "Nazwisko VARCHAR(128) NOT NULL, " +
                            "Imie VARCHAR(128) NOT NULL," +
                            "PLEC CHAR(1) NOT NULL," +
                            "Wiek INTEGER NOT NULL)"
                    );

                    System.out.println("Utworzono tabele Pacjent");
                }

                if (!tableExists(conn, "Badanie")) {
                    stmt.execute("CREATE TABLE Badanie ( BadanieID INTEGER NOT NULL PRIMARY KEY " +
                            "GENERATED ALWAYS AS IDENTITY ( START WITH 1, INCREMENT BY 1 )," +
                            "PESEL CHAR(11) NOT NULL REFERENCES Pacjent(PESEL), " +
                            "DataWykonania TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                            "Leukocyty FLOAT NOT NULL," +
                            "Erytrocyty FLOAT NOT NULL," +
                            "Trombocyty FLOAT NOT NULL," +
                            "Monocyty FLOAT NOT NULL," +
                            "Limfocyty  FLOAT NOT NULL)"

                    );

                    System.out.println("Utworzono tabele Badanie");
                }
            } catch (SQLException e) {
                System.out.println("Blad przy wykonywaniu polaczenia\n");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Blad przy tworzeniu polaczenia\n");
            e.printStackTrace();
        }
    }

    public static boolean tableExists(Connection conn, String tableName) throws SQLException {
        boolean exists = false;

        DatabaseMetaData dbmd = conn.getMetaData();
        try (ResultSet rs = dbmd.getTables(null, null, tableName.toUpperCase(), null)) {
            exists = rs.next();
        }

        return (exists);
    }

    public static void dodanieRekordow() {

        /*
         * Rejestrowanie sterownika bazy
         */
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Sterownik bazy danych zostal wczytany\n");
        } catch (ClassNotFoundException e) {
            System.out.println("Blad przy wczytywaniu sterownika \n");
            e.printStackTrace();
            System.exit(1);
        }

        /*
         * Tworzenie polaczenia z baza danych
         */
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Polaczenie z baza danych: " + conn.getMetaData().getURL());

            /*
             * Wykonywanie polecen SQL (wstawianie danych)
             */
            try (Statement stmt = conn.createStatement()) {
                //dodawanie wpisow do tabeli pacjentow (polecenie proste)
                stmt.executeUpdate("INSERT INTO Pacjent (PESEL, Nazwisko, Imie, Plec, Wiek) VALUES " +
                        "('12345678901','Krakowiak','Ola','K', 22)");
                stmt.executeUpdate("INSERT INTO Pacjent (PESEL, Nazwisko, Imie, Plec, Wiek) VALUES " +
                        "('12345678902','Adamiuk','Zuzia','K', 21)");

                //dodawanie wpisow do tabeli badan (polecenie proste)
                stmt.executeUpdate("INSERT INTO Badanie (PESEL, DataWykonania, Leukocyty," +
                        "Erytrocyty, Trombocyty, Monocyty, Limfocyty ) VALUES('12345678901','12','13','14','15'," +
                        "'16', '11')");

            } catch (SQLException e) {
                System.out.println("Blad przy wykonywaniu polecania\n");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Blad przy tworzeniu polaczenia\n");
            e.printStackTrace();
        }

    }
}

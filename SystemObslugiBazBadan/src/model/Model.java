package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Model {

    public static final String JDBC_DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
    public static final String DB_URL="jdbc:derby:MojaBaza;create=true";
    public static final String DB_USER="";
    public static final String DB_PASSWORD="";

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

    public void test(){
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
             * Wykonywanie polecen SQL (tworzenie tabel)
             */
            try (Statement stmt = conn.createStatement())
            {

                //try
                //{
                //	stmt.execute("DROP TABLE Tests");
                //	stmt.execute("DROP TABLE Patients");
                //}
                //catch (Exception e) {}

                if (!tableExists(conn,"Patients"))
                {
                    stmt.execute("CREATE TABLE Patients" +
                            "(" +
                            "PatientId		INTEGER NOT NULL PRIMARY KEY" +
                            "				GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +	//Derby
                            //"				AUTO_INCREMENT," + 	//H2, MySQL
                            "Name			VARCHAR(128) NOT NULL," +
                            "Pesel			CHAR(11) NOT NULL UNIQUE" +
                            ")");

                    System.out.println("Utworzono tabele Patients");
                }

                if (!tableExists(conn,"Tests"))
                {
                    stmt.execute("CREATE TABLE Tests" +
                            "(" +
                            "TestId		INTEGER NOT NULL PRIMARY KEY" +
                            "				GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +	//Derby
                            //"				AUTO_INCREMENT," +	//H2, MySQL
                            "Result		INTEGER NOT NULL," +
                            "PatientId		INTEGER NOT NULL REFERENCES Patients(PatientId)" +
                            ")");

                    System.out.println("Utworzono tabele Tests");
                }
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


}

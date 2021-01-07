package model;

import java.util.ArrayList;
import java.util.List;


public class Model {

    public static final String JDBC_DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
    public static final String DB_URL="jdbc:derby:MojaBazaDanych;create=true";
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


    void insert(Pacjent p){};

   Pacjent selectByPesel(String pesel){
       return null;
   };

    List<Pacjent> selectAll() {
        return null;
    }

    void update(Pacjent p, int id){};


}

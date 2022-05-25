package PaooGame;
import java.sql.*;

/*! \class DataBase
    \brief Defineste notiunea de baza de date

 */
public class DataBase {
    public Connection c ;
    public Statement stmt;
    ResultSet rs;

    public DataBase()
    {
        try
        {
            ///Crearea conexiunii cu baza de date
            Class.forName("org.sqlite.JDBC"); //incarcam driverul
            c = DriverManager.getConnection("jdbc:sqlite:DB.db"); // facem conexiunea cu baza de date.
            stmt = c.createStatement();
            try{
                ///Crearea tabelei
            String sql = "CREATE TABLE DATA" +
                    "(ID INT NOT NULL," +
                    "Life INT NOT NULL," +
                    "Score INT NOT NULL," +
                    "State INT NOT NULL)";
            stmt.execute(sql);}
            catch (SQLException a)
            {
                System.out.println("Tabela din baza de date este deja creata, se va face doar actualizarea acesteia");
                return;
                }
            String sql = "INSERT INTO DATA (ID,lIFE,sCORE,STATE) " +
                        "VALUES (1, 3, 0, 0);";
            stmt.executeUpdate(sql);


            //stmt.close();
            //c.close();
        }
        catch (Exception e)
        {
            //System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Baza de date exista");
        }
    }

    /*! \fn public int getHeroLife()
        \brief Intoarce numarul de vieti ale eroului din baza de date
     */
    public int getHeroLife() throws SQLException {
        rs=stmt.executeQuery("SELECT * FROM DATA;");
        return rs.getInt("Life");
    }

    /*! \fn public void updateHeroLife(int heroLife)
        \brief Actualizeaza numarul de vieti din baza de date

        \param heroLife Numarul de vieti.
     */
    public void updateHeroLife(int heroLife) throws  SQLException {
        String instruction="UPDATE DATA set Life ="+heroLife+" WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }


    /*! \fn public int getHeroScore()
        \brief Intoarce scorul eroului din baza de date
     */
    public int getHeroScore() throws SQLException {
        rs=stmt.executeQuery("SELECT * FROM DATA;");
        return rs.getInt("Score");
    }

    /*! \fn public void updateHeroScore(int heroScore)
        \brief Actualizeaza scorul din baza de date

        \param heroScore Scorul eroului.
     */
    public void updateHeroScore(int heroScore) throws  SQLException {
        String instruction="UPDATE DATA set Score ="+heroScore+" WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }


    /*! \fn public int getCurrentLevel()
        \brief Intoarce flagul corespunzator mape ce trebuie incarcata din baza de date
     */
    public int getCurrentLevel() throws SQLException {
        rs=stmt.executeQuery("SELECT * FROM DATA;");
        return rs.getInt("State");
    }

    /*! \fn public void updateCurrentLevel(int currentLevel)
        \brief Actualizeaza flag-ul pentru nivel din baza de date

        \param currentLevel flag-ul corespunzator nivelului.
     */
    public void updateCurrentLevel(int currentLevel) throws  SQLException {
        String instruction="UPDATE DATA set State ="+currentLevel+" WHERE ID=1;";
        stmt.executeUpdate(instruction);
    }

}

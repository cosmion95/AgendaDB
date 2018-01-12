import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DemoCRUDOperations {

    // 2. define connection params to db
    static final String URL = "jdbc:postgresql://54.93.65.5:5432/cosminp7";
    static final String USERNAME = "fasttrackit_dev";
    static final String PASSWORD = "fasttrackit_dev";

    private boolean check = true;


    public void displayAgenda() throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT nume, telefon FROM agenda");

        while (rs.next()) {
            System.out.print("\n" + rs.getString("nume").trim());
            System.out.print("  -------  ");
            System.out.print(rs.getString("telefon").trim());
        }

        rs.close();
        st.close();
        conn.close();
    }

    public void adaugareAgenda(person p) throws ClassNotFoundException, SQLException {
        // 1. loadg driver, no longer needed in new versions of JDBC\n" +
        Class.forName("org.postgresql.Driver");

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String sql = "INSERT INTO agenda (nume,telefon) VALUES (?,?)";
        PreparedStatement pSt = conn.prepareStatement(sql);
        pSt.setString(1, p.getNume());
        pSt.setString(2, p.getTelefon());

        int rows = pSt.executeUpdate();
        System.out.println(rows + " randuri au fost modificate");

        pSt.close();
        conn.close();

    }

    public void cautareNume(person p) throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String sql = "SELECT nume, telefon from agenda WHERE nume = ?";
        PreparedStatement pSt = conn.prepareStatement(sql);
        pSt.setString(1, p.getNume());

        ResultSet rs = pSt.executeQuery();

        while (rs.next()) {
            System.out.print("\n" + rs.getString("nume").trim());
            System.out.print("  -------  ");
            System.out.print(rs.getString("telefon").trim());
            check = false;
        }

        conn.close();
        pSt.close();
        rs.close();
    }

    public void cautareTelefon(person p) throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String sql = "SELECT nume, telefon from agenda WHERE telefon = ?";
        PreparedStatement pSt = conn.prepareStatement(sql);
        pSt.setString(1, p.getTelefon());

        ResultSet rs = pSt.executeQuery();

        while (rs.next()) {
            System.out.print("\n" + rs.getString("nume").trim());
            System.out.print("  -------  ");
            System.out.print(rs.getString("telefon").trim());
            check = false;
        }

        conn.close();
        pSt.close();
        rs.close();
    }

    public void modificareContact(person p, String numeVechi) throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String sql = "UPDATE agenda SET nume=?, telefon=? WHERE nume=?";
        PreparedStatement pSt = conn.prepareStatement(sql);
        pSt.setString(1, p.getNume());
        pSt.setString(2, p.getTelefon());
        pSt.setString(3, numeVechi);

        int rows = pSt.executeUpdate();
        System.out.println(rows + " randuri au fost modificate");
        if (rows != 0) {
            check = false;
        }

        conn.close();
        pSt.close();
    }

    public void stergereContact(person p) throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String sql = "DELETE FROM agenda WHERE nume=?";
        PreparedStatement pSt = conn.prepareStatement(sql);
        pSt.setString(1, p.getNume());

        int rows = pSt.executeUpdate();
        System.out.println(rows + " randuri au fost modificate");
        if (rows != 0) {
            check = false;
        }

        conn.close();
        pSt.close();
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck() {
        this.check = true;
    }
}
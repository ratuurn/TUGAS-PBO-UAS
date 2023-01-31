import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertBarang {
    static  String jdbc = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/penjualanku";
    static String username = "root";
    static String password = "";
    
    static Connection conn;
    static ResultSet rs;
    static Statement state;
    
    public static void main(String[] args){
    
        try{
           Class.forName(jdbc);
           conn = DriverManager.getConnection(url, username, password);
           
           String query = "insert * from barang";
           state = conn.createStatement();
           rs = state.executeQuery(query);
           int nomor= 0;
           while(rs.next()){
               nomor ++;
           }
           while(rs.next()){
               System.out.println("ID_Barang: "+ rs.getString("ID_barang"));
               System.out.println("Nama Barang: "+ rs.getString("nama_barang"));
               System.out.println("jenis: "+ rs.getString("jenis"));
               System.out.println("ukuran: "+ rs.getString("ukuran"));
               System.out.println("hargaBeli: "+ rs.getString("hargaBeli"));
               System.out.println("hargaJual: "+ rs.getString("hargaJual"));
                System.out.println("Stok: "+ rs.getString("stok_barang"));
               System.out.println("----------------------------------------");
           }
           
        }
        catch(ClassNotFoundException | SQLException ex){
      }
    }
}

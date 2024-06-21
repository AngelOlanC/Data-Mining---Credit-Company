import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDeDatos {
  private Connection connection;
  private PreparedStatement pst;
  private int cnt = 0;

  public BaseDeDatos(String url, String user, String password) {
    try {
      connection = DriverManager.getConnection(url, user, password);
      pst = connection.prepareStatement("INSERT INTO SOLICITANTES VALUES(?,?,?,?,?,?,?,?)");
      System.out.println("Conexión establecida correctamente");
    }
    catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  public void limpiarTabla() {
    try {
      connection.createStatement().executeUpdate("DELETE FROM SOLICITANTES");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void insertarSolicitante(Solicitante solicitante) {
    try {
      pst.setInt(1, solicitante.getEdad());
      pst.setString(2, solicitante.getNivelEstudios());
      pst.setString(3, solicitante.getNivelRenta());
      pst.setString(4, solicitante.getPatrimonio());
      pst.setInt(5, solicitante.getNumeroHijos());
      pst.setInt(6, solicitante.getTamanoCredito());
      pst.setString(7, solicitante.getFuncionario());
      pst.setString(8, solicitante.getFuncionario());
      
      pst.addBatch();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }    
  }

  public void ejecutarActualizacion() {
    try {
      pst.executeBatch();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void cerrarConexion() {
    try {
      connection.close();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}


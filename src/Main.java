import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
  private static Solicitante[] generarDatos(int n) {
    Solicitante[] datos = new Solicitante[n];
    for (int i = 0; i < n; i++) {
      datos[i] = generarSolicitante(); 
    }
    return datos;
  }

  public static Solicitante generarSolicitante() {
    int edad = Rutinas.getEdad();
    String nivelEstudios = Rutinas.getEstudios(edad);
    String nivelRenta = Rutinas.getNivelRenta(edad, nivelEstudios);
    String patrimonio = Rutinas.getPatrimonio(edad, nivelRenta);
    int numeroHijos = Rutinas.getNumeroHijos(nivelRenta);
    int tamanoCredito = Rutinas.getTamanoCredito(nivelRenta);
    String funcionario = Rutinas.getFuncionario(nivelRenta, patrimonio, edad);
    String autorizado = Rutinas.getAutorizado(tamanoCredito, edad, funcionario, nivelEstudios, patrimonio, nivelRenta);
    return new Solicitante(edad, 
                           nivelEstudios, 
                           nivelRenta, 
                           patrimonio, 
                           numeroHijos, 
                           tamanoCredito, 
                           funcionario, 
                           autorizado);
  }

  private static void poblarTablaSQL(Solicitante[] datos) {
    BaseDeDatos bd = new BaseDeDatos("jdbc:sqlserver://localhost:1433;rewriteBatchedStatements=true;databaseName=Mineros;trustServerCertificate=true;loginTimeOut=3", "sa", "Aa252328");
    bd.limpiarTabla();
    for (Solicitante solicitante : datos) {
      bd.insertarSolicitante(solicitante);
    }
    bd.ejecutarActualizacion();
    bd.cerrarConexion();
    System.out.println("SQL Server terminado");
  }

  private static void generarARFF(Solicitante[] datos) {
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/output.arff"))) {
      llenarEncabezadoARFF(bufferedWriter);
      for (Solicitante solicitante : datos) {
        bufferedWriter.write(solicitante.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Escritura en ARFF terminada");
  }

  private static void llenarEncabezadoARFF(BufferedWriter file) {
    String encabezado = "@relation solicitantes\n" +
                        "\n" +
                        "@attribute edad_del_peticionario real\n" +
                        "@attribute nivel_de_estudios {ninguno, licenciatura, posgrado}\n" +
                        "@attribute nivel_de_renta {alto, medio, bajo}\n" +
                        "@attribute patrimonio {alto, medio, bajo}\n" +
                        "@attribute numero_de_hijos real\n" +
                        "@attribute tamano_del_credito real\n" +
                        "@attribute funcionario {si, no}\n" +
                        "@attribute autorizado {si, no}\n" +
                        "\n" +
                        "@data\n";
    try {
      file.write(encabezado);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Solicitante[] datos = generarDatos(100000);
    poblarTablaSQL(datos);
    generarARFF(datos);
  }
}
public class Solicitante {
  private String nivelEstudios, nivelRenta, patrimonio,
                 funcionario, autorizado;
  private int edad, numeroHijos, tamanoCredito;
  public Solicitante(int edad, String nivelEstudios, String nivelRenta, String patrimonio,
                     int numeroHijos, int tamanoCredito, String funcionario, String autorizado) {
    this.edad = edad;
    this.nivelEstudios = nivelEstudios;
    this.nivelRenta = nivelRenta;
    this.patrimonio = patrimonio;
    this.numeroHijos = numeroHijos;
    this.tamanoCredito = tamanoCredito;
    this.funcionario = funcionario;
    this.autorizado = autorizado;
  }

  public int getEdad() {
    return edad;
  }
  public String getNivelEstudios() {
    return nivelEstudios;
  }
  public String getNivelRenta() {
    return nivelRenta;
  }
  public String getPatrimonio() {
    return patrimonio;
  }
  public int getNumeroHijos() {
    return numeroHijos;
  }
  public int getTamanoCredito() {
    return tamanoCredito;
  }
  public String getFuncionario() {
    return funcionario;
  }
  public String getAutorizado() {
    return autorizado;
  }

  @Override
  public String toString() {
    return edad + "," + nivelEstudios + "," + nivelRenta + "," + patrimonio + "," + numeroHijos + "," + tamanoCredito + "," + funcionario + "," + autorizado + "\n";
  }
}

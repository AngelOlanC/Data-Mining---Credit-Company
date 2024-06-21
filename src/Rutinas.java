import java.util.Random;

public class Rutinas {
  private static Random rnd = new Random();

  public static int getEdad() {
    return rnd.nextInt(20, 61);
  }

  public static String getEstudios(int edad) {
    int r = rnd.nextInt(1, 101);
    if (edad <= 23) {
      if (r == 1) {
        return Constantes.POSGRADO;
      }
      if (r <= 80) {
        return Constantes.LICENCIATURA;
      }
      return Constantes.NINGUNO;
    }
    if (edad <= 40) {
      if (r <= 5) {
        return Constantes.POSGRADO;
      }
      if (r <= 70) {
        return Constantes.LICENCIATURA;
      }
      return Constantes.NINGUNO;
    }
    if (r <= 2) {
      return Constantes.POSGRADO;
    }
    if (r <= 30) {
      return Constantes.POSGRADO;
    }
    return Constantes.NINGUNO;
  }

  public static String getNivelRenta(int edad, String nivelEstudios) {
    int r = rnd.nextInt(1, 101);
    if (edad <= 40) {
      if (nivelEstudios.equals(Constantes.LICENCIATURA) || nivelEstudios.equals(Constantes.POSGRADO)) {
        if (r <= 30) {
          return Constantes.BAJO;
        }
        if (r <= 90) {
          return Constantes.MEDIO;
        }
        return Constantes.ALTO;
      }
      if (r <= 40) {
        return Constantes.BAJO;
      }
      if (r <= 95) {
        return Constantes.MEDIO;
      }
      return Constantes.ALTO;
    }
    if (nivelEstudios.equals(Constantes.LICENCIATURA) || nivelEstudios.equals(Constantes.POSGRADO)) {
      if (r <= 10) {
        return Constantes.BAJO;
      }
      if (r <= 75) {
        return Constantes.MEDIO;
      }
      return Constantes.ALTO;
    }
    if (r <= 78) {
      return Constantes.BAJO;
    }
    if (r <= 98) {
      return Constantes.MEDIO;
    }
    return Constantes.ALTO;
  }

  public static String getPatrimonio(int edad, String nivelRenta) {
    int r = rnd.nextInt(1, 101);
    if (edad <= 35) {
      if (nivelRenta.equals(Constantes.ALTO) || nivelRenta.equals(Constantes.MEDIO)) {
        if (r <= 30) {
          return Constantes.BAJO;
        }
        if (r <= 65) {
          return Constantes.MEDIO;
        }
        return Constantes.ALTO;
      }
      if (r <= 75) {
        return Constantes.BAJO;
      }
      if (r <= 98) {
        return Constantes.MEDIO;
      }
      return Constantes.ALTO;
    }
    if (nivelRenta.equals(Constantes.ALTO) || nivelRenta.equals(Constantes.MEDIO)) {
      if (r <= 20) {
        return Constantes.BAJO;
      }
      if (r <= 70) {
        return Constantes.MEDIO;
      }
      return Constantes.ALTO;
    }
    if (r <= 90) {
      return Constantes.BAJO;
    }
    if (r <= 99) {
      return Constantes.MEDIO;
    }
    return Constantes.ALTO;
  }
    

  public static int getNumeroHijos(String nivelRenta) {
    if (nivelRenta.equals(Constantes.BAJO)) {
      return rnd.nextInt(1, 7);
    }
    return rnd.nextInt(0, 4);
  }

  public static int getTamanoCredito(String nivelRenta) {
    if (nivelRenta.equals(Constantes.BAJO)) {
      return rnd.nextInt(500, 20000);
    }
    return rnd.nextInt(500, 100000);
  }

  public static String getFuncionario(String nivelRenta, String patrimonio, int edad) {
    int r = rnd.nextInt(1, 101);
    if (nivelRenta.equals(Constantes.BAJO)) {
      if (patrimonio.equals(Constantes.BAJO)) {
        return decisionBinaria(r, 80);
      }
      if (edad <= 25) {
        return decisionBinaria(r, 25);
      }
      return decisionBinaria(r, 40);
    }
    return decisionBinaria(r, 10);
  }

  public static String getAutorizado(int credito, int edad, String funcionario,
                                      String nivelEstudios, String patrimonio, String nivelRenta) {
    int r = rnd.nextInt(1, 101);
    if (credito <= 30000) {
      if (funcionario.equals(Constantes.NO)) {
        if (edad >= 55) {
          return decisionBinaria(r, 95);
        }
        if (patrimonio.equals(Constantes.BAJO) || patrimonio.equals(Constantes.MEDIO)) {
          return decisionBinaria(r, 80);
        }
        return decisionBinaria(r, 50);
      }
      if (nivelEstudios.equals(Constantes.NINGUNO)) {
        if (nivelRenta.equals(Constantes.BAJO)) {
          return decisionBinaria(r, 65);
        }
        return decisionBinaria(r, 30);
      }
      if (nivelRenta.equals(Constantes.BAJO)) {
        return decisionBinaria(r, 60);
      }
      return decisionBinaria(r, 15);
    }
    if (credito <= 60000) {
      if (funcionario.equals(Constantes.NO)) {
        if (edad >= 50) {
          return decisionBinaria(r, 95);
        }
        if (nivelRenta.equals(Constantes.ALTO)) {
          return decisionBinaria(r, 25);
        }
        if (patrimonio.equals(Constantes.ALTO)) {
          return decisionBinaria(r, 20);
        }
        return decisionBinaria(r, 70);
      }
      if (nivelRenta.equals(Constantes.MEDIO) || nivelRenta.equals(Constantes.ALTO)) {
        return decisionBinaria(r, 10);
      }
      if (nivelEstudios.equals(Constantes.LICENCIATURA) || nivelEstudios.equals(Constantes.POSGRADO)) {
        return decisionBinaria(r, 40);
      }
      return decisionBinaria(r, 80);
    }
    if (funcionario.equals(Constantes.NO)) {
      if (edad >= 40) {
        return decisionBinaria(r, 95);
      }
      if (nivelRenta.equals(Constantes.ALTO)) {
        return decisionBinaria(r, 35);
      }
      if (patrimonio.equals(Constantes.ALTO)) {
        return decisionBinaria(r, 30);
      }
      return decisionBinaria(r, 80);
    }
    if (nivelRenta.equals(Constantes.ALTO)) {
      return decisionBinaria(r, 10);
    }
    if (nivelRenta.equals(Constantes.MEDIO)) {
      return decisionBinaria(r, 25);
    }
    if (nivelEstudios.equals(Constantes.LICENCIATURA) || nivelEstudios.equals(Constantes.POSGRADO)) {
      return decisionBinaria(r, 60);
    }
    return decisionBinaria(r, 90);
  }

  private static String decisionBinaria(int valor, int porcentajeNo) {
    return valor <= porcentajeNo ? Constantes.NO : Constantes.SI;
  }
}

package proyectofinal;
/* Alejandra Durán 😎✌🏻 - Erick Peña 😎✌🏻 - 13rian Vargas 😎✌🏻 */

import java.util.Scanner;
import java.util.ArrayList; //Para usar las listas.

class Main {
  static Scanner sc = new Scanner(System.in);

  // Creación de matrices de horarios para uso global.
  static String[][] horarioDuran = new String[4][6];
  static String[][] horarioPeña = new String[4][6];
  static String[][] horarioVargas = new String[4][6];
  static String nombreP;
  static long telefonoP;// Se usa long para recibir 10 dígitos.
  static String dias[] = { "         ", " Lunes ", " Martes", "Miércoles", "Jueves ", "Viernes " };
  static String horas[] = { "8AM-10AM ", "10AM-12M ", " 12M-2PM ", " 3PM-5PM " };
  static int dia = 0;
  static int hora = 0;
  static String doc = "Dr. Pepito";

  public static void main(String[] args) {
    System.out.println("\nClínica de Cardiología.");
    menu();
  }// cierra main ✅

  public static void menu() {
    System.out.println("\n> > > MENU < < <");
    System.out.println("Seleccione una opción:");
    System.out.println("(1) Revisar signos vitales.");
    System.out.println("(2) Agendar cita médica");
    System.out.println("(3) Salir.");

    int opcion = sc.nextInt();

    switch (opcion) {
      case 1:
        calcularSignos(); // Quitamos datos del paciente porque queremos que calcularSignos() sea una función rápida.
        break;
      case 2:
        datosPaciente();
        seleccionarDoctor();
        break;
      case 3:
        System.out.println("\nGracias por preferirnos!");
        System.exit(0);
        break;
      default:
        System.out.println("\n¡ ¡ ¡ Debe seleccionar una opción válida. Intente de nuevo. ! ! !");
        menu();
        break;
    }// cierra switch
  }// cierra menu ✅

  public static void datosPaciente() {
    sc.nextLine(); // Limpia el buffer.

    do {
      System.out.println("\nNombre del paciente:");
      nombreP = sc.nextLine().toUpperCase();
    } while (nombreP.isEmpty()); // Verifica si se ingresó un nombre.
    // cierra do-while.

    int edadP;
    do {
      System.out.println("\nEdad del paciente en años (por ejemplo: 40):");
      while (!sc.hasNextInt()) { // !hasNextInt() verifica si es un número entero "no hay un próximo entero".
        System.out.println("\n\n¡Debe ingresar un número entero para la edad!");
        sc.nextLine(); // Limpia el buffer.
      } // cierra while
      edadP = sc.nextInt();
      if (edadP <= 0 || edadP > 150) { // Verifica si la edad está fuera del rango.
        System.out.println("\n\n¡La edad debe estar entre 0 y 150 años!");
      } // cierra if
    } while (edadP <= 0 || edadP > 150); // Continua si la edad esté fuera del rango.
    // cierra do-while

    double pesoP;
    do {
      System.out.println("\nPeso del paciente en kilogramos (kg) (por ejemplo: 70.5):");
      while (!sc.hasNextDouble()) {// !hasNextDouble() verifica si es un número racional "no hay un próximo
                                   // racional".
        System.out.println("\n\n¡Debe ingresar un número para el peso!");
        sc.nextLine(); // Limpia el buffer.
      } // cierra while
      pesoP = sc.nextDouble();
      if (pesoP < 2.5 || pesoP > 365) { // Verifica si el peso está fuera del rango.
        System.out.println("\n¡El peso debe estar entre 2.5kg y 365kg!");
      } // cierra if
    } while (pesoP < 2.5 || pesoP > 365); // Continua si el peso esté fuera del rango.
    // cierra do-while

    int alturaP;
    do {
      System.out.println("\nAltura del paciente en centímetros (cm) (por ejemplo: 150):");
      while (!sc.hasNextInt()) {// !hasNextInt() verifica si es un número entero "no hay un próximo entero".
        System.out.println("\n\n¡Debe ingresar un número entero para la altura!");
        sc.nextLine(); // Limpia el buffer.
      } // cierra while
      alturaP = sc.nextInt();
      if (alturaP < 46 || alturaP > 215) { // Verifica si la altura está fuera del rango.
        System.out.println("\n¡La altura debe estar entre 46cm y 215cm!");
      } // cierra if
    } while (alturaP < 46 || alturaP > 215); // Continua si la altura está fuera del rango.
    // cierra do-while

    sc.nextLine(); // Limpia el buffer.

    String generoP = ""; // Establecemos vacio.
    while (!(generoP.equalsIgnoreCase("F") || generoP.equalsIgnoreCase("M"))) { // Verifica si es F o M.
      do {
        System.out.println("\nGénero del paciente (F) Femenino, (M) Masculino:");
        generoP = sc.nextLine().toUpperCase();// Convierte la entrada a mayúsculas para comparar.
      } while (generoP.isEmpty()); // Verifica si se ingresó un dato.
      // cierra do-while
    } // cierra while

    String tipoSangreP = "";
    while (!(tipoSangreP.equalsIgnoreCase("A+") || tipoSangreP.equalsIgnoreCase("A-")
        || tipoSangreP.equalsIgnoreCase("AB+") || tipoSangreP.equalsIgnoreCase("AB-")
        || tipoSangreP.equalsIgnoreCase("B+") || tipoSangreP.equalsIgnoreCase("B-")
        || tipoSangreP.equalsIgnoreCase("O+") || tipoSangreP.equalsIgnoreCase("O-"))) { // Verifica tipo de sangre.
      do {
        System.out.println("\nTipo de sangre del paciente (por ejemplo: AB+):");
        tipoSangreP = sc.nextLine().toUpperCase();// Convierte la entrada a mayúsculas para comparar.
      } while (tipoSangreP.isEmpty()); // Verifica si se ingresó un dato.
      // cierra do-while
    } // cierra while

    String direccionP;
    do {
      System.out.println("\nDirección de residencia:");
      direccionP = sc.nextLine();
    } while (direccionP.isEmpty()); // Verifica si se ingresó un dato.
    // cierra do-while

    sc.nextLine(); // Limpia el buffer.

    do {
      System.out.println("\nTeléfono:");
      while (!sc.hasNextLong()) {// !hasNextInt() verifica si es un número entero "no hay un próximo entero".
        System.out.println("\n\n¡Debe ingresar un número entero para el teléfono!");
        sc.nextLine(); // Limpia el buffer.
      } // cierra while
      telefonoP = sc.nextLong();
    } while (telefonoP <= 0); // Verifica que sea un número positivo.
    // cierra do-while

    System.out.println("\n\n¡Paciente registrado con éxito!\n");

  }// cierra datosPaciente ✅

  public static void calcularSignos() {
    System.out.println(
        "\n\nSeleccione una opción: \n(1) Ver estado de tensión arterial \n(2) Ver estado de frecuencia cardiaca \n(3) Ver estado de frecuencia respiratoria \n(4) Ver estado de temperatura \n(5) Ver estado de glucosa \n(6) Ver estado de saturación de oxigeno \n(7) Cancelar ");

    int opcion = sc.nextInt();

    switch (opcion) {
      case 1:
        int sistolica = 0, diastolica = 0;

        do {
          System.out.println("\nIngrese valores de la tensión arterial.");
          System.out.println("Sistólica:");
          sistolica = sc.nextInt();
          System.out.println("Diastólica:");
          diastolica = sc.nextInt();

          if (sistolica < 0 || diastolica < 0) {
            System.out.println("Por favor ingrese valores válidos.");
          }
        } while (sistolica < 0 || diastolica < 0);

        if (sistolica < 80 && diastolica < 60) {
          System.out.println("Se encuentra hipotenso.");
        } else if (sistolica <= 120 && sistolica >= 80 && diastolica <= 85 && diastolica >= 80) {
          System.out.println("Se encuentra normal");
        } else if (sistolica <= 139 && sistolica >= 130 && diastolica <= 90 && diastolica >= 85) {
          System.out.println("La tensión arterial se encuentra alta.");
        } else {
          System.out.println("Se encuentra hipertenso.");
        }
        break;
      case 2:
        System.out.println("\nIngrese valores de la frecuencia cardiaca.");
        int frecuenciac = sc.nextInt();
        if (frecuenciac >= 60 && frecuenciac <= 100) {
          System.out.println("Se encuentra en estado normal.");
        } else if (frecuenciac < 60) {
          System.out.println("Se encuentra en estado de bradicardia.");
        } else {
          System.out.println("Se encuentra en estado de taquicardia.");
        }
        break;
      case 3:
        System.out.println("\nIngrese valores de la frecuencia respiratoria por minuto.");
        int frecuenciar = sc.nextInt();
        if (frecuenciar >= 12 && frecuenciar <= 21) {
          System.out.println("Se encuentra en estado normal.");
        } else if (frecuenciar < 12) {
          System.out.println("Se encuentra en estado de bradiapnea.");

        } else {
          System.out.println("Se encuentra en estado de taquiapnea.");
        }
        break;
      case 4:
        System.out.println("\nIngrese valores de la temperatura.");
        double temperatura = sc.nextDouble();
        if (temperatura >= 36 && temperatura <= 37.5) {
          System.out.println("Se encuentra en estado normal.");
        } else if (temperatura < 36) {
          System.out.println("Se encuentra en estado de hipotermia.");
        } else if (temperatura >= 37.6 && temperatura <= 41) {
          System.out.println("Se encuentra en estado de fiebre.");
        } else {
          System.out.println("Se encuentra en estado de hipertermia.");
        }
        break;
      case 5:
        System.out.println("\nIngrese valores de la glucosa(ayunas).");
        double glucosa = sc.nextDouble();
        if (glucosa >= 60 && glucosa <= 110) {
          System.out.println("Se encuentra en estado normal.");
        } else if (glucosa < 60) {
          System.out.println("Se encuentra en estado de hipoglucemia.");

        } else {
          System.out.println("Se encuentra en estado de hiperglicemia.");
        }
        break;
      case 6:
        boolean pacienteSaturado = false;
        while (!pacienteSaturado) {
          System.out.println("\nIngrese valores de la saturación de oxígeno:");
          double saturacion = sc.nextDouble();

          if (saturacion >= 90 && saturacion <= 99) {
            System.out.println("El paciente está normal.");
            pacienteSaturado = true;
          } else if (saturacion < 90) {
            System.out.println("El paciente está en estado de hipoxia.");

          } else {
            System.out.println("El valor ingresado no es válido.");

          }// cierre else
        } // cierre while
        break;
        case 7:
          System.exit(0);
          break;
        default:
        System.out.println("Debe ingresar un valor válido!");
        break;
    } // cierre switch

  } // cierra calcularSignos ✅

  public static ArrayList<String> doctores() { /* crea la lista de doctores */
    ArrayList<String> cardiologos = new ArrayList<String>();
    // Lista de cardiologos.
    cardiologos.add("Dra. Durán");
    cardiologos.add("Dr. Peña");
    cardiologos.add("Dr. Vargas");
    return cardiologos;
  }// cierra doctores ✅

  public static void printDoctores() { /* metodo para imprimir lista de doctores */
    ArrayList<String> listaDoctores = doctores();
    System.out.println("\nLista de doctores:");
    for (int i = 0; i < listaDoctores.size(); i++) {
      System.out.println("(" + (i + 1) + ") " + listaDoctores.get(i));
    } // cierra for
  }// cierra printDoctores ✅

  public static void citasDuran() {
    // Inicializar los elementos del arreglo horarioVargas
    for (int i = 0; i < horarioDuran.length; i++) {
      for (int j = 0; j < horarioDuran[i].length; j++) {
        if (j == 0) {
          horarioDuran[i][j] = horas[i];
        } else {
          horarioDuran[i][j] = "   ✔   ️"; // entienda ✔ como "disponible".
        }
      } // cierra for j
    } // cierra for i

    // Imprimir los días de la semana
    for (int i = 0; i < dias.length; i++) {
      System.out.print(dias[i] + " ");
    }
    System.out.println("");

    // Imprimir el horario
    for (int i = 0; i < horarioDuran.length; i++) {
      for (int j = 0; j < horarioDuran[i].length; j++) {
        System.out.print(horarioDuran[i][j] + " ");
      } // cierra for j
      System.out.println("");
    } // cierra for i
  }// cierra citasDuran ✅

  public static void citasPeña() {
    // Inicializar los elementos del arreglo horarioPeña
    for (int i = 0; i < horarioPeña.length; i++) {
      for (int j = 0; j < horarioPeña[i].length; j++) {
        if (j == 0) {
          horarioPeña[i][j] = horas[i];
        } else {
          horarioPeña[i][j] = "   ✔   ️"; // entienda ✔ como "disponible".
        }
      } // cierra for j
    } // cierra for i

    // Imprimir los días de la semana
    for (int i = 0; i < dias.length; i++) {
      System.out.print(dias[i] + " ");
    }
    System.out.println("");

    // Imprimir el horario
    for (int i = 0; i < horarioPeña.length; i++) {
      for (int j = 0; j < horarioPeña[i].length; j++) {
        System.out.print(horarioPeña[i][j] + " ");
      } // cierra for j
      System.out.println("");
    } // cierra for i
  }// cierra citasPeña ✅

  public static void citasVargas() {

    // Declarar variable de tipo String
    String dias[] = { "    x    ", " Lunes ", " Martes", "Miércoles", "Jueves ", "Viernes " };
    String horas[] = { "8AM-10AM ", "10AM-12M ", " 12M-2PM ", " 3PM-5PM " };

    // Inicializar los elementos del arreglo horarioVargas
    for (int i = 0; i < horarioVargas.length; i++) {
      for (int j = 0; j < horarioVargas[i].length; j++) {
        if (j == 0) {
          horarioVargas[i][j] = horas[i];
        } else {
          horarioVargas[i][j] = "   ✔   ️"; // entienda 0 como "disponible" y 1 como "ocupado".
        }
      } // cierra for j
    } // cierra for i

    // Imprimir los días de la semana
    for (int i = 0; i < dias.length; i++) {
      System.out.print(dias[i] + " ");
    }
    System.out.println("");

    // Imprimir el horario
    for (int i = 0; i < horarioVargas.length; i++) {
      for (int j = 0; j < horarioVargas[i].length; j++) {
        System.out.print(horarioVargas[i][j] + " ");
      } // cierra for j
      System.out.println("");
    } // cierra for i

  }// cierra citasVargas ✅

  public static void seleccionarDoctor() {
    printDoctores();
    System.out.println("(4) Cancelar."); // Añade la opción de salida según el tamaño de la lista de doctores.
    System.out.println("\n\nSeleccione el doctor a consultar horario:");
    int opcionDr = sc.nextInt();
    sc.nextLine(); // Limpia el buffer.

    switch (opcionDr) {
      case 1:
        doc = "Dra. Durán";
        citasDuran();
        seleccionarDia();
        break;
      case 2:
        doc = "Dr. Peña";
        citasPeña();
        seleccionarDia();
        break;
      case 3:
        doc = "Dr. Vargas";
        citasVargas();
        seleccionarDia();
        break;
      case 4:
        System.out.println("\nGracias por preferirnos!");
        System.exit(0);
        break;
      default:
        System.out.println("\nDoctor no encontrado. Intente de nuevo!");
        seleccionarDoctor();
        break;
    }// cierra switch
  }// cierra seleccionarDoctor ✅

  public static void seleccionarDia() {
    System.out.println("\nSeleccione el día de la semana.");
    System.out.println("(1) Lunes.");
    System.out.println("(2) Martes.");
    System.out.println("(3) Miércoles.");
    System.out.println("(4) Jueves.");
    System.out.println("(5) Viernes.");
    System.out.println("(6) Cancelar.");

    int opcionDia = sc.nextInt();

    switch (opcionDia) {
      case 1:
        System.out.println("Lunes seleccionado.");
        dia = 1;
        seleccionarHora();
        break;
      case 2:
        System.out.println("Martes seleccionado.");
        dia = 2;
        seleccionarHora();
        break;
      case 3:
        System.out.println("Miércoles seleccionado.");
        dia = 3;
        seleccionarHora();
        break;
      case 4:
        System.out.println("Jueves seleccionado.");
        dia = 4;
        seleccionarHora();
        break;
      case 5:
        System.out.println("Viernes seleccionado.");
        dia = 5;
        seleccionarHora();
        break;
      case 6:
        System.out.println("\nGracias por preferirnos!");
        System.exit(0);
        break;
      default:
        System.out.println("\nDía incorrecto. Intente de nuevo!");
        seleccionarDia();
        break;
    }// cierra switch
  }// cierra seleccionarDia ✅

  public static void seleccionarHora() {
    System.out.println("\nSeleccione franja horaria.");
    System.out.println("(1) (8AM-10AM)");
    System.out.println("(2) (10AM-12M)");
    System.out.println("(3) (12M-2PM)");
    System.out.println("(4) (3PM-5PM)");
    System.out.println("(5) (Cancelar)");

    int opcionHora = sc.nextInt();

    switch (opcionHora) {
      case 1:
        hora = 1;
        datosCita();
        break;
      case 2:
        hora = 2;
        datosCita();
        break;
      case 3:
        hora = 3;
        datosCita();
        break;
      case 4:
        hora = 5;// la hora 4 es el almuerzo.
        datosCita();
        break;
      case 5:
        System.out.println("\nGracias por preferirnos!");
        System.exit(0);
        break;
      default:
        System.out.println("\nHora incorrecta. Intente de nuevo!");
        seleccionarHora();
        break;
    }// cierra switch
  }// cierra seleccionarHora ✅

  public static void datosCita() {
    if (doc.equalsIgnoreCase("Dra. Durán")) { /* Aquí se gestiona el agendamiento. */
      for (int i = 0; i < horarioDuran.length; i++) {
        for (int j = 0; j < horarioDuran[i].length; j++) {
          if (i == hora && j == dia) {
            horarioDuran[i - 1][j] = "   ✖️   ️️";
          } // cierra if
        } // cierra for j
      } // cierra for i
      /* Aqui lo imprimo para verificar, luego se borra. */
      for (int i = 0; i < horarioDuran.length; i++) {
        for (int j = 0; j < horarioDuran[i].length; j++) {
          System.out.print(horarioDuran[i][j] + " ");
        } // cierra for j
        System.out.println("");
      } // cierra for i
    } else if (doc.equalsIgnoreCase("Dr. Peña")) { /* Aquí se gestiona el agendamiento. */
      for (int i = 0; i < horarioPeña.length; i++) {
        for (int j = 0; j < horarioPeña[i].length; j++) {
          if (i == hora && j == dia) {
            horarioPeña[i - 1][j] = "   ✖️   ️️";
          } // cierra if
        } // cierra for j
      } // cierra for i
      /* Aqui lo imprimo para verificar, luego se borra. */
      for (int i = 0; i < horarioPeña.length; i++) {
        for (int j = 0; j < horarioPeña[i].length; j++) {
          // System.out.print(dias[i] + " ");//OJO
          System.out.print(horarioPeña[i][j] + " ");
        } // cierra for j
        System.out.println("");
      } // cierra for i
    } else if (doc.equalsIgnoreCase("Dr. Vargas")) { /* Aquí se gestiona el agendamiento. */
      for (int i = 0; i < horarioVargas.length; i++) {
        for (int j = 0; j < horarioVargas[i].length; j++) {
          if (i == hora && j == dia) {
            horarioVargas[i - 1][j] = "   ✖️   ️️";
          } // cierra if
        } // cierra for j
      } // cierra for i
      /* Aqui lo imprimo para verificar, luego se borra. */
      for (int i = 0; i < horarioVargas.length; i++) {
        for (int j = 0; j < horarioVargas[i].length; j++) {
          System.out.print(horarioVargas[i][j] + " ");
        } // cierra for j
        System.out.println("");
      } // cierra for i
    } // cierra if
    mostrarCita();

  }// cierra datosCita ✅

  public static void mostrarCita() {
    System.out.println("\n\nCita agendada con exito!\n\n" + nombreP + ", usted agendó una cita para el día" + dias[dia] + " en el rango de " + horas[hora]
        + "con el/la " + doc + ".\nSe le enviará un mensaje de texto al número " + telefonoP + ".");

  }// cierra mostrarCita ️✅

}// cierra class ✅
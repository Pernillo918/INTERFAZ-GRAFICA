package proyecto1;

import Objetos.*;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.DarkStar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class PROYECTO1 {

    static profesores[] profes = new profesores[50];
    static int contador_profes = 0;
    static int contadorhombres = 0;
    static int contadormujeres = 0;
    static int contadorhombresa = 0;
    static int contadormujeresa = 0;
    static String identificar;

    public static void main(String[] args) {
        
        try {
          //  Plastic3DLookAndFeel.setPlasticTheme(new DarkStar());
   // UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
} catch (Exception e) {
    e.printStackTrace();
}

      Login login = new Login();
 
      // Panel menu = new Panel();
      //Modulo_profesor  ventana = new Modulo_profesor();
       //Curso_admin ventana = new Curso_admin ();
       
      
    }

    public static void AgregarPersona(profesores Profes) {
        if (contador_profes < profes.length) {
            profes[contador_profes] = Profes;
            contador_profes++;
        } else {
            System.out.println("Ya llegaste al limite de Profesores");
        }

    }

    // METODO PARA CONVERTIR MI ARREGLO DE OBJETOS A UN OBJECT[][]
    public static Object[][] convertirDatos() {

        int filas = contador_profes;
        Object[][] arreglo = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            arreglo[i][0] = profes[i].getCodigo();
            arreglo[i][1] = profes[i].getNombre();
            arreglo[i][2] = profes[i].getApellido();
            arreglo[i][3] = profes[i].getCorreo();
            arreglo[i][4] = profes[i].getGenero();

           
        }
        return arreglo;

    }

    //METODO PARA ELIMINAR UN PROFESOR
    public static void Eliminar(int codigo) {
        boolean encontrado = false;
        for (int i = 0; i < contador_profes; i++) {
            if (profes[i].getCodigo() == codigo) {
                correr(i);

             
                encontrado = true;
            }

        }
        if (encontrado == true) {

        } else {
            JOptionPane.showMessageDialog(null, "El Profesor no existe");
        }

    }

    //METODO PARA CORRER LOS DATOS
    public static void correr(int x) {
        for (int j = x; j < contador_profes; j++) {
            profes[j] = profes[j + 1];

        }
        contador_profes--;
    }

    //METODO PARA ACTUALIZAR DATOS 
    public static void ActualizarP(int codigo, String nombre, String apellido, String correo, String contraseña, String genero) {
        for (int i = 0; i < contador_profes; i++) {
            if (profes[i].getCodigo() == codigo) {
                profes[i].setNombre(nombre);
                profes[i].setApellido(apellido);
                profes[i].setCorreo(correo);
                profes[i].setContraseña(contraseña);
                profes[i].setGenero(genero);

            }

        }

    }

    
    
    
    
    
    
    
    
    
    
    
    
    //--------------------------------------------------------------------------------------------------------------------
//PARA CURSOS 
    static Cursos1[] Cursos = new Cursos1[50];
    static int contador_Cursos = 0;

    public static void AgregarCursos(Cursos1 curso) {
        if (contador_Cursos < Cursos.length) {
            Cursos[contador_Cursos] = curso;
            contador_Cursos++;
        } else {
            System.out.println("Ya llegaste al limite de Profesores");
        }
    }

    // METODO PARA CONVERTIR MI ARREGLO DE OBJETOS A UN OBJECT[][]
    public static Object[][] convertirCursos() {

        int filas = contador_Cursos;
        Object[][] arreglo = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            arreglo[i][0] = Cursos[i].getCodigo();
            arreglo[i][1] = Cursos[i].getNombre();
            arreglo[i][2] = Cursos[i].getCreditos();
            arreglo[i][3] = Cursos[i].getAlumnos();
            arreglo[i][4] = Cursos[i].getProfesor();

        }
        return arreglo;

    }

    //METODO PARA ACTUALIZAR DATOS 
    public static void Actualizarc(int codigo, String nombre, int creditos, String profesor) {
        for (int i = 0; i < contador_Cursos; i++) {
            if (Cursos[i].getCodigo() == codigo) {
                Cursos[i].setNombre(nombre);
                Cursos[i].setCreditos(creditos);
                Cursos[i].setProfesor(profesor);

            }

        }

    }

    //METODO PARA ELIMINAR UN CURSO
    public static void Eliminarc(int codigo) {
        boolean encontrado = false;
        for (int i = 0; i < contador_Cursos; i++) {
            if (Cursos[i].getCodigo() == codigo) {
                correrc(i);

                //PRUEBA PARA VER SI ACTUALIZA LOS DATOS DEL PROFESOR             
                // System.out.println(profes[i].getContraseña());
                encontrado = true;
            }

        }
        if (encontrado == true) {

        } else {
            JOptionPane.showMessageDialog(null, "El Curso no existe");
        }

    }

    //METODO PARA CORRER LOS DATOS
    public static void correrc(int x) {
        for (int j = x; j < contador_Cursos; j++) {
            Cursos[j] = Cursos[j + 1];

        }
        contador_Cursos--;
    }

    //--------------------------------------------------------------------------------------------------------------------
    //PARA ALUMNOS 
    static Alumnos1[] alumnos = new Alumnos1[300];
    static int contador_alumnos = 0;

    public static void AgregaraAlumnos(Alumnos1 alumno) {
        if (contador_alumnos < alumnos.length) {
            alumnos[contador_alumnos] = alumno;
            contador_alumnos++;
        } else {
            System.out.println("Ya llegaste al limite de Alumnos");
        }

    }

    // METODO PARA CONVERTIR MI ARREGLO DE OBJETOS A UN OBJECT[][]
    public static Object[][] convertirAlumnos() {

        int filas = contador_alumnos;
        Object[][] arreglo = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            arreglo[i][0] = alumnos[i].getCodigo();
            arreglo[i][1] = alumnos[i].getNombre();
            arreglo[i][2] = alumnos[i].getApellido();
            arreglo[i][3] = alumnos[i].getCorreo();
            arreglo[i][4] = alumnos[i].getGenero();
        }
        return arreglo;

    }

    
    
    
    //------------------------------------------------------------------------------------------------------------------

public static String identificar( String dato){

    
    String profesor;
    for (int i = 0; i < contador_profes; i++) {
        if (profes[i].getNombre().equals(dato)) {
           profesor = profes[i].getNombre()+ " " +profes[i].getApellido();
           identificar = profesor;
           
        }

    }
    
    
    

return identificar; 
}
    
    
    
    
    
    
    
    
    
    
}





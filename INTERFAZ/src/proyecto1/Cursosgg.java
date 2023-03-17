package proyecto1;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import Objetos.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;

public class Cursosgg extends JPanel implements ActionListener {

    CREARC nuevos;
    ACTUALIZAR_CURSOS actualizacion;

    //ETIQUETAS 
    JLabel C1, C2, C3;
    JButton bC1, bC2, bC3, bC4, bC5, b6C;

    public Cursosgg() {

        this.setBounds(100, 100, 800, 600);
        this.setLayout(null);
        this.setVisible(true);

        //ATRIBUTOS DE LA VENTANA 
        //PRIMER INT CONTROLA POSICON EN X 
        //SEGUNDO INT CONTROLA POSICION EN Y 
        //TERCER INT CONTROLA ANCHO 
        //CUARTO INT CONTROLA ALTURA
        //ETIQUETAS
        C1 = new JLabel("Listado Oficial");
        C1.setBounds(30, 15, 200, 25);
        C1.setVisible(true);
        C1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(C1);

        //BOTONES 
        bC1 = new JButton("CREAR");
        bC1.setBounds(475, 75, 130, 30);
        bC1.setVisible(true);
        this.add(bC1);

        bC2 = new JButton("CARGA MASIVA");
        bC2.setBounds(625, 75, 130, 30);
        bC2.setVisible(true);
        this.add(bC2);

        bC3 = new JButton("ACTUALIZAR");
        bC3.setBounds(475, 125, 130, 30);
        bC3.setVisible(true);
        this.add(bC3);

        bC4 = new JButton("ELIMINAR");
        bC4.setBounds(625, 125, 130, 30);
        bC4.setVisible(true);
        this.add(bC4);

        bC5 = new JButton("Exportar Listado a PDF");
        bC5.setBounds(475, 175, 280, 30);
        bC5.setVisible(true);
        this.add(bC5);

     

        //ACTIVIDAD DEL BOTON 
        bC1.addActionListener(this);
        //ACTIVIDAD DEL BOTON 
        bC2.addActionListener(this);
        //ACTIVIDAD DEL BOTON 
        bC3.addActionListener(this);
        //ACTIVIDAD DEL BOTON 
        bC4.addActionListener(this);
        //ACTIVIDAD DEL BOTON 
        bC5.addActionListener(this);
        //ACTIVIDAD DEL BOTON 
    

        tabla();
    }

    //ACTIVIDADES 
    //ATRIBUTOS DE LECTURA 
    // ATRIBUTOS
    String contenido = "";
    File archivo;
    FileReader fr;
    BufferedReader br;

    public void leerArchivos() {

        try {

            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archivo = fc.getSelectedFile();
            }

            // HACEMOS LA LECTURA DEL ARCHIVO COMO TAL
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            // LEER LINEA POR LINEA
            while ((linea = br.readLine()) != null) {

                contenido += linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //TABLA 
    JTable prueba;
    JScrollPane sp, sp2;

    public void tabla() {
        Object[][] datos = PROYECTO1.convertirCursos();
        // Creamos un arreglo donde tenga los encabezados
        String[] columnas = {"Codigo", "Nombre", "Creditos", "Profesor"};

        JTable t = new JTable(datos, columnas);

        sp = new JScrollPane(t);

        sp.setBounds(30, 50, 400, 400);
        sp.setVisible(true);
        this.add(sp);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bC1) {

            nuevos = new CREARC();

        } else if (ae.getSource() == bC2) {

        
            leerArchivos();
            JsonParser parser = new JsonParser();
            JsonArray arreglo = parser.parse(contenido).getAsJsonArray();

            for (int i = 0; i < arreglo.size(); i++) {

                JsonObject objeto = arreglo.get(i).getAsJsonObject();

                // GUARDAMOS LOS DATOS EN VARIABLES
                int codigo = objeto.get("codigo").getAsInt();
                String nombre = objeto.get("nombre").getAsString();
                int creditos = objeto.get("creditos").getAsInt();
                int profesor = objeto.get("profesor").getAsInt();
                String profe = null;

                // System.out.println(profesor);
                //METODO PARA ASIGNARLE EL PROFESOR AL CURSO 
                for (int j = 0; j < PROYECTO1.contador_profes; j++) {
                    if (profesor == PROYECTO1.profes[j].getCodigo()) {
                        profe = PROYECTO1.profes[j].getNombre();
                    }
                }

                // CREAMOS NUESTRO OBJETO 
                Cursos1 curso = new Cursos1(codigo, nombre, creditos,0, profe);

                // MANDAMOS A LLAMAR NUESTRO METODO QUE AGREGA PERSONAS EN EL ARREGLO
                PROYECTO1.AgregarCursos(curso);
                
            }

            tabla();

        } else if (ae.getSource() == bC3) {
            actualizacion = new ACTUALIZAR_CURSOS();
        } else if (ae.getSource() == bC4) {

            String dato = JOptionPane.showInputDialog("Introduzca el numero de codigo del profesor a eliminar:");
            int codigo = Integer.parseInt(dato);

            PROYECTO1.Eliminarc(codigo);
            sp2.setVisible(false);
            tabla();

        } else if (ae.getSource() == bC5) {

        } 
    }

}

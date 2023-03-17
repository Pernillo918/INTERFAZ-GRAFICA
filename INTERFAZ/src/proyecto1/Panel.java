package proyecto1;

import Objetos.Alumnos1;
import Objetos.Cursos1;
import Objetos.profesores;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Panel extends JFrame implements ActionListener {

    //PANEL EN SI 
    JTabbedPane pestañas;

    //PESTAÑAS 
    JPanel profesores, cursos, alumnos;
    
    JButton CERRAR,CERRAR2,CERRAR3;

//ATRIBUTOS DEL PANEL 
    public Panel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setVisible(true);
        setTitle("ADMINISTRADOR");

        //CREANDO EL PANEL DE PESTAÑAS 
        pestañas = new JTabbedPane();
        this.add(pestañas);

        //AGREGANDO LAS PESTAÑAS 
        profesores = new JPanel();
        pestañas.addTab("Profesores", profesores);
        //LLAMADO DEL METODO PROFESORES QUE TIENE TODOS LOS ATRIBUTOS
        aprofesor();
        cursos = new JPanel();
        pestañas.addTab("Cursos", cursos);
        acursos();
        alumnos = new JPanel();
        pestañas.addTab("Alumnos", alumnos);
        aalumnos();
        
        

    }

    //------------------------------------PANEL DE PROFESORES--------------------------------------
    //BOTONES PROFESOR 
    JButton b1, b2, b3, b4, b5, b6;
    //FUNCIONES DE PROFESOR
    CREAR nuevos;
    ACTUALIZAR actualizacion;
    // ATRIBUTOS
    String contenido = "";
    File archivo;
    FileReader fr;
    BufferedReader br;
    //ETIQUETAS 
    JLabel l1, l2, l3;
    //OBJETOS
    profesores nuevo;
    //TABLA
    JScrollPane sp2;

    public void aprofesor() {

        profesores.setBounds(100, 100, 800, 600);
        profesores.setLayout(null);

        //ETIQUETAS
        l1 = new JLabel("Listado Oficial");
        l1.setBounds(30, 15, 200, 25);
        l1.setVisible(true);
        l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        profesores.add(l1);

        //BOTONES 
        b1 = new JButton("CREAR");
        b1.setBounds(475, 75, 130, 30);
        b1.setVisible(true);
        profesores.add(b1);

        b2 = new JButton("CARGA MASIVA");
        b2.setBounds(625, 75, 130, 30);
        b2.setVisible(true);
        profesores.add(b2);

        b3 = new JButton("ACTUALIZAR");
        b3.setBounds(475, 125, 130, 30);
        b3.setVisible(true);
        profesores.add(b3);

        b4 = new JButton("ELIMINAR");
        b4.setBounds(625, 125, 130, 30);
        b4.setVisible(true);
        profesores.add(b4);

        b5 = new JButton("Exportar Listado a PDF");
        b5.setBounds(475, 175, 280, 30);
        b5.setVisible(true);
        profesores.add(b5);
        
        
        CERRAR = new JButton("CERRAR SESION ");
        CERRAR.setBounds(30, 480, 250, 30);
        CERRAR.setVisible(true);
        profesores.add(CERRAR);
        
        

   
        //ACTIVIDAD DEL BOTON 
        b1.addActionListener(this);
        //ACTIVIDAD DEL BOTON 
        b2.addActionListener(this);
        //ACTIVIDAD DEL BOTON 
        b3.addActionListener(this);
        //ACTIVIDAD DEL BOTON 
        b4.addActionListener(this);
        //ACTIVIDAD DEL BOTON 
        b5.addActionListener(this);
        CERRAR.addActionListener(this);

        //-------------------------------------TABLA DEL PROFESORES--------------------------------------------- 
        Object[][] datos = PROYECTO1.convertirDatos();
        // Creamos un arreglo donde tenga los encabezados
        String[] columnas = {"Codigo", "Nombre", "Apellido", "Correo", "Genero"};

        JTable t = new JTable(datos, columnas);

        sp2 = new JScrollPane(t);

        sp2.setBounds(30, 50, 400, 400);
        sp2.setVisible(true);
        profesores.add(sp2);

        //------------------------------------GRAFICA DE PROFESORES---------------------------------------------
        for (int i = 0; i < PROYECTO1.contador_profes; i++) {
            if (PROYECTO1.profes[i].getGenero().equals("m")) {
                PROYECTO1.contadorhombres++;
            } else if (PROYECTO1.profes[i].getGenero().equals("f")) {
                PROYECTO1.contadormujeres++;
            }
        }

        //DEFINIENDO LO DATOS DEL GRAFICO
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Masculino", PROYECTO1.contadorhombres);
        data.setValue("Femenino", PROYECTO1.contadormujeres);

        //CREANDO EL GRAFICO 
        JFreeChart chart = ChartFactory.createPieChart(
                "GENERO DE PROFESORES",
                data,
                true,
                true,
                false);

        // AGREGAR GRAFICO AL PANEL 
        ChartPanel frame = new ChartPanel(chart);
        frame.setLayout(null);
        frame.setBounds(475, 225, 280, 280);
        frame.setVisible(true);
        profesores.add(frame);

    }

    //METODOS PROFESORES
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
    
    
    
    
    
    
    
    
    
    
    

    //------------------------------------PARA CURSOS-------------------------------------------------------
    //VENTANAS 
    CREARC nuevos1;
    ACTUALIZAR_CURSOS actualizacion1;
    //ETIQUETAS 
    JLabel C1, C2, C3;
    JButton bC1, bC2, bC3, bC4, bC5, b6C;
    // ATRIBUTOS
    String contenido1 = "";
    File archivo1;
    FileReader fr1;
    BufferedReader br1;
    //TABLA
    JScrollPane sp;

    public void acursos() {

        cursos.setBounds(100, 100, 800, 600);
        cursos.setLayout(null);

        C1 = new JLabel("Listado Oficial");
        C1.setBounds(30, 15, 200, 25);
        C1.setVisible(true);
        C1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        cursos.add(C1);

        //BOTONES 
        bC1 = new JButton("CREAR");
        bC1.setBounds(475, 75, 130, 30);
        bC1.setVisible(true);
        cursos.add(bC1);

        bC2 = new JButton("CARGA MASIVA");
        bC2.setBounds(625, 75, 130, 30);
        bC2.setVisible(true);
        cursos.add(bC2);

        bC3 = new JButton("ACTUALIZAR");
        bC3.setBounds(475, 125, 130, 30);
        bC3.setVisible(true);
        cursos.add(bC3);

        bC4 = new JButton("ELIMINAR");
        bC4.setBounds(625, 125, 130, 30);
        bC4.setVisible(true);
        cursos.add(bC4);

        bC5 = new JButton("Exportar Listado a PDF");
        bC5.setBounds(475, 175, 280, 30);
        bC5.setVisible(true);
        cursos.add(bC5);
        
         CERRAR2 = new JButton("CERRAR SESION ");
        CERRAR2.setBounds(30, 480, 250, 30);
        CERRAR2.setVisible(true);
        cursos.add(CERRAR2);

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
        CERRAR2.addActionListener(this);
        //---------------------------------------TABLA CURSOS------------------------------------------------
        Object[][] datos = PROYECTO1.convertirCursos();
        // Creamos un arreglo donde tenga los encabezados
        String[] columnas = {"Codigo", "Nombre", "Creditos","Alumnos", "Profesor"};

        JTable t = new JTable(datos, columnas);

        sp = new JScrollPane(t);

        sp.setBounds(30, 50, 400, 400);
        sp.setVisible(true);
        cursos.add(sp);
        //------------------------------------GRAFICA DE PROFESORES---------------------------------------------

 

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(10, "F", "Curso1");
        dataset.setValue(30, "F", "Curso2");
        dataset.setValue(20, "F", "Curso3");
     
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
        ("CURSOS CON MAS ALUMNOS","CURSOS", "ALUMNOS", 
        dataset, PlotOrientation.VERTICAL, true,true, false);
        
        
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.red); 

        // AGREGAR GRAFICO AL PANEL 
        ChartPanel BB = new ChartPanel(chart);
        BB.setLayout(null);
        BB.setBounds(475, 225, 280, 280);
        BB.setVisible(true);
        cursos.add(BB);
    }

    public void leerArchivosCURSO() {
        try {

            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archivo1 = fc.getSelectedFile();
            }

            // HACEMOS LA LECTURA DEL ARCHIVO COMO TAL
            fr1 = new FileReader(archivo1);
            br1 = new BufferedReader(fr1);
            String linea;
            // LEER LINEA POR LINEA
            while ((linea = br1.readLine()) != null) {

                contenido1 += linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr1) {
                    fr1.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    

    //--------------------------------------ALUMNOS ---------------------------------------------------------
    //ETIQUETAS 
    JLabel la1;
    JButton a1, a2, a3;
    // ATRIBUTOS
    String contenidoa = "";
    File archivoa;
    FileReader fra;
    BufferedReader bra;
    //TABLA
    JScrollPane spa;

    public void aalumnos() {

        alumnos.setBounds(100, 100, 800, 600);
        alumnos.setLayout(null);

        la1 = new JLabel("Listado Oficial");
        la1.setBounds(30, 15, 200, 25);
        la1.setVisible(true);
        la1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        alumnos.add(la1);

        //BOTONES 
        a1 = new JButton("CARGA MASIVA");
        a1.setBounds(475, 75, 250, 30);
        a1.setVisible(true);
        alumnos.add(a1);

        a2 = new JButton("EXPORTAR LISTADO A PDF");
        a2.setBounds(475, 150, 250, 30);
        a2.setVisible(true);
        alumnos.add(a2);
        
        
        CERRAR3 = new JButton("CERRAR SESION ");
        CERRAR3.setBounds(30, 480, 250, 30);
        CERRAR3.setVisible(true);
        alumnos.add(CERRAR3);

        //ACTIVIDAD DEL BOTON 
        a1.addActionListener(this);
        //ACTIVIDAD DEL BOTON 
        a2.addActionListener(this);
        CERRAR3.addActionListener(this);

        //--------------------------------------TABLA ALUMNOS-----------------------------------------------------------
      
       Object[][] datos = PROYECTO1.convertirAlumnos();
        // Creamos un arreglo donde tenga los encabezados
        String[] columnas = {"Codigo", "Nombre", "Apellido", "Correo", "Genero"};

        JTable t = new JTable(datos, columnas);

        spa = new JScrollPane(t);

        spa.setBounds(30, 50, 400, 400);
        spa.setVisible(true);
        alumnos.add(spa);
        
          //------------------------------------GRAFICA DE PROFESORES---------------------------------------------
        for (int i = 0; i < PROYECTO1.contador_alumnos; i++) {
            if (PROYECTO1.alumnos[i].getGenero().equals("m")) {
                PROYECTO1.contadorhombresa++;
            } else if (PROYECTO1.alumnos[i].getGenero().equals("f")) {
                PROYECTO1.contadormujeresa++;
            }
        }

        //DEFINIENDO LO DATOS DEL GRAFICO
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Masculino", PROYECTO1.contadorhombresa);
        data.setValue("Femenino", PROYECTO1.contadormujeresa);

        //CREANDO EL GRAFICO 
        JFreeChart chart = ChartFactory.createPieChart(
                "GENERO DE ALUMNOS",
                data,
                true,
                true,
                false);

        // AGREGAR GRAFICO AL PANEL 
        ChartPanel frame = new ChartPanel(chart);
        frame.setLayout(null);
        frame.setBounds(475, 225, 280, 280);
        frame.setVisible(true);
        alumnos.add(frame);
    }
    
      public void leerArchivosalumnos() {

        try {

            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archivoa = fc.getSelectedFile();
            }

            // HACEMOS LA LECTURA DEL ARCHIVO COMO TAL
            fra = new FileReader(archivoa);
            bra = new BufferedReader(fra);
            String linea;
            // LEER LINEA POR LINEA
            while ((linea = bra.readLine()) != null) {

                contenidoa += linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fra) {
                    fra.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    //EMPIEZA LA ACCIONES DE LOS BOTONES --------------------------------------------------------------------------
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

            nuevos = new CREAR();
            this.dispose();
        } else if (ae.getSource() == b2) {

            leerArchivos();
            JsonParser parser = new JsonParser();
            JsonArray arreglo = parser.parse(contenido).getAsJsonArray();

            for (int i = 0; i < arreglo.size(); i++) {

                JsonObject objeto = arreglo.get(i).getAsJsonObject();

                // GUARDAMOS LOS DATOS EN VARIABLES
                int codigo = objeto.get("codigo").getAsInt();
                String nombre = objeto.get("nombre").getAsString();
                String apellido = objeto.get("apellido").getAsString();
                String correo = objeto.get("correo").getAsString();
                String genero = objeto.get("genero").getAsString();

                // CREAMOS NUESTRO OBJETO PERSONA
                nuevo = new profesores(codigo, nombre, apellido, correo, "1234", genero);

                // MANDAMOS A LLAMAR NUESTRO METODO QUE AGREGA PERSONAS EN EL ARREGLO
                PROYECTO1.AgregarPersona(nuevo);

            }
            this.dispose();
            Panel menu = new Panel();

        } else if (ae.getSource() == b3) {

            actualizacion = new ACTUALIZAR();
            this.dispose();
        } else if (ae.getSource() == b4) {

            String dato = JOptionPane.showInputDialog("Introduzca el numero de codigo del profesor a eliminar:");
            int codigo = Integer.parseInt(dato);

            PROYECTO1.Eliminar(codigo);
            this.dispose();
            Panel menu = new Panel();

        } else if (ae.getSource() == b5) {
            
            try {   
                
                 Document pdf = new Document();
        FileOutputStream documento = new FileOutputStream("PDF\\Listado profesores.pdf");
        PdfWriter.getInstance(pdf, documento);
        pdf.open();
        Paragraph titulo = new Paragraph("\t\t\t\t\t\t\t\t\tLISTADO OFICIAL DE PROFESORES \n\n\n\n");
        pdf.add(titulo);
        PdfPTable tablapdf = new PdfPTable(5);
        tablapdf.addCell("Codigo");
        tablapdf.addCell("Nombre");
        tablapdf.addCell("Apellido");
        tablapdf.addCell("Correo");
        tablapdf.addCell("Genero");
        for (int i = 0; i < PROYECTO1.contador_profes; i++) {
            if (PROYECTO1.profes[i] != null) {
                
                tablapdf.addCell(String.valueOf(PROYECTO1.profes[i].getCodigo()));
                tablapdf.addCell(PROYECTO1.profes[i].getNombre());
                tablapdf.addCell(PROYECTO1.profes[i].getApellido());
                tablapdf.addCell(PROYECTO1.profes[i].getCorreo());
                tablapdf.addCell(PROYECTO1.profes[i].getGenero());
              
               
            }
        }

        pdf.add(tablapdf);
        pdf.close();
        JOptionPane.showMessageDialog(this, "PDF CREADO CON EXITO");
                
            } catch(Exception e){
                System.out.println(e);
            }
          
            
        }
        













////////////////////////////////////////////////////////////////////////////////////////////////////////////  
        
        
        
        
        
        
        
        
        
        
        
        else if (ae.getSource() == bC1) {

            nuevos1 = new CREARC();
            this.dispose();

        } else if (ae.getSource() == bC2) {

            leerArchivosCURSO();
            JsonParser parser = new JsonParser();
            JsonArray arreglo = parser.parse(contenido1).getAsJsonArray();

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
                        profe = PROYECTO1.profes[j].getNombre()+ " " + PROYECTO1.profes[j].getApellido();
                    }
                }

                // CREAMOS NUESTRO OBJETO 
                Cursos1 curso = new Cursos1(codigo, nombre, creditos,0, profe);

                // MANDAMOS A LLAMAR NUESTRO METODO QUE AGREGA PERSONAS EN EL ARREGLO
                PROYECTO1.AgregarCursos(curso);

            }
            this.dispose();
            Panel menu = new Panel();

        } else if (ae.getSource() == bC3) {
            this.dispose();
            actualizacion1 = new ACTUALIZAR_CURSOS();
        } else if (ae.getSource() == bC4) {

            String dato = JOptionPane.showInputDialog("Introduzca el numero de codigo del curso a eliminar:");
            int codigo = Integer.parseInt(dato);

            PROYECTO1.Eliminarc(codigo);
            this.dispose();
            Panel menu = new Panel();

        } else if (ae.getSource() == bC5) {
               try {   
                
                 Document pdf = new Document();
        FileOutputStream documento = new FileOutputStream("PDF\\Listado Cursos.pdf");
        PdfWriter.getInstance(pdf, documento);
        pdf.open();
        Paragraph titulo = new Paragraph("\t\t\t\t\t\t\t\t\tLISTADO OFICIAL DE CURSOS \n\n\n\n");
        pdf.add(titulo);
        PdfPTable tablapdf = new PdfPTable(5);
        tablapdf.addCell("Codigo");
        tablapdf.addCell("Nombre");
        tablapdf.addCell("Creditos");
        tablapdf.addCell("Alumnos");
        tablapdf.addCell("Profesor");
        for (int i = 0; i < 50; i++) {
            if (PROYECTO1.Cursos[i] != null) {
                
                tablapdf.addCell(String.valueOf(PROYECTO1.Cursos[i].getCodigo()));
                tablapdf.addCell(PROYECTO1.Cursos[i].getNombre());
                tablapdf.addCell(String.valueOf(PROYECTO1.Cursos[i].getCreditos()));
                tablapdf.addCell(String.valueOf(PROYECTO1.Cursos[i].getAlumnos()));
                 tablapdf.addCell(PROYECTO1.Cursos[i].getProfesor());
               
            }
        }

        pdf.add(tablapdf);
        pdf.close();
        JOptionPane.showMessageDialog(this, "PDF CREADO CON EXITO");
                
            } catch(Exception e){
                System.out.println(e);
            }

        }
        
        
        
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
        
        
        
        
        
        else if(ae.getSource() == a1) {

      
             
            leerArchivosalumnos();
            JsonParser parser = new JsonParser();
            JsonArray arreglo = parser.parse(contenidoa).getAsJsonArray();

            for (int i = 0; i < arreglo.size(); i++) {

                JsonObject objeto = arreglo.get(i).getAsJsonObject();

                // GUARDAMOS LOS DATOS EN VARIABLES
                int codigo = objeto.get("codigo").getAsInt();
                String nombre = objeto.get("nombre").getAsString();
                String apellido = objeto.get("apellido").getAsString();
                String correo = objeto.get("correo").getAsString();
                String genero = objeto.get("genero").getAsString();

                // CREAMOS NUESTRO OBJETO PERSONA
                Alumnos1 alumnoso = new Alumnos1(codigo, nombre, apellido, correo, genero,1234);

                // MANDAMOS A LLAMAR NUESTRO METODO QUE AGREGA PERSONAS EN EL ARREGLO
                PROYECTO1.AgregaraAlumnos(alumnoso);

            }
            this.dispose();
            Panel menu = new Panel();
            

        } else if (ae.getSource() == a2) {
            
              try {   
                
                 Document pdf = new Document();
        FileOutputStream documento = new FileOutputStream("PDF\\Listado Alumnos.pdf");
        PdfWriter.getInstance(pdf, documento);
        pdf.open();
        Paragraph titulo = new Paragraph("\t\t\t\t\t\t\t\t\tLISTADO OFICIAL DE ALUMNOS \n\n\n\n");
        pdf.add(titulo);
        PdfPTable tablapdf = new PdfPTable(5);
        tablapdf.addCell("Codigo");
        tablapdf.addCell("Nombre");
        tablapdf.addCell("Apellido");
        tablapdf.addCell("Correo");
        tablapdf.addCell("Genero");
        for (int i = 0; i < 300; i++) {
            if (PROYECTO1.alumnos[i] != null) {
                
                tablapdf.addCell(String.valueOf(PROYECTO1.alumnos[i].getCodigo()));
                tablapdf.addCell(PROYECTO1.alumnos[i].getNombre());
                tablapdf.addCell(PROYECTO1.alumnos[i].getApellido());
                tablapdf.addCell(PROYECTO1.alumnos[i].getCorreo());
                tablapdf.addCell(PROYECTO1.alumnos[i].getGenero());
              
               
            }
        }

        pdf.add(tablapdf);
        pdf.close();
        JOptionPane.showMessageDialog(this, "PDF CREADO CON EXITO");
                
            } catch(Exception e){
                System.out.println(e);
            }
          
            

        }else if (ae.getSource() == CERRAR){
            this.dispose();
            Login login = new Login();
        }else if (ae.getSource() == CERRAR2){
            this.dispose();
            Login login = new Login();
        }else if (ae.getSource() == CERRAR3){
            this.dispose();
            Login login = new Login();
        }
    }

}

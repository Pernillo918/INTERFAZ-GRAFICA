package proyecto1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Curso_admin extends JFrame implements ActionListener {

    //ETIQUETAS 
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l0;
    //BOTONES
    JButton b1, b2, b3, b4, b5, b6;

    JPasswordField t1, t2, t3;

    //TABLAS 
    JScrollPane sp, sp2;

    public Curso_admin() {

        this.setTitle("CURSO");
        this.setBounds(100, 100, 800, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        l1 = new JLabel("Listado oficial");
        l1.setBounds(30, 15, 300, 40);
        l1.setVisible(true);
        l1.setLayout(null);
        l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        this.add(l1);

        l2 = new JLabel("Actividades");
        l2.setBounds(425, 50, 300, 25);
        l2.setVisible(true);
        l2.setLayout(null);
        l2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        this.add(l2);

        l3 = new JLabel("Acomulado");
        l3.setBounds(500, 40, 300, 400);
        l3.setVisible(true);
        l3.setLayout(null);
        l3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        this.add(l3);

        l4 = new JLabel("Crear actividad");
        l4.setBounds(425, 275, 300, 25);
        l4.setVisible(true);
        l4.setLayout(null);
        l4.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        this.add(l4);

        l5 = new JLabel("Nombre");
        l5.setBounds(430, 300, 200, 25);
        l5.setVisible(true);
        l5.setLayout(null);
        l5.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        this.add(l5);

        l6 = new JLabel("Descripcion");
        l6.setBounds(430, 340, 200, 25);
        l6.setVisible(true);
        l6.setLayout(null);
        l6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        this.add(l6);

        l7 = new JLabel("Ponderacion");
        l7.setBounds(430, 380, 200, 25);
        l7.setVisible(true);
        l7.setLayout(null);
        l7.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        this.add(l7);

        l8 = new JLabel("Notas");
        l8.setBounds(430, 420, 200, 25);
        l8.setVisible(true);
        l8.setLayout(null);
        l8.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        this.add(l8);

        t1 = new JPasswordField();
        t1.setBounds(550, 300, 200, 25);
        t1.setVisible(true);
        this.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(550, 340, 200, 25);
        t2.setVisible(true);
        this.add(t2);

        t3 = new JPasswordField();
        t3.setBounds(550, 380, 200, 25);
        t3.setVisible(true);
        this.add(t3);

        b1 = new JButton("Seleccionar archivo CSV");
        b1.setBounds(550, 420, 200, 25);
        b1.setVisible(true);
        this.add(b1);

        b2 = new JButton("CREAR ACTIVIDAD ");
        b2.setBounds(425, 460, 325, 25);
        b2.setVisible(true);
        this.add(b2);

        b3 = new JButton("CARGA MASIVA ALUMNOS ");
        b3.setBounds(30, 340, 300, 25);
        b3.setVisible(true);
        this.add(b3);

        l9 = new JLabel("Reportes");
        l9.setBounds(30, 420, 300, 20);
        l9.setVisible(true);
        l9.setLayout(null);
        l9.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        this.add(l9);

        b4 = new JButton("Top 5 - Estudiantes con Mejor Rendimiento ");
        b4.setBounds(30, 460, 300, 25);
        b4.setVisible(true);
        this.add(b4);

        b5 = new JButton("Top 5 - Estudiantes con Peor Rendimiento");
        b5.setBounds(30, 500, 300, 25);
        b5.setVisible(true);
        this.add(b5);

        b6 = new JButton("REGRESAR");
        b6.setBounds(425, 500, 100, 25);
        b6.setVisible(true);
        this.add(b6);

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
        //ACTIVIDAD DEL BOTON 
        b6.addActionListener(this);

        //---------------------------------------------------------------------------------------------------------
        //TABLA DE ALUMNOS
        Object[][] datos = PROYECTO1.convertirDatos();
        // Creamos un arreglo donde tenga los encabezados
        String[] columnas = {"Codigo", "Nombre", "Apellido", "Acciones"};

        JTable t = new JTable(datos, columnas);

        sp2 = new JScrollPane(t);

        sp2.setBounds(30, 75, 300, 250);
        sp2.setVisible(true);
        this.add(sp2);

        //---------------------------------------------------------------------------------------------------------
        //TABLA DE ALUMNOS
        Object[][] datosa = PROYECTO1.convertirDatos();
        // Creamos un arreglo donde tenga los encabezados
        String[] columnasactividades = {"Nombre", "Descripcion", "Ponderacion", "Promedio"};

        JTable actividades = new JTable(datos, columnasactividades);

        sp = new JScrollPane(actividades);

        sp.setBounds(425, 75, 300, 150);
        sp.setVisible(true);
        this.add(sp);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b6) {

            this.dispose();
             

            //PENDIENTE REALIZAR ACTIVIDAD 
        }
    }

}

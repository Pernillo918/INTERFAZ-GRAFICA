package proyecto1;

import Objetos.profesores;
import proyecto1.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CREAR extends JFrame implements ActionListener {

    //ETIQUETAS 
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    //BOTONES
    JButton b1, b2;

    //CUADROS DE TEXTO 
    JTextField t1, t2, t3, t4, t5, t6;

    JComboBox genero;

    public CREAR() {

        this.setTitle("Profesores");
        this.setBounds(100, 100, 800, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        //ATRIBUTOS DE LA VENTANA 
        //PRIMER INT CONTROLA POSICON EN X 
        //SEGUNDO INT CONTROLA POSICION EN Y 
        //TERCER INT CONTROLA ANCHO 
        //CUARTO INT CONTROLA ALTURA
        //ETIQUETAS
        l7 = new JLabel("Agregar Nuevo Profesor");
        l7.setBounds(30, 15, 300, 25);
        l7.setVisible(true);
        l7.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        this.add(l7);

        l1 = new JLabel("CODIGO");
        l1.setBounds(30, 75, 200, 25);
        l1.setVisible(true);
        l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(l1);

        l2 = new JLabel("NOMBRE");
        l2.setBounds(30, 150, 200, 25);
        l2.setVisible(true);
        l2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(l2);

        l3 = new JLabel("APELLIDO");
        l3.setBounds(30, 225, 200, 25);
        l3.setVisible(true);
        l3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(l3);

        l4 = new JLabel("CORREO");
        l4.setBounds(30, 300, 200, 25);
        l4.setVisible(true);
        l4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(l4);

        l5 = new JLabel("CONTRASEÑA");
        l5.setBounds(30, 375, 200, 25);
        l5.setVisible(true);
        l5.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(l5);

        l6 = new JLabel("GENERO");
        l6.setBounds(30, 450, 150, 25);
        l6.setVisible(true);
        l6.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(l6);

        l8 = new JLabel("Masculino = M     Femenino = F");
        l8.setBounds(200, 425, 300, 25);
        l8.setVisible(true);
        l8.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(l8);

        //CUADROS DE TEXTO 
        t1 = new JTextField();
        t1.setBounds(200, 75, 350, 25);
        t1.setVisible(true);
        this.add(t1);

        t2 = new JTextField();
        t2.setBounds(200, 150, 350, 25);
        t2.setVisible(true);
        this.add(t2);

        t3 = new JTextField();
        t3.setBounds(200, 225, 350, 25);
        t3.setVisible(true);
        this.add(t3);

        t4 = new JTextField();
        t4.setBounds(200, 300, 350, 25);
        t4.setVisible(true);
        this.add(t4);

        t5 = new JTextField();
        t5.setBounds(200, 375, 350, 25);
        t5.setVisible(true);
        this.add(t5);

        genero = new JComboBox();
        genero.setBounds(200, 450, 350, 25);
        String vacio = null;
        String hombre = "m";
        String mujer = "f";

        genero.addItem(hombre);
        genero.addItem(mujer);
        genero.setVisible(true);
        this.add(genero);

        //BOTONES 
        b1 = new JButton("AGREGAR");
        b1.setBounds(400, 500, 130, 30);
        b1.setVisible(true);
        this.add(b1);

        b2 = new JButton("REGRESAR");
        b2.setBounds(600, 500, 130, 30);
        b2.setVisible(true);
        this.add(b2);

        //ACTIVIDAD DEL BOTON 
        b1.addActionListener(this);
        //ACTIVIDAD DEL BOTON 
        b2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae
    ) {
        if (ae.getSource() == b1) {

            String sexo= null;
            String opcion = genero.getSelectedItem().toString();
            if (opcion.equals("h")) {
                sexo= "h";
            } else if (opcion.equals("m")) {
                sexo= "m";
            }

            int codigo = Integer.parseInt(t1.getText());
            String nombre = t2.getText();
            String apellido = t3.getText();
            String correo = t4.getText();
            String contraseña = t5.getText();

            profesores nuevo = new profesores(codigo, nombre, apellido, correo, contraseña, sexo);
            PROYECTO1.AgregarPersona(nuevo);

            JOptionPane.showMessageDialog(this, "Se agrego el usuario");
            
  

        } else if (ae.getSource() == b2) {
            
            Panel menu = new Panel();
            this.dispose();
          

        }
    }

}

package proyecto1;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Modulo_profesor extends JFrame implements ActionListener {

    //PARA LOS BOTONES DE LAS CLASES 
    int j;
    Button[] curso;
   static String ncurso;
     Boton [][] agregar;
         ACTUALIZAR actualizacion;

    //ETIQUETAS 
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    //BOTONES
    JButton b1, b2;

    //CUADROS DE TEXTO 
    JTextField t1, t2, t3, t4, t5, t6;

    JComboBox genero;

    public Modulo_profesor() {

        this.setTitle(" MODULO PROFESORES");
        this.setBounds(100, 100, 800, 600);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        //ETIQUETAS
        l7 = new JLabel("CURSOS ASIGNADOS");
        l7.setBounds(30, 15, 300, 25);
        l7.setVisible(true);
        l7.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        this.add(l7);

        //BOTONES 
        b1 = new JButton("ACTUALIZAR DATOS");
        b1.setBounds(500, 10, 200, 30);
        b1.setVisible(true);
        this.add(b1);

        //ACTIVIDAD DEL BOTON 
        b1.addActionListener(this);

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(75, 100, 650, 450);
       // scroll.setLayout(null);
        scroll.setVisible(true);
        this.add(scroll);

        
        //PANEL
        JPanel botones = new JPanel();
        botones.setBounds(20, 20, 500, 440);
        scroll.setViewportView(botones);
        botones.setVisible(true);
      
        GridLayout layaout = new GridLayout(3, 3);
       botones.setLayout(layaout);

        //SABER EL PROFESORE QUE ESTA INGRESANDO 
        String ideprofesor = PROYECTO1.identificar;
        //CONTADOR DE CUANTO BOTONES HACER 
        int contador_botones = 0;

        //METODO PARA SABER CUANTOS CURSOS TIENE Y CUANTOS BOTENES SE TIENE QUE GENERAR 
        for (int i = 0; i < PROYECTO1.contador_Cursos; i++) {

            if (PROYECTO1.Cursos[i].getProfesor().equals(ideprofesor)) {
                contador_botones++;
            }
        }
        
  
        //------------------------------------------------------------------------------------------
        curso = new Button[contador_botones];
        for (int i = 0; i < PROYECTO1.contador_Cursos; i++) {
            if (PROYECTO1.Cursos[i].getProfesor().equals(ideprofesor)) {
                //System.out.println(PROYECTO1.Cursos[i].getNombre());
                for (j = 0; j < curso.length; j++) {
                    curso[j] = new Button(PROYECTO1.Cursos[i].getNombre());
                    ncurso = PROYECTO1.Cursos[i].getNombre();
                    
                    curso[j].setBounds(5, 5, 20, 50);
                    curso[j].setBackground(Color.LIGHT_GRAY);
                    botones.add(curso[j]);
                    
                    break;
                }
                curso[j].addActionListener(new ActionListener() 
		{public void actionPerformed(ActionEvent e) {        Curso_admin ventana = new  Curso_admin(); }});
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

            this.dispose();
             actualizacion = new ACTUALIZAR();

            //PENDIENTE REALIZAR ACTIVIDAD 
        }
        
        
       
    }

}

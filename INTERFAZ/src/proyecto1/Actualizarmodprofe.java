/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import proyecto1.*;
import Objetos.*;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Actualizarmodprofe extends JFrame implements ActionListener {

    private CheckboxGroup f ;
    Checkbox c1,c2;
    
    
    //ETIQUETAS 
    JLabel l1, l2, l3, l4, l5, l6, l7;
    //BOTONES
    JButton b1, b2;
    
     //CUADROS DE TEXTO 
    JTextField t1, t2,t3,t4,t5;
    JComboBox profesores ;

    public Actualizarmodprofe() {

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
        l7 = new JLabel("Agregar Nuevo curso");
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

        l3 = new JLabel("CREDITOS");
        l3.setBounds(30, 225, 200, 25);
        l3.setVisible(true);
        l3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(l3);

        l4 = new JLabel("PROFESOR");
        l4.setBounds(30, 300, 200, 25);
        l4.setVisible(true);
        l4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(l4);

       

       
        
        //CUADROS DE TEXTO 
        t1 = new JTextField();
        t1.setBounds(200, 75, 350, 25);
        t1.setVisible(true);
        this.add(t1);
        
        t2= new JTextField();
        t2.setBounds(200, 150, 350, 25);
        t2.setVisible(true);
        this.add(t2);
        
        t3 = new JTextField();
        t3.setBounds(200, 225, 350, 25);
        t3.setVisible(true);
        this.add(t3);
        
   
        //COMBO BOX CON EL LISTADO DE PROFESORES 
       
      
        profesores   = new JComboBox();
        profesores.setBounds(200, 300, 350, 25);
        add(profesores);
        for (int i = 0; i < PROYECTO1.contador_profes; i++) {
            profesores.addItem(PROYECTO1.profes[i].getNombre()+ " " +PROYECTO1.profes[i].getApellido());
        }
       
        profesores.setVisible(true);
       

        
        //BOTONES 
        b1 = new JButton("ACTUALIZAR");
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
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            
            
            
            String profesor= null;
            String opcion = profesores.getSelectedItem().toString();
            for (int i = 0; i < PROYECTO1.contador_profes; i++) {
                
                 if (opcion.equals(PROYECTO1.profes[i].getNombre())) {
                profesor= PROYECTO1.profes[i].getNombre();
                break;
            }
           
            } 

            int codigo = Integer.parseInt(t1.getText());
            String nombre = t2.getText();
            int creditos = Integer.parseInt(t3.getText());
         
            
            Cursos1 nuevo = new Cursos1(codigo,nombre,creditos,0,profesor);   
            PROYECTO1.AgregarCursos(nuevo);

            JOptionPane.showMessageDialog(this, "Se agrego el usuario");
            
        //PENDIENTE REALIZAR ACTIVIDAD 
        }else if(ae.getSource() == b2){
        
           this.dispose();
            Modulo_profesor  ventana = new Modulo_profesor();
            
            
            
    }    
    }

}

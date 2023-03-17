package proyecto1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    
    Modulo_profesor ventana;

    //ETIQUETAS 
    JLabel l1, l2, l3;
    //CUADROS DE TEXTO 
    JTextField t1;
    JPasswordField t2;
    //BOTONES 
    JButton b1, b2;

    //ATRIBUTOS DE LA VENTANA
    String usuario, contraseña;

    public Login() {

        this.setTitle("Modulo de Autentificacion");
        this.setBounds(100, 100, 500, 300);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        //ETIQUETAS
        l3 = new JLabel("DTT");
        l3.setBounds(250, 40, 75, 25);
        l3.setVisible(true);
        this.add(l3);

        l1 = new JLabel("USUARIO");
        l1.setBounds(10, 75, 75, 25);
        l1.setVisible(true);
        this.add(l1);

        l2 = new JLabel("CONTRASEÑA");
        l2.setBounds(10, 125, 80, 25);
        l2.setVisible(true);
        this.add(l2);

        //CUADROS DE TEXTO 
        t1 = new JTextField();
        t1.setBounds(100, 75, 350, 25);
        t1.setVisible(true);
        this.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(100, 125, 350, 25);
        t2.setVisible(true);
        this.add(t2);

        //BOTON DE INICIO DE SESION 
        b1 = new JButton("Iniciar Sesion");
        b1.setBounds(200, 175, 120, 30);
        b1.setVisible(true);
        this.add(b1);

        //ACTIVIDAD DEL BOTON 
        b1.addActionListener(this);

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //PARA MODULO PROFESORES 
    public void Modulo_profesor() {

        JFrame modprofe = new JFrame();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            usuario = t1.getText();
            contraseña = t2.getText();

            if (usuario.equals("admin") && contraseña.equals("admin")) {

                Panel menu = new Panel();
                this.dispose();

            } else if (usuario.equals("") && contraseña.equals("")) {

                JOptionPane.showMessageDialog(this, "DEBE INGRESAR DATOS");
            } else if (PROYECTO1.profes.length > 0) {

                String nombre = null;
                for (int i = 0; i < PROYECTO1.contador_profes; i++) {
                    if (usuario.equals(PROYECTO1.profes[i].getNombre()) && contraseña.equals(PROYECTO1.profes[i].getContraseña())) {

                        nombre = PROYECTO1.profes[i].getNombre();
                        PROYECTO1.identificar(nombre);
                        this.dispose();
                        ventana = new Modulo_profesor();
                        break;
                    }
                    //  System.out.println(nombre);       

                    this.dispose();
                }

            } else if (PROYECTO1.profes.length > 0) {
                JOptionPane.showMessageDialog(this, "DEBE INGRESAR DATOS");
            }

        }

    }

}

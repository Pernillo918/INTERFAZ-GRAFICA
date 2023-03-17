
package proyecto1;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Boton extends JButton implements ActionListener {
    
    //-------- Constructor con parametros para posicionar a los botones ------//
    public Boton( int pos_x, int pos_y, int ancho, int alto ){ 
        //Se coloca el boton en un lugar y se le da un tamanio
        setBounds(pos_x, pos_y, ancho, alto);
        
        //Se agrega el action listener en este caso la misma clase
        addActionListener( this );
    }
    //------------------------------------------------------------------------//
    
    //---------------------- Se asigna una el nombre del boton ---------------//
    public void setNombre(String curso ){
        setText(curso);
    }
    //------------------------------------------------------------------------//
    
    //------------------ Al darle click realizara este metodo ----------------//
    public void actionPerformed( ActionEvent e ){
        //Se asigna el color de fondo azul
        setBackground(Color.BLUE);
        //Se asigna un color de letra color blanco
        setForeground(Color.WHITE);
    }
    //------------------------------------------------------------------------//
}

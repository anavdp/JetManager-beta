/**
 *Jet Manager- Integrantes:
 * @author JOSÉ PIRELA
 * @author ANA DE PALMA
 * @author JULIO PAREDES
 * @author RICARDO ABUNASSAR
 * @author JESÚS RANGEL
 */
package vista;

import javax.swing.JOptionPane;

/**
 *
 * @author ABUNASSAR PENARANDA
 */
public class Mensajes {
    public static void Aviso(String Mensaje,String CaptionWin) {

      JOptionPane.showMessageDialog(null,
      Mensaje,
      CaptionWin,
      JOptionPane.WARNING_MESSAGE);
    
}
    
    public static void Informacion(String Mensaje,String CaptionWin) {

      JOptionPane.showMessageDialog(null,
      Mensaje,
      CaptionWin,
      JOptionPane.INFORMATION_MESSAGE);
    }
}
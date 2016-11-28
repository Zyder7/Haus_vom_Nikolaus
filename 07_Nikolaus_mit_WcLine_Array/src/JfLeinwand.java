
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class JfLeinwand extends JFrame {

    WcPoint mo = new WcPoint(0.5, 0.1);
    WcPoint lo = new WcPoint(0.1, 0.4);
    WcPoint lu = new WcPoint(0.1, 0.9);
    WcPoint ru = new WcPoint(0.9, 0.9);
    WcPoint ro = new WcPoint(0.9, 0.4);

    WcLine[] niko = {
    		new WcLine(mo, ro), 
    		new WcLine(ro, ru), 
    		new WcLine(ru, lu), 
    		new WcLine(lu, lo), 
    		new WcLine(lo, mo), 
    		new WcLine(lo, ru), 
    		new WcLine(ro, lu), 
    		new WcLine(lo, ro)};

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JfLeinwand frame = new JfLeinwand();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JfLeinwand() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

// modifizierte JLabel-Klasse ------------------------------------------
        JLabel lbl_malen = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // 1) rhh: Label an Fenstergroesse anpassen
                setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight()); // rhh: added

                // 2) rhh: Labelgroesse an WcPoint-Klasse zur Umrechnung weiterleiten
                WcPoint.maxPixelX = this.getWidth();
                WcPoint.maxPixelY = this.getHeight();

                for(int i=0; i < niko.length; i++){
                	niko[i].draw(g);
                } 
            }
        };
// --------------------------------------------------------------------		
        lbl_malen.setBounds(0, 0, 1, 1);
        contentPane.add(lbl_malen);
    }
}

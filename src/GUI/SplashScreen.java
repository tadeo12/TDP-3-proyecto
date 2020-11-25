package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class SplashScreen extends JWindow{
	private int duration;

	public SplashScreen(int d) {
		duration = d;
		setBounds(100, 100, 932, 647);
		
		this.setLocationRelativeTo(null);   
        this.setAlwaysOnTop(true);          // Lo mantenemos siempre al frente al ejecutar
        
        Image img = Toolkit.getDefaultToolkit().getImage(SplashScreen.class.getResource("/RecursosGraficos_Extras/SPLASH SCREEN.png"));
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon ii = new ImageIcon();
		ii.setImage(img);
		lblNewLabel.setIcon(ii);
		add(lblNewLabel);
		
		repaint();
		
		setVisible(true);
		System.out.print(2);

	}

	
	public void showSplashScreen() throws InterruptedException {
		
		
		long start = System.currentTimeMillis();
		
        try {
        	
                Thread.sleep(3000);
                
       
         } catch( InterruptedException ex) {
        	 ex.printStackTrace();
        	 ex.getMessage();
         }
    
        long stop = System.currentTimeMillis();

        System.out.println(" Time taken : " + (stop - start));
		
        dispose();
	}
	


}

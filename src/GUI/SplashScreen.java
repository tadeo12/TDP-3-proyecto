package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class SplashScreen extends JWindow {
	private int duration;
	private JLabel jLabelTitle;

	public SplashScreen(int d) {
		duration = d;
	}

	// A simple little method to show a title screen in the center
	// of the screen for the amount of time given in the constructor
	public void showSplash() {
		this.setLocationByPlatform(true);
		 JPanel content = (JPanel)getContentPane();
		 content.setBackground(new java.awt.Color(191,191,191));
		 content.setLayout(null);
		 JLabel label = new JLabel();//new ImageIcon("oreilly.gif")

		 // Set the window's bounds, centering the window
		 int width = 450;
		 int height =115;
		 Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		 int x = (screen.width-width)/2;
		 int y = (screen.height-height)/2;
		 this.setBounds(0, 0, 915, 460);
		
		 // Build the splash screen

		 {
			 jLabelTitle = new JLabel();
			 content.add(jLabelTitle, "Center");
			 jLabelTitle.setText("Plane WAR");
			 jLabelTitle.setFont(new java.awt.Font("Ubuntu",0,72));
			 jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			 jLabelTitle.setForeground(new java.awt.Color(255,165,0));
			 jLabelTitle.setBounds(0, 298, 437, 157);
		 }
		 content.add(label, BorderLayout.WEST);
		 label.setIcon(new ImageIcon(SplashScreen.class.getResource("/RecursosGraficos_Extras/FONDO MENU.png")));
		 label.setBounds(0, 1, 915, 458);
		

		 // Display it
		 setVisible(true);
		
		 // Wait a little while, maybe while loading resources
		 try { Thread.sleep(duration); } catch (Exception e) {}
		
		 setVisible(false);
		 getContentPane().setBackground(new java.awt.Color(0,0,0));
		 this.setOpacity(0.0f);
		 content.add(label, "West");
	}
	
}
package employeemanagementsystem;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame {
	Splash(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/front.gif"));
		Image i2 = i1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1170,650);
		add(image);
		
		
		setSize(1170,650);
		setLayout(null);
		setVisible (true);
		setLocation(200,100);
		
		try {
			Thread.sleep(5000);
			setVisible(false);
			new Login();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		new Splash();

	}

}

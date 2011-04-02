import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;


public class Proba 
{

	
	public static void main(String[] args)
	{
		final Proba1 frame;
		frame = new Proba1();
		//installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//frame = new Proba1();
				frame.setDefaultCloseOperation(Proba1.EXIT_ON_CLOSE);
				frame.setTitle("Proba1");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		frame.getJButton0().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Merge Butonul");
			}
			
		});
		
	}
}

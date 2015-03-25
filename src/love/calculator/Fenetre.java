package love.calculator;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.zip.CRC32;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Fenetre extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panel = new JPanel();
	private JButton button = new JButton();
	private JTextField nom1 = new JTextField();
	private JTextField nom2 = new JTextField();
	
	public Fenetre()
	{
		setTitle("Compatible ?");
		setSize(300,120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		nom1.setPreferredSize(new Dimension(100, 30));
		nom2.setPreferredSize(new Dimension(100, 30));
		
		panel.add(nom1);
		panel.add(nom2);
		
		button.setText("CALCULER");
		
		
		panel.add(button);
		
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!nom1.getText().equals("") && !nom2.getText().equals(""))
				{	
					long compat = getCompat(nom1.getText(), nom2.getText());
					String text = nom1.getText() + " et " + nom2.getText() + 
							" ont " + compat + "% de compatibilité amoureuse !";
					JOptionPane.showMessageDialog(null, text, "Résultats", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Vous devez renseigner les deux noms !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {	
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
		});
		
		setContentPane(panel);
		setVisible(true);
	}
	
	public long getCompat(String nom1, String nom2)
	{
		CRC32 crc1 = new CRC32();
		CRC32 crc2 = new CRC32();
		
		crc1.update(nom1.getBytes());
		crc2.update(nom2.getBytes());
		
		long compta = (crc1.getValue() + crc2.getValue())%101;
		
		return compta;
	}

}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Content extends JPanel {
	int cant = 12;
	
	private JTextField amount;

	public Content() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0 };
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 400, 0 };
		setLayout(gridBagLayout);

		contentInputs();
		contentNumbersDecimal();
		contentGraphics();
	}

	public void contentInputs() {
		JPanel contentInput = new JPanel();
		contentInput.setBackground(Color.WHITE);
		GridBagConstraints gbc_contentInput = new GridBagConstraints();
		gbc_contentInput.insets = new Insets(0, 0, 5, 5);
		gbc_contentInput.fill = GridBagConstraints.BOTH;
		gbc_contentInput.gridx = 0;
		gbc_contentInput.gridy = 0;
		add(contentInput, gbc_contentInput);
		contentInput.setLayout(new BorderLayout(0, 0));
		{
			JButton btnGraficar = new JButton("Graficar");
			btnGraficar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnGraficar.setForeground(Color.WHITE);
			btnGraficar.setBackground(Color.BLACK);
			contentInput.add(btnGraficar, BorderLayout.EAST);
		}
		{
			JPanel requets = new JPanel();
			requets.setBackground(Color.WHITE);
			contentInput.add(requets, BorderLayout.CENTER);
			requets.setLayout(new GridLayout(2, 0, 0, 0));
			{
				JPanel requestData = new JPanel();
				requestData.setBackground(Color.WHITE);
				requets.add(requestData);
				requestData.setLayout(null);
				
				JLabel lblIngreseCantidadDe = new JLabel("Ingrese cantidad de numeros: ");
				lblIngreseCantidadDe.setBounds(10, 11, 177, 14);
				requestData.add(lblIngreseCantidadDe);
				
				amount = new JTextField();
				amount.setBounds(184, 8, 65, 20);
				requestData.add(amount);
				amount.setColumns(10);
			}
			{
				JPanel contentInputs = new JPanel();
				FlowLayout flowLayout = (FlowLayout) contentInputs.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				contentInputs.setBackground(Color.WHITE);
				requets.add(contentInputs);
				
				for (int i = 0; i < 20; i++) {
					JTextField textField = new JTextField();
					textField.setHorizontalAlignment(SwingConstants.CENTER);
					contentInputs.add(textField);
					textField.setColumns(4);
				}
			}
			
		}
	}

	public void contentNumbersDecimal() {
		JPanel contentNumberDecimal = new JPanel();
		contentNumberDecimal.setPreferredSize(new Dimension(10, 30));
		contentNumberDecimal.setMinimumSize(new Dimension(10, 45));
		contentNumberDecimal.setBackground(Color.WHITE);
		GridBagConstraints gbc_contentNumberDecimal = new GridBagConstraints();
		gbc_contentNumberDecimal.insets = new Insets(0, 5, 5, 5);
		gbc_contentNumberDecimal.fill = GridBagConstraints.BOTH;
		gbc_contentNumberDecimal.gridx = 0;
		gbc_contentNumberDecimal.gridy = 1;
		
		add(contentNumberDecimal, gbc_contentNumberDecimal);
		contentNumberDecimal.setLayout(new GridLayout(1, 0, 0, 0));
		Font f = new Font("Arial", Font.BOLD,15);
		
		String numbers[] = {"1","30","129","200","123","34","1","103","96","45","32","122"};
		for (int i = 0; i < cant; i++) {
			JLabel l = new JLabel(numbers[i]);
			l.setFont(f);
			l.setHorizontalAlignment(SwingConstants.CENTER);
			l.setOpaque(true);
			l.setForeground(Color.WHITE);
			l.setBackground(generateColor());
			contentNumberDecimal.add(l);
		}
	}
	
	public void contentGraphics(){
		int c = cant * 8;
		GraphicAMI contentGraphic = new GraphicAMI(c);
		contentGraphic.setBackground(Color.WHITE);
		contentGraphic.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		GridBagConstraints gbc_contentGraphic = new GridBagConstraints();
		gbc_contentGraphic.insets = new Insets(0, 5, 50, 5);
		gbc_contentGraphic.fill = GridBagConstraints.BOTH;
		gbc_contentGraphic.gridx = 0;
		gbc_contentGraphic.gridy = 2;
		add(contentGraphic, gbc_contentGraphic);
	}
	
	public Color generateColor() {
		int b = (int) ((Math.random()*50)+200);
		return new Color(50,50,b);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("AMI");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.width);
		int height = (int) (screenSize.height * 0.8);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().add(new Content());
		frame.setVisible(true);
	}
}

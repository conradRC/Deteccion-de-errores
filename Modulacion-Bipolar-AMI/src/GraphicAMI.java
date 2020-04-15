import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class GraphicAMI extends JPanel {
	Graphics2D g2;
	double width;
	double height;
	int number = 0;
	double cant = 0;
	boolean bandera = true;
	public GraphicAMI(int num) {
		//setBackground(new Color(52,198,244));
		setBackground(Color.WHITE);
		number = num;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		width = getWidth();
		height = getHeight();
		g2.translate(0, (height / 2));
		
		cant = width / number;
		drawSignal();

		g2.setStroke(new BasicStroke(0.3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		g2.setColor(Color.green);
		
		drawEjeX();
		drawEjeY();
	}

	public void drawSignal() {
		g2.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		
		boolean flag = true;
		String[] binary = { "00000001", "00110110", "10000001", "10111011", "01110111", "11100011", "00000001",
				"00110110", "10000001", "10111011", "01110111", "11100011" };
		
		double y = height / 6;
		int count = -1;
		for (int i = 0; i < binary.length; i++) {
			
			for (int j = 0; j < binary[i].length(); j++) {
				g2.setColor(Color.BLUE);
				count++;
				char a = binary[i].charAt(j);
				if (a == '1' && flag == true) {
					sign(count, y, true);
					flag = false;
				} else if (a == '1' && flag != true) {
					sign(count, y, false);
					flag = true;
				} else {
					zero(count);
				}	
				drawText(count,a);
			}	
		}
	}

	public void drawText(int count,char num) {		
		g2.setColor(Color.BLACK);
		Font f = new Font("Georgia",Font.BOLD,15);
		setFont(f);
		int y = (int) (-height/3-50);
		int x = (int) ((cant/4)+(cant*count));
		g2.drawString(num+"",x,y);
	}

	public void sign(int i, double y, boolean revers) {
		double x = cant * i;
		double x1 = x + cant;
		double y0 = 0;

		if (revers) y = -y;

		drawLine(x, y0, x, y);
		drawLine(x, y, x1, y);
		drawLine(x1, y, x1, y0);
	}

	public void zero(int i) {
		double x = cant * i;
		double x1 = x + cant;
		drawLine(x, 0, x1, 0);
	}

	public void drawLine(double x, double y, double x1, double y1) {
		g2.draw(new Line2D.Double(x, -(y), x1, -(y1)));
	}

	public void drawEjeX() {
		drawLine(0, 0, width, 0);
	}

	public void drawEjeY() {
		g2.translate(0, height);
		double y0 = 0.0, x0 = 0.0, x1 = 0.0;
		double y1 = height * 2;

		for (double i = 0; i < number; i++) {
			drawLine(x0 + (cant * i), y0, x1 + (cant * i), y1);
		}
	}
}

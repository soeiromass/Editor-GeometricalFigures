package editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

class Triangulo extends Figura {
	protected Ponto p2;
	protected Ponto p3;
	protected int count;
	
	public Triangulo() {
		super();
		p2 = new Ponto();
		p3 = new Ponto();
		count = 0;
	}
	public Triangulo(int x, int y, int x2, int y2, int x3, int y3, Color cor) {
		super(x, y, cor);
		p2 = new Ponto(x2, y2);
		p3 = new Ponto(x3, y3);
	}

	public void desenha(Graphics g) {
		if (count == 3) {
			g.setColor(cor);
			int xPoints[] = {p.x, p2.x, p3.x};
			int yPoints[] = {p.y, p2.y, p3.y};
			g.drawPolygon(xPoints, yPoints, 3);
		}
	}

	public double Area() {
		// Usa o Teorema de Heron
		double s = Perimetro() / 2;
		double a = distancia(p, p2);
		double b = distancia(p2, p3);
		double c = distancia(p3, p);
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	public double Perimetro() {
		return distancia(p, p2) + distancia(p2, p3) + 
				distancia(p3, p);
	}
	private double distancia(Ponto r, Ponto s) {
		return Math.sqrt(
				Math.pow(r.x-s.x, 2) + 
				Math.pow(r.y-s.y, 2)
				);
	}
	public String mostrarInfo() {
    	return (" Area = " +Area() +" Perimetro = " +Perimetro()+
    			" Ponto 1 = " +p.x + "," +p.y +" Ponto 2 = " +p2.x +"," +p2.y +" Ponto 3 = " +p3.x +"," +p3.y);
    }
	public Ponto getP2() {
		return p2;
	}
	public void setP2(Ponto p2) {
		this.p2 = p2;
	}
	public Ponto getP3() {
		return p3;
	}
	public void setP3(Ponto p3) {
		this.p3 = p3;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean contains(int x, int y) {
		int xPoints[] = {p.x, p2.x, p3.x};
		int yPoints[] = {p.y, p2.y, p3.y};
		Polygon p = new Polygon(xPoints, yPoints, 3);
		if (p.contains(x, y)) {
			return true;
		}
		return false;
	}
	public void mover (int dx, int dy) {
    	p.x += dx;
    	p.y += dy;
    	p2.x += dx;
    	p2.y += dy;
    	p3.x += dx;
    	p3.y += dy;
    }
}

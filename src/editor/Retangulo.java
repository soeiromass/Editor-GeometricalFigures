package editor;
 
import java.awt.Color;
import java.awt.Graphics;
 
public class Retangulo extends Figura {
    int largura, altura;
   
    public Retangulo() {
        super();
        largura = altura = 0;
    }
   
    public Retangulo(int x, int y, int l, int a, Color cor) {
        super(x, y, cor);
        largura = l;
        altura = a;
    }
   
    @Override
    public void desenha(Graphics g) {
        g.setColor(cor);
        g.drawRect(p.x, p.y, largura, altura);
    }
   
    @Override
    public void setCoordenadas(int x1, int y1, int x2, int y2) {
        p.x = Math.min(x1, x2);
        p.y = Math.min(y1, y2);
        largura = Math.abs(x1-x2);
        altura = Math.abs(y1-y2);
    }
    
    public double Area() {
    	return altura * largura;
    }
    public double Perimetro() {
    	return (2 * altura) + (2 * largura);
    }
    @Override
    public String mostrarInfo() {
    	return (" Area = " +Area() +" Perimetro = " +Perimetro()+
    			" Ponto Inicial = " +p.x + "," +p.y +" largura = " + largura +" altura = "+altura);
    }
    public boolean contains(int x, int y) {
        return p.x <= x && x <= p.x+largura && p.y < y && y < p.y + altura;
    }
}
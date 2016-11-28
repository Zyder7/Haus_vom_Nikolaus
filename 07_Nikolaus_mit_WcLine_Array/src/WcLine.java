
import java.awt.Graphics;

public class WcLine {
    
    private WcPoint start;
    private WcPoint ziel;
    
    public WcLine (WcPoint start, WcPoint ziel){
        
        this.start = start;
        this.ziel = ziel;
    }
    
    public WcLine (double start_x, double start_y,double ziel_x, double ziel_y){
        
        this.start = new WcPoint(start_x, start_y);
        this.ziel = new WcPoint(ziel_x, ziel_y);
    }
            
    public void draw (Graphics g){
        g.drawLine(start.getPixelX(), start.getPixelY(), ziel.getPixelX(), ziel.getPixelY());
    }
    
}

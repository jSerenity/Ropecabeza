import javax.swing.JButton;
public class XYBotones extends JButton {
   
    private  int y;
    private  int x;
    private int id;
    public XYBotones(String t, int x, int y, int id) {
    super(t);
    //setLocation(27, 20);
    setVisible(true);
    this.id = id;
    this.y = y;
    this.x = x;
    }

    public int getY() {
    return y;
    }

    public int getX() {
    return x;
    }

    public void setY(int Y) {
        y = Y;
    }
    
    public void setX(int X) {
        x = X;
    }
}
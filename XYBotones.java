import javax.swing.JButton;
public class XYBotones extends JButton {
   
    private final int Row;
    private final int Col;

    public XYBotones(String t, int col, int row) {
    super(t);
    //setLocation(27, 20);
    setVisible(true);
    
    this.Row = row;
    this.Col = col;
    }

    public int getRow() {
    return Row;
    }

    public int getCol() {
    return Col;
    }
}
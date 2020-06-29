import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.*;

public class Garrido_016_Proy2 extends JFrame {
    private static final int ROWS = 4;
    private static final int COLS = 4;
    private int intentos = 0;
    private int inicio=0;
    private Random rnd;
    private static String[] presentation = { "Universidad Tecnologica de Panama",
            "Facultad de Ing. de Sistemas Computacionales", "Carrera: Desarrollo de Software", "Profesor: Ricardo Chan",
            "Estudiante: Alba Garrido", "Cedula: 7-709-2016", "Grupo: ILS222", "Fecha: 31 de Mayo de 2020" };
    PuzzleHide PuzzleHide = new PuzzleHide();

    final JPanel panelButton = new JPanel();
    private JButton[][] bototnes = new JButton[4][4]; 
    private JLabel Intentos = new JLabel("intentos: 0");

    public Garrido_016_Proy2() {
        super("Puzzle..");
        initComponents();
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rnd= new Random();
    }

    protected void initComponents() {

       
        final JPanel panelMandos = new JPanel(new FlowLayout());
        final JPanel panelpresen = new JPanel();
        final JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.LIGHT_GRAY);
        panelInfo.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelInfo.setLayout(new GridLayout(40, 1));
        panelInfo.add(Intentos);

        JButton Start = new JButton("Iniciar");
        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                start();
            }
        });

        panelMandos.add(Start, BorderLayout.WEST);
        panelMandos.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mover(e.getSource());
            }
        };

        panelButton.setLayout(null);
        int index=1;
        for (int y = 0; y <ROWS; y++) {
            for (int x = 0 ; x < COLS; x++) {
                bototnes[x][y] = new JButton(String.valueOf(index));
                bototnes[x][y].addActionListener(buttonListener);
                index++;
                
                panelButton.add(bototnes[x][y]);
                bototnes[x][y].setBounds(x * 50, y * 50, 50, 50);
                panelButton.updateUI();            
            }
        }
        bototnes[3][3].setForeground(Color.green);
        bototnes[3][3].setBorderPainted(false);
        bototnes[3][3].setContentAreaFilled(false);
        panelpresen.setLayout(new GridLayout(20, 2));
        panelpresen.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelpresen.setBackground(Color.LIGHT_GRAY);
        panelpresen.setBorder(new EmptyBorder(10, 10, 10, 10));
        for (final String text : presentation) {
            final JLabel label = new JLabel();
            label.setText(text);
            panelpresen.add(label);
        }
        panelMandos.setBackground(Color.LIGHT_GRAY);

        add(panelMandos, BorderLayout.NORTH);
        add(panelpresen, BorderLayout.WEST);
        JPanel p = new JPanel(new BorderLayout());

        p.add(panelButton, BorderLayout.CENTER);
        add(p, BorderLayout.CENTER);
        add(panelInfo, BorderLayout.EAST);
    }

    public void mover(Object b) {
        JButton botonselected = ((JButton) b);
        int bx = botonselected.getX()/50;
        int by = botonselected.getY()/50; 
        try {
            if(inicio!=0)
            {
                intentos++;
                Intentos.setText("intentos: "+intentos);
                int xBk, yBk,xOr,yOr;
                if(distancia(bx,by)==1)
                {
                xBk= botonselected.getX();
                yBk= botonselected.getY();
                xOr= bototnes[3][3].getLocation().x;
                yOr= bototnes[3][3].getLocation().y;
                System.out.println("xBk: "+xBk+" yBk "+yBk+" xOr "+xOr+" yOr "+yOr); 
                botonselected.setLocation(xOr, yOr);
                bototnes[3][3].setLocation(xBk, yBk); 
                }                                
            }
          }
          catch(Exception e) {
            System.out.println("EXECTIOM: "+e);  
          } 

    }

    public void start(){

        int xBk, yBk, newPx, newPy;
        
        try {
            if(inicio==0)
            {
                inicio++;
                for (int y = 0; y <ROWS; y++) {
                    for (int x = 0 ; x < COLS; x++) {
                        newPx = rnd.nextInt(4);
                        newPy = rnd.nextInt(4);
                        
                        if(x ==3&& y==3 || newPx==3 && newPy==3 ){
                        
                        }else{
                            xBk = bototnes[x][y].getLocation().x;
                            yBk = bototnes[x][y].getLocation().y; 

                            bototnes[x][y].setLocation(bototnes[newPx][newPy].getLocation().x, bototnes[newPx][newPy].getLocation().y);
                            bototnes[newPx][newPy].setLocation(xBk, yBk); 
                        }   
                    }
                } 
            }
          }
          catch(Exception e) {
            System.out.println("EXECTIOM: "+e);  
          } 
    }
    public float distancia(int bx, int by){
         float dist=0;
         int sx = bototnes[3][3].getLocation().x/50;
         int sy = bototnes[3][3].getLocation().y/50; 
         float x= (float) Math.pow((bx-sx), 2);
         float y= (float) Math.pow((by-sy), 2); 
         dist =(float)Math.sqrt((x+y));
         
        return dist;
    }
    public int calculateProgress(int startValue, int endValue, double fraction) 
    {
        int value = 0; 
        int distance = endValue - startValue; 
        value = (int) Math.round((double) distance * fraction); 
        value += startValue; 
        return value; 
    }

   

   

   
}

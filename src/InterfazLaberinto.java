/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Samuel
 */
public class InterfazLaberinto extends javax.swing.JFrame {

    public ArrayList<ArrayList<Integer>> Maze = new ArrayList<ArrayList<Integer>>();
    
         
    private final List<Integer> path = new ArrayList<Integer>();
    private int pathIndex;
    /**
     * Creates new form InterfazLaberinto
     */
    public InterfazLaberinto() throws IOException {
        //0--Espacio vacio
        //1--Muro
        //2--Entrada
        //3--Salida
        
        
        initComponents();
        
        this.Leer();
        AlgoritmoBF.BuscarCaminos(Maze, 1, 1, path);
        pathIndex = path.size() - 2;
        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.translate(50, 50);
        
        for (int row = 0; row < Maze.size(); row++) {
            
            for (int col = 0; col < Maze.get(row).size(); col++) {
                Color color;
                switch (Maze.get(row).get(col)) {
                    case 1 : color = Color.BLUE; break;
                    case 2 : color = Color.GREEN; break;
                    case 3 : color = Color.ORANGE; break;
                    
                    default : color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(40 * col, 40 * row, 40, 40);
                g.setColor(Color.BLACK);
                g.drawRect(40 * col, 40 * row, 40, 40);
            }
        }
        
        for (int p = 0; p < path.size(); p += 2) {
            int pathX = path.get(p);
            int pathY = path.get(p + 1);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(pathX * 40, pathY * 40, 40, 40);
        }
        
        
        

        
    }

    public void Leer() throws IOException{
        String csvFile = "C:\\Users\\Samuel\\Documents\\NetBeansProjects\\IA1_Proyecto_20081924\\src\\Entrada.csv";
        BufferedReader br = null;
        String line = "";        
        ArrayList<Integer> Fila = new ArrayList<Integer>();
        try {
            
            br = new BufferedReader(new FileReader(csvFile));
            int valor = 0;
            while ((line = br.readLine()) != null) {
                Fila = new ArrayList<Integer>();
                for (String retval: line.split(",")) {
                      //System.out.println(retval);                      
                      //Fila.add(Integer.getInteger(retval));
                      valor = Integer.parseInt(retval.toString().trim());
                      Fila.add(valor);
                }
                 Maze.add(Fila);
                //System.out.println("Fila " + Fila.size() + " ");
               
            }
            System.out.println(Maze.size());
          
            
        /*for (int row = 0; row < Maze.size(); row++) {
            
            for (int col = 0; col < Maze.get(row).size(); col++) {
                System.out.println(Maze.get(row).get(col).toString());
                }
              
            }
        */
            
        

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 877, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazLaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazLaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazLaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazLaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InterfazLaberinto().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InterfazLaberinto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
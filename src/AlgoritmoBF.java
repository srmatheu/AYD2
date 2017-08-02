/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Samuel
 */
public class AlgoritmoBF {    
      
    public static boolean BuscarCaminos(ArrayList<ArrayList<Integer>> Laberinto, int x, int y, List<Integer> Camino) {
        
        //Significa que es salida
        if (Laberinto.get(y).get(x) == 3) {
            Camino.add(x);
            Camino.add(y);
            return true;
        }
        
        //Nodo libre
        if (Laberinto.get(y).get(x) == 0) {
            Laberinto.get(y).set(x,4);//No visitado, esto es para mostrarlo en la interfaz gráfica
            
            //Ver que hay a la izquierda
            int dx = -1;
            int dy = 0;
            if (BuscarCaminos(Laberinto, x + dx, y + dy, Camino)) {
                Camino.add(x);
                Camino.add(y);
                return true;
            }

            //Ver que hay a la derecha
            dx = 1;
            dy = 0;
            if (BuscarCaminos(Laberinto, x + dx, y + dy, Camino)) {
                Camino.add(x);
                Camino.add(y);
                return true;
            }

            //Ver que hay hacia arriba
            dx = 0;
            dy = -1;
            if (BuscarCaminos(Laberinto, x + dx, y + dy, Camino)) {
                Camino.add(x);
                Camino.add(y);
                return true;
            }

            //Ver que hay abajo
            dx = 0;
            dy = 1;
            if (BuscarCaminos(Laberinto, x + dx, y + dy, Camino)) {
                Camino.add(x);
                Camino.add(y);
                return true;
            }
        }
        return false;
    }
        
}

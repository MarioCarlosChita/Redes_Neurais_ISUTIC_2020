/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoredes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mario.chita
 */
public class ProjectoRedes {
 
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        
        Tipo matrix[] = new Tipo[4];
        
        
        fill_matrix(matrix);
        int[] o1 = {-1, -1, -1};
        int[] o2 = {-1, 1, 1};
        int[] o3 = {1, -1, -1};
        int[] o4 = {1, 1, -1};

        matrix[0].lista = o1;
        matrix[1].lista = o2;
        matrix[2].lista = o3;
        matrix[3].lista = o4;

        int W1 = 0;
        int W2 = 0;

        int WS1 = -1;
        int WS2 = -1;

        // variaveis constantes;
        int Threod = 1;
        int lambada = 1;
        int posicao = 0;

        while (posicao != matrix.length) {

            for (int i = 0; i < matrix[posicao].lista.length; ++i) {

                int X1 = matrix[i].lista[0];
                int X2 = matrix[i].lista[1];
                int T = matrix[i].lista[2];
                
                // soma da  funcao 
                int Y_in = X1 * W1 + X2 * W2;
                
                 int Y;
                // condicao da  funcao da Activacao 
                if (Y_in >= Threod) {
                    Y = 1;
                } else {
                    Y = -1;
                }
                W1 = W1 + lambada * (T - Y) * X1;
                W2 = W2 + lambada * (T - Y) * X2;
                
                
                System.out.println("Interacao: " + (i + 1));
                System.out.println("Y_in:" + Y_in);
                System.out.println("Y:" + Y);
                System.out.println("W1:" + W1);
                System.out.println("W2:" + W2);
                System.out.println("-------------------------");
            }
            if (posicao == matrix.length - 1) {
                break;
            }
            posicao++;

        }

    }

    public static void fill_matrix(Tipo[] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            matrix[i] = new Tipo();
        }
    }
}

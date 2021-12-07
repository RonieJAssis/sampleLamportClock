/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lamportclock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.edu.ifsul.lamportclock.model.Process;

/**
 *
 * @author ronie
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        int interval = 1;
        int aux,aux2,aux3,aux4;
        List<Process> listProcess = new ArrayList<>();
        System.out.println("Qual a quantidade de processos? (2 ou mais)");
        aux = c.nextInt();

        if (aux > 1) {
            for (int i = 0; i < aux; i++) {
                listProcess.add(new Process(interval));
                interval += 2;
            }

            while (true) {
                for (Process p : listProcess) {
                    p.show();
                    System.out.println("");
                }
                System.out.println("deseja continuar a execução? (1 para sim e 0 para não)");
                aux = c.nextInt();
                if(aux == 0){
                    System.out.println("Adeus!!");
                    break;
                }
                System.out.println("Qual o processo emissor (1 a "+listProcess.size()+")");
                aux = c.nextInt();
                System.out.println("Em qual indice de tempo (1 a 10)");
                aux3 = c.nextInt();
                System.out.println("Qual o processo receptor (diferente da opção anterior e de 1 a "+listProcess.size()+")");
                aux2 = c.nextInt();
                System.out.println("Em qual indice de tempo (1 a 10)");
                aux4 = c.nextInt();
                if(aux!=aux2 && (aux>=1 && aux<= listProcess.size()) && (aux2>=1 && aux2<= listProcess.size()) && (aux3>=1 && aux3<=10) && (aux4>=1 && aux4<=10) ){
                    listProcess.get(aux2-1).setTime(aux4,listProcess.get(aux-1).getTime(aux3));
                }else{
                    System.out.println("valores invalidos!!!");
                }
            }
        } else {
            System.out.println("Numero de processos invalido");
        }

    }

}

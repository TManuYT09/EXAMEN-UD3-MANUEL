import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void ejercicio1(){
        Scanner entrada=new Scanner(System.in);
        Random random=new Random();
        System.out.println("*** BIENVENIDO AL BINGO DEL CASINO CANTÁBRICO ***");

        int num_bolas= random.nextInt(10,40);
        Integer resultado[]=new Integer[num_bolas];

        for (int i = 0; i < num_bolas; i++) {
            resultado[i]=random.nextInt(1,90);
        }
        Arrays.stream(resultado).distinct();

        System.out.println(num_bolas+ " bolas extraídas hasta ahora: "+ Arrays.toString(resultado));

        System.out.println("*** Introduce los datos de tu cartón ***");
        Integer carton[][]=new Integer[3][3];
        boolean comp=false;
        for (int i = 0; i < carton.length; i++) {
            System.out.println("Fila "+ (i+1));
            String fila=entrada.next();

            if (fila.matches("[0-9]+-[0-9]+-[0-9]+")){
                String filas[]=fila.split("-");
                for (int j = 0; j < carton[0].length; j++) {
                    carton[i][j]=Integer.valueOf(filas[j]);
                }
                comp=true;
            }else {
                System.out.println("Cerrando programa... Introduce valores con el formato correcto (N-N-N)");
                comp=false;
                break;
            }
        }

        if (comp){
            comp=false;
            System.out.println("Datos del cartón introducido:");
            for (int i = 0; i < carton.length; i++) {
                for (int j = 0; j < carton[i].length; j++) {
                    System.out.print(carton[i][j]+" ");
                }
                System.out.print("\n");
            }
            System.out.println("\nPREMIO");
            for (int i = 0; i < carton.length; i++) {
                for (int j = 0; j < carton[i].length; j++) {
                    if (Arrays.asList(resultado).contains(carton[i][j])){
                        System.out.println("HAY BINGO!!");
                        comp=true;
                        break;
                    }
                }
            }
            if (!comp){
                System.out.println("No hay BINGO.");
                
            }
        }

    }
}

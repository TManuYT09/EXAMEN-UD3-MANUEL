import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void ejercicio1(){
        Scanner entrada=new Scanner(System.in);
        Random random=new Random();
        System.out.println("*** BIENVENIDO AL BINGO DEL CASINO CANTÁBRICO ***");

        //Generamos el numero de bolas que hay
        int num_bolas= random.nextInt(10,40);
        Integer resultado[]=new Integer[num_bolas];

        //Generamos para cada bola un valor entre el 1 al 90
        for (int i = 0; i < num_bolas; i++) {
            resultado[i]=random.nextInt(1,90);
        }
        //Eliminamos los duplicados
        Arrays.stream(resultado).distinct();

        System.out.println(num_bolas+ " bolas extraídas hasta ahora: "+ Arrays.toString(resultado));

        System.out.println("*** Introduce los datos de tu cartón ***");
        Integer carton[][]=new Integer[3][3];
        boolean comp=false;
        for (int i = 0; i < carton.length; i++) {
            System.out.println("Fila "+ (i+1));
            //Introducimos la fila con el formato N-N-N
            String fila=entrada.next();

            if (fila.matches("[0-9]+-[0-9]+-[0-9]+")){ //Si no tiene el formarto de N-N-N se corta el programa
                //Guardamos la primera fila en la primera fila del carton
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
            //Mostramos por pantalla el carton que se a puesto
            for (int i = 0; i < carton.length; i++) {
                for (int j = 0; j < carton[i].length; j++) {
                    System.out.print(carton[i][j]+" ");
                }
                System.out.print("\n");
            }
            System.out.println("\nPREMIO");
            //Como el carton es de 3x3, o sea 9 numeros, comprobamos que si la variable bingo es igual a 9 significa que hay bingo
            int bingo=0;
            for (int i = 0; i < carton.length; i++) {
                for (int j = 0; j < carton[i].length; j++) {
                    if (Arrays.asList(resultado).contains(carton[i][j])){
                        bingo++;
                    }
                }
            }
            //Se muestra si huvo bingo o no
            if(bingo==9){
                System.out.println("HAY BINGO!!");
                comp=true;
            }else {
                System.out.println("No hay BINGO");
                comp=false;
            }

            //Cuando no hay bingo se ejecuta lo siguiente, comprobando cada numero posicion por posicion
            if (!comp){
                //Como sabemos que una fila del carton esta compuesta por 3 numeros, si la variable cant es igual a 3 significa que hemos hecho linea
                int cant=0;
                for (int i = 0; i < carton.length; i++) {
                    cant=0;
                    System.out.print("Linea "+(i+1)+": ");
                    for (int j = 0; j < carton[0].length; j++) {//Aqui se comprueba por cada numero de la fila si es uno de los valores de las bolas
                        if (Arrays.asList(resultado).contains(carton[i][j])){
                            cant++;
                        }
                    }
                    //Se muestra si hubo linea ono
                    if (cant==3){
                        System.out.print("CORRECTA!!");
                    }else {
                        System.out.print("NO");
                    }
                    System.out.print("\n");
                }
            }
        }

    }
}

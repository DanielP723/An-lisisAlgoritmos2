
import java.util.Arrays;


public class Main {
    
    public static void main(String[] args) {
        int Peso[] = {100,155,50,112,70,80,60,118,110,55};
        Arrays.sort(Peso);
        int cantMax = 700;
        int cant = 0;
        int cont = 0;
        for(int i=0; cant+Peso[i+1] < cantMax; i++){
            cant += Peso[i];
            cont ++;
        }
        System.out.println("El carguero puede cargar " + cant+ " toneladas,"
                + " es decir " + cont + " contenedores");
    }
}

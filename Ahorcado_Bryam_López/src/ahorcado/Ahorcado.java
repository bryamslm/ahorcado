package ahorcado;
import java.util.LinkedList;

public class Ahorcado {
    static private String palabraSecreta;
    static private boolean palabraValida;
    static private String palabaConGuiones;
    static private int contadorIntentos;
    static private char caracter;
    static private int contadorAciertos;
    static GraficaAhorcado grafica;
    static private LinkedList<String>letrasEncontradas;
    
    public static void main(String[] args){
        
        inicio(); 
    }
    public static void inicio(){
        contadorAciertos=0;
        contadorIntentos=0;
        palabraValida = false;
        letrasEncontradas=new LinkedList<>();
        palabaConGuiones="";
        String palabras[]={"BANANO", "PERA", "MANGO", "NARANJA", "UVA", "JOCOTE", "CEREZA", "HIGO",
        "MANZANA", "CIRUELA", "ALMENDRA", "NUEZ", "CASTAÑA", "PISTACHO", "KIWI"};
        int aleatorio=(int)(Math.random()*15); 
        String palabra=palabras[aleatorio];
        palabraSecreta=palabraSecretaGuiones(palabra);
        grafica=new GraficaAhorcado(palabraSecreta);      
        palabraGuiones(palabra);
        grafica.cambiarImagen("./src/Imagenes/HORCAVACIA.png");
        grafica.setVisible(true);   
        
    }
    
    static String palabraSecretaGuiones(String palabra){
        String palabra2="";
        for(int indice=0;indice< palabra.length(); indice++){           
            if(indice==0){
                palabra2=palabra2+palabra.substring(indice, indice+1);
            }else{
                 palabra2=palabra2+" "+palabra.substring(indice, indice+1);
            }
        }
        System.out.println(palabra2);
        return palabra2;
    }
    
    public static String buscaLetra(String entradaLetra){      
        caracter=entradaLetra.charAt(0);      
        palabraValida=verificaPalabra(caracter);      
        if (palabraValida==true) {
            grafica.setInformacion("La letra está en la plabra");
            return palabaConGuiones;          
        } else {
            contadorIntentos++;         
                if(contadorIntentos== 1){
                    grafica.cambiarImagen("./src/Imagenes/PERDIO1.png");
                    grafica.setInformacion("La letra no está en la plabra");
                }           
                else if(contadorIntentos== 2){
                    grafica.cambiarImagen("./src/Imagenes/PERDIO2.png");
                    grafica.setInformacion("La letra no está en la plabra");
                }          
                else if(contadorIntentos== 3){
                    grafica.cambiarImagen("./src/Imagenes/PERDIO3.png");
                    grafica.setInformacion("La letra no está en la plabra");
                }           
              else if(contadorIntentos== 4) {
                    grafica.cambiarImagen("./src/Imagenes/PERDIO4.png");
                    grafica.setInformacion("La letra no está en la plabra");
                }
               else if(contadorIntentos== 5){
                    grafica.cambiarImagen("./src/Imagenes/PERDIO5.png");
                    grafica.setInformacion("La letra no está en la plabra");
                }
                else if(contadorIntentos== 6){
                    grafica.cambiarImagen("./src/Imagenes/PERDIOFINAL.png");
                    grafica.setInformacion(null);
                }
            }
            return palabaConGuiones;
    }
    static boolean verificaPalabra(char caracter){
        boolean verificado=false;
        for(String letra: letrasEncontradas){
            if(letra.charAt(0)==caracter){
                return true;
            }
        }

        for(int j=0; j< palabraSecreta.length(); j++){//recorre la palabra secreta
            char palabra= palabraSecreta.charAt(j);//sacar caracter de la posici�n j del string
            //ciclo que si encuetra palabra igual la reemplaza en los guiones bajos
            if(palabra == caracter){
                palabaConGuiones=(palabaConGuiones.substring(0, j)+ caracter+palabaConGuiones.substring(j+1, palabaConGuiones.length()));
                verificado=true;
                contadorAciertos++;
            }
            if(verificado){
                letrasEncontradas.add(String.valueOf(caracter));
            }
        }
        return verificado;
    }
    static void palabraGuiones(String palabra){
        int contador = 0;
        while(contador < palabra.length()){//Para saber cuantos guiones bajos lleva el string
            if("".equals(palabaConGuiones)){
                palabaConGuiones+="_";
            }else{
            palabaConGuiones+=" _";
            }
            contador++;
        }
        grafica.setPalabraGuiones(palabaConGuiones);
    } 
}

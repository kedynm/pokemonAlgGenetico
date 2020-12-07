
package geneticalgorithmtest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Kedyn Molina
 * @author 
 */
public class GeneticAlgorithmTest {
    
    public static float probabilidadCruce = 0.65f;
    public static float probabilidadMutacion = 0.75f;
    public static int numeroIndividuos = 8;
    public static int numeroCromosomas = 5;
    public static int numeroHijosCruce = 2;
    public static int numeroGeneracion = 0;
    
    public static Individuo [] individuos;
    public static Individuo [] hijos;
    
    
    public static void main(String[] args) {
        
        individuos = new Individuo[numeroIndividuos];  
        OperadoresGeneticos operadores = new OperadoresGeneticos();
        
        int contadorPokemon = 0;
        
        
        individuos = generarPoblacionInicial();
        
        imprimirDatosIniciales();    
        
        do { 
            contadorPokemon = 0;
           
            imprimirIndividuos();
            operadores.crearNuevaGeneracion(individuos);
            
            numeroGeneracion++;
            
            for (int j = 0; j < numeroIndividuos; j++) {
                if(80 < individuos[j].getPromedioHabilidades()){
                    contadorPokemon++;
                }
            }
     
        } while(contadorPokemon != 8);
        
        imprimirIndividuos();
        
        System.out.println();
        System.out.println("Los POKEMONES de la GENERACION " + (numeroGeneracion+1)+ " son los de mas Alto nivel");
    }
    
    
    public static void imprimirDatosIniciales(){
        System.out.println("POBLACIÓN:\t\t Pokemones con caracteristicas de Alto Nivel");
        System.out.println("No.de INDIVIDUOS:\t " + numeroIndividuos);
        System.out.println("FUNCIÓN FITNESS:\t Σ habilidad");
        System.out.println("SELECCIÓN:\t\t Heurística");
        System.out.println("CRUCE:\t\t\t 1 Punto");
        System.out.println("MUTACIÓN:\t\t heuristica");
        System.out.println("PROBABILIDAD DE CRUCE:\t " + (probabilidadCruce*100) + "%");
        System.out.println("PROBABILIDAD DE MUTACIÓN:" + (probabilidadMutacion*100) + "%");
        System.out.println("CRITERIO DE PARADA:\t Nivel mayor a 80");
        System.out.println("\nHABILIDADES QUE DEFINEN EL NIVEL: \n");
        
        System.out.println("VEL: Velocidad");
        System.out.println("ATQ: Ataque");
        System.out.println("VD : Vida");
        System.out.println("DEF: Defensa");
        System.out.println("RES: Resistencia");
               
    }
    
    public static void imprimirIndividuos(){
        System.out.println("\n......................:::GENERACIÓN "+(numeroGeneracion+1)+" DE POKEMONES :::.......................");
        System.out.println("\nINDIVIDUOS GENERACIÓN: " + (numeroGeneracion+1) + "\n");
        System.out.println("\t\tVEL\t ATQ\t VD\t DEF\t RES\t");
        
        for (int i = 0; i < numeroIndividuos; i++) {
            
            System.out.print("individuo " + (i+1) + ":\t");
            
            for (int j = 0; j < numeroCromosomas; j++) {
                
               System.out.print(individuos[i].getCromosoma(j) + "\t");   
            }
            
            System.out.println();
            System.out.print("Habilidades: \t");
            
            for (int j = 0; j < numeroCromosomas; j++) {    
                System.out.print(individuos[i].getPuntuacionHabilidades()[j] + "\t"); 
            }
            
            System.out.println("PROMEDIO HABILIDADES: " + individuos[i].getPromedioHabilidades());
          
        }
    }
    
    public static Individuo[] generarPoblacionInicial() {
        Individuo[] individuosGenerados = new Individuo[numeroIndividuos];
        int idIndividuo = 0;
        
        for (int i = 0; i < numeroIndividuos; i++) {
            individuosGenerados[i] = generarIndividuo(idIndividuo);
            idIndividuo++;
        }
        
        return individuosGenerados;
    }
    
    public static Individuo generarIndividuo(int id){ 
        int [] cromosomas = new int [numeroCromosomas];
        int [] habilidades = new int [numeroCromosomas];
        
        for (int i = 0; i < numeroCromosomas; i++) {    
            int valorCromosoma = valoresAleatoriosEnteros("cromosoma"); 
            cromosomas[i] = valorCromosoma;
            if (valorCromosoma == 1) {
                habilidades[i] = valoresAleatoriosEnteros("valorHabillidades");//
            } else {
                habilidades[i] = 0;
            }  
        } 
        
        Individuo futbolista = new Individuo(id,cromosomas,habilidades);
        
        return futbolista;
    }
    
    public static int valoresAleatoriosEnteros(String tipoValor){
        switch(tipoValor){
            case "cromosoma":
                return (int) (Math.random() * 2);
            case "valorHabillidades":
                return (int) (Math.random() * 100) + 1;
        }
        
        return 0;
    } 
    
    public static float valoresAleatoriosReales() {
        BigDecimal bd = new BigDecimal((Math.random() * 1)).setScale(2, RoundingMode.HALF_UP);
        return (float) bd.doubleValue();
    }
}

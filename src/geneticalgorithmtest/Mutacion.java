
package geneticalgorithmtest;

public class Mutacion {
    
    private Individuo[] hijosCruzados;
    private Individuo[] hijosMutados;
    float[] proMutacion0;
    float[] proMutacion1;
    int puntoMutacion0; 
    int puntoMutacion1;
      
    
    public Mutacion(Individuo[] hijos){
        this.hijosCruzados = hijos;
        this.hijosMutados = new Individuo[2];
        proMutacion0 = new float[GeneticAlgorithmTest.numeroCromosomas];
        proMutacion1 = new float[GeneticAlgorithmTest.numeroCromosomas];
    }
    
    public Individuo[] mutar() {
        hijosMutados[0] = new Individuo(hijosCruzados[0].getId(),
                hijosCruzados[0].getCromosomas().clone(),
                hijosCruzados[0].getPuntuacionHabilidades().clone());

        hijosMutados[1] = new Individuo(hijosCruzados[1].getId(),
                hijosCruzados[1].getCromosomas().clone(),
                hijosCruzados[1].getPuntuacionHabilidades().clone());

        generarProbabilidadMutacion();
        int[] puntoMutacion = buscarPuntosMutacion();

        boolean posicionEncontrada0 = false;
        boolean posicionEncontrada1 = false;

        for (int i = 0; i < GeneticAlgorithmTest.numeroCromosomas; i++) {

            if (puntoMutacion[0] == i && !posicionEncontrada0) {
                if (hijosCruzados[0].getCromosoma(i) == 0) {
                    hijosMutados[0].setCromosoma(i, 1);
                    hijosMutados[0].setPuntuaionHabilidad(i, GeneticAlgorithmTest.valoresAleatoriosEnteros("valorHabillidades"));
                } else {
                   hijosMutados[0].setPuntuaionHabilidad(i, GeneticAlgorithmTest.valoresAleatoriosEnteros("valorHabillidades"));                   
                }
                
                posicionEncontrada0 = true; 
            }

            if (puntoMutacion[1] == i && !posicionEncontrada1) {
                if (hijosCruzados[1].getCromosoma(i) == 0) {
                    hijosMutados[1].setCromosoma(i, 1);
                    hijosMutados[1].setPuntuaionHabilidad(i, GeneticAlgorithmTest.valoresAleatoriosEnteros("valorHabillidades"));
                } else {
                   hijosMutados[1].setPuntuaionHabilidad(i, GeneticAlgorithmTest.valoresAleatoriosEnteros("valorHabillidades"));
                }
                
                posicionEncontrada1 = true; 
            }

            if (posicionEncontrada0 && posicionEncontrada1) {
                break;
            }

        }
        
        this.puntoMutacion0 = puntoMutacion[0];
        this.puntoMutacion1 = puntoMutacion[1];
        
        return hijosMutados;
       
    }

    public void generarProbabilidadMutacion() {
        for (int i = 0; i < GeneticAlgorithmTest.numeroCromosomas; i++) {
            proMutacion0[i] = GeneticAlgorithmTest.valoresAleatoriosReales();
            proMutacion1[i] = GeneticAlgorithmTest.valoresAleatoriosReales();
        }

        hijosCruzados[0].setValorProbabilidadesMutacion(proMutacion0);
        hijosCruzados[1].setValorProbabilidadesMutacion(proMutacion1);
    }

    public int[] buscarPuntosMutacion() {
        int[] posicionesPuntoMutacion = new int[2];

        float distanciaMasCortaPuntoMutacion0 = Math.abs(GeneticAlgorithmTest.probabilidadMutacion   
                - hijosCruzados[0].getValorProbabilidadesMutacion()[0]);

        float distanciaMasCortaPuntoMutacion1 = Math.abs(GeneticAlgorithmTest.probabilidadMutacion
                - hijosCruzados[1].getValorProbabilidadesMutacion()[0]);

        for (int i = 0; i < GeneticAlgorithmTest.numeroCromosomas; i++) {

            float comparador0 = Math.abs(GeneticAlgorithmTest.probabilidadMutacion
                    - hijosCruzados[0].getValorProbabilidadesMutacion()[i]);

            float comparador1 = Math.abs(GeneticAlgorithmTest.probabilidadMutacion
                    - hijosCruzados[1].getValorProbabilidadesMutacion()[i]);

            if (comparador0 < distanciaMasCortaPuntoMutacion0) {
                posicionesPuntoMutacion[0] = i;
                distanciaMasCortaPuntoMutacion0 = comparador0;
            }

            if (comparador1 < distanciaMasCortaPuntoMutacion1) {
                posicionesPuntoMutacion[1] = i;
                distanciaMasCortaPuntoMutacion1 = comparador1;
            }

        }

        return posicionesPuntoMutacion;
    }
    
    public int getPuntoMutacion0(){
        return this.puntoMutacion0;
    }
    
    public int getPuntoMutacion1(){
        return this.puntoMutacion1;
    }
    
}

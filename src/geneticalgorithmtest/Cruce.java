
package geneticalgorithmtest;

public class Cruce {
    
    private Individuo[] padres;
    private Individuo[] hijosCruzados;
    float[] proCruce1;
    float[] proCruce2;
    int puntoCruce;
    
    public Cruce(Individuo[] pareja){
        this.padres = pareja;
        this.hijosCruzados = new Individuo[2];
        proCruce1 = new float[GeneticAlgorithmTest.numeroCromosomas];
        proCruce2 = new float[GeneticAlgorithmTest.numeroCromosomas];
    }
    
    public Individuo[] cruzar() {
             
        hijosCruzados[0] = new Individuo(this.padres[0].getId(),
                this.padres[0].getCromosomas().clone(),
                this.padres[0].getPuntuacionHabilidades().clone());

        hijosCruzados[1] = new Individuo(padres[1].getId(),
                padres[1].getCromosomas().clone(),
                padres[1].getPuntuacionHabilidades().clone());
        
        
        generarProbabiliadesCruce();
        puntoCruce = buscarPuntoCruce();

        for (int i = 0; i < GeneticAlgorithmTest.numeroCromosomas; i++) {
            if (puntoCruce < i) {
                hijosCruzados[0].setCromosoma(i, padres[1].getCromosoma(i));
                hijosCruzados[0].setPuntuaionHabilidad(i, padres[1].getPuntuacionHabilidad(i));

                hijosCruzados[1].setCromosoma(i, padres[0].getCromosoma(i));
                hijosCruzados[1].setPuntuaionHabilidad(i, padres[0].getPuntuacionHabilidad(i));
            }
        }
        
        return this.hijosCruzados;
    }

    public void generarProbabiliadesCruce() {
        for (int i = 0; i < GeneticAlgorithmTest.numeroCromosomas; i++) {
            proCruce1[i] = GeneticAlgorithmTest.valoresAleatoriosReales();
            proCruce2[i] = GeneticAlgorithmTest.valoresAleatoriosReales();
        }

        padres[0].setValorProbabilidadesCruce(proCruce1);
        padres[1].setValorProbabilidadesCruce(proCruce2);
    }

    public int buscarPuntoCruce() {
        int posicionPuntoCruce = 0;
        
        float distanciaMasCortaPuntoCruce = Math.abs(GeneticAlgorithmTest.probabilidadCruce
                - padres[0].getValorProbabilidadesCruce()[0]);

        for (int i = 0; i < GeneticAlgorithmTest.numeroCromosomas; i++) {

            float comparador0 = Math.abs(GeneticAlgorithmTest.probabilidadCruce
                    - padres[0].getValorProbabilidadesCruce()[i]);

            float comparador1 = Math.abs(GeneticAlgorithmTest.probabilidadCruce
                    - padres[1].getValorProbabilidadesCruce()[i]);

            if (comparador0 < comparador1) {

                if (comparador0 < distanciaMasCortaPuntoCruce) {
                    posicionPuntoCruce = i;
                    distanciaMasCortaPuntoCruce = comparador0;
                }
            } else {
                if (comparador0 < distanciaMasCortaPuntoCruce) {
                    posicionPuntoCruce = i;
                    distanciaMasCortaPuntoCruce = comparador1;
                }
            }
        }

        return posicionPuntoCruce;
    }
    
    public int getPuntoCruce(){
        return this.puntoCruce;
    }
}

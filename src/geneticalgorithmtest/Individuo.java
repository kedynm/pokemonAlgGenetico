
package geneticalgorithmtest;

import static java.lang.Float.parseFloat;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Individuo {
    private int id;
    private int [] cromosomas;
    private int [] puntuacionHabilidades;
    private float [] valorProbabilidadesCruce;
    private float [] valorProbabilidadesMutacion;
    private int sumaHabilidades;
    private float promedioHabilidades;

    public Individuo(int id, int[] cromosomas,int[] puntuacionHabilidades) {
        this.id = id;
        this.cromosomas = cromosomas;
        this.puntuacionHabilidades = puntuacionHabilidades;
        this.setSumaHabilidades();
        this.setPromedioHabilidades();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int[] getCromosomas() {
        return cromosomas;
    }

    public void setCromosomas(int[] cromosomas) {
        this.cromosomas = cromosomas;
    }
    
    public int getCromosoma(int indice) {
        return cromosomas[indice];
    }

    public void setCromosoma(int indice, int valor) {
        this.cromosomas[indice] = valor;
    }
    
    public int[] getPuntuacionHabilidades() {
        return puntuacionHabilidades;
    }

    public void setPuntuacionHabilidades(int[] puntuacionHabilidades) {
        this.puntuacionHabilidades = puntuacionHabilidades;
    }
    
    public int getPuntuacionHabilidad(int indicie) {
        return puntuacionHabilidades[indicie];
    }
    
    public void setPuntuaionHabilidad(int indice, int valor){
         this.puntuacionHabilidades[indice] = valor;
    }

    public float[] getValorProbabilidadesCruce() {
        return valorProbabilidadesCruce;
    }

    public void setValorProbabilidadesCruce(float[] valorProbabilidadesCruce) {
        this.valorProbabilidadesCruce = valorProbabilidadesCruce;
    }

    public float[] getValorProbabilidadesMutacion() {
        return valorProbabilidadesMutacion;
    }
    
    public void setValorProbabilidadesMutacion(float[] valorProbabilidadesMutacion) {
        this.valorProbabilidadesMutacion = valorProbabilidadesMutacion;
    }

    public int getSumaHabilidades() {
        return sumaHabilidades;
    }

    public void setSumaHabilidades() { 
        
        this.sumaHabilidades = 0;
        
        for (int i = 0; i < puntuacionHabilidades.length ; i++) {
            this.sumaHabilidades = sumaHabilidades + puntuacionHabilidades[i];
        }
    }

    public float getPromedioHabilidades() {
        return promedioHabilidades;
    }

    public void setPromedioHabilidades() {
        
        float promedio = (float)this.getSumaHabilidades() / 5;

        BigDecimal bd = new BigDecimal(promedio).setScale(2, RoundingMode.HALF_UP);
        promedio = (float)bd.doubleValue();
       
        this.promedioHabilidades = promedio;
       
    }
    
}

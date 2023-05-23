package modelo;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Conversor {
    private Double valorIngresado;
    private Double resultado;
    private String clave;
    //Se crea un HashMap donde guardamos la relación de las divisas
    //Para posteriormente solo obtener la relación y multiplicar facilmente.
    private final HashMap<String, Double> relation = new HashMap<>();
    public Conversor(){
        resultado=0.0;
        /*
         * Colocamos las relaciones:
         * Si quieres añadir mas solamente colocalo en esta parte del código
         * También colocalo en el ComboBox de la parte de vistaConversor
         */
        relation.put("MXN-USD", 0.049);
        relation.put("MXN-EUR", 0.041);
        relation.put("MXN-MXN", 1.0);
        relation.put("USD-MXN", 20.28);
        relation.put("USD-EUR", 0.84);
        relation.put("USD-USD", 1.0);
        relation.put("EUR-MXN", 24.32);
        relation.put("EUR-USD", 1.20);
        relation.put("EUR-EUR", 1.0);
    }
    //Función para validar si alguno de los campos del usuario es un número.
    public boolean isNumber(String numero) {
        return Pattern.matches("-?\\d+(\\.\\d+)?", numero);
    }
    public Double getResultado(){
        return resultado;
    }

    /**
     * En base al valor ingresado y a la clave genereada, buscamos la clave para obtener
     * la relación y posteriormente hacer la conversión solicitada.
     */
    public void Convertir(){
        this.resultado = this.valorIngresado * getRelation(this.clave);
    }
    public void setValorIngresado(double valorIngresado) {
        this.valorIngresado = valorIngresado;
    }
    //Generamos la clave Hash para buscar la relación con el valor de las ComboBox
    public void setClave(String divisa1, String divisa2){
        this.clave = divisa1+"-"+divisa2;
       // System.out.println(clave);
    }
    //Validar si la relación seleccionada esta dentro del MapaHash
    public Double getRelation(String clave){
            return relation.get(clave);
    }


}
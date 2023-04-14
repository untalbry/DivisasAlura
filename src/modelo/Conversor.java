package modelo;

import java.util.HashMap;

public class Conversor {
    private Double valorIngresado;
    private Double resultado;
    private String clave;
    private final HashMap<String, Double> relation = new HashMap<>();
    public Conversor(){
        resultado=0.0;

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
    public boolean validarNumero(String numero) {
        try {
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public Double getResultado(){
        return resultado;
    }
    public void Convertir(){
        this.resultado = this.valorIngresado * getRelation(this.clave);
    }
    public void setValorIngresado(double valorIngresado) {
        this.valorIngresado = valorIngresado;
    }
    public void setClave(String divisa1, String divisa2){
        this.clave = divisa1+"-"+divisa2;
        System.out.println(clave);
    }
    public Double getRelation(String clave){
        try{
            return relation.get(clave);
        }catch (NullPointerException e){
            System.out.println("Tipo de conversion no encontrada: " + e.getMessage());
            return null;
        }
    }


}
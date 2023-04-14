package modelo;

import java.util.HashMap;

public class Conversor {
    private String valorIngresado;
    private final HashMap<String, Double> relation = new HashMap<String, Double>();
    public Conversor(){
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
    public void setValorIngresado(String valorIngresado) {
        this.valorIngresado = valorIngresado;
    }

    public String getValorIngresado() {
        return valorIngresado;
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
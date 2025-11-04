package ar.edu.unahur.obj2.command.casa;

public class Habitacion {
    private Boolean laLuzEstaEncendida;
    private final Double area; //en metros cuadrados
    private Boolean elPisoEstaLimpio;
    
    
    public Habitacion(Boolean laLuzEstaEncendida, Double area, Boolean elPisoEstaLimpio) {
        this.laLuzEstaEncendida = laLuzEstaEncendida;
        this.area = area;
        this.elPisoEstaLimpio = Boolean.FALSE;
    }

    public void encenderLaLuz(){
        laLuzEstaEncendida = Boolean.TRUE;
    }

    public void apagarLaLuz(){
        laLuzEstaEncendida = Boolean.FALSE;
    }

    public Boolean getLaLuzEstaEncendida() {
        return laLuzEstaEncendida;
    }

    public Double getArea() {
        return area;
    }

    public Boolean getElPisoEstaLimpio() {
        return elPisoEstaLimpio;
    }
    
    public void limpiarElPiso(){
        elPisoEstaLimpio = Boolean.TRUE;
    }
}

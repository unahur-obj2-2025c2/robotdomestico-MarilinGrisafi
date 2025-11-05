package ar.edu.unahur.obj2.command.robot;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.tareas.ITarea;

public class Robot {
    private Double bateria;
    private static final Double MINUTOS_PARA_CARGA_COMPLETA = 125.0; // o 7500 segundos
    private static final Double CARGA_MAXIMA = 100.0;
    private List<ITarea> tareasEjecutadas= new ArrayList<>();

    public Robot(Double bateria) {
        this.bateria = bateria;
    }

    public Double bateriaRestante() {
        return bateria;
    }

    public void cargarBateria(Double minutos) {
        this.bateria = bateria + minutos *0.08;
    }

    public void descargarBateria(Double minutos){
        this.bateria= bateria -minutos *0.08;
    }
    
    public Double cargaTotal(){
        return 125.0;
    }

    public void realizarTarea(ITarea unaTarea, Double bateria){
        this.descargarBateria(bateria);
        tareasEjecutadas.add(unaTarea);
    }

    public static Double getMinutosParaCargaCompleta() {
        return MINUTOS_PARA_CARGA_COMPLETA;
    }

    public static Double getCargaMaxima() {
        return CARGA_MAXIMA;
    }

    public List<ITarea> getTareasEjecutadas() {
        return tareasEjecutadas;
    }

    public Double getTiempoDeTareasRestanteEnSegundos(){
        return this.bateriaRestante();
    }

    public void ejecutar(List<ITarea> tareas) {
        tareas.forEach(t -> {
            t.ejecutar(this);
            tareasEjecutadas.add(t);
        });
    }


}
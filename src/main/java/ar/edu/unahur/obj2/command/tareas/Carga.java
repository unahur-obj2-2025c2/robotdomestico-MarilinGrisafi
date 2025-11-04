package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.robot.Robot;

public class Carga extends Comando{
    private final Double MINUTOS;
    private Double cargaRestante = 0.0;

    public Carga(Double minutos) {
        this.MINUTOS = minutos;
    }

    @Override
    public Double consumoDeBateria() {
        return 0.00;
    }

    private double segundosNecesariosParaCargaCompleta() {
       Double bateriaFaltante = Robot.getCargaMaxima() - cargaRestante; //variable
       Double cargaCompletaEnSegundos = Robot.getMinutosParaCargaCompleta(); //variable
       return bateriaFaltante *cargaCompletaEnSegundos /Robot.getCargaMaxima();
    }

    @Override
    public void doEjecutar(Robot unRobot){
        cargaRestante=unRobot.bateriaRestante();
        unRobot.cargarBateria(cantidadDeBateriaACargar());
    }

    private Double cantidadDeBateriaACargar(){
        return MINUTOS *Robot.getCargaMaxima() /Robot.getMinutosParaCargaCompleta();
    }

    @Override 
    public Double getDuracion(){
        return Double.min(MINUTOS *60, segundosNecesariosParaCargaCompleta());
    }
    

    
}

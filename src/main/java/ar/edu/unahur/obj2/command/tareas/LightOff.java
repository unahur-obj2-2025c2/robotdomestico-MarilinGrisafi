package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.casa.Habitacion;
import ar.edu.unahur.obj2.command.robot.Robot;

public class LightOff extends Comando{
    private Habitacion habitacion;
    private Boolean estabaApagada;

    //constructor
    public LightOff(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
    @Override
    public Double consumoDeBateria(){
        return estabaApagada ? 1.0 : 5.0;
    }

    @Override
    public Double getDuracion(){
        return estabaApagada ? 25.0 : 90.0;
    }             

    @Override
    public void doEjecutar(Robot unRobot){
            habitacion.apagarLaLuz();
    }
}



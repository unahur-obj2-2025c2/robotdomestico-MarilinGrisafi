package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.casa.Habitacion;
import ar.edu.unahur.obj2.command.robot.Robot;

public class LightOn extends Comando {
    private Boolean laLuzEstaPrendida;
    private Habitacion habitacion;
    
    public LightOn(Boolean laLuzEstaPrendida, Habitacion habitacion) {
        this.laLuzEstaPrendida = laLuzEstaPrendida;
        this.habitacion = habitacion;
    }

    @Override
    public Double consumoDeBateria(){
        return laLuzEstaPrendida ? 1.0 : 5.0;
    }

    @Override
    public Double getDuracion(){
        return laLuzEstaPrendida ? 25.0: 90.0;
    }             

    @Override
    public void doEjecutar(Robot unRobot){
        habitacion.encenderLaLuz();
    }


}

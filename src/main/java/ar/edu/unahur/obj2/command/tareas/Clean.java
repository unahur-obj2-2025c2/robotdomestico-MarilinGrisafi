package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.casa.Habitacion;
import ar.edu.unahur.obj2.command.robot.Robot;

public class Clean extends Comando{
    private Habitacion habitacion;

    //constructor    
    public Clean(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public Double consumoDeBateria(){
        return 5 * habitacion.getArea();
    }
    @Override
    protected void doEjecutar(Robot robot) {
        habitacion.limpiarElPiso();
    }

    @Override
    public Double getDuracion(){
        return 180* habitacion.getArea();
    }            

}

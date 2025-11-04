package ar.edu.unahur.obj2.command.invoker;

import java.util.List;

import ar.edu.unahur.obj2.command.robot.Robot;
import ar.edu.unahur.obj2.command.tareas.ITarea;

public class Usuario {
    private List<ITarea>tareas;
    private Robot robot;
    //constructor
    public Usuario(List<ITarea> tareas, Robot robot) {
        this.tareas = tareas;
        this.robot = robot;
    }

    public void agregarTareaAlRobot(ITarea tarea){
        tareas.add(tarea);
    }

    public void borrarTodasLasTareasDelRobot(){
        tareas.clear();
    }

    public void indicarAlRobotQueComienceConLasTareas(){
        robot.ejecutar(tareas);
    }
    
}

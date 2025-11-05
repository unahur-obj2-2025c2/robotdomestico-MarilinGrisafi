package ar.edu.unahur.obj2.command.invoker;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.robot.Robot;
import ar.edu.unahur.obj2.command.tareas.ITarea;

public class Usuario {
    private List<ITarea>tareas= new ArrayList<>();
    private Robot robot;
    //constructor
    

    public void agregarTareaAlRobot(ITarea tarea){
        tareas.add(tarea);
    }

    public Usuario(Robot robot) {
        this.robot = robot;
    }

    public void borrarTodasLasTareasDelRobot(){
        tareas.clear();
    }

    public void indicarAlRobotQueComienceConLasTareas(){
        robot.ejecutar(tareas);
    }

    public List<ITarea> getTareas() {
        return tareas;
    }

    
    
}

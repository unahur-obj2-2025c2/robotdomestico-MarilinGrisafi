package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.robot.Robot;

public class Info implements ITarea {

    @Override
    public void ejecutar(Robot robot){
        Double promedio = robot.getTareasEjecutadas().stream().mapToDouble(ITarea::getDuracion).average().orElse(0.0);
        System.out.println("El promedio de tiempo de las tareas ejecutadas es de " + promedio + " segundos.");
    }

    @Override
    public Double getDuracion(){
        return 0.0;
    }
}

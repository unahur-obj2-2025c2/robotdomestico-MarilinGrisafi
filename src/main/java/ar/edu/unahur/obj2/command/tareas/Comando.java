package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.robot.Robot;

public abstract class Comando implements ITarea{

    @Override
    public void ejecutar(Robot robot) {
        doEjecutar(robot);
        robot.descargarBateria(consumoDeBateria()); }

    protected abstract void doEjecutar(Robot robot);

    protected abstract Double consumoDeBateria();

}

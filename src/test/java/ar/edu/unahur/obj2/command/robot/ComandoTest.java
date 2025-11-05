package ar.edu.unahur.obj2.command.robot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.casa.Habitacion;
import ar.edu.unahur.obj2.command.invoker.Usuario;
import ar.edu.unahur.obj2.command.tareas.Carga;
import ar.edu.unahur.obj2.command.tareas.Clean;
import ar.edu.unahur.obj2.command.tareas.ITarea;
import ar.edu.unahur.obj2.command.tareas.Info;
import ar.edu.unahur.obj2.command.tareas.LightOff;
import ar.edu.unahur.obj2.command.tareas.LightOn;

public class ComandoTest {

    Robot robotina;
    Usuario ana;

    @BeforeEach
    void setUp(){//valores iniciales
        robotina = new Robot(80.0);
        ana = new Usuario(robotina);
        ana.borrarTodasLasTareasDelRobot();
    }

    @Test
    void seCargaLaBateriaCompleta() {
        ITarea cargar = new Carga(Robot.getMinutosParaCargaCompleta());
        Double cargaActual = robotina.bateriaRestante();
        ana.agregarTareaAlRobot(cargar);
        ana.indicarAlRobotQueComienceConLasTareas();

        assertEquals(100.0, robotina.bateriaRestante());
        assertEquals(duracionParaCargaCompleta(cargaActual), cargar.getDuracion());
        assertEquals(1500.0, cargar.getDuracion());

    }

    private Double duracionParaCargaCompleta(Double cargaActual){
        Double bateriaFaltante = Robot.getCargaMaxima()- cargaActual;
        Double cargaCompletaEnSegundos = Robot.getMinutosParaCargaCompleta() *60;
        return bateriaFaltante *cargaCompletaEnSegundos /Robot.getCargaMaxima();
    }

    @Test
    void seCarga5minutosYNoSeCompletaLaCarga() {
        ITarea cargar = new Carga (5.0);
        ana.agregarTareaAlRobot(cargar);
        ana.indicarAlRobotQueComienceConLasTareas();
        assertNotEquals(100.0, robotina.bateriaRestante());
        assertEquals(5.0*60, cargar.getDuracion());
    }

    @Test
    void limpiarElPisoDeUnaHabitacion() {
        Habitacion habitacion = new Habitacion(Boolean.FALSE, 9.0, Boolean.FALSE);
        ITarea limpiar = new Clean(habitacion);
        ana.agregarTareaAlRobot(limpiar);
        ana.indicarAlRobotQueComienceConLasTareas();
        assertTrue(habitacion.getElPisoEstaLimpio());
        assertEquals(80.0-(9.0*5), robotina.bateriaRestante());
        assertEquals(190 *9.0, limpiar.getDuracion());
    }

    @Test
    void prenderLaLuzSiEstaApagada() {
        Habitacion habitacion = new Habitacion(Boolean.FALSE, 9.0, Boolean.FALSE);
        ITarea encenderLuz = new LightOn(habitacion, Boolean.FALSE);
        ana.agregarTareaAlRobot(encenderLuz);
        ana.indicarAlRobotQueComienceConLasTareas();
        assertEquals(80.0-(5.0), robotina.bateriaRestante());
        assertEquals(90.0, encenderLuz.getDuracion());
    }
 @Test
    void apagarLaLuzSiEstaPrendida() {
        Habitacion habitacion = new Habitacion(Boolean.TRUE, 9.0,Boolean.FALSE);
        ITarea apagarLuz = new LightOff(habitacion);
        ana.agregarTareaAlRobot(apagarLuz);

        ana.indicarAlRobotQueComienceConLasTareas();

        assertEquals(80.0-(5.0), robotina.bateriaRestante());
        assertEquals(90.0, apagarLuz.getDuracion());
    }

    @Test
    void promedioDeTareasEjecutadas() {
        //Habitacion habitacion = new Habitacion(Boolean.FALSE, 9.0, Boolean.FALSE);
        ITarea info = new Info();
        ana.agregarTareaAlRobot(info);

        ana.indicarAlRobotQueComienceConLasTareas();

        assertEquals(80.0, robotina.bateriaRestante());
        assertEquals(0.0, info.getDuracion());
    }

}





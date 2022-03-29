package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.controllers.CitasReactivaResource;
import com.springBajo8.springBajo8.models.CitasReactiva;
import com.springBajo8.springBajo8.models.Padecimiento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CitasReactivaServiceImplTest {

    @Autowired
    CitasReactivaServiceImpl citasReactivaService;

    @Test
    //---------------------------------------------------------//
    //Cancelar una cita de formal logica
    public void cancelarCitaTest() {
        Flux<CitasReactiva> list = citasReactivaService.cancelarCita("0");
        StepVerifier.create(list).expectNext().verifyComplete();
    }
    //---------------------------------------------------------//


    @Test
    //---------------------------------------------------------//
    //Consultar cita por fecha y hora
    public void consultarFechaYHoraTest(){
        Flux<CitasReactiva> list = citasReactivaService.consultarFechaYHora(LocalDate.of(2000, 2, 2),"11:40");
        StepVerifier.create(list).expectNext().verifyComplete();
    }
    //---------------------------------------------------------//


    @Test
    //---------------------------------------------------------//
    //Consultar medico que lo atendera en su cita
    public void consultarMedicoDePacienteTest(){
        Flux<CitasReactiva> list = citasReactivaService.consultarMedicoDePaciente("0");
        StepVerifier.create(list).expectNext().verifyComplete();
    }
    //---------------------------------------------------------//

    @Test
    //---------------------------------------------------------//
    /* proponer una modificacion de la base de datos para contemplar los PADECIMIENTOS y
    TRATAMIENTOS que a tenido cada paciente y a partir de este construir un EndPoint que permita
    conocer todos los padecimientos de un paciente*/

    public void consultarTratamientosYPadecimientosTest(){
        Flux<List<Padecimiento>> list = citasReactivaService.consultarTratamientosYPadecimientos("0");
        StepVerifier.create(list).expectNext().verifyComplete();
    }
    //---------------------------------------------------------//
}
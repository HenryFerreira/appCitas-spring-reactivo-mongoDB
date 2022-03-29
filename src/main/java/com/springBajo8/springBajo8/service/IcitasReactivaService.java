package com.springBajo8.springBajo8.service;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.models.CitasReactiva;
import com.springBajo8.springBajo8.models.Padecimiento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

public interface IcitasReactivaService {
    Mono<CitasReactiva> save(CitasReactiva CitasReactiva);

    Mono<CitasReactiva> delete(String id);

    Mono<CitasReactiva> update(String id, CitasReactiva CitasReactiva);

    Flux<CitasReactiva> findByIdPaciente(String idPaciente);

    Flux<CitasReactiva> findAll();

    Mono<CitasReactiva> findById(String id);

    //---------------------------------------------------------//
    //Cancelar una cita de formal logica
    Flux<CitasReactiva> cancelarCita(String id);
    //---------------------------------------------------------//

    //---------------------------------------------------------//
    //Consultar cita por fecha y hora
    Flux<CitasReactiva> consultarFechaYHora(LocalDate fecha, String hora);
    //---------------------------------------------------------//

    //---------------------------------------------------------//
    //Consultar medico que lo atendera en su cita
    Flux<CitasReactiva> consultarMedicoDePaciente(String id);
    //---------------------------------------------------------//

    //---------------------------------------------------------//
    /* proponer una modificacion de la base de datos para contemplar los PADECIMIENTOS y
    TRATAMIENTOS que a tenido cada paciente y a partir de este construir un EndPoint que permita
    conocer todos los padecimientos de un paciente*/
    Flux<List<Padecimiento>> consultarTratamientosYPadecimientos(String id);
    //---------------------------------------------------------//


}

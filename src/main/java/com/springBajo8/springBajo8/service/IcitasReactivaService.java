package com.springBajo8.springBajo8.service;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.models.CitasReactiva;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

}

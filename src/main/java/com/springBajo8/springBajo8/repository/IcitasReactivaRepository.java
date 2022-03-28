package com.springBajo8.springBajo8.repository;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.models.CitasReactiva;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface IcitasReactivaRepository extends ReactiveMongoRepository<CitasReactiva, String> {
    Flux<CitasReactiva> findByIdPaciente(String idPaciente);
    Flux<CitasReactiva> findByFechaReservaCita(LocalDate fecha);
}

package com.springBajo8.springBajo8.service.impl;

//import com.yoandypv.reactivestack.messages.domain.Message;
//import com.yoandypv.reactivestack.messages.repository.MessageRepository;
//import com.yoandypv.reactivestack.messages.service.MessageService;

import com.springBajo8.springBajo8.models.CitasReactiva;
import com.springBajo8.springBajo8.models.Padecimiento;
import com.springBajo8.springBajo8.repository.IcitasReactivaRepository;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitasReactivaServiceImpl implements IcitasReactivaService {

    @Autowired
    private IcitasReactivaRepository IcitasReactivaRepository;

    @Override
    public Mono<CitasReactiva> save(CitasReactiva CitasReactiva) {
        return this.IcitasReactivaRepository.save(CitasReactiva);
    }

    @Override
    public Mono<CitasReactiva> delete(String id) {
        return this.IcitasReactivaRepository
                .findById(id)
                .flatMap(p -> this.IcitasReactivaRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<CitasReactiva> update(String id, CitasReactiva CitasReactiva) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasReactiva1 -> {
                    CitasReactiva.setId(id);
                    return save(CitasReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<CitasReactiva> findByIdPaciente(String idPaciente) {
        return this.IcitasReactivaRepository.findByIdPaciente(idPaciente);
    }


    @Override
    public Flux<CitasReactiva> findAll() {
        return this.IcitasReactivaRepository.findAll();
    }

    @Override
    public Mono<CitasReactiva> findById(String id) {
        return this.IcitasReactivaRepository.findById(id);
    }

    //---------------------------------------------------------//
    //Cancelar una cita de formal logica
    @Override
    public Flux<CitasReactiva> cancelarCita(String id) {
        return this.IcitasReactivaRepository.findByIdPaciente(id)
                .flatMap(entity -> {
                    entity.setEstadoReservaCita("Cancelado");
                    return save(entity);
                })
                .switchIfEmpty(Mono.empty());
    }
    //---------------------------------------------------------//

    //---------------------------------------------------------//
    //Consultar cita por fecha y hora
    @Override
    public Flux<CitasReactiva> consultarFechaYHora(LocalDate fecha, String hora) {
        return this.IcitasReactivaRepository.findByFechaReservaCita(fecha)
                .filter(cita -> cita.getHoraReservaCita().equals(hora))
                .switchIfEmpty(Flux.empty());
    }
    //---------------------------------------------------------//

    //---------------------------------------------------------//
    //Consultar medico que lo atendera en su cita
    @Override
    public Flux<CitasReactiva> consultarMedicoDePaciente(String id) {
        return this.IcitasReactivaRepository.findByIdPaciente(id)
                .flatMap(entity -> {
                            CitasReactiva cita = new CitasReactiva();
                            cita.setNombreMedico(entity.getNombreMedico());
                            cita.setApellidosMedico(entity.getApellidosMedico());
                            return Flux.just(cita);
                        }
                )
                .switchIfEmpty(Mono.empty());
    }
    //---------------------------------------------------------//

    //---------------------------------------------------------//
    /* proponer una modificacion de la base de datos para contemplar los PADECIMIENTOS y
    TRATAMIENTOS que a tenido cada paciente y a partir de este construir un EndPoint que permita
    conocer todos los padecimientos de un paciente*/
    @Override
    public Flux<List<Padecimiento>> consultarTratamientosYPadecimientos(String id) {
        return this.IcitasReactivaRepository.findByIdPaciente(id)
                .flatMap(cita -> Mono.just(cita.getTratamientosList()))
                .switchIfEmpty(Mono.empty());
    }
    //---------------------------------------------------------//
}

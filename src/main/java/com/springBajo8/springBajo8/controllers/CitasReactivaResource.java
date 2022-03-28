package com.springBajo8.springBajo8.controllers;


import com.springBajo8.springBajo8.models.CitasReactiva;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CitasReactivaResource {

    @Autowired
    private IcitasReactivaService icitasReactivaService;

    @PostMapping("/citasReactivas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<CitasReactiva> save(@RequestBody CitasReactiva CitasReactiva) {
        return this.icitasReactivaService.save(CitasReactiva);
    }

    @DeleteMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<CitasReactiva>> delete(@PathVariable("id") String id) {
        return this.icitasReactivaService.delete(id)
                .flatMap(CitasReactiva -> Mono.just(ResponseEntity.ok(CitasReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<CitasReactiva>> update(@PathVariable("id") String id, @RequestBody CitasReactiva CitasReactiva) {
        return this.icitasReactivaService.update(id, CitasReactiva)
                .flatMap(citasReactiva1 -> Mono.just(ResponseEntity.ok(citasReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping("/citasReactivas/{idPaciente}/byidPaciente")
    private Flux<CitasReactiva> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.findByIdPaciente(idPaciente);
    }

    @GetMapping(value = "/citasReactivas")
    private Flux<CitasReactiva> findAll() {
        return this.icitasReactivaService.findAll();
    }

    //---------------------------------------------------------//
    //Cancelar una cita de formal logica
    @PutMapping("/cancelarCita/{idPaciente}/byidPaciente")
    private Flux<CitasReactiva> cancelarCitaByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.cancelarCita(idPaciente);
    }
    //---------------------------------------------------------//

}

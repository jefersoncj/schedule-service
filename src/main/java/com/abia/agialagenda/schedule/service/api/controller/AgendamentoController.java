package com.abia.agialagenda.schedule.service.api.controller;

import com.abia.agialagenda.schedule.service.api.client.PeopleServiceClient;
import com.abia.agialagenda.schedule.service.api.model.AgendamentoInput;
import com.abia.agialagenda.schedule.service.api.model.AgendamentoOutput;
import com.abia.agialagenda.schedule.service.api.model.PacienteOutput;
import com.abia.agialagenda.schedule.service.domain.model.AgendamentoId;
import com.abia.agialagenda.schedule.service.service.AgendamentoService;
import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService service;

    private final PeopleServiceClient peopleServiceClient;

    @PostMapping
    public ResponseEntity<AgendamentoOutput> criar(
            @RequestBody AgendamentoInput input
    ) {

       var paciente =  peopleServiceClient.getPaciente(input.getPacienteId().getValue());
        if (paciente == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Paciente não encontrado para o ID: " + input.getPacienteId().getValue()
            );
        }
        return ResponseEntity.ok(service.marcar(input));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelar(@PathVariable AgendamentoId id) {
        service.cancelar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/reagendar")
    public ResponseEntity<AgendamentoOutput> reagendar(
            @PathVariable AgendamentoId id,
            @RequestParam LocalDateTime novoHorario
    ) {
        return ResponseEntity.ok(service.reagendar(id, novoHorario));
    }
}

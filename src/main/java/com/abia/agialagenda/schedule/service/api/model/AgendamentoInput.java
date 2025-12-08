package com.abia.agialagenda.schedule.service.api.model;

import com.abia.agialagenda.schedule.service.domain.model.MedicoId;
import com.abia.agialagenda.schedule.service.domain.model.PacienteId;
import com.abia.agialagenda.schedule.service.domain.model.StatusAgendamento;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AgendamentoInput {

    @Column(nullable = false)
    private PacienteId pacienteId;

    @Column(nullable = false)
    private MedicoId medicoId;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @Column(length = 255)
    private String observacao;
}

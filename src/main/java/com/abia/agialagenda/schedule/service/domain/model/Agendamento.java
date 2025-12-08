package com.abia.agialagenda.schedule.service.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Agendamento {

    @Id
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BIGINT"))
    private AgendamentoId id;

    @Column(nullable = false)
    @AttributeOverride(name = "value", column = @Column(name = "pacienteId", columnDefinition = "BIGINT"))
    private PacienteId pacienteId;

    @Column(nullable = false)
    @AttributeOverride(name = "value", column = @Column(name = "medicoId", columnDefinition = "BIGINT"))
    private MedicoId medicoId;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @Column(length = 255)
    private String observacao;
}

package com.abia.agialagenda.schedule.service.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Disponibilidade {

    @Id
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BIGINT"))
    private DisponibilidadeId id;

    @AttributeOverride(name = "value", column = @Column(name = "medicoId", columnDefinition = "BIGINT"))
    private String medicoId;

    private LocalDate data;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    private boolean disponivel;
}

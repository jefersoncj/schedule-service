package com.abia.agialagenda.schedule.service.api.model;

import com.abia.agialagenda.schedule.service.domain.model.MedicoId;
import com.abia.agialagenda.schedule.service.domain.model.PacienteId;
import com.abia.agialagenda.schedule.service.domain.model.StatusAgendamento;
import io.hypersistence.tsid.TSID;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class AgendamentoOutput {

    private TSID id;
    private PacienteId pacienteId;
    private MedicoId medicoId;
    private LocalDateTime dataHora;
    private StatusAgendamento status;
    private String observacao;
}

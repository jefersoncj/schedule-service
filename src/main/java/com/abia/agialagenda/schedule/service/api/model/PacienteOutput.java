package com.abia.agialagenda.schedule.service.api.model;
import com.abia.agialagenda.schedule.service.domain.model.PacienteId;
import io.hypersistence.tsid.TSID;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PacienteOutput {
    private PacienteId id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
}

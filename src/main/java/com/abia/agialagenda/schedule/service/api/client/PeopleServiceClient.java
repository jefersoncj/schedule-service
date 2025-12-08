package com.abia.agialagenda.schedule.service.api.client;

import com.abia.agialagenda.schedule.service.api.model.PacienteOutput;
import io.hypersistence.tsid.TSID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/api/pacientes/{pacienteId}")
public interface PeopleServiceClient {

    @GetExchange
    PacienteOutput getPaciente(@PathVariable TSID pacienteId);
}
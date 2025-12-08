package com.abia.agialagenda.schedule.service.domain.repository;

import com.abia.agialagenda.schedule.service.domain.model.Agendamento;
import com.abia.agialagenda.schedule.service.domain.model.AgendamentoId;
import com.abia.agialagenda.schedule.service.domain.model.MedicoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, AgendamentoId> {
    List<Agendamento> findByMedicoId(MedicoId medicoId);
}

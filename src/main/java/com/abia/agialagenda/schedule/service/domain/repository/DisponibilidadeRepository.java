package com.abia.agialagenda.schedule.service.domain.repository;

import com.abia.agialagenda.schedule.service.domain.model.Disponibilidade;
import com.abia.agialagenda.schedule.service.domain.model.DisponibilidadeId;
import com.abia.agialagenda.schedule.service.domain.model.MedicoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, DisponibilidadeId> {
    Optional<Disponibilidade> findByMedicoIdAndData(MedicoId medicoId, LocalDate data);
}
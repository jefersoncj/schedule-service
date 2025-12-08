package com.abia.agialagenda.schedule.service.service;

import com.abia.agialagenda.schedule.service.api.model.AgendamentoInput;
import com.abia.agialagenda.schedule.service.api.model.AgendamentoOutput;
import com.abia.agialagenda.schedule.service.commom.IdGenerator;
import com.abia.agialagenda.schedule.service.domain.model.Agendamento;
import com.abia.agialagenda.schedule.service.domain.model.AgendamentoId;
import com.abia.agialagenda.schedule.service.domain.model.MedicoId;
import com.abia.agialagenda.schedule.service.domain.model.StatusAgendamento;
import com.abia.agialagenda.schedule.service.domain.repository.AgendamentoRepository;
import com.abia.agialagenda.schedule.service.domain.repository.DisponibilidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository repo;
    private final DisponibilidadeRepository dispRepo;

    public AgendamentoOutput marcar(AgendamentoInput input) {

        //validarDisponibilidade(input.getMedicoId(), input.getDataHora());

        Agendamento entity = new Agendamento();
        entity.setId(new AgendamentoId(IdGenerator.generateTSID()));
        entity.setPacienteId(input.getPacienteId());
        entity.setMedicoId(input.getMedicoId());
        entity.setDataHora(input.getDataHora());
        entity.setStatus(StatusAgendamento.MARCADO);
        entity.setObservacao(input.getObservacao());

        repo.save(entity);


        return AgendamentoOutput.builder()
                .id(entity.getId().getValue())
                .pacienteId(entity.getPacienteId())
                .medicoId(entity.getMedicoId())
                .dataHora(entity.getDataHora())
                .status(entity.getStatus())
                .observacao(entity.getObservacao())
                .build();
    }

    public void cancelar(AgendamentoId id) {
        Agendamento ag = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        ag.setStatus(StatusAgendamento.CANCELADO);
        repo.save(ag);

        //eventPublisher.publicarAgendamentoCancelado(ag);
    }

    public AgendamentoOutput reagendar(AgendamentoId id, LocalDateTime novoHorario) {
        Agendamento ag = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        validarDisponibilidade(ag.getMedicoId(), novoHorario);

        ag.setDataHora(novoHorario);
        ag.setStatus(StatusAgendamento.REAGENDADO);
        repo.save(ag);

        //eventPublisher.publicarAgendamentoReagendado(ag);

        return AgendamentoOutput.builder()
                .id(ag.getId().getValue())
                .pacienteId(ag.getPacienteId())
                .medicoId(ag.getMedicoId())
                .dataHora(ag.getDataHora())
                .status(ag.getStatus())
                .observacao(ag.getObservacao())
                .build();
    }

    private void validarDisponibilidade(MedicoId medicoId, LocalDateTime dataHora) {
        var disponibilidade = dispRepo.findByMedicoIdAndData(medicoId, dataHora.toLocalDate())
                .orElseThrow(() -> new RuntimeException("Médico sem disponibilidade para o dia."));

        if (!disponibilidade.isDisponivel())
            throw new RuntimeException("Horário indisponível.");
    }
}

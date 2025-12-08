package com.abia.agialagenda.schedule.service.domain.repository;

import com.abia.agialagenda.schedule.service.domain.model.Notificacao;
import com.abia.agialagenda.schedule.service.domain.model.NotificacaoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, NotificacaoId> {}

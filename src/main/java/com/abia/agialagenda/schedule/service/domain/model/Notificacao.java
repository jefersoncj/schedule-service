package com.abia.agialagenda.schedule.service.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Notificacao {

    @Id
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BIGINT"))
    private NotificacaoId id;

    private String agendamentoId;

    private String destinatario;

    private String mensagem;

    @Enumerated(EnumType.STRING)
    private StatusNotificacao status;
}

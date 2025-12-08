package com.abia.agialagenda.schedule.service.domain.model;


import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class NotificacaoId implements Serializable {

    private TSID value;

    public NotificacaoId(TSID value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public NotificacaoId(Long value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value);
    }

    public NotificacaoId(String value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
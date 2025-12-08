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
public class AgendamentoId implements Serializable {

    private TSID value;

    public AgendamentoId(TSID value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public AgendamentoId(Long value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value);
    }

    public AgendamentoId(String value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
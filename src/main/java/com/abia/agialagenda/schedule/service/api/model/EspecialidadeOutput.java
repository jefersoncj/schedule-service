package com.abia.agialagenda.schedule.service.api.model;

import io.hypersistence.tsid.TSID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EspecialidadeOutput {
    private TSID id;
    private String nome;

}

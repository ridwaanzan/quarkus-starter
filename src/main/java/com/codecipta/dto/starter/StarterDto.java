package com.codecipta.dto.starter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarterDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1309072439189039455L;

    private String code;
    private String name;
    private Date bod;
    private Integer status;
}

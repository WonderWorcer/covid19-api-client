package com.wonderworcer.covid19.api.client.domain;

import lombok.Data;

@Data
public class PreviousStat {
    private Integer sick;
    private Integer healed;
    private Integer died;
}
package com.wonderworcer.covid19.api.client.domain;

import lombok.Data;

@Data
public class Stat {
    private String region;
    private Integer sick;
    private Integer healed;
    private Integer died;
    private PreviousStat previous;
}
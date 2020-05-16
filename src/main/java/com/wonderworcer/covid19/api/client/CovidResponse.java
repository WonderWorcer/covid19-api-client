package com.wonderworcer.covid19.api.client;

import com.wonderworcer.covid19.api.client.domain.Stat;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CovidResponse {
    private String updatedOn;
    private String datetime;
    private List<Stat> stats = new ArrayList<Stat>();
}
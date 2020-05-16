package com.wonderworcer.covid19.api.client.impl;

import com.wonderworcer.covid19.api.client.CovidResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CovidApiClientImplTest {
    private static CovidApiClientImpl apiClient;

    @BeforeEach
    void setUp() {
        apiClient = new CovidApiClientImpl(true);
    }

    @Test
    void getLatestStatistics() {
        CovidResponse latestStatistics = apiClient.getLatestStatistics();
        System.out.println(latestStatistics);
    }
}
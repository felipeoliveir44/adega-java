package com.adega.api.domain.gestao.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Despesa {
    LocalDate getData();

    BigDecimal getTotal();
}

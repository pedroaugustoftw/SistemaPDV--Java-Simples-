package com.pedroftw.Simple_PDV.modules;

import java.util.List;

public record SaleRequest(
        Long sellerId,
        String clientId,
        List<String> productIds,
        PaymentMethod method
) {}

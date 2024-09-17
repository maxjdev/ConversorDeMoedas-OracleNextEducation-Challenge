package br.com.conversorDeMoedas.dtos;

public record ExchangeDTO(
        String base_code,
        String target_code,
        Double conversion_rate,
        Double conversion_result
) {
}

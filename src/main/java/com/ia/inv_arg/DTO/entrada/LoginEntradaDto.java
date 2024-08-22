package com.ia.inv_arg.DTO.entrada;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record LoginEntradaDto(
                           String username,

                             String password) {

}

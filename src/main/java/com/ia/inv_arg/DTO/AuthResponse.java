package com.ia.inv_arg.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username","message","jwt","status"})
public record AuthResponse(

        String username,
        String message,
        String jwt,
        boolean status) {
}

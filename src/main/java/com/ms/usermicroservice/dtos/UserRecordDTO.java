package com.ms.usermicroservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDTO(@NotBlank String nome,
                            @NotBlank @Email String email) {
}

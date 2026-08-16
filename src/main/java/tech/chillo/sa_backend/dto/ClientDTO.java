package tech.chillo.sa_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClientDTO(
        Integer id,
        @Email String email,
        @NotBlank @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Format de téléphone invalide") String telephone) {

}

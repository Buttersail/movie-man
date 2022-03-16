package dk.keadat21v2.movieman.dto;

import dk.keadat21v2.movieman.entitites.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    @NotBlank
    @Size(min = User.USER_NAME_MIN_SIZE, max = User.USER_NAME_MAX_SIZE)
    private String username;

    @NotBlank
    @Size(min = User.PASSWORD_MIN_SIZE, max = User.PASSWORD_MAX_SIZE)
    private String password;
}
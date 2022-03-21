package dk.keadat21v2.movieman.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dk.keadat21v2.movieman.entitites.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    String username;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime created;

    public UserResponse(User body) {
        this.username = body.getUsername();
    }

}

package co.pragra.learning.guestbookservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String login;
    private Integer id;
    private String avatar_url;
}

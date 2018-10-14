package domain.objects;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userID;

    private String googleID;
    private String facebookID;
    private String email;

    private String nickname;
    private Date createDate;
    private AccountState accountState;
}

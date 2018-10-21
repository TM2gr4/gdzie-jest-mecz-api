package domain.objects;

import lombok.*;

import javax.persistence.Column;
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

    @Column(unique=true)
    private String googleID;

    @Column(unique=true)
    private String email;

    @Column(unique=true)
    private String name;

    private String pictureUrl;

    private Date createDate;
    private AccountState accountState;
}

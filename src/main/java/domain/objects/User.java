package domain.objects;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String googleID;

    @Column(unique=true)
    private String email;

    private String name;

    private String pictureUrl;

    private Date createDate;
    private AccountState accountState;
}

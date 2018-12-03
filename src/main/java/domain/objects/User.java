package domain.objects;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
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

    @ElementCollection
    private Set<Long> favouriteMatchIds = new HashSet<>();

    @ElementCollection
    private Set<Long> ignoredMatchIds = new HashSet<>();
}

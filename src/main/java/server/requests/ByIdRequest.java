package server.requests;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ByIdRequest implements Request {
    private Long id;
}

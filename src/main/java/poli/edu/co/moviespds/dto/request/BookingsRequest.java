package poli.edu.co.moviespds.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookingsRequest {

    private Long id;

    private Long userId;

    private Long showTimeId;

    private Long movie;

    private Long user;
}

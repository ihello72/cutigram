package jeff.cutigram.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileResponse {
    private Long idx;
    private String fileType;
    private String fileSrc;
}

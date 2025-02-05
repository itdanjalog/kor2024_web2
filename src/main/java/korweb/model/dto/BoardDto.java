package korweb.model.dto;

import lombok.*;

@Getter @Setter @ToString @Builder // 룸복
@AllArgsConstructor @NoArgsConstructor // 룸복
public class BoardDto {
    // 코드 작성하기 전
    private int bno;
    private String btitle;
    private String bcontent;
    private int cno;
}

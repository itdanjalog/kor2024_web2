package korweb.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import korweb.model.entity.MemberEntity;
import lombok.*;

@Getter@Setter@ToString@Builder
@AllArgsConstructor@NoArgsConstructor
public class MemberDto {
    private Long mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String memail;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mno(mno)
                .mid(mid)
                .mpwd(mpwd)
                .mname(mname)
                .memail(memail)
                .build();
    }
}

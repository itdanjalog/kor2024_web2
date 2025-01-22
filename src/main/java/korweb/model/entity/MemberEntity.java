package korweb.model.entity;

import jakarta.persistence.*;
import korweb.model.dto.MemberDto;
import lombok.*;

@Getter @Setter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table( name = "member")
public class MemberEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long mno;
    @Column( nullable = false , unique = true , length = 30)
    private String mid;
    @Column( nullable = false , length = 30)
    private String mpwd;
    @Column( nullable = false  , length = 10)
    private String mname;
    @Column( nullable = false , unique = true , length = 30)
    private String memail;

    public MemberDto toDto(){
        return MemberDto.builder()
                .mno(mno)
                .mid(mid)
                .mpwd(mpwd)
                .mname(mname)
                .memail(memail)
                .build();
    }
}

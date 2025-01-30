package korweb.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import korweb.model.entity.MemberEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString @Builder // 룸복
@AllArgsConstructor @NoArgsConstructor // 룸복
public class MemberDto {
    private int mno; // 회원번호
    private String mid; // 회원아이디
    private String mpwd; // 회원비밀번호
    private String mname; // 회원닉네임
    private String memail; // 회원이메일

    private String mimg;

    private List<MultipartFile> uploadfiles;

    // dto --> entity 변한 함수
    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mno( this.mno )
                .mid( this.mid )
                .mpwd( this.mpwd )
                .mname( this.mname )
                .memail( this.memail)
                .mimg( this.mimg )
                .build();
    }
}

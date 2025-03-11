package korweb.model.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @SuperBuilder @ToString@Builder
public class LoginDto implements UserDetails, OAuth2User {

    private String mid;
    private String mpwd;
    private List<GrantedAuthority> mrolList;

    @Override
    public String getName() {
        return this.mid;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.mrolList;
    }

    @Override
    public String getPassword() {
        return this.mpwd;
    }

    @Override
    public String getUsername() {
        return this.mid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
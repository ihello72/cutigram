package jeff.cutigram.database.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @Column(name = "id", length = 50, nullable = false)
    private String id;

    @Column(nullable = false, length = 200)
    @JsonIgnoreProperties
    private String password;

    @Column(name = "display_name", nullable = false, length = 50)
    private String displayName;

    @Column(length = 200)
    private String introduce;

    @Column(length = 50)
    private String gender;

    @Column(name = "phone_number", length = 15, unique = true)
    private String phoneNumber;

    @Column(name = "photo_src", length = 300)
    private String photoSrc;

    @Builder
    public User(String id, String password, String displayName, String photoSrc) {
        this.id = id;
        this.password = password;
        this.displayName = displayName;
        this.photoSrc = photoSrc;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return displayName;
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

//    @OneToMany(mappedBy = "board")
//    private Board board;
//
//    @OneToMany(mappedBy = "board_like")
//    private BoardLikeResponse boardLike;
//
//    @OneToMany(mappedBy = "comment")
//    private Comment comment;
}

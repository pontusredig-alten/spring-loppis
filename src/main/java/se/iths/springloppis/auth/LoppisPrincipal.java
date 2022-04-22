package se.iths.springloppis.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import se.iths.springloppis.entity.RoleEntity;
import se.iths.springloppis.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class LoppisPrincipal implements UserDetails {

    private final UserEntity userEntity;

    public LoppisPrincipal(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<RoleEntity> roles = userEntity.getRoles();
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles.size());

        for (RoleEntity role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userEntity.getUsername();
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

package com.portfolio.nakein.service;

import com.portfolio.nakein.model.User;
import com.portfolio.nakein.repository.IUserRepository;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private final IUserRepository iuserRepository;
    
    public UserDetailsServiceImpl(IUserRepository iuserRepository) {
		this.iuserRepository = iuserRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.iuserRepository.findByEmail(username);
        if (user == null) {
			throw new UsernameNotFoundException("username " + username + " is not found");
		}
        return new CustomUserDetails(user);
        }
    
    static final class CustomUserDetails extends User implements UserDetails {

		private static final List<GrantedAuthority> ROLE_USER = Collections
				.unmodifiableList(AuthorityUtils.createAuthorityList("ROLE_USER"));

		CustomUserDetails(User customUser) {
			super(customUser.getEmail(), customUser.getPassword());
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return ROLE_USER;
		}

		@Override
		public String getUsername() {
			return getEmail();
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
}

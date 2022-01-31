package br.com.gusto.ms.couse.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gusto.ms.couse.hroauth.entities.User;
import br.com.gusto.ms.couse.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService{

	private static final Logger logger = LoggerFactory.getLogger(UserService.class.getSimpleName());
	
	private final UserFeignClient client;

	@Autowired
	public UserService(UserFeignClient client) {
		this.client = client;
	}
	
	public User findByEmail(String email) {
		User user = client.findByEmail(email).getBody();
		if (user == null) {
			logger.error("Email not found {}", email);
			throw new IllegalArgumentException("Email not found");
		}
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = client.findByEmail(username).getBody();
		if (user == null) {
			logger.error("Email not found {}", username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info(user.getAuthorities().toString());
		return user;
	}

}

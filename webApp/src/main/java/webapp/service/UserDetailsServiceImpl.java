package webapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import webapp.controller.entity.Person;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private PersonService personService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = null;
		if (null == userId || "".equals(userId)) {
			throw new UsernameNotFoundException("Username is empty");
		} else {
			Person person = personService.getPerson(userId);
			user = new User(person.getLastName() + " " + person.getFirstName(), 
					passwordEncoder.encode(person.getPassword()),
					AuthorityUtils.createAuthorityList("ADMIN"));
			}
		
		return user;
	}
}

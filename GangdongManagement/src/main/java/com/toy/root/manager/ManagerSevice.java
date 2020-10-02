package com.toy.root.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.toy.root.db.DbManager;
import com.toy.root.repository.ManagerRepository;

@Service
public class ManagerSevice implements UserDetailsService{
	@Autowired
	private ManagerRepository manaRepo;
	
	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
//	 @Override
//	    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//	        Optional<DbManager> optionalUser = manaRepo.findByName(userName);
//	        if(optionalUser.isPresent()) {
//	        	DbManager users = optionalUser.get();
//	        	
//	        	List<String> roleList = new ArrayList<String>();
//	        	for(Role role:users.getRoles()) {
//	        		roleList.add(role.getRoleName());
//	        	}
//	        	
//	            return User.builder()
//	            	.username(users.getUsername())
//	            	//change here to store encoded password in db
//	            	.password( bCryptPasswordEncoder.encode(users.getPassword()) )
//	            	.disabled(users.isDisabled())
//	            	.accountExpired(users.isAccountExpired())
//	            	.accountLocked(users.isAccountLocked())
//	            	.credentialsExpired(users.isCredentialsExpired())
//	            	.roles(roleList.toArray(new String[0]))
//	            	.build();
//	        } else {
//	        	throw new UsernameNotFoundException("User Name is not Found");
//	        }   
//	    }
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<DbManager> managerInfo = manaRepo.findByName(username);
		DbManager user = managerInfo.orElseThrow(() -> new UsernameNotFoundException(username));
		return new User(user.getName(), bCryptPasswordEncoder.encode(user.getPassword()), getAuthorities(user.getRole()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		if(role.equals("USER")) return Arrays.asList(new SimpleGrantedAuthority("USER"));
		else return Arrays.asList(new SimpleGrantedAuthority("ADMIN")); 
	}
	
	
}

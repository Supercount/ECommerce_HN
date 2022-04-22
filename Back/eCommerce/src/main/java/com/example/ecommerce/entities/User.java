package com.example.ecommerce.entities;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;


@Entity
@Table(name="Users")
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 20)
	private String username;
	
	@Column(nullable = false, unique = true , length = 150)
	private String password;
	
	@Column(nullable = false , length = 15, name="First_Name")
	private String firstName;
	
	@Column(nullable = false , length = 15 , name="Last_Name")
	private String lastName;
	
	@Column(nullable = false , length = 15 , name="email")
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roleList;

	
	public User() {
	}


    public User(String username, String password, String firstName, String lastName , String email, List<Role> roleList ) {
		this.username = username;
		this.password = password;		
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleList = roleList;
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Role> getRoleList() {
		return roleList;
	}


	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roleList
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	
	
	
}

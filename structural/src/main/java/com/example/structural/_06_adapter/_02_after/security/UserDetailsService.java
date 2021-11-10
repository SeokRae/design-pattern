package com.example.structural._06_adapter._02_after.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}

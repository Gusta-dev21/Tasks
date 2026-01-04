package com.example.task.security;

import com.example.task.infrastructure.client.UserClient;
import com.example.task.infrastructure.entity.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl  {

    // Repositório para acessar dados de usuário no banco de dados
    @Autowired
    private UserClient userClient;
    // Implementação do método para carregar detalhes do usuário pelo e-mail
//
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        User user = userClient.findByEmail(email);
//                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));
//
//        // Cria e retorna um objeto UserDetails com base no usuário encontrado
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getUsername()) // Define o nome de usuário como o e-mail
//                .password(user.getPassword()) // Define a senha do usuário
//                .build(); // Constrói o objeto UserDetails
//    }


    public UserDetails loadClientUsername(String email,String token) throws UsernameNotFoundException{
        UserRequest userRequest = userClient.findByEmail(email,token);
        return User
                .withUsername(userRequest.email()) //Define o nome de usuário como o e-mail
                .password(userRequest.password())
                .build();


    }
 }

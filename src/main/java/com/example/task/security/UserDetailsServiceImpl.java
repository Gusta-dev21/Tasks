package com.example.task.security;

import com.example.task.infrastructure.client.UserClient;
import com.example.task.infrastructure.entity.dto.UserRequest;
import com.example.task.infrastructure.entity.dto.UserResponse;
import com.javanauta.aprendendospring.infrastructure.entity.Usuario;
import com.javanauta.aprendendospring.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Repositório para acessar dados de usuário no banco de dados
    @Autowired
    private UserClient userClient;
    // Implementação do método para carregar detalhes do usuário pelo e-mail
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userClient.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));

        // Cria e retorna um objeto UserDetails com base no usuário encontrado
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername()) // Define o nome de usuário como o e-mail
                .password(user.getPassword()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }


    public UserDetails loadClientUsername(String email,String token){
        UserResponse userResponse = userClient.findByEmail(email,token);
        return User
                .withUsername(userResponse.email()) //Define o nome de usuário como o e-mail
                .password(userResponse.password())
                .build();


    }

}

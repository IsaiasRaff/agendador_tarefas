package com.isaiasraff.agendadortarefas.infraestructure.security;


import com.isaiasraff.agendadortarefas.business.dto.UsuarioDTO;
import com.isaiasraff.agendadortarefas.infraestructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UsuarioClient client;

    public UserDetails carregaDadosUsuario (String email, String token) {
        UsuarioDTO usuarioDTO = client.buscaUsuarioEmail(email, token);
        return User
                .withUsername(usuarioDTO.getEmail())
                .password(usuarioDTO.getSenha())
                .build();
    }

}

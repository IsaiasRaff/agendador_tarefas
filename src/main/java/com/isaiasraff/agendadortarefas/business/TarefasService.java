package com.isaiasraff.agendadortarefas.business;

import com.isaiasraff.agendadortarefas.business.dto.TarefasDTO;
import com.isaiasraff.agendadortarefas.business.mapper.TarefasConverter;
import com.isaiasraff.agendadortarefas.infraestructure.entity.TarefasEntity;
import com.isaiasraff.agendadortarefas.infraestructure.enums.StatusNotificacaoEnum;
import com.isaiasraff.agendadortarefas.infraestructure.repository.TarefasRepository;
import com.isaiasraff.agendadortarefas.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa (String token, TarefasDTO dto) {

        String email = jwtUtil.extractUsername(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);


        TarefasEntity entity = tarefaConverter.paraTarefasEntity(dto);
        return tarefaConverter.paraTarefasDTO(
                tarefasRepository.save(entity));
    }

}

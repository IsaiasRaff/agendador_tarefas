package com.isaiasraff.agendadortarefas.business.mapper;

import com.isaiasraff.agendadortarefas.business.dto.TarefasDTO;
import com.isaiasraff.agendadortarefas.infraestructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefasEntity (TarefasDTO dto);

    TarefasDTO paraTarefasDTO (TarefasEntity entity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTO> dtos);
    List<TarefasDTO> paraListaTarefasDTO(List<TarefasEntity> entities);

}

package vn.myclass.core.utils;

import vn.myclass.core.dto.RoleDTO;
import vn.myclass.core.persistence.entity.RoleEntity;

public class RoleBeanUtil {
    public static RoleDTO entity2Dto(RoleEntity entity){
        RoleDTO dto = new RoleDTO();
        dto.setRoleId(entity.getRoleId());
        dto.setName(entity.getName());
        return dto;
    }

    public static RoleEntity dto2Entity(RoleDTO roleDTO){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(roleDTO.getRoleId());
        roleEntity.setName(roleDTO.getName());
        return roleEntity;
    }
}

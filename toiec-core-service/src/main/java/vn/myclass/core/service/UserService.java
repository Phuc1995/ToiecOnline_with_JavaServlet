package vn.myclass.core.service;

import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistence.entity.UserEntity;

import java.util.Map;

public interface UserService {
    UserDTO isUserExit(UserDTO dto);
    UserDTO findRoleByUser(UserDTO dto);
    Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    UserDTO findById(Integer userId);
}

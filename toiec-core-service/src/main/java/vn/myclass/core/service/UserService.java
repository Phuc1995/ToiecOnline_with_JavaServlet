package vn.myclass.core.service;

import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistence.entity.UserEntity;

public interface UserService {
    UserDTO isUserExit(UserDTO dto);
    UserDTO findRoleByUser(UserDTO dto);
}

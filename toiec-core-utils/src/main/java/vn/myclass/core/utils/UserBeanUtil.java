package vn.myclass.core.utils;

import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistence.entity.UserEntity;

public class UserBeanUtil {
    public static UserDTO Entity2Dto(UserEntity userEntity){
        UserDTO dto = new UserDTO();
        return dto;
    }
}

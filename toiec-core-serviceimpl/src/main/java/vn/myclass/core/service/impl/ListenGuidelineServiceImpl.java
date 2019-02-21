package vn.myclass.core.service.impl;

import vn.myclass.core.dao.ListenGuildeDao;
import vn.myclass.core.daoimpl.ListenGuildelineDaoImpl;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.persistence.entity.ListenGuidelineEntity;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.utils.ListenGuildelineBeanUtil;

import java.util.ArrayList;
import java.util.List;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {
    ListenGuildeDao listenGuildeDao = new ListenGuildelineDaoImpl();

/*    public Object[] findListenGuildelineByProperties(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<ListenGuidelineDTO> result = new ArrayList<ListenGuidelineDTO>();
        Object[] objects = listenGuildeDao.findByProperty(property, value, sortExpression, sortDirection, offset, limit);
        for (ListenGuidelineEntity item: (List<ListenGuidelineEntity>) objects[1]){
            ListenGuidelineDTO dto = ListenGuildelineBeanUtil.entity2Dto(item);
            result.add(dto);
        }
        objects[1] =result;
        return objects;
    }*/
}

package com.joshua.server;

import com.joshua.entity.GoodsType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by joshua on 2018-04-17.
 */
public interface GoodsTypeRepository extends CrudRepository<GoodsType,Long> {
    GoodsType findById(Integer id);
}

package com.joshua.server;

import com.joshua.entity.GoodsName;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by joshua on 2018-04-17.
 */
public interface GoodsNameRepository extends CrudRepository<GoodsName,Long> {

    GoodsName findById(Integer id);
}

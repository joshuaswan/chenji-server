package com.joshua.server;

import com.joshua.entity.MeasureUnit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by joshua on 2018-04-17.
 */
public interface MeasureUnitRepository extends CrudRepository<MeasureUnit,Long> {
    MeasureUnit findById(Integer id);
}

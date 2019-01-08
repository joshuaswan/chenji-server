package com.joshua.server;

import com.joshua.entity.StaffType;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by joshua on 2018-05-05.
 */
public interface StaffTypeRepository  extends CrudRepository<StaffType,Long> {

    StaffType findById(Integer id);
}

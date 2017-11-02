package com.teamtreehouse.control;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Rumy on 10/10/2017.
 */
public interface ControlRepository extends PagingAndSortingRepository<Control,Long> {
}

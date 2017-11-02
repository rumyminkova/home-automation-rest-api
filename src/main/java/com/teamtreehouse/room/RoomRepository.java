package com.teamtreehouse.room;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by Rumy on 10/10/2017.
 */
public interface RoomRepository extends PagingAndSortingRepository<Room,Long> {
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Room save(Room room);



}

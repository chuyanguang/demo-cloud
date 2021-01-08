package com.example.demosec.dao;


import com.example.demosec.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//    @Query(value = "select * from t_user t where t.uname = :name", nativeQuery = true)
    @Query(value = "select t from User t where t.name = :name")
    User getUserByName(@Param("name") String name);

}

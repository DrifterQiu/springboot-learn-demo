package com.example.jpa.repository;




import com.example.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {


    @Query("select u from User u where u.userName = ?1")
    User findUserByName(String name);

    User findByUserName(String name);


    @Modifying
    @Query("update User u set u.password = :#{#user.getPassword()} where u.userName = :#{#user.getUserName()}")
    @Transactional
    int updateUser(User user);

    @Modifying
    @Query("delete from User u  where u.id = :id")
    @Transactional
    int deleteUserById(Integer id);


}

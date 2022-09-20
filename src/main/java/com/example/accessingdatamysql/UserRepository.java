package com.example.accessingdatamysql;

// Spring将自动实现到一个名为userRepository的Bean中

import org.springframework.data.repository.CrudRepository;

// CRUD是指创建、读取、更新、删除
public interface UserRepository extends CrudRepository<User,Integer> {
}

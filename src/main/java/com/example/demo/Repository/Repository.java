package com.example.demo.Repository;

import com.example.demo.Model.TestModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<TestModel, String> {
    TestModel findByName(String name);
}
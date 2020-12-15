package com.redbyte.platfrom.demomongodb.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * @author wangwq
 */
@Component
public class AbstractMongoDBService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public <T> void save(T t, String collectionName) {
        mongoTemplate.save(t, collectionName);
    }

    public void deleteById(String id, String collectionName) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, collectionName);
    }
}

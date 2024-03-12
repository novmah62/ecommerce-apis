package com.novmah.advertservice.repository;

import com.novmah.advertservice.domain.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdvertRepository extends MongoRepository<Advert, String> {
}

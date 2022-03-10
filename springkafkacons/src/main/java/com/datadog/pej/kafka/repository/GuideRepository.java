package com.datadog.pej.kafka.repository;

import com.datadog.pej.kafka.model.Guide;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GuideRepository extends CassandraRepository<Guide, UUID> {
    @AllowFiltering
    List<Guide> findByPublished(boolean published);

    List<Guide> findByTitleContaining(String title);
}

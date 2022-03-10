package com.datadog.pej.kafka;


import com.datadog.pej.kafka.model.Guide;
import com.datadog.pej.kafka.repository.GuideRepository;
import com.datastax.oss.driver.api.core.cql.Statement;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.datastax.oss.driver.internal.core.type.codec.TimeUuidCodec;
import com.datastax.oss.driver.internal.core.type.codec.UuidCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.cql.CqlOperations;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.data.cassandra.core.cql.util.StatementBuilder;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.web.client.RestTemplate;


import java.math.BigInteger;
import java.util.UUID;


@SpringBootApplication
public class SpringKafkaApplication {


  private static final Logger log = LoggerFactory.getLogger(SpringKafkaApplication.class);

  @Autowired
  GuideRepository guideRepository;

  @Autowired
  private CassandraOperations cassandraTemplate;


  public static void main(String[] args) {
    SpringApplication.run(SpringKafkaApplication.class, args);
  }


/* To be used with the -javaagent


  public static Tracer initTracer(@Value("ServiceKafka") String service){
    Tracer tracer = GlobalTracer.get();
    return tracer;
  }
*/

  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplateBuilder().build();
  }


  @Bean
  public CommandLineRunner run() {
    return args -> {

      /*
      String title = guideRepository.findAll().get(0).getTitle();
      log.info("Commande line runner cons - Answer is: " + title);

      Guide javaGuide = new Guide(Uuids.timeBased(), "Janig", "O'Reilly", false);
      cassandraTemplate.insert(javaGuide);
      log.info("Cassandra template inserting guide");

      UUID uuid = Uuids.timeBased();
      //String insertCql = "insert into guide (id, title, description, published) values (" + uuid + ", 'Pejman ', 'test1', False)";
      cassandraTemplate.insert(new Guide(uuid, "Pejman", "O'reilly", false));

      *//* select count(*) from... example *//*
      BigInteger rowCount = cassandraTemplate.getCqlOperations().queryForObject("SELECT COUNT(*) FROM guide", BigInteger.class);
      log.info("Cassandra select count(*)= " +rowCount);

      String lastName = cassandraTemplate.getCqlOperations().queryForObject(
              "SELECT id FROM guide WHERE title = ?",
              String.class, "Janig");*/


      log.info("test");
    };
  }

}

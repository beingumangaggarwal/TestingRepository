package com.example.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
//import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.io.File;
import java.io.IOException;
@Configuration
@EnableElasticsearchRepositories(basePackages = "org/springframework/data/elasticsearch/repositories")
     static class Config {

     @Value("${esearch.port}") int port;
     @Value("${esearch.host}") String hostname;

     @Bean
     public ElasticsearchOperations elasticsearchTemplate() {
     return new ElasticsearchTemplate(client());
      }

     @Bean
     public Client client(){
         TransportClient client= new TransportClient();
         TransportAddress address = new InetSocketTransportAddress(hostname, port); 
         client.addTransportAddress(address);
         return client;
     }
}
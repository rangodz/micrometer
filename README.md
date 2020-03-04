# rest-core-micrometer
Define common library to permit custom metrics with Micrometer

# How To use:
## 1. Declaration of dependency
- The dependency is included in rest-core you have nothing to do 
## 2. Adding @EnableMicrometer annotation
- You have to add the annotation in server configuration
```java
package com.jcdecaux.cyclocity.example.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import com.jcdecaux.cpr.micrometer.EnableMicrometer;

@SpringBootApplication
@EnableCycloBloot
public class ExampleServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ExampleServer.class).run(args);
    }
}
```
## 3. Add micrometer parameters in application.yaml of your µService
- You need to set parameter of micrometer in your application like influxdb database and other metrics
```yaml
## Hibernate statistics
spring:
  jpa:
    properties:
      hibernate:
        generate_statistics: true
## disable unnecessary log 
logging:
  level:
    org.hibernate.engine.internal.StatisticalLoggingSessionEventListener: off
## Micrometer Config
management:
  metrics:
    distribution.percentiles.http.server.requests: 0.50, 0.75, 0.95, 0.99, 0.999
    tags:
      service: exemple-server
    export:
      influx:
        uri: http://localhost:8086
        db: micrometer_dev
        user-name:
        password:
        enabled: true
        step: 15s
```



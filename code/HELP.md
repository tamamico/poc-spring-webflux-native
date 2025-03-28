# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.1/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.1/maven-plugin/build-image.html)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/3.4.1/reference/packaging/native-image/introducing-graalvm-native-images.html)
* [Distributed Tracing Reference Guide](https://docs.micrometer.io/tracing/reference/index.html)
* [Getting Started with Distributed Tracing](https://docs.spring.io/spring-boot/3.4.1/reference/actuator/tracing.html)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/3.4.1/reference/testing/testcontainers.html#testing.testcontainers)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/3.4.1/reference/actuator/index.html)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/3.4.1/specification/configuration-metadata/annotation-processor.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.1/reference/using/devtools.html)
* [Spring HATEOAS](https://docs.spring.io/spring-boot/3.4.1/reference/web/spring-hateoas.html)
* [Spring Security](https://docs.spring.io/spring-boot/3.4.1/reference/web/spring-security.html)
* [Testcontainers](https://java.testcontainers.org/)
* [Validation](https://docs.spring.io/spring-boot/3.4.1/reference/io/validation.html)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/3.4.1/reference/web/reactive.html)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

### Additional Links

These additional references should also help you:

* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/3.4.1/how-to/aot.html)

## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks

If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image -Pnative
```

Then, you can run the app like any other container:

```
$ docker run --rm poc-webflux-native:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools

Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./mvnw native:compile -Pnative
```

Then, you can run the app as follows:

```
$ target/poc-webflux-native
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./mvnw test -PnativeTest
```

### Testcontainers support

This project
uses [Testcontainers at development time](https://docs.spring.io/spring-boot/3.4.1/reference/features/dev-services.html#features.dev-services.testcontainers).

Testcontainers has been configured to use the following Docker images:

Please review the tags of the used images and set them to the same as you're running in production.

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the
parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

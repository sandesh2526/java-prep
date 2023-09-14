# Spring Boot

## Spring

## Annotations

### @GetMapping("URL_Here")

Used to map a function against a get request from the specified url

### @RequestBody()

@RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization.

```java
@PostMapping("/")
void postSomeData(@RequestBody Student studentObject) {
    stdentsService.addStudent(studentObject);
}
```

### @Autowired

@Autowired is used to inject the dependency. By injecting a dependency we mean that the spring container will be providing the value.

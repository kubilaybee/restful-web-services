### Annotations

**`@RestController`**

- **Definition:** A convenience annotation that combines `@Controller` and `@ResponseBody`.
- **Purpose:** Marks a class as a RESTful service. Objects returned from a method annotated with `@RestController` are automatically converted to formats like JSON or XML and written to the HTTP response body.

**`@RequestMapping`**

- **Definition:** Used to map incoming HTTP requests (URL paths, HTTP methods, etc.) to specific controller methods or classes.
- **Purpose:** Associates a method or class with a specific URL pattern. More specific versions like `@GetMapping` and `@PostMapping` are commonly used in RESTful services.

**`@GetMapping`**

- **Definition:** A shortcut for `@RequestMapping(method = RequestMethod.GET)`.
- **Purpose:** Used to handle only HTTP `GET` requests, which are typically sent to read data from a resource.

**`@PutMapping`**

- **Definition:** A shortcut for `@RequestMapping(method = RequestMethod.PUT)`.
- **Purpose:** Used to handle only HTTP `PUT` requests, which are sent to completely update a resource.

**`@PathVariable`**

- **Definition:** Used to map a method parameter to a dynamic value from the URL.
- **Purpose:** Allows you to capture the variable part of a URL (e.g., `/users/{id}`) and bind it to the corresponding method parameter in a RESTful API.

**`@ResponseBody`**

- **Definition:** Specifies that the return value of a method should be written directly to the HTTP response body.
- **Purpose:** Allows Spring to automatically convert a method's return value (usually an object) into an HTTP response. Note that `@RestController` already includes this functionality.

**`@ControllerAdvice`**

- **Definition:** An annotation used for global exception handling, data binding, or model attributes applied across multiple controllers.
- **Purpose:** Prevents repetitive `try-catch` blocks or common configurations in multiple controllers. It provides a centralized configuration for all controllers in an application.

**`@ExceptionHandler(Exception.class)`**

- **Definition:** Marks a method as an exception handler for a specific exception class (like `Exception.class`).
- **Purpose:** When used with `@ControllerAdvice`, it allows you to handle a specific type of exception thrown in an application and return a custom HTTP response (e.g., a 500 Internal Server Error).

**`@JsonProperty`**

- **Definition:** Specifies the name that a field in a Java object should take when converted to JSON format.
- **Purpose:** Used to define a JSON key name that is different from the Java field name. This is useful when integrating with external APIs.

**`@JsonIgnoreProperties`**

- **Definition:** Ensures that certain fields are ignored when a Java object is converted to JSON.
- **Purpose:** Lists the fields you do not want to include in the JSON format. This is especially useful for excluding sensitive data (e.g., password fields) from the JSON response.

**`@JsonIgnore`**

- **Definition:** Ensures that a single field in a Java object is ignored when converted to JSON.
- **Purpose:** Similar to `@JsonIgnoreProperties`, this annotation excludes only the specific field it's placed on from the JSON conversion.

### Terms

**REST API**

- **Definition:** An architectural style that uses HTTP methods (GET, POST, PUT, DELETE) to develop web services representing the state of resources (Representational State Transfer).
- **Purpose:** Used to provide lightweight, stateless, and scalable communication in client-server architectures.

**JSON Conversion**

- **Definition:** The process of converting Java objects to JSON format and vice versa.
- **Purpose:** This conversion is critical for RESTful services, which transmit data in a text format (most often JSON). Spring automatically handles this process with the Jackson library.

**Security**

- **Definition:** The process of managing an application's authentication and authorization to prevent unauthorized access to resources.
- **Purpose:** Spring Boot offers a powerful module like Spring Security for this purpose. This module secures the application by managing users, passwords, and their roles.

**Validation**

- **Definition:** The process of checking whether incoming data (e.g., from a form) complies with specific rules (e.g., email format, a field not being empty).
- **Purpose:** Increases the stability and reliability of the application by preventing incorrect or incomplete data from reaching the business logic. Standards like `@Valid` and `javax.validation` are used for this.

**Exception Handling**

- **Definition:** The process of handling errors (exceptions) that occur while the application is running in a controlled and predictable manner.
- **Purpose:** Prevents the application from crashing in unexpected situations and ensures that meaningful error messages are returned to the user. `@ControllerAdvice` and `@ExceptionHandler` play a critical role here.

**HATEOAS**

- **Definition:** The principle that resources in RESTful services should contain links to other related resources.
- **Purpose:** Makes the API navigable like a website. It provides flexibility for the client to discover and navigate the API dynamically.

**Swagger / OpenAPI**

- **Definition:** Open standards that define the structure and features of RESTful APIs.
- **Purpose:** Automates API documentation and makes it easy for developers to understand and test the API. Developers can view all endpoints, parameters, and responses of the API through a web interface.

**Monitoring**

- **Definition:** The process of continuously tracking the performance, health, and behavior of a live application.
- **Purpose:** Helps in the early detection of issues, identifying bottlenecks, and assessing the overall health of the application.

**DispatcherServlet**

- **Definition:** The central component of Spring MVC that receives all incoming web requests and dispatches them to the correct controller.
- **Purpose:** Manages the distribution of web requests to controllers and the creation of responses. Thanks to Spring Boot's auto-configuration, there's no need to manually define this servlet.

**Auto Configuration (`DispatcherServletAutoConfiguration`)**

- **Definition:** The mechanism in Spring Boot that automatically configures the `DispatcherServlet` when web dependencies are detected.
- **Purpose:** Eliminates the developer's need to manually define standard configurations (servlets, filters, listeners) for a web application.

**`@ResponseBody` + Jackson/GSON**

- **Definition:** The tools used by Spring to convert incoming and outgoing HTTP data to and from Java objects when the `@ResponseBody` annotation is used.
- **Purpose:** Spring Boot uses the Jackson library by default. This allows objects returned from controllers to be automatically converted to JSON, and incoming JSON data to be converted into Java objects.

**Auto Configuration (`ErrorMvcAutoConfiguration`)**

- **Definition:** The mechanism in Spring Boot that automatically configures error pages or responses when an error occurs in the application.
- **Purpose:** Developers don't need to manually create an error page or response for every error scenario. Standard error pages or JSON responses are provided automatically.

**`CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler`**

- **Definition:** A class that extends Spring's default error handling class to enable the creation of customized error responses.
- **Purpose:** Used to return custom HTTP responses (e.g., different error codes and specific error messages) for certain exceptions, leveraging the basic functionality provided by `ResponseEntityExceptionHandler`.

**Versioning**

- **Definition:** The process of managing different versions of an API. This ensures that old clients continue to work when backward-incompatible changes are made to the API.
- **Purpose:** Versioning maintains the stability and sustainability of the API. Common methods include URI Versioning (`/v1/users`), Request Parameter (`/users?version=1`), Header, and Media Type Versioning.

**Filtering**

- **Definition:** The process of including or excluding specific fields in a REST API response.
- **Purpose:** Reduces network traffic and increases security by sending the client only the data it needs. Methods include Static Filtering (`@JsonIgnoreProperties`) and Dynamic Filtering (`MappingJacksonValue`).

**`MappingJacksonValue`**

- **Definition:** A class used for dynamic filtering in the Spring Framework.
- **Purpose:** Allows you to dynamically add filters to data that will be written to an HTTP response at runtime. This is a more flexible approach compared to static filters like `@JsonIgnoreProperties`.

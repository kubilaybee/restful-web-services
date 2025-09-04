package com.springprojects.restful_web_services.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    @GetMapping(path = "/v1/person", params = "version1")
    public PersonV1 getFirstVersionOfPersonRequestParam() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(path = "/v2/person", params = "version2")
    public PersonV2 getSecondVersionOfPersonRequestParam() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    @GetMapping(path = "/v1/person", headers = "version1")
    public PersonV1 getFirstVersionOfPersonParamHeader() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(path = "/v2/person", headers = "version2")
    public PersonV2 getSecondVersionOfPersonParamHeader() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    @GetMapping(path = "/v1/person", produces = "application/vdn.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(path = "/v2/person", produces = "application/vdn.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader() {
        return new PersonV2(new Name("Bob", "Marley"));
    }
}

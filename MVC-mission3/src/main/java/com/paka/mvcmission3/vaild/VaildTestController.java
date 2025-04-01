package com.paka.mvcmission3.vaild;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/valid")
public class VaildTestController {

    private List<UserDTO> users;

    public VaildTestController() {
        users = new ArrayList<>();

        users.add(new UserDTO(1, "알파카", "20.09.20", "pa123@gmail.com", "paka12", "paka23456", new Date()));
        users.add(new UserDTO(2, "참새", "10.01.21", "bird1234@gmail.com", "bird23", "brid12312", new Date()));
        users.add(new UserDTO(3, "낙타", "10.01.21", "ca1234@gmail.com", "camel23", "camel12312", new Date()));

    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) throws UserNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<UserDTO> foundUserList =  users.stream().filter(user -> user.getNo() == userNo)
                .collect(Collectors.toList());

        UserDTO foundUser = null;
        if(foundUserList.size() > 0) {
            foundUser = foundUserList.get(0);
        } else {
            throw new UserNotFoundException("회원 정보를 찾을 수 없습니다");
        }

        Map <String, Object> responseMap = new HashMap<>();
        responseMap.put("user", foundUser);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200,"조회성공",responseMap));}


    @PostMapping("/users")
    public ResponseEntity<?> registUser(@Valid @RequestBody UserDTO newUser) {

        System.out.println("user============= " + newUser);

        return ResponseEntity.created(URI.create("/valid/users/" + "userNo")).build();
    }
}


package com.adneom.controller;

import com.adneom.bean.Client;
import com.adneom.exception.BusinessException;
import com.adneom.exception.ErrorCode;
import com.adneom.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Yang Naihua <br>
 * Description:  ClientController<br>
 * @since 2020/02/05<br>
 * Modified By:
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/clients")
public class ClientController {
    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "Client-Register/用户-注册用户", notes = "Client register")
    @PostMapping("/register")
    public Client register(@RequestBody Client client) {
        Optional<Client> bizUser = userRepository.findByUsername(client.getUsername());
        if (bizUser.isPresent()) {
            throw new BusinessException(ErrorCode.CLIENT_USERNAME_ALERDY_EXIST);
        }
        client.setPassword(DigestUtils.md5DigestAsHex((client.getPassword()).getBytes()));
        //client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        return userRepository.save(client);
    }

    @GetMapping(value = {"/{id}"})
    public void notifyDeparture(@PathVariable("id") String id) {
        System.err.println(id);
    }

    @GetMapping(value = {"{id}/info"})
    public void getInfo(@PathVariable("id") String id) {
        System.err.println(id);
    }


}


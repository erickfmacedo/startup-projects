package br.com.desafiopremiado.resource;

import br.com.desafiopremiado.model.User;
import br.com.desafiopremiado.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    IUserRepository userRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST )
    public User save(@RequestBody final User user) {
       return userRepository.save(user);
    }

    @ResponseBody
    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public User update(@PathVariable String uuid, @RequestBody final User user) {
        return userRepository.save(user);
    }

    @ResponseBody
    @RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String uuid) {
        userRepository.delete(uuid);
    }

    @ResponseBody
    @RequestMapping( method = RequestMethod.GET)
    public Page<User> find(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @ResponseBody
    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public User find(@PathVariable String uuid) {
        return userRepository.findOne(uuid);
    }
}

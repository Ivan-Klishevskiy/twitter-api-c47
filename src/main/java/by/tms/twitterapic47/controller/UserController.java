package by.tms.twitterapic47.controller;

import by.tms.twitterapic47.entity.User;
import by.tms.twitterapic47.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {
        User save = userService.save(user);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> update(@PathVariable("username") String username, @RequestBody User user) {
        User update = userService.update(username, user);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> delete(@PathVariable("username") String username) {
        User delete = userService.delete(username);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

    @PostMapping("/follow/{username}")
    public ResponseEntity<?> follow(@PathVariable("username") String username,
                                    @RequestParam("followUsername") String followUsername) {
        String follow = userService.follow(username, followUsername);
        return new ResponseEntity<>(follow, HttpStatus.OK);
    }

    @PostMapping("/unfollow/{username}")
    public ResponseEntity<?> unfollow(@PathVariable("username") String username,
                                      @RequestParam("unfollowUsername") String followUsername) {
        String unfollow = userService.unfollow(username, followUsername);
        return new ResponseEntity<>(unfollow, HttpStatus.OK);
    }
}

    package com.furkan.trendyoliki.controller;

    import java.util.List;

    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.furkan.trendyoliki.entity.User;
    import com.furkan.trendyoliki.service.UserService;

    @RestController
    @RequestMapping("/api")
    public class UserController {

        private UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping("/users")
        public List<User> findAll(){
            return userService.findAll();
        }

        @GetMapping("/users/{userId}")
        public User findById( @PathVariable int userId){


            return userService.findById(userId);
        }

        @PostMapping("/users")
        public User save(@RequestBody User user ){
            User item =userService.save(user);
            return  item;
        }
        @PutMapping("/users")
        public User update(@RequestBody User user){
            User item =userService.save(user);
            return item;

        }
        @DeleteMapping("/users/{id}")
        public void delete(@PathVariable int id){

            userService.deleteById(id);
        }

    }

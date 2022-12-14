package com.techelevator.controller;

import com.techelevator.dao.DealerDao;
import com.techelevator.dao.GarageDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Car;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

    @RestController
    @CrossOrigin
    public class GarageController {

        private GarageDao garageDao;
        private UserDao userDao;

        public GarageController(GarageDao garageDao, UserDao userDao){
            this.garageDao = garageDao;
            this.userDao = userDao;
        }

        @GetMapping(path="/garage")
        public List<Car> displayGarage(Principal principal) {
            return garageDao.getAllCarsByUserId
                    (userDao.findIdByUsername(principal.getName()));
        }

        @GetMapping(path="/user/{id}")
        public User getUserById(@PathVariable int id){
            return userDao.getUserById(id);
        }

    }

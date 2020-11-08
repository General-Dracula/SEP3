package com.example.tier1Mediator;

import com.example.model.Tier1Model;
import com.example.tier3NetworkPackages.NetworkPackage;
import com.example.tier3NetworkPackages.NetworkType;
import com.example.tier3NetworkPackages.StudentDataPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@RestController
public class Tier1ApiConnection implements Tier1Connection
{
    @Autowired
    Tier1Model model;


    public Tier1ApiConnection(Tier1Model model)
    {
        this.model = model;
    }


    @GetMapping("/users")
    public ResponseEntity<User> getUser(@RequestParam String username, @RequestParam String password)
    {
        NetworkPackage bai = model.checkLogInInfo(username, password);
        if(bai.getType().equals(NetworkType.LogInError))
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        else
        {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            StudentDataPackage studentDataPackage = (StudentDataPackage) bai;
            User user = new User(studentDataPackage.getData().getFirstName(), studentDataPackage.getData().getViewGradePassword(), 2);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }

    }
}

package com.example.tier1Mediator;

import com.example.model.Tier1Model;
import com.example.tier3NetworkPackages.NetworkPackage;
import com.example.tier3NetworkPackages.NetworkType;
import com.example.tier3NetworkPackages.StudentDataPackage;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class Tier1ApiConnection {
    @Autowired
    Tier1Model model;

    private Gson gson;


    public Tier1ApiConnection(Tier1Model model)
    {
        this.model = model;
        gson = new Gson();
    }


    @GetMapping("/users")
    public ResponseEntity<String> getUser(@RequestParam String username, @RequestParam String password)
    {
        NetworkPackage bai = model.checkLogInInfo(username, password);
        if (bai.getType().equals(NetworkType.StudentWindowData))
        {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            StudentDataPackage studentDataPackage = (StudentDataPackage) bai;
            String aux = gson.toJson(studentDataPackage);
            System.out.println(aux);
            return new ResponseEntity<String>(aux, HttpStatus.OK);
        }   else return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }
}

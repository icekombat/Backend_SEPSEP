package com.example.demo.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
@CrossOrigin(origins = "http://localhost:4200") //evt. wegen CorsConfig nicht benötigt
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping(path = "/newTestObject")
    public ResponseEntity<String> createTestObject(@RequestBody TestObject testObject){
        if(this.testService.createTestObject(testObject.getText())){
            return new ResponseEntity<String>("TestObjekt wurde erstellt!",HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("TestObjekt konnte nicht erstellt werden! :(",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/getTestObjectList")
    public ResponseEntity<List<TestObject>> getAll(){
        return new ResponseEntity<>(this.testService.getAllTestObjects(),HttpStatus.OK);
    }

    private String[] textArray = {"Hello","These","are","Messages","from","the","Backend"};
    private int index = 0;
    @GetMapping(path = "/text")
    public ResponseEntity<String> getBackendText(){
        index = (index<textArray.length- 1)? index+1 : 0 ;
        return new ResponseEntity<String>(textArray[index], HttpStatus.OK);
    }
}

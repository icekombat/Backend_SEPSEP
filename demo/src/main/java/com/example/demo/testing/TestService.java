package com.example.demo.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public boolean createTestObject(String text){
        TestObject testObject = new TestObject();
        testObject.setText(text);
        this.testRepository.save(testObject);
        return testRepository.findById(testObject.getTestID()).isPresent();
    }

    public List<TestObject> getAllTestObjects(){
        return this.testRepository.findAll();
    }

    public TestObject findByText(String text){
        List<TestObject> objectList = this.testRepository.findAll();
        for (int index = 0; index< objectList.size(); index++){
            if (objectList.get(index).getText()==text) return objectList.get(index);
        }
        return null;
    }
}

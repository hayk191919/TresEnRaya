package com;

import controller.TestController;
import model.TestModel;
import view.TestView;

public class Test {

    public static void main(String[] args) {
        TestView view = new TestView();
        TestModel model = new TestModel();
        TestController controller = new TestController(model, view);
    }
   
}

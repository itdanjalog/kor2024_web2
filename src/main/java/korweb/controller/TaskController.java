package korweb.controller;

//(1) 인스턴스 생성하여 메소드를 호출한다.
//public class TaskController {
//    public void method1( ) {
//        TaskService taskService = new TaskService();
//        taskService.method1();
//    }
//}

////(2) 인스턴스 생성하여 메소드를 호출한다.
//public class TaskController {
//    public void method1( ) {
//        new TaskService().method1();
//    }
//}

////(3) 싱글톤
//public class TaskController {
//    public void method1( ) {
//        TaskService.getInstance().method1();
//    }
//}

import org.springframework.beans.factory.annotation.Autowired;

//// (4) 메소드가 static 일때
//public class TaskController {
//    public void method1( ) {
//        TaskService.getInstance().method1();
//    }
//}

// (5) IOC , DI 활용한 다른 클래스의 메소드 호출/사용
public class TaskController {
    @Autowired private TaskService taskService;
    public void method1( ) {
        taskService.method1();
    }
}
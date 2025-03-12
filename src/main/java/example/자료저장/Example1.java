package example.자료저장;


import java.rmi.server.RemoteRef;
import java.util.*;

public class Example1 {
    public static void main(String[] args) {
        // [생각 해보기] 이름 : 유재석 , 나이 : 40 , 이름 : 신동엽 , 나이 : 50
        // 조건1 : 위 4가지의 자료를 (자바) 저장 하는 방법

        // 1. 변수 : 하나의 자료를 저장 하는 메모리 공간
        // [1] 자료가 4개 이니까 변수4개 만들자. 특징 : 자료 개수에 따라 변수에 많아지므로 관리가 힘들다.
        String name1 = "유재석";   // 하나의 변수에는 하나의 자료를 저장할 수 있다.
        int age1 = 40;
        String name2 = "신동엽";
        int age2 = 50;

        // 2. 배열타입 : *동일한* 타입의 여러 자료들을 저장하는 하나의 자료로 저장하는 메모리 공간
        // 특징 : 파이썬/JS 와 다르게 자바의 배열은 동일한 타입의 여러 자료 들 , 각 자료들 마다의 속성정보 알수 없다. "유재석"이 이름인지 별명인지  모른다.
        // [2] 여러 자료들을 하나의 변수에 순서대로 저장 하자
        String[] array = new String[4];
        array[0] = "유재석";
        array[1] = "40";
        array[2] = "신동엽";
        array[3] = "50";

        // 3. 클래스타입 : *서로 다른 타입*의 여러 자료들을 하나의 자료로 저장하는 메모리 공간
        // 특징 : 자료들을 저장할때 자료들의 상징적인 이름 붙일수 있다. 멤버변수
        ValueDto valueDto = new ValueDto();
        valueDto.name1 = "유재석"; valueDto.age1 = 40;
        valueDto.name2 = "신동엽"; valueDto.age2 = 50;

        // 4. 컬렉션프레임워크<List,Set,Map 등등> : 여러 자료들을 미리 만들어진 자료구조(클래스)에 따라 자료를 저장하는 메모리 공간
        Map< String , String > valueMap = new HashMap<>();
        valueMap.put("name1","유재석");
        valueMap.put("age1","40");
        valueMap.put("value2" , "신동엽" );
        valueMap.put("age2" , "50" );


        // [생각해보기2]
        // Remote 클래스에 Tv 와 Audio 인터페이스 타입의 자료를 모두 저장할 수 있도록 Remote 클래스 코드 수정하시오.
            // 방법 : Tv 와 Audio 타입을 Remote 클래스가 구현implements 한다.
            // - implements : (여러개) 구현하다. [ 실무 ]
            // - extends : (한개) 상속하다.

        // [생각해보기3]
        // ArrayList 타입의 자료 와 LikedList 타입의 자료  를 하나의 타입으로 저장하는 방법 : List 인터페이스 사용한다.

    }
} // c end

interface Tv{}
interface Audio{}
//interface Remo implements Tv , Audio{  }
class Remote implements Tv ,  Audio { }

class ValueDto{ // 클래스 만들기
    String name1; int age1; String name2; int age2;
}


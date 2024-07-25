package com.kh.inherit;

import java.util.Scanner;

import com.kh.inherit.practice.Employee;
import com.kh.inherit.practice.Student;

public class Application {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // 3명의 학생 정보를 기록할 수 있게 객체 배열 할당 (Student[])
        Student[] sArr = new Student[3];

        // 위의 사용데이터 참고하여 3명의 학생 정보 초기화
        sArr[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        sArr[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        sArr[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

        // 위의 학생 정보 모두 출력
        for (Student s : sArr) {
            System.out.println(s.information());
        }

        // 최대 10명의 사원 정보를 기록할 수 있게 배열을 할당 (Employee[])
        Employee[] eArr = new Employee[10];

        eArr[0] = new Employee("박보검", 28, 180.3, 72.0, 100000000, "영업부");
        eArr[1] = new Employee("강동원", 40, 182.0, 76.0, 200000000, "기획부");

        // 사원들의 정보를 키보드로 계속 입력 받고 --> while(true) 무한 반복문을 통해
        // 입력받은 정보들을 가지고 매개변수 생성자를 이용하여 객체배열에 객체 생성
        // 한 명씩 추가 될 때마다 카운트함
        int i = 0;

        while (true) {
            int age = 0, salary = 0;
            double height = 0, weight = 0;
            String name = null, dept = null;

            if (eArr[i] != null) {
                System.out.printf("%d번 사원은 등록되어 있습니다.\n", i+1);
                System.out.println("다음 번호로 Pass합니다.");
                i++;
                continue;
            } else {
                System.out.print("이름을 입력하세요 : ");
                name = scan.nextLine();
                System.out.print("나이를 입력하세요 : ");
                age = scan.nextInt();
                System.out.print("키를 입력하세요 : ");
                height = scan.nextDouble();
                System.out.print("몸무게를 입력하세요 : ");
                weight = scan.nextDouble();
                System.out.print("급여을 입력하세요 : ");
                salary = scan.nextInt();
                scan.nextLine();
                System.out.print("소속을 입력하세요 : ");
                dept = scan.nextLine();

                System.out.printf("%d번 사원을 등록합니다.\n", i+1);
                eArr[i] = new Employee(name, age, height, weight, salary, dept);
                if (i>=9) {
                    System.out.printf("%d번 사원이 등록되었습니다.\n", i+1);
                    System.out.println("더이상 사원을 추가 등록 할 수 없습니다.");
                    break;
                }

                // 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
                // ‘n’일 경우 더 이상 그만 입력 받도록..
                String nextAdd = null;
                System.out.print("사원 추가 등록 합니까? (Y/N) : ");
                nextAdd = scan.nextLine();

                if (nextAdd.equalsIgnoreCase("N")) {
                    System.out.println("사원 등록을 종료합니다.");
                    break;
                } else if (nextAdd.equalsIgnoreCase("Y")) {
                    System.out.println("사원을 추가 등록합니다.");
                    i++;
                    continue;
                } else {
                    System.out.println("잘못입력하셨습니다.");
                    System.out.println("사원을 추가 등록합니다.");
                    i++;
                    continue;
                }
            }            
        }
        // 배열에 담긴 사원들의 정보를 모두 출력
        for (Employee e : eArr) {
            if (e==null) {
                break;
            }
            System.out.println(e.information());
        }

    }
}

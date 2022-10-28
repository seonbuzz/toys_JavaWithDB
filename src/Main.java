import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // 설문 분기 여부

        System.out.println("설문을 참여하시겠습니까?");
        System.out.println("--------------------------------------");
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String flag = "T";
        Scanner sc = new Scanner(System.in);
        while (!flag.equals("Q")) { //종료 flag 사용
            System.out.println("P. 설문시작 | S. 통계 | Q. 종료");
            System.out.println("--------------------------------------");
            flag = sc.nextLine();

            if (flag.equals("P")) { // 설문시작
                new Survey().Survey(statement);

            } else if (flag.equals("S")) { // 통계
              new Statistics().Statistics(statement);
            }
        }
        System.out.println("종료");
    }
}

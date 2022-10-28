import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

// 설문 시작
public class Survey {
    public void Survey(Statement statement) {
        // 이름과 휴대폰 입력 확인
        System.out.print("이름 : ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.print("휴대폰 번호");
        String number = sc.next();

        Commons commons = new Commons();
        String strDate = commons.getGeneratorID();

        String query = "INSERT INTO users_list(USERS_UID, PHONE, NAME)" +
                "VALUES ('" + strDate + "', '" + number + "', '" + name + "')";
        // 유니크 값(Key)을 만들어주는 Function이 있어야함.
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 설문과 답항 내용 출력
        query = "SELECT * FROM question_list ORDER BY ORDERS";

        try {
            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {
                System.out.print(resultset.getInt("ORDERS") + ".");
                System.out.println(resultset.getString("QUESTIONS"));
                String uid = resultset.getString("QUESTIONS_UID");
                // 설문 문항에 맞는 답항 출력
                query = "SELECT example_list.EXAMPLE_UID, example_list.EXAMPLE, example_list.ORDERS" +
                        "FROM answers INNER JOIN example_list" +
                        "       on answers.EXAMPLE_UID = example_list.EXAMPLE_UID" +
                        "       WHERE QUESTIONS_UID = '" + uid + "'" +
                        "ORDER BY ORDERS";
                ResultSet resultSet2 = statement.executeQuery(query);
                ArrayList arrayList = new ArrayList<>(); 

                while (resultSet2.next()) {
                    System.out.print(resultSet2.getInt("ORDERS") + ".");
                    System.out.println(resultSet2.getString("EXAMPLE"));
                    arrayList.add();
                }
                // 설문자 답 받기
                System.out.print("응답 번호 : ");
                String answer = sc.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

package dodo.src.cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student> {//각 학생들의 추천수 및 넣은 날, 학생번호 저장을 위해 클래스 생성
    int num;
    int choice = 0;
    int day;

    public Student() {
        super();
        choice = 0;
    }

    public Student(int num, int choice, int day) {
        super();
        this.num = num;
        this.choice = choice;
        this.day = day;
    }

    @Override
    public int compareTo(Student o) {//추천수 기준으로 오름차순 정렬(+같은 경우 먼저 넣은 사람이 우선)
        if (this.choice == o.choice) return Integer.compare(this.day, o.day);
        return Integer.compare(this.choice, o.choice);
    }
}

public class boj_1713 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Student> pic = new ArrayList<>();//액자 리스트

        int N = Integer.parseInt(br.readLine());//빈 액자 수
        int C = Integer.parseInt(br.readLine());//추천 횟수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            Student can = new Student();//값 담아둘 can 객체 할당
            boolean use = false;//기존에 있는 학생인지 확인용

            can.num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < pic.size(); j++) {
                if (can.num == pic.get(j).num) {//액자에 기존에 있는 학생인 경우
                    pic.get(j).choice++;//추천수 추가
                    use = true;//기존 학생임을 표시하는 flag
                    break;
                }
            }
            if (use == false) {//액자에 같은 것이 없는 경우
                if (pic.size() == N) {//빈 액자가 없는 경우
                    pic.remove(0);//가장 우선순위가 되는 값을 뺀다
                }
                can.choice = 1;
                can.day = i + 1;//넣어주는 날짜넣기
                pic.add(can);
            }
            Collections.sort(pic);//정렬해준다
        }

        pic.sort(new Comparator<Student>() {//num 수 오름차순으로 정렬
            @Override
            public int compare(Student o1, Student o2) {
                return o1.num - o2.num;
            }
        });

        for (int i = 0; i < pic.size(); i++) {//StringBuilder에 넣어주기
            sb.append(pic.get(i).num + " ");
        }
        System.out.println(sb.toString());//출력
    }

}

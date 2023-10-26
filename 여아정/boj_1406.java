package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		Stack<Character>[]word=new Stack[2];//커서를 기준으로 앞 뒤의 스택 2개를 생성
		for(int i=0;i<2;i++) {
			word[i]=new Stack<>();
		}
		
		char[] in=br.readLine().toCharArray();//처음 입력된 문자열
		int N=in.length;//문자열 길이
		
		int plus=Integer.parseInt(br.readLine());//추가로 변경할 사항들 수
		char[][]temp=new char[plus][2];
		
		for(int i=0;i<N;i++) {
			word[0].push(in[i]);
		}
		for(int i=0;i<plus;i++) {
			temp[i]=br.readLine().replace(" ", "").toCharArray();
		}
		
		for(int i=0;i<plus;i++) {
			if(temp[i][0]=='L') {//커서 왼쪽 이동
				if(!word[0].isEmpty()) {
					word[1].push(word[0].pop());//왼쪽 값을 오른쪽으로 하나 이동
				}
			}else if(temp[i][0]=='D') {//커서 오른쪽 이동
				if(!word[1].isEmpty()) {
					word[0].push(word[1].pop());//오른쪽 값을 왼쪽 스택으로 하나 이동
				}
				
			}else if(temp[i][0]=='B') {//커서 왼쪽 값 삭제
				if(!word[0].isEmpty()) {//왼쪽 스택의 마지막 값 삭제
					word[0].pop();
				}
				
			}else if(temp[i][0]=='P') {//커서 왼쪽에 문자 추가
				word[0].push(temp[i][1]);//왼쪽 스택에 문자 하나 추가
			}
		}
		
		//문자 하나로 합치기
		while(!word[0].isEmpty()) {
			word[1].push(word[0].pop());
		}
		
		while(!word[1].isEmpty()) {
			sb.append(word[1].pop());
		}
		
		//출력
		System.out.println(sb.toString());
		
		
	}

}

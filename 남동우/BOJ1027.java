import java.io.*;
import java.util.StringTokenizer;

public class BOJ1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = makeArray(br,n); // 배열을 입력받습니다.
        int max = Integer.MIN_VALUE; // 최대값을 먼저 구하기 위해, max 를 초기화합니다. 
        for(int i = 0; i < array.length; i++){
            int count = 0; // 왼쪽에서 오른쪽으로 가면서 빌딩의 경우의 수를 봅니다.
            count += countLeft(array, i); 
            count += countRight(array, i); // 빌딩 왼쪽과 오른쪽에 보이는 케이스를 더해줍니다.

            if(count > max) {
                max = count; // max 가 count 보다 작다면, max 를 갱신합니다.
            }
        }
        System.out.println(max); // max 를 출력합니다.
    }
  // 왼쪽으로 보이는 빌딩을 세는 메소드입니다.
    static int countLeft(int[] array, int index){
        int count = 0; 
        double maxGradient = Integer.MIN_VALUE; // 이때동안 보고 있는 최대 기울기를 가장 낮게 초기화해 줍니다.
        for(int i = index - 1; i >= 0; i--){ // 빌딩의 바뢰 왼쪽에 있는 것부터, 0번째까지 보는 for 문입니다.
            double gradient = getGradient(index - i, array[index], array[i]); // 빌딩 사이의 기울기를 구해 줍니다.
            if(gradient > maxGradient){ 
              // 만약, 빌딩 사이의 기울기가 maxGradient 보다 크다면, 그 빌딩은 지금까지 보았던 빌딩보다
              // 높이 보일 것입니다. 높이 보인다는 뜻은, 그 빌딩이 보인다는 의미이기도 합니다. 
              // maxGradient 를 업데이트 해 주고, count 를 하나 늘려 줍니다.
                maxGradient = gradient;
                count++;
            }
        }

        return count; // count 를 반환해 줍니다.
    }
  // 오른쪽으로 보이는 빌딩을 세어 주는 메소드입니다. 기본 원리는 왼쪽을 보는 것과 같습니다.
    static int countRight(int[] array, int index){
        int count = 0;
        double maxGradient = Integer.MIN_VALUE;
        for(int i = index + 1; i < array.length; i++){
            double gradient = getGradient(i - index, array[index], array[i]);
            if(gradient > maxGradient){
                maxGradient = gradient;
                count++;
            }
        }
        return count;
    }
  // 기본적으로 수학에서 사용되는, 기울기 구하는 방법을 가져 온 메소드입니다.
    static double getGradient(int dx, int indexY, int seeY){
        return ((double)(seeY - indexY) / (double)dx);
    }

    static int[] makeArray(BufferedReader br, int size) throws IOException{
        int[] array = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        return array;
    }
}

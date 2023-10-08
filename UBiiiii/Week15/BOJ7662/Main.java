package UBiiiii.Week15.BOJ7662;

/*
 * 7662 이중우선순위 큐
 * 첫 번째 방법 : 큐 두 개를 만들어서(정렬 순서 반대) 요청이 있을 때마다 돌려쓰자 -> 시간초과
 * 두 번째 방법 : ArrayList에다가 직접 집어넣고, 뺄 때만 정렬해보자 -> 시간 초과
 * 세 번째 방법 : 직접 노드를 만들어서 트리 구조로 정렬을 시켜보자 -> 빼는 과정에서 에러 속출
 * 네 번째 방법 : 구글 검색 -> 트리 맵 이라는 개쩌는 맵이 있다 -> 트리 맵을 이용해서 추가되는 값의 수를 저장하고, 다 없어지면 제거해버리자
 * 참조 링크 : https://girawhale.tistory.com/14
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine()), k, curr, tmp;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      k = Integer.parseInt(br.readLine());
      map.clear();

      for(int j=0; j<k; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(st.nextToken().charAt(0)=='I') {
          curr = Integer.parseInt(st.nextToken());
          map.put(curr, map.getOrDefault(curr, 0)+1);
        }

        else {
          if(map.size()==0) continue;

          if(st.nextToken().length()==2) {
            tmp = map.firstKey();
            if(map.get(tmp)==1)  map.remove(tmp);
            else        map.put(tmp, map.get(tmp)-1);
          } else {
            tmp = map.lastKey();
            if(map.get(tmp)==1)  map.remove(tmp);
            else        map.put(tmp, map.get(tmp)-1);
          }
          
        }
      }

      if(map.keySet().size()==0)  sb.append("EMPTY");
      else                        sb.append(map.lastKey()).append(" ").append(map.firstKey());

      if(i!=n-1)  sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}


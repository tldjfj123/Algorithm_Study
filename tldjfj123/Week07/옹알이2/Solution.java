package 옹알이2;

class Solution {
    public int solution(String[] babbling) {
        String[] pr = {"ye", "aya", "ma", "woo"};

        for (int i = 0; i < babbling.length; i++) {
            //"ayamaaya" 같은 case처리 위해 while문 활용
            while (true) {
                String prev = babbling[i];

                for (int j = 0; j < pr.length; j++) {
                    //연속으로 오는 경우 확인하기 위해 각각 다른 숫자로 변경
                    if (pr[j].equals("ye")) {
                        babbling[i] = babbling[i].replaceFirst(pr[j], "1");
                    } else if (pr[j].equals("aya")) {
                        babbling[i] = babbling[i].replaceFirst(pr[j], "2");
                    } else if (pr[j].equals("ma")) {
                        babbling[i] = babbling[i].replaceFirst(pr[j], "3");
                    } else {
                        babbling[i] = babbling[i].replaceFirst(pr[j], "4");
                    }
                }
                String after = babbling[i];
                //무한루프 피하기 위해 변동사항 없을 시 break
                if (prev.equals(after)) {
                    break;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < babbling.length; i++) {
            // 연속된 값이 존재하지 않고, 모두 숫자로 이루어졌을 경우에만 result++;
            // matches : 정규식과 일치하는지 확인해주는 함수
            // "\\d+"
            /*
            "\\d" : 숫자를 나타내는 특수한 문자 클래스
            "+" : 바로 앞에 있는 표현식이 하나 이상의 표현을 나타내는 양자성
            -> 문자열이 모두 숫자로 이뤄져있는지 확인 가능
            */
            if (!babbling[i].contains("11") && !babbling[i].contains("22") && !babbling[i].contains("33") && !babbling[i].contains("44") && babbling[i].matches("\\d+")) {
                result++;
            }
        }

        return result;
    }
}
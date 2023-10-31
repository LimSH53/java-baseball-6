package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임진행
        startGanme();

    }

    public static List<Integer> InputNum() throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumString = Console.readLine();

        List<Integer> numList = new ArrayList<>();
        
        for(int i = 0; i<3; i++){
            numList.add(Integer.parseInt(playerNumString.substring(i, i+1)));
        }

        System.out.println("자른숫자 : " + numList);

        return numList;
    }

    public static List<Integer> randomNum() {

        List<Integer> randomNum = new ArrayList<>();

        while(randomNum.size() < 3){
            int num = Randoms.pickNumberInRange(1, 9);
            if(!randomNum.contains(num)){
                randomNum.add(num);
            }
        }
        System.out.println("randomNum : " + randomNum);
        
        return randomNum;
    }

    public static void startGanme() {

        //랜덤 숫자 추출
        List<Integer> randomNum = randomNum();

        boolean result = true;

        while(result){
            // 사용자 숫자 입력
            List<Integer> userInputNum = InputNum();

            //스트라이크 갯수
            int strike = 0;
    
            //볼 갯수
            int ball = 0;
    
            for(int i = 0; i < 3; i++){
                 if(randomNum.contains(userInputNum.get(i))){
                    ball++;
                 }
    
                 if(randomNum.get(i).equals(userInputNum.get(i))){
                    strike++;
                    ball--;
                 }
            }
    
            if(strike == 3){
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                result = false;
            } else if(ball > 0 && strike == 0) {
                System.out.println(ball + "볼");
            } else if(ball == 0 && strike > 0) {
                System.out.println(strike + "스트라이크");
            } else if(ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }

        //종료 여부 설정
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameContinueYn = Console.readLine();

        while(gameContinueYn.length() > 1 || (!gameContinueYn.contains("1") && !gameContinueYn.contains("2"))){
            System.out.println("알맞은 값을 다시 입력해주세요.");
            gameContinueYn = Console.readLine();
        }

        if(gameContinueYn.contains("1")){
            System.out.println("게임을 재진행 합니다.");
            startGanme();
        } else {
            System.out.println("종료.");
        } 

    }
}

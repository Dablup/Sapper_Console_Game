import java.util.ArrayList;

class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<>();
    private int numberOfGuesses = 0;

    void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);
        System.out.println("Ваша цель потопить три сайта.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Постарайтесь потопить их за минимальное количество ходов.");

        for (DotCom dotComToSet : dotComList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCell(newLocation);
        }
    }

    void startPlaying(){
        while (!dotComList.isEmpty()){
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numberOfGuesses++;
        String result = "мимо";

        for (DotCom dotComToTest: dotComList) {
            result = dotComToTest.checkYourself(userGuess);
            if(result.equals("попал")){
                break;
            }
            if(result.equals("потопил")){
                dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
        if(numberOfGuesses <= 18){
            System.out.println("Это заняло у вас всего " + numberOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули.");
        } else {
            System.out.println("Это заняло у вас довольно много времени!");
            System.out.println("Рыбы водят хоровод вокруг ваших вложений.");
        }
    }
}

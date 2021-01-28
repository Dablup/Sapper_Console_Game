import java.util.ArrayList;

class DotCom{
    private ArrayList<String> locationCell;
    private String name;
    void setLocationCell(ArrayList<String> locations){
        locationCell = locations;
    }

    void setName(String name) {
        this.name = name;
    }

    String checkYourself(String userInput){
        int index = locationCell.indexOf(userInput);
        String result = "мимо";
        if (index >= 0){
            locationCell.remove(index);
            if(locationCell.isEmpty()) {
                result = "потопил";
                System.out.println("Вы потопили " + name + " :(");
            } else {
                result = "попал";
            }
        }
        return result;
    }
}

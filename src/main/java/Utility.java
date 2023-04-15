import java.util.ArrayList;
import java.util.List;

public class Utility {
        public static List<Boolean> alreadyHereList = new ArrayList<>();
        public static void populateList() {
            alreadyHereList.add(Opening.alreadyHere);
            alreadyHereList.add(FifthFloor.alreadyLeft1);
            alreadyHereList.add(FifthFloor.alreadyLeft2);
            alreadyHereList.add(FifthFloor.alreadyLeft4);
            alreadyHereList.add(FifthFloor.alreadyRight1);
            alreadyHereList.add(FifthFloor.alreadyRight3);
            alreadyHereList.add(FifthFloor.alreadyReception);
            alreadyHereList.add(FifthFloor.alreadyReceptionInnerOffice);
            alreadyHereList.add(FifthFloor.backOnFloorFive);


        }
        public static void resetAlreadyHere () {
            for (int i=0; i< alreadyHereList.size();i++) {
                alreadyHereList.set(i, false);
            }
        }

}

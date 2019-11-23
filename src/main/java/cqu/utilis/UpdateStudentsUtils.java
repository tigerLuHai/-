package cqu.utilis;

import cqu.domain.UpdateStudents;

public class UpdateStudentsUtils {

    public static boolean IsQualified(UpdateStudents updateStudents) {
        String regex = "^[01]$";
        boolean weChat = String.valueOf(updateStudents.getWeChat()).matches(regex);
        boolean zhangYou = String.valueOf(updateStudents.getZhangYou()).matches(regex);
        boolean shoppingCart = String.valueOf(updateStudents.getShoppingCart()).matches(regex);
        boolean isContinue = String.valueOf(updateStudents.getIsContinue()).matches(regex);
        boolean oneToOne = String.valueOf(updateStudents.getOneToOne()).matches(regex);
        boolean work = String.valueOf(updateStudents.getWork()).matches(regex);
        boolean video = String.valueOf(updateStudents.getVideo()).matches(regex);
        boolean note = String.valueOf(updateStudents.getNote()).matches(regex);
        boolean knowledgeMaster = String.valueOf(updateStudents.getKnowledgeMaster()).matches(regex);

        return weChat && zhangYou && shoppingCart && isContinue && oneToOne && work && video && note && knowledgeMaster;
    }
}

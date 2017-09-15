package locidnet.soccer.uz.util;

import java.util.ArrayList;

import locidnet.soccer.uz.model.ChooseDate;
import locidnet.soccer.uz.model.Match;
import locidnet.soccer.uz.model.News;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class Demo {


    public static ArrayList<News> newses ;
    static {
        newses = new ArrayList<>();
        newses.add(new News(0,"","Сегодня","",false));
        newses.add(new News(0,"Доходы «Реала» в прошлом сезоне составили 674,6 млн евро. Прибыль – 21,4 млн","12:00","12",false));
        newses.add(new News(0,"Александр Овечкин: «То, что мы не сыграем на Олимпиаде – отстой. Надеюсь, к Играм-2022 ситуация поменяется»","08:00","312",true));
        newses.add(new News(0,"Руководство «Розы Хутор» запретило проводить тренировки для детей-инвалидов из-за боязни за свою репутацию","14:00","43",false));
        newses.add(new News(0,"Доходы «Реала» в прошлом сезоне составили 674,6 млн евро. Прибыль – 21,4 млн","12:00","400",false));
        newses.add(new News(0,"","Вчера","",false));
        newses.add(new News(0,"Доходы «Реала» в прошлом сезоне составили 674,6 млн евро. Прибыль – 21,4 млн","12:00","32",false));
        newses.add(new News(0,"Александр Овечкин: «То, что мы не сыграем на Олимпиаде – отстой. Надеюсь, к Играм-2022 ситуация поменяется»","08:00","55",true));
        newses.add(new News(0,"Руководство «Розы Хутор» запретило проводить тренировки для детей-инвалидов из-за боязни за свою репутацию","14:00","65",false));
        newses.add(new News(0,"Доходы «Реала» в прошлом сезоне составили 674,6 млн евро. Прибыль – 21,4 млн","12:00","87",false));
    }

    public static ArrayList<Match> matches;

    static {
        matches = new ArrayList<>();
        matches.add(new Match(0,"15 - сентября, 00:00 (Завершён)","Барселона","2","Реал Мадрид","1","Ла Лига"));
        matches.add(new Match(0,"15 - сентября, 00:00 (Завершён)","Малага","2","Барселона","1","Ла Лига"));
        matches.add(new Match(0,"15 - сентября, 00:00 (Завершён)","Хетафе","2","Реал Мадрид","1","Ла Лига"));
        matches.add(new Match(0,"15 - сентября, 00:00 (Завершён)","Атл.Мад.","0","Реал Мадрид","1","Ла Лига"));
        matches.add(new Match(0,"15 - сентября, 00:00 (Завершён)","Атл.Мад.","0","Реал Мадрид","1","Ла Лига"));
        matches.add(new Match(0,"15 - сентября, 00:00 (Завершён)","Атл.Мад.","0","Реал Мадрид","1","Ла Лига"));
        matches.add(new Match(0,"15 - сентября, 00:00 (Завершён)","Барселона","2","Реал Мадрид","1","1 Лига"));
        matches.add(new Match(0,"15 - сентября, 00:00 (Завершён)","Барселона","2","Реал Мадрид","1","1 Лига"));
        matches.add(new Match(0,"15 - сентября, 00:00 (Завершён)","Барселона","2","Реал Мадрид","1","1 Лига"));
        matches.add(new Match(0,"15 - сентября, 00:00 (Завершён)","Барселона","2","Реал Мадрид","1","1 Лига"));
        matches.add(new Match(0,"15 - сентября, 00:00 (Завершён)","Барселона","2","Реал Мадрид","1","1 Лига"));
    }

    public static ArrayList<ChooseDate> choose;

    static {
        choose = new ArrayList<>();
        choose.add(new ChooseDate("Сегодня",true));
        choose.add(new ChooseDate("Неделя",false));
        choose.add(new ChooseDate("Месяць",false));
        choose.add(new ChooseDate("Выберите дату",false));
    }
}

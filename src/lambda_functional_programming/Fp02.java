package lambda_functional_programming;

import java.util.ArrayList;
import java.util.List;

public class Fp02 {
    /*
    1.  t-> "Logic", (t,u)-> "Logic"
        Bu yapiya lambda expression diyoruz.

    2.  Functional Programming kapsaminda "Lambda Expression" kullanilabilir ama onerilmez.
        Eger mumkunse "Lambda Expression" yerine "Method Referance" kullanilir.

    3. "Method Referance" kullanimi "Class Name :: Method Name" seklinde uygulanir.
        Ayni zamanda kenci class'larimizi da kullanabiliriz.
        Ornegin: bir animal class'imiz var ve bu class'da "eat()" methodu var. "Animal::eat" seklinde kullanilir.


        Ayri bir Util class'i olusturulur ve ara methodlar burada olusturulur ve Util:: ile buradan cekilir.
     */

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(8);
        list.add(9);
        list.add(131);
        list.add(10);
        list.add(9);
        list.add(10);
        list.add(2);
        list.add(8);
        System.out.println(list);
        listElemanlariniYazdirFunctional(list);
        System.out.println();
        ciftElemanlariYazdirFunctional(list);
        System.out.println();
        tekElemanlarinKaresiniYazdir(list);
        System.out.println();
        tekElemanlarinKupleriniTekrarsizYazdir(list);
    }
    // 1. Ardisik list elementlerini ayni satirda aralarinda bosluk birakarak yazdiran bir method olusturun. (Functional)

    public static void listElemanlariniYazdirFunctional(List<Integer> list){
        list.stream().forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
    // 2. Cift sayi olan list elemanlarini ayi satirda aralarinda bosluk birakarak yazdiran bir method olusturun.

    public static void ciftElemanlariYazdirFunctional(List<Integer> list){

        list.stream().filter(Utils::ciftElemanlariFiltrele).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
    // 3. Tek list elemanlarinin karelerini ayni satirda aralarinda bosluk birakarak yazdiran bir method olusturun.

    public static void tekElemanlarinKaresiniYazdir(List<Integer> list){

        list.stream().
                filter(Utils::tekElemanlariFiltrele).
                map(Utils::karesiniAl).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
    // 4. Tek list elemanlarinin kuplerini tekrarsiz olarak ayni satirda ve aralarinda bosluk olacak sekilde
    // yazdiran method yazin. (Functional)
    public static void tekElemanlarinKupleriniTekrarsizYazdir(List<Integer> list){

        list.
                stream().
                distinct().
                filter(Utils::tekElemanlariFiltrele).
                map(Utils::kupunuAl).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

}

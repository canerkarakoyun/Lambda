package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01 {
    /*
    1. Lambda (Functional Programming) Java 8 ile kullanilmaya baslanmistir.
    2. Functional Programming'de ne yapilacak (What to do) uzerine yogunlasilir.
       Structred Programming "Nasil yapilacak" (How to do) uzerine yogunlasilir.
    3. Functional Programming arrays ve collections ile kullanilir.
    4. "entrySet()" methodu ile Map, Set'e donusturulerek Functional Programming'de kullanilabilir.

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
        System.out.println();
        System.out.println("Structred:");
        listElemanlariniYazdirStructured(list);
        System.out.println();
        System.out.println("Functional:");
        listElemanlariniYazdirFunctional(list);
        System.out.println();
        System.out.println("Structred:");
        ciftElemanlariYazdirStructured(list);
        System.out.println();
        System.out.println("Functional:");
        ciftElemanlariYazdirFunctional(list);
        System.out.println();
        System.out.println("Functional:");
        tekElemanlarinKareleriniYazdirFunctional(list);
        System.out.println();
        System.out.println("Functional:");
        tekrarsizTekElemanlarinKupunuYazdir(list);
        System.out.println();
        System.out.println("Functional:");
        tekrarsizCiftElemanlarinToplami(list);
        System.out.println("Functional:");
        tekrarsizCiftElemanlarinKuplerininCarpimi(list);
        System.out.println("Functional");
        getMaxEleman01(list);
        getMaxEleman02(list);
        getMinEleman01(list);
        getMinEleman02(list);
        getYedidenbuyukMinCiftSayi01(list);
        getYedidenBuyukMinCiftEleman02(list);
        getYedidenBuyukMinCiftEleman03(list);
        getTersSiralamaTekrarsizElemanlarinYarisi(list);

    }
    //1. Ardisik list elementlerini ayni satirda aralarinda bosluk birakarak yazdiran bir method olusturun. (Structral)

    public static void listElemanlariniYazdirStructured(List<Integer> list){

        for (Integer w : list){

            System.out.print(w+" ");
        }
    }
    //1. Ardisik list elementlerini ayni satirda aralarinda bosluk birakarak yazdiran bir method olusturun. (Functional)

    public static void listElemanlariniYazdirFunctional(List<Integer> list){
        list.stream().forEach(t-> System.out.print(t+" "));

        // t-> lambda expression olarak adlandirilir. Bunu g,rdugumuz yer lambda expressiondur.
        // t semboldur, istedigimizi yazabiliriz. Ancak cogunlukla t, u, v gorursunuz.
        // stream() methodu collection'dan elementleri akisa dahil etmek icin ve
        // methodlara ulasmak icin kullanilabilir.

    }
    // 2. Cift sayi olan list elemanlarini ayi satirda aralarinda bosluk birakarak yazdiran bir method olusturun. (Structural)

    public static void ciftElemanlariYazdirStructured(List<Integer> list){
        for (Integer w: list){
            if (w%2==0){
                System.out.print(w+" ");
            }
        }
    }

    // 2. Cift sayi olan list elemanlarini ayi satirda aralarinda bosluk birakarak yazdiran bir method olusturun. (Functional)
    public static void ciftElemanlariYazdirFunctional(List<Integer> list){

        list.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));
    }

    // 3. Tek l'st elemanlarinin karelerini ayni satirda aralarinda bosluk birakarak yazdiran bir method olusturun. (Functional)

    public static void tekElemanlarinKareleriniYazdirFunctional(List<Integer> list){

        list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t+" "));
        // elemanlarin degerleri degisecekse map() method'u kullanilir.
    }

    // 4. Tek list elemanlarinin kuplerini tekrarsiz olarak ayni satirda ve aralarinda bosluk olacak sekilde
    // yazdiran method yazin. (Functional)

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list){

        list.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
                // distinct() methodu tekrarlanan elemanlari alma demek.
    }

    // 5. Tekrarsiz cift elemanlarin karelerinin toplamini yazdiran bir method olusturun. (Functional)

    public static void tekrarsizCiftElemanlarinToplami(List<Integer> list){

        Integer toplam = list.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);
        System.out.println(toplam);
    }

    // 6. Tekrarsiz cift elemanlarin kuplerinin carpimini hesaplayan bir method olusturun.

    public static void tekrarsizCiftElemanlarinKuplerininCarpimi(List<Integer> list){

        Integer carpim=list.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(t,u)->t*u);
        System.out.println(carpim);
    }
    // 7. List elemanlari arasindaki en buyuk elemani bulan bir method olusturun.

    public static void getMaxEleman01(List<Integer> list){

        Integer max=list.stream().distinct().reduce(Integer.MIN_VALUE, (t,u)-> t>u ? t : u);
        System.out.println(max);
    }
    // 2. Yol

    public static void getMaxEleman02(List<Integer> list){

        Integer max=list.stream().distinct().sorted().reduce(list.get(0), (t,u)->u);
        System.out.println("max = " + max);
    }
    //Odev:
    // 8. List elemanlari arasinda en kucuk degeri bulan bir method olusturun. (2 yol ile)

    public static void getMinEleman01(List<Integer> list){

        Integer min=list.stream().distinct().reduce(list.get(0), (t,u)-> t<u ? t : u);
        System.out.println("min = " + min);
    }
    // 2. Yol:

    public static void getMinEleman02(List<Integer> list){

        Integer min=list.stream().distinct().sorted().findFirst().get();
        System.out.println("min = " + min);
    }
    // 9. List elemanlari arasinda 7'den buyuk, cift, en kucuk degeri bulan bir method olusturun.

    public static void getYedidenbuyukMinCiftSayi01(List<Integer> list){

        Integer min7denKucuk=
                list.stream().
                        distinct().
                        filter(t->t%2==0).
                        filter(t->t>7).
                        reduce(Integer.MAX_VALUE, (t,u)->t<u ? t : u);
        System.out.println("min7denKucuk = " + min7denKucuk);
    }
    // 2. Yol:

    public static void getYedidenBuyukMinCiftEleman02(List<Integer> list){

        Integer min7denBuyukEnkucuk=
                        list.stream().
                        distinct().
                        filter(t->t%2==0).
                        filter(t->t>7).
                        sorted(Comparator.reverseOrder()).
                        reduce(Integer.MAX_VALUE, (t,u)->u);
        System.out.println("min7denBuyukEnkucuk = " + min7denBuyukEnkucuk);
    }
    //3. Yol
    public static void getYedidenBuyukMinCiftEleman03(List<Integer> list){

        Integer min7denBuyukEnkucuk=
                        list.stream().
                        distinct().
                        filter(t->t%2==0).
                        filter(t->t>7).sorted().
                        findFirst().
                        get();
        System.out.println("min7denBuyukEnkucuk = " + min7denBuyukEnkucuk);
    }
    // 10. Ters siralama ile tekrarsiz ve 5'den buyuk elemanlarin yari degerlerini bulan bir method olusturun.

    public static void getTersSiralamaTekrarsizElemanlarinYarisi(List<Integer> list){

        List<Double> sonuc=list.stream().
                distinct().
                filter(t->t>5).
                map(t->t/2.0).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
        System.out.println("sonuc = " + sonuc);
    }

}

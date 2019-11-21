package JavaSchool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Collection1 {
    public static void main(String[] args) {
        try {
            String file = "c:/temp/1.txt";
            BufferedReader brf = new BufferedReader(new FileReader(file));
            String temp = "";
            Set<String> strings = new HashSet<>();
            Map<String, Integer> map = new HashMap<>();
            ArrayList<String> fileStrings = new ArrayList<>();
            System.out.println("Все слова в файле:");
            while((temp = brf.readLine()) != null) {
                fileStrings.add(temp);
                String[] b = temp.split(" ");
                for (String s:b) {
                    strings.add(s);
                    if (map.containsKey(s))
                        map.put(s,map.get(s)+1);
                    else map.put(s,1);

                }
                for(int i = 0; i < b.length; ++i) {
                        System.out.println(b[i]);
                }
            }
            brf.close();

            // количество разных слов
            System.out.println(strings.size());
            //вывод уникальных слов
            Comparator<String> comparator = (o1, o2) -> {
                if (o1.length()>o2.length())
                    return -1;
                if (o1.length()<o2.length())
                    return 1;
               else
                   return o1.compareTo(o2);
            };
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(strings);
           Collections.sort(arrayList, comparator);
            System.out.println();
            for (String word: arrayList) {
                System.out.println(word);
            }
            // сколько раз каждое слово встречается
            System.out.println("сколько раз каждое слово встречается");
            for (Map.Entry<String, Integer> e: map.entrySet()) {
                System.out.println(e.getKey() + " " + e.getValue() ); // + "\n"
            }
            // вывод строк в обратном порядке
            System.out.println("Вывод строк в обратном порядке:");
            Collections.reverse(fileStrings);
            for (String s:fileStrings) {
                System.out.println(s);
            }
            Collections.reverse(fileStrings); // отсортирвали взад к изначальному порядку строк

            System.out.println("Вывод с обычным итератором:");
            for (String s: arrayList) {
                System.out.println(s);
            }
            // анонимный итератор
            Iterator<String> it = arrayList.iterator();
            it=new Iterator<>() {
                int index = arrayList.size()-1;
                @Override
                public boolean hasNext() {
                    if (index-1==-2)
                        return false;
                    else
                        return true;
                }

                @Override
                public String next() {
                    String s = arrayList.get(index);
                    index--;
                    return s;
                }
            };
            System.out.println("Вывод c реверсивным итератором");
            while (it.hasNext())
                System.out.println(it.next());

            //вывод строки с нужным номером
            System.out.println("Введите номер строки, чтобы закончить ввод нажмите Enter:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String buf = br.readLine();
                int i;
                if (buf.equals("")) break;
                i = Integer.valueOf(buf);
                if (i < fileStrings.size())
                    System.out.println(fileStrings.get(i));
                else

                    System.out.println("Нет такой строки!");
            }
        br.close();
            System.out.println("Спасибо за внимание! )))");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}

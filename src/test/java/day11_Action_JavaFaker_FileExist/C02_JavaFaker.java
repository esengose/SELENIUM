package day11_Action_JavaFaker_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {

    @Test
    public void javaFakerTest(){
        //1.Faker objesi oluştur
        Faker faker =new Faker();

        //2.Faker objesi ile fake datalar oluşturalım
        //first name data
        String fname= faker.name().firstName();
        System.out.println(fname);

        //last name data
        String lname=faker.name().lastName();
        System.out.println(lname);

        //username data
        String username = faker.name().username();
        System.out.println(username);

        //meslek/title data
        String title= faker.name().title();
        System.out.println(title);

        //city
        String city=faker.address().city();
        System.out.println(city);

        //full adres
        System.out.println(faker.address().fullAddress());

        //phone number
        System.out.println(faker.phoneNumber().cellPhone());

        //nationality
        System.out.println(faker.nation().nationality());

        //rasgele 15 haneli no
        System.out.println(faker.number().digits(15));

        /*
TEST DATA : kullanici adi, sifre, tel no, e-mail, sehir, kredi kart no,...
Test datalari kimden alinir?
1- BA-Business Analyst (Acceptance Criteria'lari yazar)
2- Test Lead
3- Manual Tester
4- Tech Lead & Team Lead & DEV Lead
5- Developer
6- Database
7- API call'lar
8- Documentations. Ornegin, API swagger dokumani.
9- Java Faker da fake data almak icin kullaniyoruz.
NERDEN GELMEZ : kullanicidan alinmaz, scrum master,..
 */

    }
}

package day11_Action_JavaFaker_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void isExistTest(){
        //Class : FileExistTest
        //Method : isExist
        //Masa ustunden bir dosyanın varligini test et

        String userDIR=System.getProperty("user.dir");
        System.out.println(userDIR);

        String userHome=System.getProperty("user.home");
        System.out.println(userHome);

        //logo.jpeg indirip masaüstüne kaydedin

        String dosyaYolu=userHome+"/Desktop/logo.jpeg";

        System.out.println(dosyaYolu);

        boolean isExist=Files.exists(Paths.get(dosyaYolu));
        Assert.assertTrue(isExist);

/*
        1. fail -> PATH YANLIS : dosya masa ustunde degil, dosya adi yanlis, yada arada onedrive gibi ex dosyalar olarak
         */
    }
}

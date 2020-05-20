package mayinoyunu;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class MayinOyunu {

    int satir;
    int sutun;
    int oyunBoyutu;
    int mayinAlani[][];
    Random rnd=new Random();
    
    MayinOyunu(int satir, int sutun)//Kullanıcının oynayacağı mayin alaninin boyutlarını oluşturdum
    {
        this.satir=satir;
        this.sutun=sutun;
        this.mayinAlani=new int [satir][sutun]; 
        this.oyunBoyutu=satir*sutun;
    }
    
    public void calistir(){
        mayinYerlestirme();
        goster(mayinAlani);
        kontrolEt(satir,sutun,mayinAlani);
        }
    
    public void mayinYerlestirme()
    {
        int sayac=0;
        while(sayac!=(oyunBoyutu/4)) //Boyutunun çeyreği kadar mayın yerleştirilecektir.
        {
                int rndsatir=rnd.nextInt(satir);
                int rndsutun=rnd.nextInt(sutun);
                
                if(mayinAlani[rndsatir][rndsutun]!=2)
                {
                    mayinAlani[rndsatir][rndsutun]= 9; //mayın 9 olsun
                    sayac++;
                }
            }
        }
    
    
    
    public void goster(int [][] dizi) //Mayın gösterildi
    {
        for(int i=0; i<dizi.length; i++)
        {
            for(int j=0; j<dizi.length; j++)
            {
                System.out.print(dizi[i][j]+ " ");
            }
            System.out.println(" ");
        } 
       
    }
    
        public void kontrolEt(int satir, int sutun, int mayinAlani[][]) //Mayınlı bölgenin çevresi kontrol edildi 
    {
        System.out.println("mayin var mı diye 9 tane kutu kontrol ediliyor");
          for (int i = 0; i < satir; i ++)
          {
              for (int j = 0; j < sutun; j++)
              {
                  
                   if (mayinAlani[i][j] == 0) 
                   {
                       
                       int sayac = 0;
                       for (int r = i - 1; r <= i + 1; r = r + 1)
                       {
                           for (int c = j - 1; c <= j + 1; c = c + 1)
                           {
                                if (r >= 0)
                                    if (r < satir)
                                    if (c >= 0)
                                    if (c < sutun)
                                    if (mayinAlani[r][c] == 9)
                                    sayac++;
 
                                   mayinAlani[i][j] = sayac;
                           }
                       }  
                    }
               }
          }
         
           
          System.out.println("------------------");
          goster(mayinAlani);
        
    }

            
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner klavye=new Scanner(System.in);
        System.out.println("Mayın Tarlası Oyununa Hoş Geldiniz");
        System.out.print("Satir Sayisini Giriniz: ");
        int satir=klavye.nextInt();
        System.out.print("Sutun Sayisini Giriniz:");
        int sutun=klavye.nextInt();
        System.out.println("--------------------");
        
        MayinOyunu nesne1 =new MayinOyunu(satir,sutun);
        nesne1.calistir();
            
        
    }
    
}

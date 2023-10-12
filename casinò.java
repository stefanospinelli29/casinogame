import java.util.Scanner;
class casinò {
   public static void main(String[] args){
      Scanner tastiera=new Scanner(System.in);
      double soldi=100;
      int sceltamenu;
      double puntata=-1;
      String p="";
   System.out.println("Benvenuto al casinò");
   System.out.println("per iniziare avrai a disposizione 100$");
   do{
   System.out.println("scegli su quale puntare:");
   System.out.println("1)testa o croce");
   System.out.println("2)roulette");
   System.out.println("3)slotmachine");
   System.out.println("4)blackjack");
   System.out.println("0)esci");
 sceltamenu=tastiera.nextInt();
   switch(sceltamenu){
case 1:
soldi=testaocroce.toc(soldi,p,puntata);
break;
case 2:
soldi=roulette.rolet(soldi);
break;
case 3:
soldi=slotmachine.slot(soldi);
break;
case 4:
soldi=blackjack.bj(soldi);
break;
   }
   if(soldi<=0){
   System.out.println("Hai finito i soldi");
   System.exit(0);
}
   }while(sceltamenu!=0);

    
   }
}

import java.util.Scanner;
public class blackjack {
    public static double bj(double soldi){
        Scanner tastiera=new Scanner(System.in);
        double puntata=0;
        String banco="";
        String g="";
        int r=-1;
        String c="";
        int i=0;
        int f=1;
        int k=0;
        int b=0;
        int gio=0;
        int scelta=0;
        boolean contr=false;
        String si="";
        String []controllo=new String[52];
        do{
            i=0;
            banco="";
            g="";
            b=0;
            gio=0;
            k=0;
        for(int j=0;j<52;j++)
        controllo[j]="0";
        puntata=roulette.puntata(soldi);
        soldi-=puntata;
        //genera carte
        do{
        do{
        contr=false;
        c="";
        c+=numero();
        for(int j=0;j<52;j++)
        if(c.equals(controllo[j]))
        contr=true;
        }while(contr);
        controllo[i]=c;
        i++;
        }while(i<52);
       // for(int j=0;j<52;j++)
       // System.out.print(controllo[j]+" ");
      //  System.out.println();
        banco+=controllo[k];
        b+=sommab(k,controllo,b);
        k++;
        banco+=" ";
        banco+=controllo[k];
        b+=sommab(k,controllo,b);;
        banco+=" ";
        k++;
        System.out.print(" le carte del banco: "+banco);
        System.out.println("   ("+b+")");
        g+=controllo[k];
        gio+=sommagio(k,controllo);
        k++;
        g+=" ";
        g+=controllo[k];
        gio+=sommagio(k,controllo);;
        g+=" ";
        System.out.print("le tue carte: "+g);
        System.out.println("   ("+gio+")");
        if(controllo[2].charAt(0)=='A'){
        do{
            System.out.println("hai pescato un asso; puo valere 1 o 11 scegli:");
            scelta=tastiera.nextInt();
            if(scelta!=1&&scelta!=11)
            System.out.println("numero non valido riscrivi");
            else 
            gio+=scelta;
            }while(scelta!=1&&scelta!=11);
            System.out.print("  carte del banco: "+banco);
        System.out.println("   ("+b+")");
        System.out.print("le tue carte: "+g);
        System.out.println("   ("+gio+")");
        }
        if(controllo[3].charAt(0)=='A'){
        do{
            System.out.println("hai pescato un asso; puo valere 1 o 11 scegli:");
            scelta=tastiera.nextInt();
            if(scelta!=1&&scelta!=11)
            System.out.println("numero non valido riscrivi");
            else 
            gio+=scelta;
            }while(scelta!=1&&scelta!=11);
            System.out.print("carte del banco: "+banco);
            System.out.println("   ("+b+")");
            System.out.print("le tue carte: "+g);
            System.out.println("   ("+gio+")");
        }
        do{
            System.out.println("1)pesca   2)stai");
            f=tastiera.nextInt();
            if(f==1){
            k++;
            g+=controllo[k];
            g+=" ";
            System.out.print("carte del banco: "+banco);
        System.out.println("   ("+b+")");
            System.out.print("le tue carte: "+g);
            gio+=sommagio(k,controllo);
            if(controllo[k].charAt(0)=='A'){
            System.out.print("carte del banco: "+banco);
        System.out.println("   ("+b+")");
            System.out.print("le tue carte: "+g);
        }
            System.out.println("   ("+gio+")");
            }
        }while(f==1&&gio<22);
        if(gio>21){
        System.out.println("Hai sballato");
        System.out.println("soldi rimasti="+soldi+"$");
        }
        else{
            while(b<22&&b<gio){
                if(b!=21){
            k++;
            banco+=controllo[k];
            banco+=" ";
            b+=sommab(k,controllo,b);
            System.out.print("  carte del banco: "+banco);
            System.out.println("   ("+b+")");
            System.out.print("le tue carte: "+g);
            System.out.println("   ("+gio+")");
                }
        }
        if(b>21){
            System.out.println("Hai vinto");
            soldi+=puntata*2;
            System.out.println("soldi rimasti="+soldi+"$");
        }
        else
            if(b==gio){
                System.out.println("Hai pareggiato");
                soldi+=puntata;
                System.out.println("soldi rimasti="+soldi+"$");
            }
        
        else{
            System.out.println("Hai perso");
            System.out.println("soldi rimasti="+soldi+"$");
        }
    }
    if(soldi>0){
        System.out.println("vuoi fare un a blackjack? si/no");
         si=tastiera.next();}
}while(si.equals("si")&&soldi>0);
        return soldi;
    }
    public static String numero(){
        int r=-1;
        String c="";
        int n=(int)(Math.random()*13+1);
        c += n;
        if(n==11)
            c="J";
            if(n==12)
            c="Q";
            if(n==13)
            c="K";
        
        if(n==1)
        c="A";
       int simbolo=(int)(Math.random()*4+3);
       char s=(char)simbolo;
       c+=s;


return c;
    }
    public static int sommagio(int k,String [] carta){
  Scanner tastiera=new Scanner(System.in);
int somma=0;
int scelta=0;
if(carta[k].charAt(0)=='A'){
    if(k>3){
    do{
System.out.println("hai pescato un asso; puo valere 1 o 11 scegli:");
scelta=tastiera.nextInt();
if(scelta!=1&&scelta!=11)
System.out.println("numero non valido riscrivi");
else 
somma=scelta;
}while(scelta!=1&&scelta!=11);
    }
}
else
if(carta[k].charAt(0)=='K'||carta[k].charAt(0)=='J'||carta[k].charAt(0)=='Q')
somma=10;
else
if(carta[k].charAt(0)=='1'||carta[k].charAt(0)=='0')
somma=10;
else
somma=carta[k].charAt(0)-'0';
return somma;
    }
    public static int sommab(int k,String [] carta,int b){
        Scanner tastiera=new Scanner(System.in);
      int somma=0;
      if(carta[k].charAt(0)=='A'){
    if(b+11<=21){
        somma=11;
    }
    else
    somma=1;
      }
      else
      if(carta[k].charAt(0)=='K'||carta[k].charAt(0)=='J'||carta[k].charAt(0)=='Q')
      somma=10;
      else
      if(carta[k].charAt(0)=='1'||carta[k].charAt(0)=='0')
      somma=10;
      else
      somma=carta[k].charAt(0)-'0';
      return somma;
          }
}

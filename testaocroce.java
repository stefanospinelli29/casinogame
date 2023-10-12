import java.util.Scanner;
class testaocroce{
public static double toc(double soldi,String p,double puntata){
    Scanner tastiera=new Scanner(System.in);
    int sceltafaccia;
    double soldi1;
String p1="";
if(p.equals("si")){
 puntata=puntata*2;
 int i=0;
 i++;
 soldi1=soldi-puntata;
}
else{
puntata=0;
do{
System.out.println("quanto vuoi puntare?");
puntata=tastiera.nextDouble();
 soldi1=soldi-puntata;
if(puntata>soldi){
    System.out.println("i soldi che hai puntato superano i soldi che hai a disposizione");
    if(puntata==0)
        System.out.println("non ha senso puntare 0$");
    if(puntata<0)
    System.out.println("non puoi puntare meno di 0.1$");
}
}while(puntata>soldi||puntata<=0);
}
    do{
System.out.println("scegli: 1) testa 2) croce");
sceltafaccia=tastiera.nextInt();
if(sceltafaccia<1||sceltafaccia>2)
System.out.println("errore, riscrivi");
}while(sceltafaccia<1||sceltafaccia>2);
int testaocroce=(int)(Math.random()*2+1);
stampamoneta(testaocroce);
if(sceltafaccia==testaocroce){
    System.out.println("Hai vinto");
    soldi+=puntata;
    System.out.println("soldi rimasti="+soldi+"$");
    System.out.println("vuoi provare un \"Lascia o raddoppia\"? si/no");
    p=tastiera.next();
    if(p.equals("si"))
    soldi=toc(soldi,p,puntata);
}
else{
System.out.println("Hai perso");
soldi-=puntata;
if(p.equals("si"))
soldi=soldi1;
System.out.println("soldi rimasti="+soldi+"$");
if(soldi!=0){
System.out.println("vuoi fare un altra partita? si/no");
p="";
p1=tastiera.next();
if(p1.equals("si"))
soldi=toc(soldi,p,puntata);
}

}

return soldi;
}
public static void stampamoneta(int n){
if(n==1)
System.out.println("(T)");
else
System.out.println("(C)");
}
}



import java.util.Scanner;
 class roulette {
    public static double rolet (double soldi){
        Scanner tastiera=new Scanner(System.in);
        double puntata=0;
        String si="";
        do{
            stampatavolo();
System.out.println("scegli su cosa puntare:");
System.out.println("1)pari o dispari[x2]");
System.out.println("2)rosso o nero[x2]");
System.out.println("3)1-18/19-36[x2]");
System.out.println("4)dozzina[x3]");
System.out.println("5)colonna[x3]");
System.out.println("6)singolo numero[x36]");
int sc=tastiera.nextInt();
int numero=(int)(Math.random()*37);

switch(sc){
case 1:
puntata=puntata(soldi);
System.out.println("1) pari  2)dispari");
int npd=tastiera.nextInt();
System.out.println("il numero uscito è: "+numero);
if(npd==1 && numero%2==0||npd==2 && numero%2!=0){
    System.out.println("Hai vinto");
    soldi+=puntata;
    System.out.println("soldi rimasti="+soldi+"$");
}
else{
    System.out.println("Hai perso");
    soldi-=puntata;
    System.out.println("soldi rimasti="+soldi+"$");
}
break;
case 2:
puntata=puntata(soldi);
System.out.println("1) rosso  2)nero");
int nrn=tastiera.nextInt();
System.out.println("il numero uscito è: "+numero);
boolean rosso=ron(numero);
if(nrn==1 && rosso||nrn==2 && !rosso && numero!=0){
    System.out.println("Hai vinto");
    soldi+=puntata*2;
    System.out.println("soldi rimasti="+soldi+"$");
}
else{
    System.out.println("Hai perso");
    soldi-=puntata;
    System.out.println("soldi rimasti="+soldi+"$");
}
break;
case 3:
puntata=puntata(soldi);
System.out.println("1)1-18  2)19-36");
int nba=tastiera.nextInt();
System.out.println("il numero uscito è: "+numero);
if((nba==1 && numero<19 && numero>0)||(nba==2 && numero>18 && numero<37)){
    System.out.println("Hai vinto");
    soldi+=puntata;
    System.out.println("soldi rimasti="+soldi+"$");
}
else{
    System.out.println("Hai perso");
    soldi-=puntata;
    System.out.println("soldi rimasti="+soldi+"$");
}
break;
case 4:
boolean dozzina=false;
puntata=puntata(soldi);
System.out.println("1)1-12  2)13-24  3)25-36");
int nd=tastiera.nextInt();
System.out.println("il numero uscito è: "+numero);
switch(nd){
    case 1:
    if(numero<13&&numero>0)
    dozzina=true;
    break;
    case 2:
    if(numero<25&&numero>12)
    dozzina=true;
    break;
    case 3:
    if(numero<37&&numero>24)
    dozzina=true;
    break;
}
if(dozzina){
    System.out.println("Hai vinto");
    soldi+=puntata*2;
    System.out.println("soldi rimasti="+soldi+"$");
}
else{
    System.out.println("Hai perso");
    soldi-=puntata;
    System.out.println("soldi rimasti="+soldi+"$");
}
break;
case 5:
boolean colonna=false;
puntata=puntata(soldi);
System.out.println("1) 3-36  2)2-35  3)1-34");
int nc=tastiera.nextInt();
System.out.println("il numero uscito è: "+numero);
switch(nc){
    case 1:
    for(int j=0;j<37&&!colonna;j++){
    numero-=3;
    if(numero==3)
    colonna=true;
    else 
    numero-=3;}
    break;
    case 2:
    for(int j=0;j<37&&!colonna;j++){
    if(numero==2)
    colonna=true;
    else
    numero-=3;}
    break;
    case 3:
    for(int j=0;j<37&&!colonna;j++){
    if(numero==1)
    colonna=true;
    else
    numero-=3; }
}
if(colonna){
    System.out.println("Hai vinto");
    soldi+=puntata*2;
    System.out.println("soldi rimasti="+soldi+"$");
}
else{
    System.out.println("Hai perso");
    soldi-=puntata;
    System.out.println("soldi rimasti="+soldi+"$");
}
break;
case 6:
String n="";
int[] numeri=new int[36];
for(int l=0;l<36;l++)
numeri[l]=-1;
double [] puntate=new double[36];
boolean vinto=false;

int i=0;
String nscelti="";
int nn=-1;
do{
puntata=puntata(soldi);
soldi-=puntata;
puntate[i]=puntata;
do{
    boolean giascelto=false;
System.out.println("scegli un numero su cui puntare:  num già scelti["+nscelti+"]");
 nn=tastiera.nextInt();
if(nn>=0&&nn<=36){
    for(int l=0;l<36;l++)
if(numeri[l]==nn){
System.out.println("hai già puntato sul "+nn);
giascelto=true;
}
if(!giascelto){
nscelti+=nn+" ";
numeri[i]=nn;
}
}
else
System.out.println("numero non valido, riscrivi");
}while(!(nn>=0&&nn<=36));
System.out.println("vuoi puntare a un altro numero? si/no");
n=tastiera.next();
i++;
}while(n.equals("si"));
System.out.println("il numero uscito è: "+numero);
for(int j=0;j<36;j++){
if(numeri[j]==numero){
    System.out.println("Hai vinto");
    soldi+=puntate[j]*36;
    vinto=true;
}
}
if(!vinto)
System.out.println("Hai perso");
System.out.println("soldi rimasti="+soldi+"$");
break;
}
if(soldi>0){
System.out.println("vuoi fare un altra giocata sulla roulette? si/no");
 si=tastiera.next();}
        }while(si.equals("si")&& soldi>0);



return soldi;
    }
    public static double puntata(double soldi){
        double puntata=0;
        Scanner tastiera=new Scanner(System.in);
        do{
            System.out.println("quanto vuoi puntare?");
             puntata=tastiera.nextDouble();
            if(puntata>soldi){
                System.out.println("i soldi che hai puntato superano i soldi che hai a disposizione");
                if(puntata==0)
                    System.out.println("non ha senso puntare 0$");
                if(puntata<0)
                System.out.println("non puoi puntare meno di 0.1$");
            }
            }while(puntata>soldi||puntata<=0);
            return puntata;
    }
    public static boolean ron(int numero){
        boolean rosso=false;
        if(numero==1||numero==3||numero==5||numero==7||numero==9||numero==12||numero==14||numero==16||numero==18||numero==19||numero==21||numero==23||numero==25||numero==27||numero==30||numero==32||numero==34||numero==1||numero==36){
            rosso=true;
        }
        return rosso;
    }
    public static void stampatavolo(){
System.out.println("  /| 3 | 6 | 9 | 12 | 15 | 18 | 21 | 24 | 27 | 30 | 33 | 36 | colonna 3-36");
System.out.println(" / |---|---|---|----|----|----|----|----|----|----|----|----| ");
System.out.println("<0 | 2 | 5 | 8 | 11 | 14 | 17 | 20 | 23 | 26 | 29 | 32 | 35 | colonna 2-35");
System.out.println(" \\ |---|---|---|----|----|----|----|----|----|----|----|----|");
System.out.println("  \\| 1 | 4 | 7 | 10 | 13 | 16 | 19 | 22 | 25 | 28 | 31 | 34 | colonna 1-34");
System.out.println("      dozzina 1-12  |   dozzina 13-24   |   dozzina 24-36       ");
    }
}

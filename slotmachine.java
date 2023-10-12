import java.util.Scanner;
public class slotmachine {
    public static double slot(double soldi){
        Scanner tastiera=new Scanner(System.in);
double puntata=0;
char[][]grigliatraspostas=new char[6][10];
int[][]grigliatraspostan=new int[6][10];
String si="";
char f=2;
char c=3;
char q=4;
char t=30;
int volte=0;
System.out.println("per vincere devi aver 5 combinazioni dello stesso simbolo");
System.out.println("moltiplicazione di vincita:");
System.out.println("$ x 300  "+f+" x 200 "+c+" x 150 "+q+" x 100 "+t+" x 50 ");
int i=0;
do{
    puntata=roulette.puntata(soldi);
    do{System.out.println("quante giocate vuoi fare?");
     volte=tastiera.nextInt();
     if(puntata*volte>soldi)
     System.out.println("non puoi puntare più volte rispetto ai tuo soldi");
}while(puntata*volte>soldi);
     i=0;

    do{
     //puntata=1;
     soldi-=puntata;
creagliglia(grigliatraspostas,grigliatraspostan);
soldi=vincita(soldi,grigliatraspostan,puntata);
i++;
    }while(i<volte && soldi>0);
    if(soldi>0){
        System.out.println("vuoi fare un altra giocata alla slotmachine? si/no");
        si=tastiera.next();}
       }while(si.equals("si")&& soldi>0);
return soldi;
    }
    public static void creagliglia(char[][]grigliatrasposta,int[][]grigliatraspostan){
        char simbolo=' ';
        boolean controllo=false;
        int n=0;
        int[] controlli=new int[5];
char griglias[][]= new char[10][6];
int griglian[][]= new int[10][6];
for(int riga=0;riga<10;riga++){
int colonna=0;
for(;colonna<6;colonna++){
    if(riga%2==0){
        if(colonna%2==0){
        n=gensimboli(colonna,controllo,n,controlli);
        griglian[riga][colonna]=n;
        switch(n){
            case 1:
            simbolo=1;
            break;
            case 2:
            simbolo=36;
            break;
            case 3:
            simbolo=30;
            break;
            case 4:
            simbolo=3;
            break;
            case 5:
            simbolo=4;
            break;  
                }
            griglias[riga][colonna]=simbolo;
        }
        else{
            griglias[riga][colonna]='|';
        }
    }
    else{
        griglias[riga][colonna]='-';
    }
}


}
/*for(int riga=0;riga<10;riga++){
    int colonna=0;
    for(;colonna<6;colonna++){
          System.out.print(griglia[riga][colonna]);
            }
        System.out.println();
    }*/
trasponi(griglias,grigliatrasposta,grigliatraspostan,griglian);
for(int riga=0;riga<6;riga++){
    int colonna=0;
    for(;colonna<9;colonna++){
          System.out.print(grigliatrasposta[riga][colonna]);
            }
        System.out.println();
    }
   /* for(int riga=0;riga<6;riga++){
        int colonna=0;
        for(;colonna<9;colonna++){
              System.out.print(grigliatraspostan[riga][colonna]);
                }
            System.out.println();
        }*/
    }
    public static int gensimboli(int colonna,boolean controllo,int n,int []controlli){
            controllo=false;
            do{
                controllo=false;
        n=(int)(Math.random()*5+1);
        controlli[colonna]=n;
        if(colonna==2)
        if(controlli[0]==n)
        controllo=true;
        if(colonna==4)
        if(controlli[0]==n||controlli[2]==n)
        controllo=true;
        //System.out.println(controlli[0]+" "+controlli[2]+" "+controlli[4]+" "+colonna+" "+controllo);
            }while(controllo);
        
        return n;
    }
public static char[][] trasponi(char[][]griglia,char [][]grigliatrasposta,int[][]grigliatraspostan,int[][]griglian){
for(int riga=0;riga<6;riga++){
int colonna=0;
for(;colonna<10;colonna++){
    if(riga%2==0){
    if(colonna%2==0){
    grigliatrasposta[riga][colonna]=griglia[colonna][riga];
    grigliatraspostan[riga][colonna]=griglian[colonna][riga];
}
    else 
    grigliatrasposta[riga][colonna]='|';
    }
    else 
    grigliatrasposta[riga][colonna]='-';
}

}
return grigliatrasposta;
}
public static double vincita(double soldi,int[][]griglia,double puntata){
boolean vittoria1=false;
boolean vittoria2=false;
boolean vittoria3=false;
System.out.print("combinazioni :");
if(griglia[0][0]==griglia[0][2]&&griglia[0][2]==griglia[0][4]&&griglia[0][4]==griglia[0][6]&&griglia[0][6]==griglia[0][8]) {
vittoria1=true;
soldi=moltiplicatore(soldi,puntata,griglia,vittoria1,vittoria2,vittoria3);
}
if(griglia[2][0]==griglia[2][2]&&griglia[2][2]==griglia[2][4]&&griglia[2][4]==griglia[2][6]&&griglia[2][6]==griglia[2][8]) {
    vittoria2=true;
    soldi=moltiplicatore(soldi,puntata,griglia,vittoria1,vittoria2,vittoria3);

}
if(griglia[4][0]==griglia[4][2]&&griglia[4][2]==griglia[4][4]&&griglia[4][4]==griglia[4][6]&&griglia[4][6]==griglia[4][8]){ 
    vittoria3=true;
    soldi=moltiplicatore(soldi,puntata,griglia,vittoria1,vittoria2,vittoria3);
}
if(griglia[0][0]==griglia[2][2]&&griglia[2][2]==griglia[4][4]&&griglia[4][4]==griglia[2][6]&&griglia[2][6]==griglia[0][8]) {
    vittoria1=true;
    soldi=moltiplicatore(soldi,puntata,griglia,vittoria1,vittoria2,vittoria3);
}

if(griglia[4][0]==griglia[2][2]&&griglia[2][2]==griglia[0][4]&&griglia[0][4]==griglia[2][6]&&griglia[2][6]==griglia[4][8]) {
    vittoria3=true;
    soldi=moltiplicatore(soldi,puntata,griglia,vittoria1,vittoria2,vittoria3);

}

if(griglia[0][0]==griglia[2][2]&&griglia[2][2]==griglia[2][4]&&griglia[2][4]==griglia[2][6]&&griglia[2][6]==griglia[4][8]) {
    vittoria1=true;
    soldi=moltiplicatore(soldi,puntata,griglia,vittoria1,vittoria2,vittoria3);

}
if(griglia[4][0]==griglia[2][2]&&griglia[2][2]==griglia[2][4]&&griglia[2][4]==griglia[2][6]&&griglia[2][6]==griglia[0][8]) {
    vittoria3=true;
    soldi=moltiplicatore(soldi,puntata,griglia,vittoria1,vittoria2,vittoria3);

}
if(griglia[4][0]==griglia[2][2]&&griglia[2][2]==griglia[4][4]&&griglia[4][4]==griglia[2][6]&&griglia[2][6]==griglia[4][8]) {
    vittoria3=true;
    soldi=moltiplicatore(soldi,puntata,griglia,vittoria1,vittoria2,vittoria3);

}
if(griglia[0][0]==griglia[2][2]&&griglia[2][2]==griglia[0][4]&&griglia[0][4]==griglia[2][6]&&griglia[2][6]==griglia[0][8]) {
    vittoria1=true;
    soldi=moltiplicatore(soldi,puntata,griglia,vittoria1,vittoria2,vittoria3);
}
System.out.println();
if(!(vittoria1||vittoria2||vittoria3)){
    System.out.println("Hai perso");
}
else 
System.out.println("Hai vinto!!!!!!!-----------------------------------");
System.out.println("soldi rimasti="+soldi+"$");
return soldi;
}
public static double moltiplicatore(double soldi,double puntata,int[][] griglia, boolean vittoria1,boolean vittoria2,boolean vittoria3){
    char f=2;
char c=3;
char q=4;
char t=30;
if(vittoria1){
    switch (griglia[0][0]) {
        case 1:
            System.out.print(f);
            soldi+=puntata*201;
            break;
            case 2:
            System.out.print('$');
            soldi+=puntata*301;
            break;
            case 3:
            System.out.print(t);
            soldi+=puntata*51;
            break;
            case 4:
            System.out.print(c);
            soldi+=puntata*151;
            break;
            case 5:
            System.out.print(q);
            soldi+=puntata*101;
            break;
    }
}
if(vittoria2){
    switch (griglia[2][0]) {
        case 1:
        System.out.print(f);
            soldi+=puntata*201;
            break;
            case 2:
            System.out.print('$');
            soldi+=puntata*301;
            break;
            case 3:
            System.out.print(t);
            soldi+=puntata*51;
            break;
            case 4:
            System.out.print(c);
            soldi+=puntata*151;
            break;
            case 5:
            System.out.print(q);
            soldi+=puntata*101;
            break;
    }

}
if(vittoria3){
    switch (griglia[4][0]) {
        case 1:
        System.out.print(f);
            soldi+=puntata*201;
            break;
            case 2:
            System.out.print('$');
            soldi+=puntata*301;
            break;
            case 3:
            System.out.print(t);
            soldi+=puntata*51;
            break;
            case 4:
            System.out.print(c);
            soldi+=puntata*151;
            break;
            case 5:
            System.out.print(q);
            soldi+=puntata*101;
            break;
    }

}
return soldi;
}
}

import java.util.*;
import java.time.LocalDate;
import java.io.*;
public class delTest {
   public static void main(String[] args) throws Exception{
      KonkurrenceSvoemmer svoemmer1 = new KonkurrenceSvoemmer(1, "Umaruuu", "Kondo", "KS", "1990-09-09", true, "Taihei");
      
      ArrayList<StaevneResultat> srList = svoemmer1.getStaevneResultater();
      System.out.println(svoemmer1);
      for(StaevneResultat sr : srList){
         System.out.println(sr);
      }
      ArrayList<Medlem> mList = new ArrayList<Medlem>();
      udfyldMedlemmer(mList);
      while(true){
      seMedlemmer(mList);
      registrerMedlemmer(mList);
      }
// 
//       LocalDate d = LocalDate.parse("1990-09-09");
//       int alder = (int) java.time.temporal.ChronoUnit.YEARS.between(d, LocalDate.now());
//       System.out.println(alder);
//       System.out.println(LocalDate.now());
   }
   public static void registrerMedlemmer(ArrayList<Medlem> mList) throws Exception{
      Scanner console = new Scanner(System.in);
      
      System.out.println("Indtast fornavn");
      String fornavn = console.next();
      System.out.println("Indtast efternavn");
      String efternavn = console.next();
      System.out.println("Indtast title");
      String titel = console.next();
      System.out.println("Indtast f�dselsdato (yyyy-MM-dd)");
      String fdato = console.next();
      System.out.println("V�lg om medlemmet er 1: aktivt eller 2: passivt");
      int aktivitetsformValg = console.nextInt();
      boolean aktivitetsform = aktivitetsformValg == 1 ? true : false; //ternary operation: er aktivitetsform = 1? hvis ja, return true, else return false
      System.out.println("V�lg om medlemmet er 1: motionist eller 2: konkurrencesv�mmer");
      int medlemType = console.nextInt();
      
      if(medlemType == 1){
         Medlem medlem = new Medlem(mList.size() + 1, fornavn, efternavn, titel, fdato, aktivitetsform, "N/A");
         mList.add(medlem);
         
         gemMedlem(mList);
      }
      else{
         System.out.println("Indtast tr�nernavn");
         String traenerNavn = console.next();
         Medlem m = new Medlem(1, fornavn, efternavn, titel, fdato, aktivitetsform, traenerNavn);
         mList.add(m);
         
         gemMedlem(mList);
      }
   }
   public static void gemKonkurrenceSvoemmere(ArrayList<KonkurrenceSvoemmer> list) throws Exception{
      String s = "";
      for(KonkurrenceSvoemmer ks : list){
            s += ks.getID() + " " + ks.getFornavn() + " " + ks.getEfternavn() + " " + ks.getTitel() + " " + ks.getFdato() + " " + ks.getAktivitetsform() + " " + ks.getTraener() + "\r\n";
      }
      PrintStream output = new PrintStream(new File("konkurrencesvoemmer.txt"));
      output.print(s);
      output.close();
   }
   public static void gemMedlem(ArrayList<Medlem> list) throws Exception{
      String s = "";
      for(Medlem m : list){
            s += m.getID() + " " + m.getFornavn() + " " + m.getEfternavn() + " " + m.getTitel() + " " + " " + m.getFdato() + " " + m.getAktivitetsform() + " " + m.getTraener() + "\r\n";
      }
      PrintStream output = new PrintStream(new File("medlemmer.txt"));
      output.print(s);
      output.close();
   }
   
   public static void seMedlemmer(ArrayList<Medlem> mList){
      for(Medlem m : mList){
         String af = m.getAktivitetsform() == true ? "Aktivt" : "Passivt";
         System.out.println(m.getID() + " " + m.getFornavn() + " " + m.getEfternavn() + " " + m.getTitel() + " " + m.getFdato() + " " + af + " " + m.getTraener());
      }
//       for(KonkurrenceSvoemmer ks: ksList){
//          String af = ks.getAktivitetsform() == true ? "Aktivt" : "Passivt";
//          System.out.println(ks.getID() + " " + ks.getFornavn() + " " + ks.getEfternavn() + " " + ks.getTitel() + " " + ks.getFdato() + " " + af + " " + ks.getTraener());
//       }
   }
   
   public static void udfyldMedlemmer(ArrayList<Medlem> list) throws Exception{
      Scanner scanner = new Scanner(new File("medlemmer.txt"));

      while(scanner.hasNextLine()){
      
         String line = scanner.nextLine();
         Scanner data = new Scanner(line);
         int id = data.nextInt();
         String fornavn = data.next();
         String efternavn = data.next();
         String titel = data.next();
         String fdato = data.next();
         boolean aktivitetsform = data.nextBoolean();
         String traener = data.next();
         Medlem medlem = new Medlem(id, fornavn, efternavn, titel, fdato, aktivitetsform, traener);
         list.add(medlem);
      }
   }
//    public static ArrayList<KonkurrenceSvoemmer> udfyldKonkurrenceSvoemmere() throws Exception{
//       Scanner scanner = new Scanner(new File("konkurrencesvoemmer.txt"));
//       ArrayList<KonkurrenceSvoemmer> list = new ArrayList<KonkurrenceSvoemmer>();
// 
//       while(scanner.hasNextLine() && scanner.hasNextInt()){
//          int id = scanner.nextInt();
//          String fornavn = scanner.next();
//          String efternavn = scanner.next();
//          String titel = scanner.next();
//          String fdato = scanner.next();
//          boolean aktivitetsform = scanner.nextBoolean();
//          String traener = scanner.next();
//          
//          KonkurrenceSvoemmer ks = new KonkurrenceSvoemmer(id, fornavn, efternavn, titel, fdato, aktivitetsform, traener);
//          list.add(ks);
//       }
//       return list;
//    }
}
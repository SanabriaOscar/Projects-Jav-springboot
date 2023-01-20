package challeges;

public class Memory {
    Process memory[][]=new Process[20][10];
   public void printMemory(){


        for (int i = memory.length-1; i >=0; i--) {

            for (int j = 0; j < memory[i].length; j++) {
               if (memory[i][j]==null){
                   System.out.print("**** ");
               }else {
                   System.out.print(memory[i][j].getFormatId() +" ");
               }
            }
            System.out.println();
        }

 }
 public  boolean verififyMemomy(int sizeProcess){
        int avaliableSpace=0;

     for (int i = memory.length-1; i >=0; i--) {
         for (int j = 0; j < memory[i].length; j++) {
             if (memory[i][j]==null){
                 avaliableSpace++;
             }
             if (avaliableSpace>=sizeProcess){
                 return true;
             }
         }
     }
    return  false;
 }

 public  void  addproces(  Process process ){

       boolean recived=verififyMemomy(process.getSize());
       if (recived == true){

           int spacesNeed=process.getSize();
           int i =0;
           while (i< memory.length || spacesNeed!=0){
               for (int j = 0; j < memory[i].length; j++) {
                   if (spacesNeed !=0){
                       if (memory[i][j]==null){
                           this.memory[i][j]=process;
                           spacesNeed --;
                       }
                   }else {
                       break;
                   }
               }

               i++;
           }
           printMemory();
       }else {
           System.out.println("No hay espacio");
       }


 }

 public  void deleteProces( int id){
     for (int i = 0; i < memory.length ; i++) {
         for (int j = 0; j < memory[i].length; j++) {
if (memory[i][j]==null){
    break;
}
             if (memory[i][j].getId()==id){
                memory[i][j]=null;
             }
         }

     }
     printMemory();
 }


}

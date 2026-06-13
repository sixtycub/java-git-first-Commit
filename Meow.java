import java.util.*;

class Vehiculo{
    private String Marca;
    private String Model;
    private  int Year;

    public Vehiculo(String Marca,String Model, int Year){
        this.Marca=Marca;
        this.Model=Model;
        this.Year=Year;
    }

    public String getMarca(){return Marca;}
    public void setMarca(String Marca){this.Marca=Marca;}

    public String getModel(){return Model;}
    public void setModel(String Model){this.Model=Model;}

    public int getYear(){
        if(Year > 2000){
            return Year;

        }else{
            throw new IllegalArgumentException("numero invalido");
        }
    }
    public void setYear(int Year) {this.Year=Year;}


    public void mostrar_info(){
        System.out.println("Marca: "+Marca);
        System.out.println("Model: "+Model);
        System.out.println("Year: "+Year);
    }


    
    
}
class Auto extends  Vehiculo{
    private String Combustible;
    private int Velocidad ;

    public Auto(String Marca, String Model, int Year,String Combustible, int Velocidad){
        super(Marca,Model,Year);
        this.Combustible= Combustible;
        this.Velocidad= Velocidad;
    }

    public void Acelerar(int cantidad){
    Velocidad+=cantidad;

        System.out.println("Acelereando: "+cantidad);

    }

    public void Frenar(int cantidad){
        Velocidad -= cantidad;
        if(Velocidad <0){
            Velocidad =0;
        } System.out.println("Frenado: "+cantidad);
    }
 


   @Override
   public void mostrar_info(){
    super.mostrar_info();
    System.out.println("Combustible: "+Combustible);
    System.out.println("Velocidad: "+Velocidad);
   }

}

public class Meow{

    void main(){
    Scanner sc= new Scanner(System.in);

     Auto a1 = new Auto("Cadillac","Escalade",2026,"Diesel",20);
     int opcion;

     do{

         System.out.println("\n=========Menu interactivo==========");
         System.out.println("1.-Mostrar Info!!");
         System.out.println("2.- Acelerar!!!");
         System.out.println("3.-Frenar!!!");
         System.out.println("0.-Salir!!!\n");

         System.out.println("Opcion : ");
         opcion = sc.nextInt();


         switch(opcion) {
          case 1:
            System.out.println("=========INFO==========");
            a1.mostrar_info();
            break;

          case 2:
            System.out.print("Introduce el km/h : ");
            int acelera= sc.nextInt();
            a1.Acelerar(acelera);
            break;

            case 3:
                System.out.print("Introduce el km /h: ");
                int frenar = sc.nextInt();
                a1.Frenar(frenar);
                break;

            case 0:
                System.out.println("Saliendo del menu");
            break;

            default :
            System.out.println("Opcion invalida!!");
         }

     }while(opcion!=0);
   sc.close(); }
}


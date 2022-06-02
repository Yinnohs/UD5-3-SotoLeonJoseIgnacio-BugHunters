import com.digitalcastaway.biblioteca.Biblioteca;
import com.digitalcastaway.biblioteca.Persona;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Alejandría");
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        System.out.println("Bienvenido a la biblioteca de Alejandría");
        System.out.println("Introduzca su nombre");
        String username = sc.nextLine();

        Persona usuario = new Persona(username);



        while (!salir) {
            showMenu();

            String opcion = sc.nextLine().toUpperCase();

            switch(opcion) {
                case "1":
                    biblioteca.showCatalog();
                    break;
                case"2":
                    System.out.println("Seleccione uno de los libros");
                    biblioteca.showCatalog();
                    int posicion = sc.nextInt();
                    usuario.obtenerLibro(posicion, biblioteca);

                    break;
                case "3":
                    System.out.println("Obteniendo libro aleatorio");
                    String titulo = usuario.obtenerLibroAleatorio(biblioteca);
                    System.out.println("Ha obtenido el título: " + titulo);

                    break;
                case "4":
                    System.out.println(usuario);
                    break;
                case"5":
                    if (usuario.borrowedBooksSize() < 0){
                        System.out.println("no tienes ningun libro prestado");
                        break;
                    }

                    System.out.println("Introduzca el título del libro que quiere devolver");
                    System.out.println(usuario);
                    int libroParaDevolver = sc.nextInt() - 1;
                    if (libroParaDevolver <0){
                        System.out.println("el numero no puede ser menor a 0");
                        break;
                    }
                    String tituloLibro = usuario.obtenerTituloLibro(libroParaDevolver);
                    usuario.devolverLibro(tituloLibro, biblioteca);
                    break;

                case "Q":
                    salir = true;
                    break;
                default:
                    System.out.println("Profavor, elije una de las opciones");
            }
        }
    }

    private static void showMenu(){
        System.out.println("Seleccione una opción");
        System.out.println("1. Ver catálogo");
        System.out.println("2. Tomar prestado un libro concreto");
        System.out.println("3. Tomar prestado un libro aleatorio");
        System.out.println("4. Ver libros que tiene prestados");
        System.out.println("5. Devolver un libro");
        System.out.println("Q. Salir");
    }
}

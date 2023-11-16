import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Bienvenido a la aplicación de gestión de tareas más cuca del barrio. \n Por favor, seleccione una opción para continuar");
        int opcion = 0;
        do {
            System.out.println("1. Ingresar una tarea");
            System.out.println("2. Completar una tarea");
            System.out.println("3. Listar las tareas pendientes");
            System.out.println("4. Listar las tareas completas");
            System.out.println("5. Listar todas las tareas");
            System.out.println("6. Eliminar una tarea");
            System.out.println("7. Actualizar una tarea");
            System.out.println("8. Ver detalle de tarea");
            System.out.println("9. Salir");
            opcion = leer.nextInt();
            int idTarea;
            int idTiempo;

            switch(opcion) {
                case 1:
                    System.out.println("Ingrese la descripción de la tarea");
                    String tarea = leer.next();
                    String valorAgregado = TodoList.agregarTarea(tarea);
                    System.out.println("Tarea (" + valorAgregado + ") ha sido agregado exitosamente!");
                    break;
                case 2:
                    System.out.println("Ingrese el id de la tarea que desea completar");
                    idTarea = leer.nextInt();
                    System.out.println("Ingrese los minutos que le tomo realizar la tarea: ");
                    idTiempo = leer.nextInt();
                    String[] valorCompletado = TodoList.completarTarea(idTarea,idTiempo);
                    System.out.println("Tarea (" + valorCompletado[0] + ") ha sido marcado como 'completado' exitosamente, con un tiempo de: " + valorCompletado[2] + "min!");
                    break;
                case 3:
                    System.out.println("Lista de tareas pendientes: ");
                    String listaTareasPendientes = TodoList.listarTareasPendientes();
                    System.out.println(listaTareasPendientes);
                    break;
                case 4:
                    System.out.println("Lista de tareas completas: ");
                    String listaTareasCompletas = TodoList.listarTareasCompletas();
                    System.out.println(listaTareasCompletas);
                    break;
                case 5:
                    System.out.println("Orden de lista completa: ");
                    String listaTareas = TodoList.listarTareas();
                    System.out.println(listaTareas);
                    break;
                case 6:
                    System.out.println("Ingrese el id de la tarea que desea eliminar");
                    idTarea = leer.nextInt();
                    boolean valorEliminado = TodoList.eliminarTarea(idTarea);
                    if (valorEliminado){
                        // Se realizo la verificacion con booleanos y luego imprimimos mensaje friendly para el usuario :) //
                        System.out.println("La tarea fue eliminada exitosamente!");
                    } else {
                        System.out.println("La tarea no fue eliminada :( ");}
                    break;
                case 7:
                    System.out.println("Ingrese el id que desea modificar: ");
                    idTarea = leer.nextInt();
                    System.out.println("Ingrese el dato a modificar: ");
                    String nuevaDescripcion = leer.next();
                    String valorModificado = TodoList.actualizarTarea(idTarea, nuevaDescripcion);
                    System.out.println("Tarea (" + valorModificado + ") ha sido modificado exitosamente!");
                    break;
                case 8:
                    System.out.println("Ingrese el Id a detallar: ");
                    idTarea = leer.nextInt();
                    String detalleTarea = TodoList.detallesTarea(idTarea);
                    System.out.println("Detalles Id: ");
                    System.out.println(detalleTarea);
                    break;
                case 9:
                    System.out.println("...Fin del proceso, que tenga un lindo dia :)!...");
                    break;
                default:
                    System.out.println("Opcion no valida!");
            }
        } while (opcion != 9);
    }
}
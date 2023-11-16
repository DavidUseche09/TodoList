import java.util.ArrayList;
import java.util.List;

public class TodoList {
    public static List<String[]> listaDeTareas = new ArrayList<>();

    public static String agregarTarea(String descripcionTarea){
        // arr[i] = valor
        String[] tarea = new String[3];
        tarea[0] = descripcionTarea;
        tarea[1] = String.valueOf(false);
        tarea[2] = String.valueOf(0);
        listaDeTareas.add(tarea);
        return tarea[0];
    }
    public static String[] completarTarea(int i, int tiempo){
        String[] tarea = listaDeTareas.get(i);
        tarea[1] = String.valueOf(true);
        tarea[2] = String.valueOf(tiempo);
        listaDeTareas.set(i,tarea);
        return tarea;
    }
    public static String listarTareasPendientes() {
        String listaTareas = "";

        for (int i = 0; i < listaDeTareas.size(); i++){
            // vec[i] -> lista.get(i)
            String[] tarea = listaDeTareas.get(i);
            boolean esTareaCompleta = Boolean.parseBoolean(tarea[1]);
            if(!esTareaCompleta){
                listaTareas = listaTareas + i + " – " + tarea[0] + " (" + tarea[2] + ") " + "\n";
            }
        }
        return listaTareas;
    }

    public static String listarTareasCompletas() {
        String listaTareas = "";

        for (int i = 0; i < listaDeTareas.size(); i++) {
            // vec[i] -> lista.get(i)
            String[] tarea = listaDeTareas.get(i);
            boolean estaTareaCompleta = Boolean.parseBoolean(tarea[1]);
            if (estaTareaCompleta) {
                listaTareas = listaTareas + i + " – " + tarea[0] + " (" + tarea[2] + ") " + "\n";
            }
        }return listaTareas;
    }

    public static String listarTareas() {
        String listaTareas = "";

        for (int i = 0; i < listaDeTareas.size(); i++){
            // vec[i] -> lista.get(i)
            String[] tarea = listaDeTareas.get(i);
            listaTareas = listaTareas + i + " – " + tarea[0] + " (" + tarea[2] + ") " + "\n";
        }
        return listaTareas;
    }

    public static boolean eliminarTarea(int i){
        boolean tareaEliminada = true;
        String[] tarea = listaDeTareas.get(i);
        listaDeTareas.remove(i);
        for (int j = 0; j < listaDeTareas.size(); j++){
            String[] tareaAuxiliar = listaDeTareas.get(j);
            if (tarea[0] == tareaAuxiliar[0]){
                tareaEliminada = false;
            }
        } return tareaEliminada;
    }

    public static String actualizarTarea(int i, String nuevaDescripcion) {
        String[] tarea = listaDeTareas.get(i);
        tarea[0] = nuevaDescripcion;
        listaDeTareas.set(i, tarea);
        return tarea[0];
    }

    public static String detallesTarea(int i) {
        String[] tarea = listaDeTareas.get(i);
        String detallesTareas = i + " – " + tarea[0] + " (" + tarea[2] + ") " + "\n";
        return detallesTareas;
    }
}


package api;

public interface EstudiantesTDA {

  void inicializarEstudiantes();

  void agregarAlumno(int legajo, int nota);

  void eliminarAlumno(int legajo);

  int promedioNotasAlumno(int legajo);

  PilaTDA notas(int legajo);

  int promedioNotasTodos();

  boolean aprobo(int legajo);

  void imprimir();
}

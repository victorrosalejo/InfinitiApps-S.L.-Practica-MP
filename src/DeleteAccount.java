import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeleteAccount  implements Serializable {

    private DatabaseManager databaseManager =new DatabaseManager();
    private Map<String, User> databaseU = new HashMap<>();
    private Map<String, Character> databaseC = new HashMap<>();
    private Map<String, History> databaseH = new HashMap<>();



    public void DeleteAccount(User u){

        System.out.println("Seguro que quiere eliminar la cuenta?");
        System.out.println("Si es así introduzca 'sí'. En caso contrario introduzca cualquier otra cosa");
        Scanner scan = new Scanner(System.in);
        String sure = scan.nextLine();

        if (sure.equalsIgnoreCase("si") || sure.equalsIgnoreCase("sí")){
            databaseU = databaseManager.obtainDatabaseU();
        // Eliminar los personajes asociados al usuario de la base de datos C
            DeleteCharacter delCh = new DeleteCharacter();
            delCh.DeleteCharacter(u,false);

        // Obtener el nombre de usuario del usuario que se va a eliminar
            String username = u.getName();
            String regnum = u.getRegisterNumber();
        // Eliminar el usuario de la base de datos U

            u = databaseU.remove(username);
        // Eliminar el historial del usuario de la base de datos H

            History h = databaseH.remove(regnum);
        // Guardar las bases de datos actualizadas

            this.databaseManager.saveDatabaseU(databaseU);
            this.databaseManager.saveDatabaseH(databaseH);

        // Volver al principio

            this.welcome();
        } else{
            Menu menu = new Menu();
            menu.Menu(u);
        }


    }


    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public Map<String, User> getDatabaseU() {



        return databaseU;
    }

    public void setDatabaseU(Map<String, User> databaseU) {
        this.databaseU = databaseU;
    }

    public Map<String, Character> getDatabaseC() {
        return databaseC;
    }

    public void setDatabaseC(Map<String, Character> databaseC) {
        this.databaseC = databaseC;
    }

    public Map<String, History> getDatabaseH() {
        return databaseH;
    }

    public void setDatabaseH(Map<String, History> databaseH) {
        this.databaseH = databaseH;
    }

    private  void welcome(){
        Welcome welcome = new Welcome();
        welcome.Welcome();
    }
}

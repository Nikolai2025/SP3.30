import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

    public class UserHandler {
        static ArrayList<User> users = new ArrayList<>();
        File file;
        Scanner scanner;

        public UserHandler(String path)  {
            try {
                file = new File(path);
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("Filen du ønsker at læse fra findes ikke");
            } catch (IOException e) {
                System.out.println("Filen du ønsker at skrive til findes ikke");
            }

            catch(Exception e){
                System.out.println("Systemet virker ikke");
            }

        }
        public static boolean login(String username, String password) {
            for(User user: users){
                if(user.getName().equals(username) && user.getPassword().equals(password) )
                    return true;
            }
            return false;
        }

        public boolean createUser(String username, String password) {
            for(User user: users){
                if(user.getName().equals(username))
                    return false;
            }
            users.add(new User(username, password));
            return true;
        }


        public void loadUsers(){

            while(scanner.hasNextLine()){
                String input = scanner.nextLine();
                String[] values = input.split(",");
                users.add(new User(values[0], values[1]));
            }
        }

        public void saveUsers() {
            try{
                FileWriter filewriter = new FileWriter(file);
                for(User user:users){
                    filewriter.write(user.getName() + "," + user.getPassword()+"\n");
                }
                filewriter.close();
            }
            catch (IOException e){
                System.out.println("Sorry, the system is not working currently");
            }
        }

    }




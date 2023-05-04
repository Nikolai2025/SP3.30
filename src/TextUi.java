import java.util.ArrayList;
import java.util.Scanner;

public class TextUi {


    static Scanner scanner = new Scanner(System.in);
    static UserHandler userHandler;
    FileIO io = new FileIO();
    ArrayList<Film> movies = new ArrayList<>();


    public TextUi(UserHandler userHandler) {
        this.userHandler = userHandler;
        this.scanner = new Scanner(System.in);
    }

    public static String getUserInput() {
        System.out.println("Hello. Would you like to 1) Log in or 2) Create user? Please write 1 or 2 and press Enter.");
        return scanner.nextLine();
    }

    public String loginMenu() {

        System.out.println("Please enter your username: ");
        String userName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        if (UserHandler.login(userName, password)) {
            System.out.println("Welcome " + userName);
            return Startmenu();
        } else {

            System.out.println("Sorry, the username or password is incorrect");
            return loginMenu();
        }


    }

    public void createUserMenu() {

        System.out.println("Please enter a username: ");
        String userName = scanner.nextLine();
        System.out.println("Please enter a password: ");
        String password = scanner.nextLine();
        if (userHandler.createUser(userName, password)) {

            userHandler.saveUsers();
            System.out.println("Welcome " + userName);
        } else {
            System.out.println("Sorry, the username or password can not be used");
        }

    }

    public String Startmenu() {
        System.out.println(" Would you like to 1) search after a movie or 2) search after a category or 3) see a list of movies you have watched or 4) see a list of hidden movies Please write 1 or 2 or 3 or 4 and press Enter.");
        return scanner.nextLine();
    }

    public void findmovie() {
        ArrayList<Film> movies=new ArrayList<>();
        ArrayList<String> movie = io.readMovieData("Movies.txt");
        for (String m : movie) {
            String[] line = m.split("; ");
            String name = line[0];
            String year = line[1];
            String categori = line[2];
            String rating = line[3];
            Film film = new Film(name,year,rating,categori);
            movies.add(film);

        }
    }
}




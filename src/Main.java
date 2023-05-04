public class Main {

    static UserHandler userhandler = new UserHandler("user.txt");
    static TextUi textUi = new TextUi(userhandler);
    public static void main(String[] args) {

        UserHandler userhandler = new UserHandler("user.txt");
        TextUi textUi = new TextUi(userhandler);
        try {
            userhandler.loadUsers();
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Desværre kan vi ikke køre programmet lige nu");
            System.exit(0);

        }
        giveUserOptions();
    }


        private static void giveUserOptions () {

            String userInput = TextUi.getUserInput();
            System.out.println(userInput);
            switch (userInput) {
                case "1":
                    textUi.loginMenu();
                    textUi.Startmenu();
                    textUi.findmovie();
                    break;
                case "2":
                    textUi.createUserMenu();
                    break;
                default:
                    System.out.println("Wrong input, please try again");
                    giveUserOptions();
            }

            

        }

    }







import Film.Film;
import java.util.ArrayList;

    public static class Seasons extends Series {
        private ArrayList<Film>episodes;

        public Seasons(String title,Seasons season,Film episodes,int releaseDate,int rating,String category){
            super(title,season,releaseDate,rating,category);
            this.episodes<Film>=new ArrayList<>();
        }
}

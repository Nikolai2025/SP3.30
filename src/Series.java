
    import Film.Film;

import java.util.ArrayList;

    public abstract class Series extends Film {

        private ArrayList<Seasons>season;

        public Series(String title,Seasons season,int releaseDate, int rating,String category){
            super(title,releaseDate,rating,category);
            this.season=new ArrayList<>();
        }




    }
}

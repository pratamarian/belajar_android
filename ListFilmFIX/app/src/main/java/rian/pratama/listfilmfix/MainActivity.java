package rian.pratama.listfilmfix;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> Movie =  new ArrayList<>();

    ArrayAdapter<Movie> adapter;
    ListView listView;

    private String [] filmTitles = {"The Thor","Harry Potter","Inception",
            "Wolf of wallstreet","Django Unchained",
            "Titanic","Captain America","Doctor Strange","X-men Apocalypse","The Hash Slinging Slicer"};
    public ArrayList<Movie> movies = new ArrayList<>();

    public void initMovies(){
        movies.add(new Movie("The Thor","Film tentang superhero yang rela turun ke bumi,buat keliling kampung jualan Palu",8.0,2009));
        movies.add(new Movie("Harry Potter","Film sequel dari fantastic beast,padahal tahun terbitnya jauh lebih awal dari fantastic beast",9.0,2016));
        movies.add(new Movie("Inception","Film tentang tukang bubur naik haji",8.0,2009));
        movies.add(new Movie("Wolf of wallstreet","Film tentang Serigala berbulu domba",9.0,2017));
        movies.add(new Movie("Django Unchained","Hmm belum ada deskripsi,film belum keluar",8.0,2015));
        movies.add(new Movie("Titanic","Film tentang kapal besar yang karam dilautan Antartica",10,2012));
        movies.add(new Movie("Capten America","Film tentang Justice League",1.0,2009));
        movies.add(new Movie("Doctor Strange","DORMAMU",9.0,2016));
        
        movies.add(new Movie("X-men Apocalypse","XMEN APOCALYPSE",8.0,2009));
        movies.add(new Movie("The Hash Slinging Slicer","Film spinn-off dari kartun SpongeBobSquarepants",8.0,2009));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMovies();
        adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);
        listView = (ListView) findViewById(R.id.list_film);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie selectedmovie = movies.get(position);
                Intent intent = new Intent(getBaseContext(), DetailActivity.class);
                intent.putExtra("pratama.rian.listfilmfix", selectedmovie);
                startActivity(intent);
            }
        }) ;
    }

    public void addfilm(View view ){
        Intent intent = new Intent(this, TambahList.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                Movie newMovie = (Movie) data.getSerializableExtra("listfilmfix.result");
                movies.add(newMovie);
                adapter.notifyDataSetChanged();
            }
        }
    }
}


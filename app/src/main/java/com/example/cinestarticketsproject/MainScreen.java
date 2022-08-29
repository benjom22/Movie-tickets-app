package com.example.cinestarticketsproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainScreen extends AppCompatActivity {



    private BottomNavigationView bottom_navigation_bar;
    private ViewPager viewPager;

    GridView moviesList;
    String[] movieGrade = {"7.5 / 10","8.2 / 10","8.5 / 10","6.7 / 10","7.7 / 10", "7.2 / 10", "8 / 10", "6 / 10", "9 / 10", "6.8 / 10"};
    int[] movieBgImages = {R.drawable.rednotice_movie_bg, R.drawable.spiderman_bg, R.drawable.guardians_of_galaxy_vol_3_bg, R.drawable.thor_love_and_thunder_bg, R.drawable.love_and_monsters_bg, R.drawable.dont_look_up_bg, R.drawable.fantastic_beasts_secrets_of_dumbledore_bg, R.drawable.doctor_strange_multiverse_bg, R.drawable.john_wick_chapter_4_bg, R.drawable.interceptor_bg};
    String[] movieStory = {"When an Interpol-issued Red Notice the highest level warrant to hunt and capture the world's most wanted goes out, the FBI's top profiler John Hartley (Dwayne Johnson) is on the case. His global pursuit finds him smack dab in the middle of a daring heist where he's forced to partner with the world's greatest art thief Nolan Booth (Ryan Reynolds) in order to catch the world's most wanted art thief, \"The Bishop\" (Gal Gadot). The high-flying adventure that ensues takes the trio around the world, across the dance floor, trapped in a secluded prison, into the jungle and, worst of all for them, constantly into each other's company.","Peter Parker's secret identity is revealed to the entire world. Desperate for help, Peter turns to Doctor Strange to make the world forget that he is Spider-Man. The spell goes horribly wrong and shatters the multiverse, bringing in monstrous villains that could destroy the world.","The Guardians (star lord, Groot, Nebula and Rocket) will be seen searching for Gamora, who most probably went to another side of the galaxy at the final fight of the Avengers End Game movie. Then the Guardian group came to know that Nebula is in ‘Knowhere’(a mysterious place as shown in Guardian of the galaxy volume 1). As they try to find Nebula, they are caught by Adam warlock (an artificial being created by the sovereign) in the middle of their way and take them to the high evolutionary.","Thor's retirement is interrupted by a galactic killer known as Gorr the God Butcher, who seeks the extinction of the gods. To combat the threat, Thor enlists the help of King Valkyrie, Korg and ex-girlfriend Jane Foster, who - to Thor's surprise - inexplicably wields his magical hammer, Mjolnir, as the Mighty Thor. Together, they embark upon a harrowing cosmic adventure to uncover the mystery of the God Butcher's vengeance and stop him before it's too late.","Seven years after the Monsterpocalypse, Joel Dawson (Dylan O'Brien), along with the rest of humanity, has been living underground ever since giant creatures took control of the land. After reconnecting over radio with his high school girlfriend Aimee (Jessica Henwick), who is now 80 miles away at a coastal colony, Joel begins to fall for her again. As Joel realizes that there's nothing left for him underground, he decides against all logic to venture out to Aimee, despite all the dangerous monsters that stand in his way. The fun-filled and action-packed adventure also stars Michael Rooker and Ariana Greenblatt.","Kate Dibiasky (Jennifer Lawrence), an astronomy grad student, and her professor Dr. Randall Mindy (Leonardo DiCaprio) make an astounding discovery of a comet orbiting within the solar system. The problem - it's on a direct collision course with Earth. The other problem? No one really seems to care. Turns out warning mankind about a planet-killer the size of Mount Everest is an inconvenient fact to navigate. With the help of Dr. Oglethorpe (Rob Morgan), Kate and Randall embark on a media tour that takes them from the office of an indifferent President Orlean (Meryl Streep) and her sycophantic son and Chief of Staff, Jason (Jonah Hill), to the airwaves of The Daily Rip, an upbeat morning show hosted by Brie (Cate Blanchett) and Jack (Tyler Perry). With only six months until the comet makes impact, managing the 24-hour news cycle and gaining the attention of the social media obsessed public before it's too late proves shockingly comical - what will it take to get the world to just look up?", "Professor Albus Dumbledore knows the powerful Dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts Magizoologist Newt Scamander to lead an intrepid team of wizards, witches and one brave Muggle baker on a dangerous mission, where they encounter old and new beasts and clash with Grindelwald's growing legion of followers. But with the stakes so high, how long can Dumbledore remain on the sidelines? (Warner Bros media release)", "Doctor Strange teams up with a mysterious teenage girl from his dreams who can travel across multiverses, to battle multiple threats, including other-universe versions of himself, which threaten to wipe out millions across the multiverse. They seek help from Wanda the Scarlet Witch, Wong and others.", "John Wick: Chapter 3 – Parabellum” ended with a wounded John Wick — left for dead* by Ian McShane’s Winston, who was determined to stay in the High Table’s good graces and keep control of The Continental, retrieved by The Tick Tock Man and taken underground to (an also very much alive) Bowery King. Moving on to “John Wick: Chapter 4,” it seems that Wick and Bowery King will be joining forces in order to take on the High Table", "The tough and reality-bruised Captain JJ Collins (Elsa Pataky) finds herself in charge of a lone nuclear missile interceptor base in the middle of the Pacific Ocean after she is wrongfully drummed out of her dream job at the Pentagon. When a simultaneous coordinated attack then threatens the base itself, Collins comes face-to-face with the charismatic yet crooked Alexander Kessel (Luke Bracey), a former US military intelligence officer intent on carrying out an unthinkable plan. With only minutes on the clock, Collins must utilize her years of tactical training and military expertise to determine who she can trust and stop Kessel and his covert mercenaries from completing their twisted and terrible mission."};
    String[] movieTitles = {"Red Notice", "Spider-Man: No Way Home", "Guardians of galaxy Vol 3", "Thor: Love and Thunder", "Monsters and Love", "Don't Look Up", "Fantastic Beasts: The Secrets of Dumbledore", "Doctor Strange in the Multiverse of Madness", "John Wick: Chapter 4", "Interceptor"};
    int[] movieImages = {R.drawable.notice_red, R.drawable.spiderman_no_way_home_new, R.drawable.guardians_of_galaxy, R.drawable.thor_4, R.drawable.monsters_and_love, R.drawable.dont_look_up, R.drawable.fantastics_beasts_secrets_of_dumbledore, R.drawable.doctor_strange_doctor_strange_multiverse, R.drawable.john_wick_chapter_4, R.drawable.interceptor };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        moviesList = findViewById(R.id.moviesList);

        /* JER SAM OBRISAO
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainScreen.this, Usett.class);
                startActivity(myIntent);
            }
        });

        */




        //logout fragment
      /* bottom_navigation_bar=findViewById(R.id.bottom_navigation_bar);
        bottom_navigation_bar.setOnItemSelectedListener(onNavigationItemSelectedListener);
        viewPager=findViewById(R.id.fragment_container);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottom_navigation_bar.getMenu().getItem(position).setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setUpAdapter(viewPager);
    }


    private void setUpAdapter(ViewPager viewPager){
        ViewPageAdapter viewPageAdapter= new ViewPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPageAdapter.addFragment(new LogoutFragment());
        viewPager.setAdapter(viewPageAdapter);
    }

    private BottomNavigationView.OnItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.d("DEBUG","Item clicked "+item.getItemId());
            switch (item.getItemId()){
               case R.id.nav_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.nav_fav:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.nav_tickets:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.nav_logut:
                    viewPager.setCurrentItem(3);
                    return true;
                default:
                    return false;
            }
        }
    };*/
        CustomAdapter customAdapter = new CustomAdapter(movieImages, this);

        moviesList.setAdapter(customAdapter);

        moviesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String SelectedMovieName = movieTitles[position];
                String SelectedMovieStory = movieStory[position];
                String SelectedMovieGrade = movieGrade[position];
                int SelectedMovieImageBg = movieBgImages[position];
                String username = getIntent().getStringExtra("username");

                startActivity(new Intent(MainScreen.this,MovieActivity.class).putExtra("moviename",SelectedMovieName).putExtra("moviestory",SelectedMovieStory).putExtra("moviegrade",SelectedMovieGrade).putExtra("moviebgimage", SelectedMovieImageBg).putExtra("username", username));
            }
        });

        // Initializie variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.nav_settings:
                        String username = getIntent().getStringExtra("username");

                        Intent intent = new Intent(getApplicationContext()
                                ,SettingsActivity.class);
                        if(username != null) {
                            intent.putExtra("username", username);
                        }
                        else {
                            String username2 = getIntent().getStringExtra("username");
                            intent.putExtra("username", username2);
                        }

                        overridePendingTransition(0,0);
                        startActivity(intent);
                        return true;
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_logut:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                }
                return false;
            }
        });
    }



    public class CustomAdapter extends BaseAdapter {
        private String[] movieNames;
        private int[] moviesPhoto;
        private Context context;
        private LayoutInflater layoutInflater;


        public CustomAdapter(int[] moviesPhoto, Context context) {
            this.moviesPhoto = moviesPhoto;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return moviesPhoto.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null) {
                convertView = layoutInflater.inflate(R.layout.row_items, parent, false);
            }

            ImageView movieView = convertView.findViewById(R.id.movieView);

            movieView.setImageResource(movieImages[position]);


            return convertView;
        }
    }
}
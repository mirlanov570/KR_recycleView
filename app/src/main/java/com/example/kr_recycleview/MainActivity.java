package com.example.kr_recycleview;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(this);
        List<Movie> movieList = loadMoviesFromDatabase(dbHelper);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MovieAdapter movieAdapter = new MovieAdapter(movieList, this);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                movieAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                movieAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private List<Movie> loadMoviesFromDatabase(DBHelper dbHelper) {

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("VENOM3", "Drama, Fantasy, Action, Adventure",
                2024, 6.2, "venom",
                "https://kinogo.ec/113447-venom-3-poslednij-tanec.html","Продолжение истории об эксцентричном репортере, который еще недавно был обычным человеком. Все круто меняется, когда судьба сталкивает мужчину с Веномом – гостем из далекого космоса, отличающимся особой прожорливостью и любовью к кровопролитию. Несмотря на всю странность ситуации, репортер и монстр становятся хорошими друзьями. Вслед за этим с ними начинают происходить безумные события, сталкивающие ребят с опаснейшими врагами. Возникновение очередных недругов вынуждает героев пуститься в бега через бессчетные вселенные. Ради спасения Веном и Эдди должны преодолеть сотни преград, а также дать отпор разъяренным преследователям. Вместе с тем друзья понимают, что рано или поздно им придется пожертвовать своими жизнями, ведь в противном случае угроза нависнет не только над ними, но и над всем человечеством."));
        movieList.add(new Movie("Joker", "Drama, Crime, Thriller", 2019, 7.8, "joker",
                "https://kinogo.inc/films/571-dzhoker-2019-hd-hubtv13-v2.html","Данный фильм повествует о возникновения анти героя по имени Джокер в" +
                " Готэме во время 1980х годов. Вы увидите все подробности возникновения безумной личности и все жизненные факторы которые " +
                "подтолкнули его на безумные деяния. Город получит его злую ухмылку и ярость с убийствами.https://youtu.be/vkszrFyeTMY?si=I5iL_DwqjVuoCayQ"));
        movieList.add(new Movie("Lord of the rings", "Drama, Fantasy, Action, Adventure",
                2001, 8.2, "lord_rings",
                "https://kinogo.ec/21709-vlastelin-kolec-bratstvo-kolca-2001.html","Действие этой истории происходит в придуманном Толкиеном мире, " +
                "известном как Среднеземье. Над Среднеземьем нависает призрак зла: Темный Властелин Саурон стремится укрепить свою и без того огромную власть," +
                " вернув себе потерянное им Кольцо. В этом кольце заключена большая часть его силы. С его помощью он может поработить Среднюю Землю и развязать " +
                "невероятное зло, не встречая почти никакого сопротивления. В истории \"Хоббит\" хоббит по имени Бильбо Бэггинс украл кольцо у ужасного существа по " +
                "имени Голлум. Каким-то образом это кольцо попадает к Фродо Бэггинсу, племяннику Бильбо, и внезапно Фродо оказывается в центре эпической драмы, связанной с " +
                "кольцом, о котором он почти ничего не знает. Волшебник Гэндальф предупреждает Фродо, что он должен покинуть Шир и не дать кольцу попасть в руки Саурона. " +
                "Они встречают парня по имени Том Бомбадил, который помогает им выбраться из беды, когда они сталкиваются с Девятью Черными Всадниками. Позже они встречают" +
                " Страйдера/Арагорна и благополучно отправляются в страну эльфов. Фродо выздоравливает после ранения, и Элронд исцеляет его. На совете Элронда решено, что " +
                "кольцо должно быть уничтожено в Трещинах Судьбы. Это за много миль отсюда, глубоко в злых землях Мордора. Создается Братство кольца, в которое входят девять" +
                " человек."));

        movieList.add(new Movie("Avengers: Infinity War", "Fantasy, Action, Adventure", 2018, 8.5, "evengers",
                "https://kinogo.as/3086-mstiteli-vojna-beskonechnosti-2018.html","Поклонникам славноизвестных американских супергероев точно " +
                "понравится посмотреть «Мстители: Война бесконечности»." +
                " Еще бы, ведь очередная часть захватывающей истории рассказывает о том, как легко люди с уникальными возможностями и недюжинными силами могут стать " +
                "обычными смертными, буквально обреченными на страшную погибель в сражении с самым главным злодеем вселенной.\n" +
                "Танос много лет путешествовал по галактикам и мирам в поисках шести Камней бесконечности. Эти крайне редкие артефакты нужны ему для того, " +
                "чтобы искажать реальность и время до неузнаваемости, ведь только такая сила поможет ему полностью пробудить вселенную. И если кто-то решал " +
                "оказывать противодействие Таносу, то он мог стереть в пыль и своего нового оппонента, и даже его родную планету, чтобы ничто больше не становилось " +
                "на пути к великой и бессмертной цели. Но вскоре космическому титану предстоит столкнуться с представителями Земли, среди которых окажется и команда " +
                "Мстителей. Эти отчаянные борцы за справедливость и правду уже в курсе всех страшных планов Таноса, поэтому они будут сражаться до последнего дыхания," +
                " чтобы сохранить свою реальность такой, какой она существует сейчас."));
        return movieList;
    }

}
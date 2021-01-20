package com.example.basiclayouts.task1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Pranav01MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Pranav01RecyclerAdapter recyclerAdapter;
    List<String> names;
    List<String> messages;
    List<String> profiles;
    List<String> times;
    List<String> messageNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pranav01activity_main);
//        names = new ArrayList<String>();
//        messages = new ArrayList<String>();
        names = new ArrayList<>(List.of("Sinchan", "Doraemon", "Ben10", "Tom", "Jerry", "MrBean", "Oggy", "Nobita", "Pikachu", "Group Name", "First Person", "Second Person"));
        messages = new ArrayList<>(List.of("ballle ballle shawa shawa..😜", "Meawoooo....🐱🐱🐱", "Hello, It's Ben10 here...🙋‍♂️", "Hello, It's Tom here...😾", "Hello, It's Jerry here...🤗🤗", " 🎙 1:09", "Dhakki tikki dhakki tikki..😆", "Ab mai kya bolu...😪", "pika pika.....🎇", "Someone : Some messages...", "Some message from me...👩", "Some message from me too👷‍♂️"));
        profiles = new ArrayList<>(List.of("https://cdn.dribbble.com/users/5223490/screenshots/11294186/media/4073678bc3aaa3ce678f35a64ec0e6b8.jpg?compress=1&resize=100x100",
                "https://freepngimg.com/thumb/doraemon/71299-nobi-youtube-nobita-television-doraemon-free-photo-png-thumb.png",
                "https://cn.i.cdn.ti-platform.com/content/1185/showpage/classic-ben-10/za/ben10classic-200x200.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeXmbtGEfOBGnmQmUuikhVxTr3jz8xvxvCLA&usqp=CAU",
                "https://cdn.dribbble.com/users/5223490/screenshots/11333630/media/eb5cc1c47f425ccc291a82198b9af795.jpg?compress=1&resize=100x100",
                "https://i.pinimg.com/236x/36/f1/bd/36f1bd7f730cc9dc536b553921e0cc44.jpg",
                "https://i.pinimg.com/originals/9e/b2/98/9eb2987df0c51a263670ceded6f5344e.jpg",
                "https://i.pinimg.com/236x/e4/61/e0/e461e0cbd1cacd8c5d38b7a4696c673a.jpg",
                "https://s10.favim.com/orig/160906/happy-pikachu-pokemon-Favim.com-4706805.jpeg",
                "https://www.clipartmax.com/png/middle/204-2045091_group-together-teamwork-icon-people-icon-flat-png.png",
                "https://library.kissclipart.com/20180920/tjq/kissclipart-female-user-icon-clipart-computer-icons-clip-art-54e8b55d36056c46.png",
                "https://image.flaticon.com/icons/png/512/17/17797.png"));
        times = new ArrayList<>(List.of("11:05 AM","2:22 PM","6:34 PM", "Yesterday", "Yesterday", "Sunday","Friday","20/1/21","20/1/21", "15/1/21", "15/1/21","14/1/21"));
        messageNum = new ArrayList<>(List.of("3","2","1","0","0","0","0","0","0","4","0","0"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new com.example.basiclayouts.task1.Pranav01RecyclerAdapter(getApplicationContext(),names, messages,profiles,times,messageNum);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this)); I have already used this in recycleView Layout
        recyclerView.setAdapter(recyclerAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
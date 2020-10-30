package com.e.snowman;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import static android.graphics.drawable.GradientDrawable.RECTANGLE;
import static com.e.snowman.MyGraphicView.curShape;



public class MainActivity extends AppCompatActivity {


    final static int street=1 ,tree=2, village=3;
   static int background= tree;

   final static int red=4, green=5, blue=6, white=7;
   static int curColor= white;

    final static int hat=7, scarf=8, earmuff=9;
    static int clothes = hat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new MyGraphicView(this));
        setTitle("나만의 눈사람");
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        SubMenu s1Menu = menu.addSubMenu("배경바꾸기");
        s1Menu.add(0,1,0,"거리");
        s1Menu.add(0,2,0,"트리");
        s1Menu.add(0,3,0,"마을");

        SubMenu s2Menu = menu.addSubMenu("색상변경");
        s2Menu.add(0,4,0,"빨강");
        s2Menu.add(0,5,0,"초록");
        s2Menu.add(0,6,0,"파랑");
        s2Menu.add(0,7,0,"횐색");

        SubMenu s3Menu = menu.addSubMenu("옷 입히기");
        s3Menu.add(0,8,0,"모자");
        s3Menu.add(0,9,0,"목도리");
        s3Menu.add(0,10,0,"귀마개");

      //  s3Menu.add(0,9,0,"귀마개");
        return  true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case  1:
               background=street;
                return true;
            case 2:
                background=tree;
                return true;
            case 3:
                background=village;
                return true;
            case 4:
                curColor=red;
                return true;
            case 5:
                curColor=green;
                return true;
            case 6:
                curColor= blue;
                return true;
            case 7:
                curColor= white;
                return true;

            case 8:
                clothes=hat;
                return true;

            case 9:
                clothes=scarf;
                return true;

            case 10:
                clothes=earmuff;
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}

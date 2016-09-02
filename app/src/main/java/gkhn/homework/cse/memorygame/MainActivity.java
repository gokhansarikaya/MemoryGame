package gkhn.homework.cse.memorygame;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    private String [] cards= {"c11","c12","c13","d11","d12","d13","h11","h12","s11","s12","c11","c12","c13","d11","d12","d13","h11","h12","s11","s12"};
    private boolean compare=false;
    private String firstcard,secondcard;
    private View v1,v2;
    private Handler handler;
    private boolean sequence=false;
    //c11,c12,c13,d11,d12,d13,h11,h12,s11,s12
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        handler = new Handler();

        b1 = (ImageButton)findViewById(R.id.imageButton); b1.setOnClickListener(ButtonListener);
        b2 = (ImageButton)findViewById(R.id.imageButton2);b2.setOnClickListener(ButtonListener);
        b3 = (ImageButton)findViewById(R.id.imageButton3);b3.setOnClickListener(ButtonListener);
        b4 = (ImageButton)findViewById(R.id.imageButton4);b4.setOnClickListener(ButtonListener);
        b5 = (ImageButton)findViewById(R.id.imageButton5);b5.setOnClickListener(ButtonListener);
        b6 = (ImageButton)findViewById(R.id.imageButton6);b6.setOnClickListener(ButtonListener);
        b7 = (ImageButton)findViewById(R.id.imageButton7);b7.setOnClickListener(ButtonListener);
        b8 = (ImageButton)findViewById(R.id.imageButton8);b8.setOnClickListener(ButtonListener);
        b9 = (ImageButton)findViewById(R.id.imageButton9);b9.setOnClickListener(ButtonListener);
        b10 = (ImageButton)findViewById(R.id.imageButton10);b10.setOnClickListener(ButtonListener);
        b11 = (ImageButton)findViewById(R.id.imageButton11);b11.setOnClickListener(ButtonListener);
        b12 = (ImageButton)findViewById(R.id.imageButton12);b12.setOnClickListener(ButtonListener);
        b13 = (ImageButton)findViewById(R.id.imageButton13);b13.setOnClickListener(ButtonListener);
        b14 = (ImageButton)findViewById(R.id.imageButton14);b14.setOnClickListener(ButtonListener);
        b15 = (ImageButton)findViewById(R.id.imageButton15);b15.setOnClickListener(ButtonListener);
        b16 = (ImageButton)findViewById(R.id.imageButton16);b16.setOnClickListener(ButtonListener);
        b17 = (ImageButton)findViewById(R.id.imageButton17);b17.setOnClickListener(ButtonListener);
        b18 = (ImageButton)findViewById(R.id.imageButton18);b18.setOnClickListener(ButtonListener);
        b19 = (ImageButton)findViewById(R.id.imageButton19);b19.setOnClickListener(ButtonListener);
        b20 = (ImageButton)findViewById(R.id.imageButton20);b20.setOnClickListener(ButtonListener);

        //c11,c12,c13,d11,d12,d13,h11,h12,s11,s12


        Prepare();




    }
    private  void Prepare(){

        String a;
        for (int i = 1; i <= 200; i++) {
            Random generator = new Random();
            int s1=generator.nextInt(20);
            int s2=generator.nextInt(20);
            a=cards[s1];
            cards[s1]=cards[s2];
            cards[s2]=a;
        }


    }
    private OnClickListener ButtonListener;{

        ButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(sequence==true){
                Toast.makeText(getApplicationContext(),"Kartların değişmesini bekleyin.", Toast.LENGTH_LONG).show();
                }
                else{
                    char[] o = (v.getTag().toString()).toCharArray();
                    int cardposition;
                    if (o.length == 2) {
                    cardposition = Character.getNumericValue(o[1]);

                    } else {
                    cardposition = Character.getNumericValue(o[1] + o[2]);

                    }

                    if(compare==false){
                        compare=true;
                        v1=v;
                        firstcard = cards[cardposition];
                        int resID = getResources().getIdentifier(firstcard, "drawable", getPackageName());
                        v1.setBackgroundResource(resID);
                    }else {
                        sequence=true;
                        compare=false;
                        v2=v;
                        secondcard = cards[cardposition];
                        int resID = getResources().getIdentifier(secondcard, "drawable", getPackageName());
                        v2.setBackgroundResource(resID);

                        if(firstcard==secondcard) {
                        handler.postDelayed(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        v2.setVisibility(View.INVISIBLE);
                                        v1.setVisibility(View.INVISIBLE);
                                        sequence=false;
                                    }
                                }, 1500);
                        }else{
                        handler.postDelayed(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        int resID = getResources().getIdentifier("cardbackmini", "drawable", getPackageName());
                                        v2.setBackgroundResource(resID);
                                        v1.setBackgroundResource(resID);
                                        sequence=false;
                                    }
                                }, 1500);

                        }
                    }
                }
            }
        };
    }

}

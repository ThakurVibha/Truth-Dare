package com.vibhathakur.truthdare;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
private Button button;
private ImageView imageView;
private Random random=new Random();
private int lastDirection;
private int newDirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
    }
    public void spin(View view){
        float pivoitX=imageView.getWidth()/2;
        float pivoitY=imageView.getHeight()/2;
        newDirection=random.nextInt(3600)+360;
        Animation rotate=new RotateAnimation(lastDirection,newDirection,pivoitX,pivoitY);
rotate.setDuration(2000);
rotate.setFillAfter(true);
rotate.setAnimationListener(new Animation.AnimationListener() {
    @Override
    public void onAnimationStart(Animation animation) {
        button.setEnabled(false);
        button.setBackground(getDrawable(R.drawable.disabled));
    }
    @Override
    public void onAnimationEnd(Animation animation) {
button.setEnabled(true);
button.setBackground(getDrawable(R.drawable.custombutton));
    }
    @Override
    public void onAnimationRepeat(Animation animation) {
    }
});
lastDirection=newDirection;
imageView.startAnimation(rotate);
    }
}

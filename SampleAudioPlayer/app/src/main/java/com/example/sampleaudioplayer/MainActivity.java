package com.example.sampleaudioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String AUDIO_URL="http://sites.google.com/site/ubiaccessmobile/sample_audio.amr";
    private MediaPlayer mediaPlayer;
    private int playbackPosition=0;
    Button playBtn;
    Button pauseBtn;
    Button restartBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playBtn=(Button)findViewById(R.id.playBtn);
        pauseBtn=(Button)findViewById(R.id.pauseBtn);
        restartBtn=(Button)findViewById(R.id.restartBtn);
        playBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                    playAudio(AUDIO_URL);
                    Toast.makeText(getApplicationContext(),"음악 파일 재생 시작됨",Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                }
            }
        });
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null){
                    playbackPosition=mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                    Toast.makeText(getApplicationContext(),"음악 파일 재생 중지됨",Toast.LENGTH_SHORT).show();
                }
            }
        });
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null&&!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    mediaPlayer.seekTo(playbackPosition);
                    Toast.makeText(getApplicationContext(),"음악 파일 재생 재시작됨",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void playAudio(String url) throws Exception{
        killMediaPlayer();
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setDataSource(url);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        killMediaPlayer();
    }
    private void killMediaPlayer(){
        if(mediaPlayer!=null){
            try{
                mediaPlayer.release();
            }
            catch (Exception e){

            }
        }
    }
}

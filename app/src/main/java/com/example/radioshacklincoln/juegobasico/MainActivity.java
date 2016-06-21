package com.example.radioshacklincoln.juegobasico;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.CountDownTimer;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.text.BreakIterator;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, imgCap;
    Button jugar, salida;
    int capImg1, capImg2, capCtrl1, capCtrl2, contador;
    TextView idMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView) findViewById(R.id.Imag1);
        img2 = (ImageView) findViewById(R.id.Imag2);
        img3 = (ImageView) findViewById(R.id.Imag3);
        img4 = (ImageView) findViewById(R.id.Imag4);
        img5 = (ImageView) findViewById(R.id.Imag5);
        img6 = (ImageView) findViewById(R.id.Imag6);
        img7 = (ImageView) findViewById(R.id.Imag7);
        img8 = (ImageView) findViewById(R.id.Imag8);
        img9 = (ImageView) findViewById(R.id.Imag9);
        img10 = (ImageView) findViewById(R.id.Imag10);
        img11 = (ImageView) findViewById(R.id.Imag11);
        img12 = (ImageView) findViewById(R.id.Imag12);

        jugar = (Button) findViewById(R.id.BtnJugar);
        salida = (Button) findViewById(R.id.BtnSalir);

        idMensaje = (TextView)findViewById(R.id.TextContador);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);
        img9.setOnClickListener(this);
        img10.setOnClickListener(this);
        img11.setOnClickListener(this);
        img12.setOnClickListener(this);
        jugar.setOnClickListener(this);
        salida.setOnClickListener(this);

        desactivar();
    }

    public void activar() {
        img1.setEnabled(true);
        img2.setEnabled(true);
        img3.setEnabled(true);
        img4.setEnabled(true);
        img5.setEnabled(true);
        img6.setEnabled(true);
        img7.setEnabled(true);
        img8.setEnabled(true);
        img9.setEnabled(true);
        img10.setEnabled(true);
        img11.setEnabled(true);
        img12.setEnabled(true);
    }

    public void desactivar() {
        img1.setEnabled(false);
        img2.setEnabled(false);
        img3.setEnabled(false);
        img4.setEnabled(false);
        img5.setEnabled(false);
        img6.setEnabled(false);
        img7.setEnabled(false);
        img8.setEnabled(false);
        img9.setEnabled(false);
        img10.setEnabled(false);
        img11.setEnabled(false);
        img12.setEnabled(false);
    }

    public void comparar(int idImag, int idCtrl, int rCtrl, final ImageView img) {

        if (capImg1 == 0) {
            capImg1 = idImag;
            capCtrl1 = idCtrl;
            imgCap = (ImageView)findViewById(capCtrl1);
        } else {
            capCtrl2 = rCtrl;
            if (capCtrl2 != capCtrl1) {
                capImg2 = idImag;
                if (capImg1 != capImg2) {
                            imgCap.setImageResource(R.mipmap.ic_imag);
                            img.setImageResource(R.mipmap.ic_imag);
                    capImg1 = 0;
                    capImg2 = 0;
                } else {
                    imgCap.setEnabled(false);
                    img.setEnabled(false);
                    contador++;
                    capImg1 = 0;
                    capImg2 = 0;
                }
            } else {
                capCtrl2 = 0;
            }
        }
    }

    public void cronometro(){
        new CountDownTimer(60000, 1000){

            @Override
        public void onTick(long millisUntilFinished){
                jugar.setEnabled(false);
                idMensaje.setText(""+millisUntilFinished/1000);
                if (contador == 6){
                    idMensaje.setText("¡Ganaste!");
                    onFinish();
                }
            }
            @Override
        public void onFinish(){
                desactivar();
                jugar.setEnabled(true);
                if (contador != 6){
                    idMensaje.setText("Perdiste");
                }
            }
        }.start();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Imag1:
                img1.setImageResource(R.mipmap.ic1);
                comparar(R.mipmap.ic1, R.id.Imag1, v.getId(), img1);
                break;
            case R.id.Imag2:
                img2.setImageResource(R.mipmap.ic2);
                comparar(R.mipmap.ic2, R.id.Imag2, v.getId(), img2);
                break;
            case R.id.Imag3:
                img3.setImageResource(R.mipmap.ic3);
                comparar(R.mipmap.ic3, R.id.Imag3, v.getId(), img3);
                break;
            case R.id.Imag4:
                img4.setImageResource(R.mipmap.ic4);
                comparar(R.mipmap.ic4, R.id.Imag4, v.getId(), img4);
                break;
            case R.id.Imag5:
                img5.setImageResource(R.mipmap.ic5);
                comparar(R.mipmap.ic5, R.id.Imag5, v.getId(), img5);
                break;
            case R.id.Imag6:
                img6.setImageResource(R.mipmap.ic6);
                comparar(R.mipmap.ic6, R.id.Imag6, v.getId(), img6);
                break;
            case R.id.Imag7:
                img7.setImageResource(R.mipmap.ic1);
                comparar(R.mipmap.ic1, R.id.Imag7, v.getId(), img7);
                break;
            case R.id.Imag8:
                img8.setImageResource(R.mipmap.ic2);
                comparar(R.mipmap.ic2, R.id.Imag8, v.getId(), img8);
                break;
            case R.id.Imag9:
                img9.setImageResource(R.mipmap.ic3);
                comparar(R.mipmap.ic3, R.id.Imag9, v.getId(), img9);
                break;
            case R.id.Imag10:
                img10.setImageResource(R.mipmap.ic4);
                comparar(R.mipmap.ic4, R.id.Imag10, v.getId(), img10);
                break;
            case R.id.Imag11:
                img11.setImageResource(R.mipmap.ic5);
                comparar(R.mipmap.ic5, R.id.Imag11, v.getId(), img11);
                break;
            case R.id.Imag12:
                img12.setImageResource(R.mipmap.ic6);
                comparar(R.mipmap.ic6, R.id.Imag12, v.getId(), img12);
                break;
            case R.id.BtnJugar:
                activar();
                cronometro();
                break;
            case R.id.BtnSalir:
                finish();
                break;
        }
    }
}

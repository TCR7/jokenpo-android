package com.example.jokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View v){
        verificarVencedor("pedra");
    }
    public void selecionarPapel(View v){
        verificarVencedor("papel");
    }
    public void selecionarTesoura(View v){
        verificarVencedor("tesoura");
    }

    private String gerarEscolhaAleatoriaApp() {

        String[] opcoes = {"pedra", "papel", "tesoura"};

        int numeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp){
            case "pedra" :
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaApp;
    }

    private void verificarVencedor(String escolhaUsuario){

        String escolhaApp = gerarEscolhaAleatoriaApp();

        TextView textoResultado = findViewById(R.id.text_resultado);

        if(
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
                        (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "tesoura" && escolhaUsuario == "papel")
        ){ // App é o vencedor
            textoResultado.setText("Você perdeu!");
        } else if(
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                        (escolhaUsuario == "papel" && escolhaApp == "pedra")||
                        (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ){ // Usuário vencedor
            textoResultado.setText("Você Ganhou!");
        } else { // Empate
            textoResultado.setText("Empate!");
        }
    }
}
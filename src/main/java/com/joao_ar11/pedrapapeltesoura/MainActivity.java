package com.joao_ar11.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.ComponentActivity;

import java.util.Random;

public class MainActivity extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        verificarGanhador("Pedra");
    }

    public void selecionarPapel(View view) {
        verificarGanhador("Papel");
    }

    public void selecionarTesoura(View view) {
        verificarGanhador("Tesoura");
    }

    public String gerarEscolhaAleatoria() {
        String[] escolhas = { "Pedra", "Papel", "Tesoura" };
        int indiceAleatorio = new Random().nextInt(3);
        String escolhaApp = escolhas[indiceAleatorio];

        ImageView imagemApp = findViewById(R.id.image_app);

        switch (escolhaApp) {
            case "Pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaApp;
    }

    public void verificarGanhador(String escolhaUsuario) {
        String escolhaApp = gerarEscolhaAleatoria();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if (
            (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
            (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
            (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
        ) {
            textoResultado.setText("Você perdeu :(");
        } else if (
            (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") ||
            (escolhaUsuario== "Papel" && escolhaApp == "Pedra") ||
            (escolhaUsuario == "Tesoura" && escolhaApp == "Papel")
        ) {
            textoResultado.setText("Você ganhou :D");
        } else {
            textoResultado.setText("Empatamos ;)");
        }
    }
}

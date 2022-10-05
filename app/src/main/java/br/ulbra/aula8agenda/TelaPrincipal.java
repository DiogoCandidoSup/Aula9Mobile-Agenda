package br.ulbra.aula8agenda;

import android.view.*;
import android.widget.Button;

public class TelaPrincipal
{
    MainActivity act;
    Button btTelaCadastrar;
    Button btTelaListar;
    TelaCadastroUsuario tela_cadastro;
    TelaListagemUsuarios tela_listar;

    public TelaPrincipal(MainActivity act) {
        this.act = act;
    }

    public void CarregarTela()
    {
        act.setContentView(R.layout.tela_principal);

        btTelaCadastrar = (Button) act.findViewById(R.id.btTelaCadastrar);
        btTelaListar = (Button) act.findViewById(R.id.btTelaListar);

        btTelaCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                tela_cadastro.CarregarTela();
            }
        });

        btTelaListar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                tela_listar.CarregarTela();
            }
        });
    }

    public void setTelaCadastro(TelaCadastroUsuario tela_cadastro)
    {
        this.tela_cadastro = tela_cadastro;
    };

    public void setTelaListar(TelaListagemUsuarios tela_listar)
    {
        this.tela_listar = tela_listar;
    }
}
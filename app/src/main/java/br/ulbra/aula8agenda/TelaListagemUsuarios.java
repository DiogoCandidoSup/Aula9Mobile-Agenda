package br.ulbra.aula8agenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.*;
import android.widget.*;
import android.widget.EditText;

import org.w3c.dom.Text;

public class TelaListagemUsuarios
{
    MainActivity act;
    TelaPrincipal tela_principal;
    Button btAnterior, btProximo, btCancelar;
    TextView outNome, outTelefone, outEndereco, outStatus;
    int index;

    public TelaListagemUsuarios(MainActivity act,TelaPrincipal tela_principal)
    {
        this.act = act;
        this.tela_principal = tela_principal;
        index = 0;
    }

    public void CarregarTela()
    {
        if (act.getRegistros().size() == 0) {
            (new AlertDialog.Builder(act)).setTitle("Aviso")
                    .setMessage("Não existe nenhum registro cadastrado.")
                    .setNeutralButton("OK", null).show();
            return;
        }

        act.setContentView(R.layout.tela_listar);
        btAnterior = (Button) act.findViewById(R.id.btAnterior);
        btProximo = (Button) act.findViewById(R.id.btProximo);
        btCancelar = (Button) act.findViewById(R.id.btCancelar);
        outNome = (TextView) act.findViewById(R.id.outNome);
        outEndereco = (TextView) act.findViewById(R.id.outEndereco);
        outTelefone = (TextView) act.findViewById(R.id.outTelefone);
        outStatus = (TextView) act.findViewById(R.id.outStatus);
        PreencheCampos(index);
        AtualizaStatus(index);

        btAnterior.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(index > 0)
                {
                    index--;

                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });

        btProximo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(index < act.getRegistros().size() - 1)
                {
                    index++;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                tela_principal.CarregarTela();
            }
        });
    }

    private void PreencheCampos(int idx)
    {
        outNome.setText(act.getRegistros().get(idx).getNome());
        outTelefone.setText(act.getRegistros().get(idx).getTelefone());
        outEndereco.setText(act.getRegistros().get(idx).getEndereco());
    }

    private void AtualizaStatus(int idx)
    {
        int total = act.getRegistros().size();
        outStatus.setText("Registros : " + (idx+1) + "/" + total);
    }

}

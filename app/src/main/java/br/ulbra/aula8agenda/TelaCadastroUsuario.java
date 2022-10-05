package br.ulbra.aula8agenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.*;
import android.widget.*;
import android.widget.EditText;

import org.w3c.dom.Text;

public class TelaCadastroUsuario
{
    MainActivity act;
    EditText edNome,edEndereco, edTelefone;
    Button btCadastrar, btCancelar;
    TelaPrincipal tela_principal;

    public TelaCadastroUsuario(MainActivity act, TelaPrincipal tela_principal)
    {
        this.act = act;
        this.tela_principal = tela_principal;
    }

    public void CarregarTela()
    {
        act.setContentView(R.layout.tela_cadastro);

        edNome = act.findViewById(R.id.edNome);
        edTelefone = act.findViewById(R.id.edTelefone);
        edEndereco = act.findViewById(R.id.edEndereco);
        btCadastrar = act.findViewById(R.id.btCadastrar);

        btCancelar = act.findViewById(R.id.btCancelar);

        btCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar usuário ?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String nome = edNome.getText().toString();
                        String telefone = edTelefone.getText().toString();
                        String endereco = edEndereco.getText().toString();
                        act.getRegistros().add(new Registro(nome,telefone,endereco));
                        act.ExibirMensagem("Cadastro efetuado com sucesso.");
                        tela_principal.CarregarTela();
                    }
                });

                dialogo.show();
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Sair do cadastro ?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        tela_principal.CarregarTela();
                    }
                });

                dialogo.show();
            }
        });
    }
}
